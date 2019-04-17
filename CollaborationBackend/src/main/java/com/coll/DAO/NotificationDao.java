package com.coll.DAO;

import java.util.List;

import com.coll.Model.Notification;

public interface NotificationDao
{
    void addNotification(Notification notification);
	List<Notification> getAllNotificationsNotViewed(String email);
	Notification getNotification(int notificationId);
	void updateNotificactionViewedStatus(int notificationId);

}
