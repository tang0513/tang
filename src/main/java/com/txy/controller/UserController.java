package com.txy.controller;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.txy.entity.Roll;
import com.txy.entity.User;
import com.txy.entity.Ztree;
import com.txy.service.UserService;
import com.txy.utils.ExcelUtils;

import net.sf.json.JSONArray;

@Controller
public class UserController {

	@Autowired
	private UserService userService;
	
	@RequestMapping("login")
	public String login(String username,String password,HttpSession session,Model model) {
		List<User> list=userService.findUserAll();
		for (User user : list) {
			if(user.getUsername().equals(username)&&user.getPassword().equals(password)) {
				session.setAttribute("user", user);
				return "main";
			}
		}
		model.addAttribute("mess", "密码输入有误，请重新输入");
		return "redirect:/login.jsp";
	}
	
	@RequestMapping("toZtree")
	public String toZtree(Model model) {
		List<Ztree> list=userService.findZtreeAll();
		String string = JSONArray.fromObject(list).toString();
		model.addAttribute("string", string);
		return "left";
	}
	
	//分页列表
	@RequestMapping("list")
	public String list(Model model,Roll roll,@RequestParam(value="current",defaultValue="1") Integer current) {
		List<Roll> sesslist=userService.findSessList();
		PageHelper.startPage(current,2); 
	
		List<Roll> list=userService.findRollList(roll);
		PageInfo<Roll> page=new PageInfo<Roll>(list);
		model.addAttribute("page", page);
		model.addAttribute("sesslist", sesslist);
		return "list";
	}
	
	
	
	//登录用户名验证
	@RequestMapping("verification")
	@ResponseBody
	public int verification(String username) {
		User user=userService.findUserOneByUsername(username);
		if(user!=null) return 1;
		else return 0;
	}
	
	//二级联动
	@RequestMapping("findSessOneBySname")
	@ResponseBody
	public Roll findSessOneBySname(Roll roll) {
		Roll roll1=userService.findSessOneBySname(roll);
		/*List<Roll> list=userService.findSessListBySname(roll);*/
		return roll1;
	}
	
	
	@RequestMapping("toAdd")
	public String toAdd(Model model) {
		//届别时间格式
		SimpleDateFormat df = new SimpleDateFormat("yyyyMM");   
		//入学时间时间格式
		SimpleDateFormat df1 = new SimpleDateFormat("yyyy-MM-dd");
		// new Date()为获取当前系统时间
		String sname = df.format(new Date());
		String rdate = df1.format(new Date());
		
		model.addAttribute("sname", sname);
		model.addAttribute("rdate", rdate);
		return "add";
	}
	
	//添加时判断某届某班某人是否存在
	@RequestMapping("verStuName")
	@ResponseBody
	public int verStuName(Roll roll) {
		Roll roll1=userService.findRollByStuName(roll);
		if(roll1!=null) return 1;
		else return 0;
	}
	
	//学籍添加
	@RequestMapping("add")
	public String add(Roll roll) throws Exception {
		/*//数据库为日期格式，实体类是字符串格式，保证用户输入的日期格式标准，进行强转
		DateFormat format1 = new SimpleDateFormat("yyyy-MM-dd");  
		Date da = format1.parse(roll.getStuborn());  
		String stuborn = da.toString();
		roll.setStuborn(stuborn);*/
		
		userService.add(roll);
		List<Roll> list=userService.findSessAll();
		for (Roll roll2 : list) {
			if(roll2.getCname().equals(roll.getCname())) {
				return "redirect:/list.do";
			}
		}
		userService.addSess(roll);
		return "redirect:/list.do";
	}
	
	//跳转到修改页面，回显
	@RequestMapping("toUpdate")
	public String toUpdate(Integer rid,Model model) {
		List<Roll> list=userService.findSessList();
		Roll roll=userService.findRollBySid(rid);
		model.addAttribute("roll", roll);
		model.addAttribute("list", list);
		return "update";
	}
	
	//修改
	@RequestMapping("update")
	public String update(Roll roll) {
		userService.update(roll);
		return "redirect:/list.do";
	}
	
	@RequestMapping("del")
	public String del(Integer rid) {
		userService.del(rid);
		return "redirect:/list.do";
	}
	
	@RequestMapping("daochu")
	public void daochu(HttpServletResponse response) {
		List<Roll> list=userService.findRollAll();
		String[] columnNames={"届别","班级名称","学号","姓名","出生日期","性别","状态","民族","电话","入学日期","备注"};
		String[] colum={"sname","cname","rnum","stuname","stuborn","stusex","states","stunation","stuphone","rdate","content"};
		ExcelUtils.exportExcel(response, list, columnNames, colum, "信息表", "周考");
	}
	
	
	@RequestMapping("top")
	public String top() {
		return "top";
	}
	
	@RequestMapping("right")
	public String right() {
		return "right";
	}
	
	@RequestMapping("foot")
	public String foot() {
		return "foot";
	}
	
}
