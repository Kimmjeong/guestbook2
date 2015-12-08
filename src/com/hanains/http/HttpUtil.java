package com.hanains.http;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

public class HttpUtil {
	
	// 포워드
	public static void forwarding(HttpServletRequest request, HttpServletResponse response, String path)
			throws ServletException, IOException {
		
		RequestDispatcher rd = request.getRequestDispatcher(path);
		rd.forward(request, response);
	}
	
	// 리다이렉트
	public static void redirect(HttpServletResponse response, String url)
			throws ServletException, IOException {
		
		response.sendRedirect(url);
	}

}
