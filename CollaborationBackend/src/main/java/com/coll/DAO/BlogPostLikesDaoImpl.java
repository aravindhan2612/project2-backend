package com.coll.DAO;

import javax.transaction.Transactional;

import org.hibernate.Query;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.coll.Model.BlogPost;
import com.coll.Model.BlogPostLikes;
import com.coll.Model.User;


@Repository
@Transactional
public class BlogPostLikesDaoImpl implements BlogPostLikesDao
{
	@Autowired
	private SessionFactory sessionFactory;
		public BlogPostLikes hasUserLikedBlogPost(int blogPostId, String email)
		{
			Session session=sessionFactory.getCurrentSession();
			Query query=session.createQuery("from BlogPostLikes where blogPost.blogPostId=:blogId and likedBy.email=:email");
			query.setInteger("blogId", blogPostId);
			query.setString("email", email);
			BlogPostLikes blogPostLikes=(BlogPostLikes)query.uniqueResult();
			return blogPostLikes;
		}
	  
		public BlogPost updateLikes(int blogPostId, String email) {
			Session session=sessionFactory.getCurrentSession();
			BlogPost blogPost=(BlogPost)session.get(BlogPost.class,blogPostId);
			User likedBy=(User)session.get(User.class, email);
			BlogPostLikes blogPostLikes=hasUserLikedBlogPost(blogPostId, email);
			
			if(blogPostLikes==null)
			{
			   blogPostLikes=new BlogPostLikes();
			   blogPostLikes.setBlogPost(blogPost);
			   blogPostLikes.setLikedBy(likedBy);
			   session.save(blogPostLikes);
			  
			   blogPost.setLikes(blogPost.getLikes()+1);
			   	session.update(blogPost);
			}
			else
			{
	   			session.delete(blogPostLikes);
	   			blogPost.setLikes(blogPost.getLikes() - 1);
	   			session.update(blogPost);
			}
			return blogPost;
		}
}
