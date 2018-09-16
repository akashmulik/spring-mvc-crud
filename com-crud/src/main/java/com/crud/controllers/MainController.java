package com.crud.controllers;

import java.io.IOException;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import org.apache.catalina.connector.Request;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpRequest;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.servlet.ModelAndView;

import com.crud.entities.LoginBean;
import com.crud.entities.UsersBean;
import com.crud.servicesapi.UserService;

@Controller
@SuppressWarnings("unused")
public class MainController {

	private static final Log log = LogFactory.getLog(MainController.class);
	
	@Autowired
	private UserService service;
	
	//Sign up
	@GetMapping("/signup")
	public ModelAndView viewSignup(Model model){
		model.addAttribute(new UsersBean());
		return new ModelAndView("signup");
	}
	
	@PostMapping("/signup")
	public String signup(@Validated UsersBean bean, BindingResult result) {

		if (result.hasErrors())
			return "signup";

		bean.setActiveFlag(true);
		if (service.createOrUpdate(bean)) {
			return "redirect:/login?signup";
		}

		return "signup";
	}
	
	//Login
	@GetMapping(value = "/login")
	public ModelAndView viewLoginPage(@RequestParam(value = "error",required = false) String error,
	@RequestParam(value = "logout",	required = false) String logout,
	@RequestParam(value = "signup",	required = false) String signup) {
		
		ModelAndView model = new ModelAndView();
		if (error != null)
			model.addObject("error", "Invalid credentials provided.");

		if (logout != null)
			model.addObject("message", "Logged out successfully.");

		model.setViewName("login");
		return model;
	}
	
	//home page
	@GetMapping("/homePage")
	public ModelAndView homePage() {
		ModelAndView model = new ModelAndView();
		model.setViewName("homePage");
		return model;
	}
	
	//profile page
	@GetMapping("/myProfile")
	public ModelAndView myProfile() {
		ModelAndView model = new ModelAndView();
		model.setViewName("myProfile");
		return model;
	}
	
	//Access denied page
	@GetMapping("/accessDenied")
	public ModelAndView accessDenied() {
		ModelAndView model = new ModelAndView();
		model.setViewName("accessDenied");
		return model;
	}
	
/*	@PostMapping("/login")
	public String verifyLogin(@Validated LoginBean bean, BindingResult result, HttpServletRequest request) {
		
		List<UsersBean> list = service.verifyLogin(bean);
		
		if (list.size() == 1) {
			if ("N".equals(list.get(0).getActiveFlag())) {
				ObjectError error = new ObjectError("status", "Your account is suspended. Contact admin.");
				result.addError(error);
				return "login";
			}
			HttpSession session = request.getSession(false);
			if (session != null)
				session.invalidate();
			session = request.getSession(true);
			session.setAttribute("userID", list.get(0).getId());
			session.setMaxInactiveInterval(120);
			return "viewUsers";
		}
		ObjectError error = new ObjectError("status", "Wrong combinition of email and password, try again or signup");
		result.addError(error);
		return "login";
	}*/
	
	//View users page
	@GetMapping("/viewUsers")
	public ModelAndView getViewUsersPage() {
		return new ModelAndView("viewUsers");
	}
	
	@GetMapping("/getAllUsers")
	public @ResponseBody Map<String, Object> getAllUsers() {
		
		Map<String, Object> map = new HashMap<String, Object>();
		List<UsersBean> list = service.getAllUsers();
		map.put("status", "200");
		map.put("message", "Data found");
		map.put("data", list);
		return map;
	}
	
	// Delete user
	@PostMapping("/deleteUser")
	public ResponseEntity<String> deleteUser(LoginBean bean) {

		if (service.deleteUser(bean)) {
			return ResponseEntity.ok("deleted");
		} else {
			return ResponseEntity.ok("error");
		}
	}
	
	//update user
	@PostMapping("/updateUser")
	public ResponseEntity<String> updateUser(UsersBean bean) {
		if(service.updateUser(bean))
			return ResponseEntity.ok("updated");
		return ResponseEntity.ok("error");
	}
	
	//Logout
	@GetMapping("logout")
	public String logout(HttpServletRequest request) {
		
		if(request.getSession(false) != null) {
		log.info(request.getSession(false).getAttribute("userID"));
		request.getSession(false).removeAttribute("userID");
		request.getSession(false).invalidate();
		}
		return "redirect:/login";
	}
	
	//suspend or activate user
	@PostMapping("toggleUserStatus")
	public ResponseEntity<String> toggleUserStatus(UsersBean bean){
		
		if(service.toggleUserStatus(bean))
			return ResponseEntity.ok("success");
		return ResponseEntity.ok("error");
	}
}
