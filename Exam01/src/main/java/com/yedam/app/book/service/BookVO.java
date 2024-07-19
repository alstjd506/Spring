package com.yedam.app.book.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BookVO {
	private Integer bookNo;
	private String bookName;
	private String bookCoverimg;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date bookDate;
	private int bookPrice;
	private String bookPublisher;
	private String bookInfo;
	
	private Integer RentNo;
	private int RentPrice;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date RentDate;
	private String RentStatus;
	private int total;
	private int count;
}