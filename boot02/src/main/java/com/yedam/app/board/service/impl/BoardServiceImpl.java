package com.yedam.app.board.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.board.mapper.BoardMapper;
import com.yedam.app.board.service.BoardService;
import com.yedam.app.board.service.BoardVO;

@Service // => @Transactional
public class BoardServiceImpl implements BoardService {
	
	@Autowired
	BoardMapper mapper;
	
	@Override
	public List<BoardVO> boardList() {
		
		return mapper.selectBoardAll();
	}

	@Override
	public BoardVO boardInfo(BoardVO boardVO) {
		
		return mapper.selecfBoardInfo(boardVO);
	}

	@Override
	public int insertBoard(BoardVO boardVO) {
		int result = mapper.insertBoardInfo(boardVO);
		return result == 1 ? boardVO.getBoardNo() : -1;
	}

	@Override
	public Map<String, Object> updateBoard(BoardVO boardVO) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		int result = mapper.updateBoardInfo(boardVO);
		if(result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", boardVO);
		return map;
	}

	@Override
	public int deleteBoard(int boardNO) {
		return mapper.deleteBoardInfo(boardNO);
	}

}
