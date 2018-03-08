package com.neo.web;

import java.util.List;
import java.util.UUID;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.neo.entity.User;
import com.neo.json.AjaxJson;
import com.neo.service.UserService;

@Controller
public class UserController {

    @Resource
    UserService userService;


    @RequestMapping("/")
    public String index() {
        return "redirect:/list";
    }

    @RequestMapping("/list")
    public String list(Model model) {
        List<User> users=userService.getUserList();
        model.addAttribute("users", users);
        return "user/list";
    }

    @RequestMapping("/toAdd")
    public String toAdd() {
        return "user/userAdd";
    }

    @RequestMapping("/add")
    public String add(User user) {
        userService.save(user);
        return "redirect:/list";
    }

    @RequestMapping("/toEdit")
    public String toEdit(Model model,Long id) {
        User user=userService.findUserById(id);
        model.addAttribute("user", user);
        return "user/userEdit";
    }

    @RequestMapping("/edit")
    public String edit(User user) {
        userService.edit(user);
        return "redirect:/list";
    }
    
    @RequestMapping(value="/login",method=RequestMethod.POST)
    @ResponseBody
    public AjaxJson login(HttpServletRequest request,HttpServletResponse response) {
    	response.setHeader("Access-Control-Allow-Origin", "*");
    	response.addHeader("Access-Control-Allow-Headers", "Origin, x-requested-with, Content-Type, Accept,X-Cookie");
    	AjaxJson j = new AjaxJson();
    	String token = request.getParameter("token");
    	String password = request.getParameter("password");
    	String userName = request.getParameter("userName");
    	System.out.println(token);
    	System.out.println(password);
    	System.out.println(userName);
    	if(userService.findUserByToken(token) != null ) {
    		User user = userService.findUserByToken(token);
    		user.setPassword("");
    		j.setObject(user);
    		j.setMessage("登录成功");
    	}else {
    		User user = userService.findByuserNameAndpassword(userName, password);
    		if(null != user) {
    			System.out.println(UUID.randomUUID().toString());
    			user.setToken(UUID.randomUUID().toString());
    			userService.save(user);
    			user.setPassword("");
    			j.setObject(user);
       		 	j.setMessage("登录成功");
    		}else {
    			j.setMessage("登录失败");
    		}
    	}
    	return j;
    }

    @RequestMapping("/delete")
    public String delete(Long id) {
        userService.delete(id);
        return "redirect:/list";
    }
}
