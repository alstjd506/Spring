package com.yedam.app.test.web;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.dept.service.DeptVO;

public class DeptTestController {

	@RequestMapping(path = "dept", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String commandObject(DeptVO dvo) {
		String result = "";
		result += "path : / dept\n";
		result += "\t deptId : " + dvo.getDeptId();
		result += "\t deptName : " + dvo.getDeptName();
		return result;
	}
	
	@RequestMapping(path = "reqDept", method = {RequestMethod.GET, RequestMethod.POST})
	@ResponseBody
	public String requestParam(String deptName,
							   @RequestParam Integer deptId,
							   @RequestParam(name = "msg",
									   		 defaultValue = "No message",
									   		 required = true) String msg) {
		String result = "";
		result += "path : / reqDept\n";
		result += "\t deptId : " + deptId;
		result += "\t deptName : " + deptName;
		result += "\t message : " + msg;
		return result;
	}
	
	
	
	
}
