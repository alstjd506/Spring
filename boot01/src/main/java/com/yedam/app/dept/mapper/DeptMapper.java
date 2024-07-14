package com.yedam.app.dept.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.yedam.app.dept.service.DeptVO;

public interface DeptMapper {
	
	public List<DeptVO> selectDeptAll();
	
	public DeptVO selectDeptInfo(DeptVO dvo);
	
	public int insertDeptInfo(DeptVO dvo);
	
	public int updateDeptInfo(@Param("id") int deptId,
							  @Param("dept")DeptVO dvo);
	
	public int deleteDeptInfo(int deptId);
}
