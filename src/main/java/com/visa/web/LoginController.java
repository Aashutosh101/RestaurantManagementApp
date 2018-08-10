package com.visa.web;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.visa.service.UserService;

@Controller
public class LoginController {

	@Autowired
	private UserService userService;

	@RequestMapping(value="/userLogin.do", method=RequestMethod.POST)
	public String processLogin(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		boolean userExists = userService.checkIfUserExist(email, password);
//		try {
			if (userExists == true) {
//				request.setAttribute("email", email);
				System.out.println("Here");
//				try {
//					request.getRequestDispatcher("html/checkAvailabilityForm.jsp").forward(request, response);
//					response.sendRedirect("html/checkAvailabilityForm.jsp?email=" + email);
					return "redirect:/html/checkAVailabilityForm.html?email=" + email; 
			} else {
				System.out.println(email + " " + password);
				return "redirect:index.html?message=user%20does%20not%20exist.";
			}
	}

	@RequestMapping(value="adminLogin.do", method=RequestMethod.POST)
	public String processAdminLogin(HttpServletRequest request, HttpServletResponse response) {
		String email = request.getParameter("email");
		String password = request.getParameter("pwd");
		System.out.println(email + " " + password);
		boolean adminExists = userService.checkIfAdminExist(email, password);
		System.out.println(adminExists);
			if (adminExists == true) {
				return "redirect:/html/adminHome.html?email=" + email;
			} else {
				return "redirect:index.html?message=Admin%20does%20not%exist";
			}
		
	}

	@RequestMapping("logout.do")
	public String processLogout(Model model) {
		return "index.html";
	}
}
