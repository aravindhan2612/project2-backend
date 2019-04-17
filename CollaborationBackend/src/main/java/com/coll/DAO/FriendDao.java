package com.coll.DAO;

import java.util.List;

import com.coll.Model.Friend;
import com.coll.Model.User;



public interface FriendDao 
{
	List<User> getAllSuggestedUsers(String email);
	void addFriend(Friend friend);
	List<Friend> getPendingRequests(String email);
	void acceptRequest(Friend friend);
	void deleteRequest(Friend friend);
	List<User> listOfFriends(String email);
}
