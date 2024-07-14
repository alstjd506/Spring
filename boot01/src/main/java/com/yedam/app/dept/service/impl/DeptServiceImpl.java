package com.yedam.app.dept.service.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yedam.app.dept.mapper.DeptMapper;
import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Service
public class DeptServiceImpl implements DeptService{
	
	@Autowired
	DeptMapper deptMapper;
	
	@Override
	public List<DeptVO> deptList() {

		return deptMapper.selectDeptAll();
	}

	@Override
	public DeptVO deptInfo(DeptVO dvo) {
		
		return deptMapper.selectDeptInfo(dvo);
	}

	@Override
	public int deptInsert(DeptVO dvo) {
		int result = deptMapper.insertDeptInfo(dvo);
		return result == 1 ? dvo.getDeptId() : -1;
	}

	@Override
	public Map<String, Object> deptUpdate(DeptVO dvo) {
		Map<String, Object> map = new HashMap<>();
		boolean isSuccessed = false;
		int result = deptMapper.updateDeptInfo(dvo.getDeptId(), dvo);
		
		if(result == 1) {
			isSuccessed = true;
		}
		map.put("result", isSuccessed);
		map.put("target", dvo);
		
		return map;
	}

	@Override
	public Map<String, Object> deptDelete(DeptVO dvo) {
		Map<String, Object> map = new HashMap<>();
		
		int result = deptMapper.deleteDeptInfo(dvo.getDeptId());
		
		if(result == 1) {
			map.put("deptId", dvo.getDeptId());
		}
		
		return null;
	}

}
