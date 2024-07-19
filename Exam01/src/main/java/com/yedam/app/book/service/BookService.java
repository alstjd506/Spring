package com.yedam.app.book.service;

import java.util.List;
import java.util.Map;

public interface BookService {
	
	public List<BookVO> bookList();
	
	public BookVO bookInfo(BookVO bookVO);
	
	public int insertBook(BookVO bookVO);
	
	public BookVO selectBookNo(BookVO bookVO);
	
	public List<BookVO> rentList();
}
