package com.yedam.app.board.web;

import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

//@AllArgsConstructor
@Controller
public class BoardController {
	
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
	//             RETURN - 전체조회 다시 호출
	@PostMapping("boardInsert")
	public String boardInsertProcess(BoardVO boardVO) {
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
	//             RETURN - 수정결과 데이터(Map)
	@PostMapping("boardUpdate")
	@ResponseBody
	public Map<String, Object> boardUpdateProcess(@RequestBody BoardVO boardVO){
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
