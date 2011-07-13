package com;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import javax.servlet.http.HttpSessionEvent;
import javax.servlet.http.HttpSessionListener;

public class MySessionListener implements HttpSessionListener{

	@Override
	public void sessionCreated(HttpSessionEvent event) {
		// do nothing, for now
		
	}

	@Override
	public void sessionDestroyed(HttpSessionEvent event) {
		// create a new BW for the File, which will wipe out the file, then feed in the TM stuff into the file
	
		TaskManager tempTM = (TaskManager) event.getSession().getAttribute( "tm" );
		ArrayList<String> listToWriteFrom = tempTM.getTaskList();
		Iterator<String> it = listToWriteFrom.listIterator();
	
		File fileToWriteTo = (File) event.getSession().getAttribute( "file" );
		try {
			BufferedWriter bw = new BufferedWriter( new FileWriter ( fileToWriteTo ) );
			
			bw.write( "something" );
			
//			while( it.hasNext() ) {
//				bw.write( (String) it.next() );
//				bw.newLine();
//			}
//			
//			bw.flush();
//			bw.close();
		} catch (IOException e) {
			e.printStackTrace();
		}
		
	}
}
