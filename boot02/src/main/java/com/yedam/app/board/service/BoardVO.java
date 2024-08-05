package com.yedam.app.board.service;

import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;

@Data
public class BoardVO {
	private Integer boardNo; 		//번호
	private String boardTitle; 		//제목
	private String boardContent; 	//내용
	private String boardWriter; 	//작성자
	// <input type ="date"> => @DateTimeFormat(pattern="yyyy-MM-dd")
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date regdate; 			//작성일 => java.util.date : yyyy/MM/dd
	@DateTimeFormat(pattern="yyyy-MM-dd")
	private Date updatedate; 		//수정일
	private String image; 			//첨부이미지
	
	
	private Integer fileNo; //파일번호
	private String talbeClass; // 테이블 명
	private String path; // 경로
	private String fileName; //파일 이름
	private int sort; //순번
	private String fileType; //파일 타입
	
	
}
