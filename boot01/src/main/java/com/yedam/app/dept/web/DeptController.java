package com.yedam.app.dept.web;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

import com.yedam.app.dept.service.DeptService;
import com.yedam.app.dept.service.DeptVO;

@Controller
public class DeptController {

	@Autowired
	DeptService deptService;
	
	
	@GetMapping("deptList")
	public String deptList(Model model) {
		
		List<DeptVO> list = deptService.deptList();
		model.addAttribute("deptList", list);
		
		return "dept/list";
	}
	
	
	@GetMapping("deptInfo")
	public String deptInfo(DeptVO dvo, Model model) {
		DeptVO findVO = deptService.deptInfo(dvo);
		model.addAttribute("deptInfo", findVO);
		return "dept/info";
		
	}
	
	@GetMapping("deptInsert")
	public String deptInsertForm() {
		return "dept/insert";
				
	}
	@PostMapping("deptInsert")
	public String deptInsertProcess(DeptVO dvo) {
		int did = deptService.deptInsert(dvo);
		String url = null;
		if ( did > 1 ) {
			url ="redirect:deptInfo?deptId=" + did;
		} else {
			url = "redirect:deptList";
		}
		return url;
	}
	
	
}
