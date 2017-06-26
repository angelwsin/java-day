package org.java.jmx.mbean;

import javax.management.NotificationBroadcasterSupport;

public class ExecutorImpl extends NotificationBroadcasterSupport implements ExecutorMBean{

	public void execute() {
		
		System.out.println("exe ");
		
	}

	

}
