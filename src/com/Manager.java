package com;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.RequestDispatcher;
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
		String taskToBeAdded;
		String taskToWrite;
		
		if( session.isNew() ) {
			tm = new TaskManager();
			
			String fileName = (String) req.getParameter( "username" );
			File taskFile = new File( "/Library/Tomcat/Home/webapps/GTD/" + fileName + ".txt" );
			
			if( taskFile.exists() ) {
				BufferedReader br = new BufferedReader( new FileReader( taskFile ) );
				
				while ( null != ( taskToBeAdded = br.readLine() ) ) {
					tm.addTask( taskToBeAdded );
				}			
			} else {
				taskFile.createNewFile();
			}
			
			session.setAttribute( "file", taskFile );
		} else {
			tm = (TaskManager) session.getAttribute( "tm" );
		}
		
		if ( null != ( taskToWrite = req.getParameter( "newTask" ) ) ) {
			tm.addTask( taskToWrite );
		}
		
		session.setAttribute( "tm", tm );
		
		RequestDispatcher rd = req.getRequestDispatcher( "TaskManager.jsp" );
		rd.forward(req, resp);
		
	}
	
}
