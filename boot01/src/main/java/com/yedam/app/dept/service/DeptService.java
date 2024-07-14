package com.yedam.app.dept.service;

import java.util.List;
import java.util.Map;

public interface DeptService {
	public List<DeptVO> deptList();
	
	public DeptVO deptInfo(DeptVO dvo);
	
	public int deptInsert(DeptVO dvo);
	
	public Map<String, Object> deptUpdate(DeptVO dvo);
	
	public Map<String, Object> deptDelete(DeptVO dvo);
}
