package com.coll.DAO;

import com.coll.Model.ProfilePicture;

public interface ProfilePictureDao 
{
	void saveOrUpdateProfilePicture(ProfilePicture profilePicture);
	ProfilePicture getProfilePicture(String email);
}
