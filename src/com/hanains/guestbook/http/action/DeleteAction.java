package com.hanains.guestbook.http.action;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.hanains.guestbook.dao.GuestBookDao;
import com.hanains.http.HttpUtil;
import com.hanains.http.action.Action;

public class DeleteAction implements Action {

	@Override
	public void execute(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {

		Long no=Long.parseLong(request.getParameter("no"));
		String password=request.getParameter("password");
		
		GuestBookDao dao=new GuestBookDao();
		
		dao.delete(no, password);
		
		HttpUtil.redirect(response, "/guestbook2/gb");

	}

}
