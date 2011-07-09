package com;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

import com.TaskManager;

public class Manager extends HttpServlet {

	private static final long serialVersionUID = -5643080812997010532L;

	@Override
	public void doGet(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		PrintWriter writer = resp.getWriter();
		writer.println("I'm doGetting");
		
		
	}

	@Override
	public void doPost(HttpServletRequest req, HttpServletResponse resp)
			throws ServletException, IOException {
		
		resp.setContentType( "text/html" );
		
		HttpSession session = req.getSession();
		TaskManager tm;
		
		if( session.isNew() ) {
			tm = new TaskManager();
		} else {
			tm = (TaskManager) session.getAttribute( "tm" );
		}
		
		if ( null != req.getParameter("newTask")) {
			tm.addTask( req.getParameter( "newTask" ) );
		}
		
		session.setAttribute( "tm", tm );
		
		RequestDispatcher rd = req.getRequestDispatcher( "TaskManager.jsp" );
		rd.forward(req, resp);
		
	}
	
}
