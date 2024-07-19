package com.yedam.app.book.web;

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

import com.yedam.app.book.service.BookService;
import com.yedam.app.book.service.BookVO;

@Controller
public class BookController {

	@Autowired
	BookService bsvc;
	
	@GetMapping("bookList")
	public String bookList(Model model) {
		List<BookVO> list = bsvc.bookList();
		model.addAttribute("bookList", list);
		return "book/bookList";
	}
	
	@GetMapping("bookInfo")
	public String bookInfo(BookVO bookVO, Model model) {
		BookVO findVO = bsvc.bookInfo(bookVO);
		model.addAttribute("bookInfo", findVO);
		return "book/bookList";
	}
	
	@GetMapping("bookInsert")
	public String bookInsertForm(BookVO bookVO, Model model) {
		BookVO findVO = bsvc.selectBookNo(bookVO);
		model.addAttribute("bookVO", findVO );
		return "book/bookInsert";
	}
	
	@PostMapping("bookInsert")
	public String bookInsertProcess(BookVO bookVO) {
		bsvc.insertBook(bookVO);
		return "redirect:bookList";
	}
	
	@GetMapping("rentList")
	public String rentList(Model model) {
		List<BookVO> list = bsvc.rentList();
		model.addAttribute("rentList", list);
		return "book/rentList";
	}
	
	
}
