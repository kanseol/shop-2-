package com.icia.shop.controller.user;

import java.io.*;

import javax.servlet.*;
import javax.servlet.annotation.*;
import javax.servlet.http.*;

import com.icia.shop.dao.*;

@WebServlet("/sboard/user/resign")
public class ResignController extends HttpServlet {
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// getSession은 세션이 존재하면 꺼내고 존재하지 않으면 새로 만듬
		HttpSession session = request.getSession();
		if(session.getAttribute("username")!=null) {
			String username = (String)session.getAttribute("username");
			MockUserDao.delete(username);
			session.invalidate();
		}
		response.sendRedirect("/shop/sboard/post/list");
	}
}