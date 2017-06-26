package org.java.jmx.mbean;

import javax.management.Notification;
import javax.management.NotificationBroadcasterSupport;

public class CommandImpl extends NotificationBroadcasterSupport implements CommandMBean{

	public void comman(String commd) {
		
		System.out.println("comman:"+commd);
		Notification nt = new Notification(commd, "commd", 1);
		sendNotification(nt);
		
		System.out.println("comman:"+commd);
	}

}
