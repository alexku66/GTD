package com;

import com.TaskManager;

public class TaskManagerTest {

	public static void main(String[] args) {
		
		TaskManager taskManager = new TaskManager();
		
 		System.out.println( "trying to add something: " + taskManager.addTask( "something" ) );
 		System.out.println( "showing the task at index 0: " + taskManager.getTask( 0 ) );
 		System.out.println( "trying to remove something: " + taskManager.removeTask( "something" ) );
	}

}
