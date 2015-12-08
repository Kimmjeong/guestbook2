package com.hanains.guestbook.http.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.guestbook.dao.GuestBookDao;
import com.hanains.guestbook.vo.GuestBookVo;
import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;

public class AddAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		request.setCharacterEncoding("UTF-8");

		String name=request.getParameter("name");
		String password=request.getParameter("pass");
		String message=request.getParameter("content");
		
		GuestBookVo vo=new GuestBookVo();
		vo.setName(name);
		vo.setPassword(password);
		vo.setMessage(message);
		
		GuestBookDao dao=new GuestBookDao();
		dao.insert(vo);
		
		HttpUtil.redirect(response, "/guestbook2/gb");
	}

}
