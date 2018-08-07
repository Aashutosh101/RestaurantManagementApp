package com.visa.web;

import java.io.IOException;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.visa.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping("userLogin.do")
	public void processUserLogin(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		boolean userExists = userService.checkIfUserExist(email, password);
		try {
			if (userExists == true) {
				response.sendRedirect("userHome.html");
			} else {
				response.sendRedirect("index.html");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("adminLogin.do")
	public void processAdminLogin(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		boolean adminExists = userService.checkIfAdminExist(email, password);
		try {
			if (adminExists == true) {
				response.sendRedirect("adminHome.html");
			} else {
				response.sendRedirect("index.html");
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	@RequestMapping("logout.do")
	public String processLogout(Model model) {
		return "index.html";
	}
}
