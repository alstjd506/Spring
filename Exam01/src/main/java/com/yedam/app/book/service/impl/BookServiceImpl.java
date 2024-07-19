package com.yedam.app.book.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.book.mapper.BookMapper;
import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@Service
public class BookServiceImpl implements BookService {
	
	@Autowired
	BookMapper mapper;
	
	@Override
	public List<BookVO> bookList() {
		
		return mapper.selectBookAll();
	}

	@Override
	public BookVO bookInfo(BookVO bookVO) {
		
		return mapper.selectBookInfo(bookVO);
	}

	@Override
	public int insertBook(BookVO bookVO) {
		int result = mapper.insertBookInfo(bookVO);
		return result == 1 ? bookVO.getBookNo() : -1;
	}

	@Override
	public BookVO selectBookNo(BookVO bookVO) {
		
		return mapper.selectBookNo(bookVO);
	}

	@Override
	public List<BookVO> rentList() {
	
		return mapper.selectRentAll();
	}

	
}
