package org.java.jmx.mbean.listener;

import javax.management.Notification;
import javax.management.NotificationListener;

public class ExectorListenner implements NotificationListener {

	public void handleNotification(Notification notification, Object handback) {
		System.out.println(notification.getSource());
	}

}
