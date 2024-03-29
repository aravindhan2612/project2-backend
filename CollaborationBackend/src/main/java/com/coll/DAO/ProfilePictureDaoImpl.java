package com.coll.DAO;

import javax.transaction.Transactional;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.Model.ProfilePicture;


@Transactional
@Repository
public class ProfilePictureDaoImpl implements ProfilePictureDao {

	@Autowired
	private SessionFactory sessionFactory;
	public void saveOrUpdateProfilePicture(ProfilePicture profilePicture)
	{
	Session session=sessionFactory.getCurrentSession();
	session.saveOrUpdate(profilePicture);
	}

	public ProfilePicture getProfilePicture(String email)
	{
		Session session=sessionFactory.getCurrentSession();
		ProfilePicture profilePicture=(ProfilePicture) session.get(ProfilePicture.class, email);
		return profilePicture;
	}

}
