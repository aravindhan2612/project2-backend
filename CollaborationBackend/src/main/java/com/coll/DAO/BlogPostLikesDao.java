package com.coll.DAO;

import com.coll.Model.BlogPost;
import com.coll.Model.BlogPostLikes;

public interface BlogPostLikesDao
{
	BlogPostLikes hasUserLikedBlogPost(int blogPostId,String email);

	BlogPost updateLikes(int blogPostId, String email);
}
