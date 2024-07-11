package com.yedam.app.test.web;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.yedam.app.emp.service.EmpVO;

@Controller
public class ParamController {
	// QueryString(질의문자열) : key=value&key=value&...
	// method는 상관없은 (get, post, put ...)
	// Content-type : application/x-www-form-urlencoded

	// QueryString => 커멘드 객체 : 클래스 타입
	@RequestMapping(path = "comobj", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String commandObject(EmpVO evo) {
		String result = "";
		result += "path : / comobj\n";
		result += "\t empid : " + evo.getEmpid();
		result += "\t empname : " + evo.getEmpname();
		return result;
	}

	// QueryString => @RequestParam : 기본타입, 단일값
	@RequestMapping(path = "reqparam", method = { RequestMethod.GET, RequestMethod.POST })
	@ResponseBody
	public String requestParam(String empname, // 생략가능(필수 x)
								@RequestParam Integer empid, // RequestParam으로 명시하는 경우 무조건 필수
								@RequestParam(name = "msg",
											  defaultValue = "No message",
											  required = true) String msg) {
		String result = "";
		result += "path : / reqparam\n";
		result += "\t empid : " + empid;
		result += "\t empname : " + empname;
		result += "\t message : " + msg;
		return result;
	}
	
	// @PathVariable : 경로에 값을 포함하는 방식, 단일 값
	// Method는 상관없음
	// Content-type도 상관없음
	@RequestMapping(path ={"path/{id}/{pwd}", "path/{id}"}) // path/Hong/1234
	@ResponseBody
	public String pathVariable(@PathVariable String id,
							   @PathVariable (name = "pwd", required=false) String password) {
		if(password == null) password = "1234"; // defaultValue 설정
		String result = "";
		result += "path : /path/{id} \n";
		result += "\t id : " + id;
		result += "\t pwd : " + password;
		return result;
	}
	
	// @RequestBody : JSON 포멧, 배열 or 객체
	// Method : POST, PUT
	// Content-type : application/json
	@PostMapping("resbody")
	@ResponseBody
	public String requestBody(@RequestBody EmpVO evo) {
		String result = "";
		result += "path : / resbody\n";
		result += "\t empid : " + evo.getEmpid();
		result += "\t empname : " + evo.getEmpname();
		return result;
	}
	
	@PostMapping("resbodyList")
	@ResponseBody
	public String requestBody(@RequestBody List<EmpVO> list) {
		String result = "";
		for(EmpVO evo : list) {
			result += "path : / resbodyList\n";
			result += "\t empid : " + evo.getEmpid();
			result += "\t empname : " + evo.getEmpname();	
		}
		return result;
	}
}
