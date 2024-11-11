package com.example.demo.controller;

import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.demo.entity.User;

@Controller
@RequestMapping("/user")
public class UserController {
	
	private List<User> users = new CopyOnWriteArrayList<>();
	
	// 首頁
	@GetMapping("/")    // http://localhost:8081/User/user/      
	public String index(Model model, @ModelAttribute User user) {
		// 要放在表單裡面的就是ModelAttribute。放在表單以外的資料要渲染呈現的 在model裡面
		model.addAttribute("_method", "POST");           //有個變數叫_method，去影響表單的隱含hidden欄位的值
		model.addAttribute("submitButtonName", "新增");  //將按鈕視為變數，不要寫死，由前端的動作 來調整按鈕名稱
		model.addAttribute("users", users);             //列表，所有使用者的資料
		// model.addAttribute("user", user); 可以不用寫，因為@ModelAttribute會將User user物件帶給前端。
		
		/* 資料就會被set至表單上，顯示在前端上...data binding(只要改變 物件屬性內容>前端表單內容就會改變)
		user.setName("Vincent");
		user.setAge(18);
		user.setBirth(new Date());  //在前端，value="Mon May 29 19:58:22 CST 2023"
		user.setEducation("大學");
		user.setSex("男");
		user.setInterest(new String[] {"爬山", "飛控"});
		user.setResume("我的履歷資料:\n1:我的家庭...\n2:我喜歡...");
		*/
		return "user";
		// 四個變數_method、submitButtonName、users、user會帶給前端，讓其自行渲染
	}
	
	@PostMapping("/")
	public String add(@ModelAttribute User user) { // user會得到 html表單上傳的資訊
		users.add(user);
		return "redirect:./"; // 新增好 就重導
	}
	
	
	
	
	
	
	
	
	
	
	
	
	
	
}
