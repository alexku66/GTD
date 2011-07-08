package com;

import java.util.ArrayList;

public class TaskManager {

	//public Task[] _queueTask;
	private ArrayList<String> _queueTask; 
	
	public TaskManager() {
		// later: create a inputstream or what not that uses a text file
		
		_queueTask = new ArrayList<String>();
	}
	
	public boolean addTask( String taskText ) {
		return _queueTask.add( taskText );
	}
	
	public boolean removeTask( String taskText ) {
		return _queueTask.remove( taskText );
	}
	
	public String getTask( int index ) {
		return _queueTask.get( index );
	}
	
	public ArrayList<String> getTaskList() {
		return _queueTask;
	}
}
