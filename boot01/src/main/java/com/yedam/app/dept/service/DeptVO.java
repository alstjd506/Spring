package com.yedam.app.dept.service;

import lombok.Data;

@Data
public class DeptVO {
	private Integer deptId;
	private String deptName;
	private int mgr;
	private int locId;
}
