<%@ page import="java.util.*" %>
<%@ page import="com.TaskManager" %>
<%@ page import="java.util.ArrayList" %>

<%@ page language="java" contentType="text/html; charset=ISO-8859-1"
    pageEncoding="ISO-8859-1"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=ISO-8859-1">
<title>Your Tasks, baby!</title>
</head>
<body>

<form method="POST" action="DisplayTasks.do">
<center>
Enter a new task: <input type="text" name="newTask" />
</center>
</form>
<br />
<br />
<form method="POST" action="DisplayTasks.do">
<center>
<input type = "SUBMIT" value = "REFRESH" />
</center>
</form>

<h1 align="center">Here are your tasks</h1>
<p>

<%
	TaskManager tm = (TaskManager) request.getSession().getAttribute( "tm" );
	ArrayList<String> list = tm.getTaskList();
	
	if( null != list ) {
		Iterator<String> it = list.listIterator();
		
		while(it.hasNext()) {
			out.print(it.next() + "<br />");
		}
	}

%>

</body>
</html>