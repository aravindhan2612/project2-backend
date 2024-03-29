package com.coll.DAO;

import java.util.List;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.Model.Notification;


@Repository
@Transactional
public class NotificationDaoImpl implements NotificationDao 
{
	@Autowired
	private SessionFactory sessionFactory;
	public void addNotification(Notification notification)
	{
		Session session=sessionFactory.getCurrentSession();
		session.save(notification);	
	}

	public List<Notification> getAllNotificationsNotViewed(String email) 
	{
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(
				"from Notification where viewed=:viewed and userToBeNotified.email=:email");
		query.setBoolean("viewed", false);
		query.setString("email", email);
		List<Notification> notificationsNotViewed=query.list();
		return notificationsNotViewed;
	}

	public Notification getNotification(int notificationId)
	{
		Session session=sessionFactory.getCurrentSession();
		Notification notification=(Notification)session.get(Notification.class, notificationId);
		return notification;
	}

	public void updateNotificactionViewedStatus(int notificationId) 
	{
		Session session=sessionFactory.getCurrentSession();
		Notification notification=(Notification)session.get(Notification.class, notificationId);
        notification.setViewed(true);
        session.update(notification);

	}

}
