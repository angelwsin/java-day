package org.java.jmx.mbean.filter;

import javax.management.Notification;
import javax.management.NotificationFilter;

public class ExecutorFilter implements NotificationFilter{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;

	public boolean isNotificationEnabled(Notification notification) {
		return true;
	}

}
