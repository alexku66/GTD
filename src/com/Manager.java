package com;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.*;

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
		
//		PrintWriter writer = resp.getWriter();
//		writer.println("I'm doPosting");
		
		resp.setContentType( "text/html" );
		
		ServletContext sc = getServletContext();
		TaskManager tm = (TaskManager) sc.getAttribute("tm");
		
		for (int i=0; i<3; i++) {
			tm.addTask("thing #" + i);
		}
		
		RequestDispatcher rd = req.getRequestDispatcher("TaskManager.jsp");
		rd.forward(req, resp);
		
	}
	
}
