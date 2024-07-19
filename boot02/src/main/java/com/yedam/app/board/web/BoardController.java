package com.yedam.app.board.web;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.multipart.MultipartFile;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

import lombok.extern.slf4j.Slf4j;

//@AllArgsConstructor
@Slf4j
@Controller
public class BoardController {
	@Value("${file.upload.path}")
	private String uploadPath;
	
	//private BoardService bsvc;
	
	//@Autowired
	//public BoardController(BoardService bsvc) {
	//	this.bsvc = bsvc;
	//}
	
	@Autowired
	BoardService bsvc;
	
	// 전체조회 : URI - boardList / RETURN - board/boardList
	@GetMapping("boardList")
	public String boardList(Model model) {
		List<BoardVO> list = bsvc.boardList();
		model.addAttribute("boardList", list);
		return "board/boardList";
	}
	
	// 단건조회 : URI - boardInfo / PARAMETER - BoardVO(QueryString)
	//          RETURN - board/boardInfo
	@GetMapping("boardInfo")
	public String boardInfo(BoardVO boardVO, Model model) {
		BoardVO findVO = bsvc.boardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		return "board/boardInfo";
	}

	// 등록 - 페이지 : URI - boardInsert / RETURN - board/boardInsert
	@GetMapping("boardInsert")
	public String boardInsertForm() { // 일반적인 <form/> 활용
		return "board/boardInsert";
	}
	// 등록 - 처리 : URI - boardInsert / PARAMETER - BoardVO(QueryString)
	//             RETURN - 단건조회 호출
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO boardVO, @RequestPart MultipartFile images) {		
		String fileName = images.getOriginalFilename();
		log.warn(images.getOriginalFilename()); 
		
		UUID uuid = UUID.randomUUID();
		String uniqueFileName = uuid + "_" + fileName;
		
		String saveName = uploadPath + File.separator + uniqueFileName;
		log.debug("saveName: " + saveName);
		
		Path savePath = Paths.get(saveName);
		boardVO.setImage(uniqueFileName);
		
		try {
			images.transferTo(savePath);
		} catch (IOException e) {
			e.printStackTrace();
		}
			
		int bno = bsvc.insertBoard(boardVO);
		return "redirect:boardInfo?boardNo=" + bno;
	}	
	// 수정 - 페이지 : URI - boardUpdate / PARAMETER - BoardVO(QueryString)
	//               RETURN - board/boardUpdate
	@GetMapping("boardUpdate")
	public String boardUpdateForm(@RequestParam Integer boardNo, Model model) {
		BoardVO boardVO = new BoardVO();
		boardVO.setBoardNo(boardNo);
		
		BoardVO findVO = bsvc.boardInfo(boardVO);
		model.addAttribute("boardInfo", findVO);
		
		return "board/boardUpdate";
	}
	
	// 수정 - 처리 : URI - boardUpdate / PARAMETER - BoardVO(JSON)
	//             RETURN - 수정결과 데이터(Map) json이라면 @RequestBody
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdateProcess(@RequestPart("board") BoardVO boardVO,
	        									  @RequestPart(value="image")  MultipartFile images){	
		if (images != null && !images.isEmpty()) {
			String fileName = images.getOriginalFilename();
		    UUID uuid = UUID.randomUUID();
		    String uniqueFileName = uuid + "_" + fileName;

		    String saveName = uploadPath + File.separator + uniqueFileName;
		    Path savePath = Paths.get(saveName);
		    try {
		        images.transferTo(savePath);
		        boardVO.setImage(uniqueFileName);
		    } catch (IOException e) {
		            e.printStackTrace();
		    }
		} else {
		    boardVO.setImage(boardVO.getImage());
		}
		return bsvc.updateBoard(boardVO);
	}
	
	// 삭제 - 처리 : URI - boardDelete / PARAMETER - Integer
	//             RETURN - 전체조회 다시 호출
	@GetMapping("boardDelete")
	public String boardDelete(@RequestParam Integer boardNo) {
		bsvc.deleteBoard(boardNo);
		return "redirect:boardList";
	}
	
}
