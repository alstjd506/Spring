package com.yedam.app.book.mapper;

import java.util.List;

import com.yedam.app.book.service.BookVO;

public interface BookMapper {
	
	public List<BookVO> selectBookAll();
	
	public BookVO selectBookInfo(BookVO bookVO);
	
	public int insertBookInfo(BookVO bookVO);
	
	public BookVO selectBookNo(BookVO bookVO);
	
	public List<BookVO> selectRentAll();
	
}
