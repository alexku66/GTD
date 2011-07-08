package com;

import javax.servlet.*;
import com.TaskManager;

public class MyListener implements ServletContextListener {

  /* (non-Javadoc)
   * @see javax.servlet.ServletContextListener#contextDestroyed(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextDestroyed( ServletContextEvent event )
  {
    // do nothing
    
  }

  /* (non-Javadoc)
   * @see javax.servlet.ServletContextListener#contextInitialized(javax.servlet.ServletContextEvent)
   */
  @Override
  public void contextInitialized( ServletContextEvent event )
  {
	  ServletContext sc = event.getServletContext();
	  TaskManager taskManager = new TaskManager();
	  //taskManager.addTask( "something" );
	  sc.setAttribute( "tm", taskManager );
  }
}