package com.coll.DAO;

import java.util.List;

import com.coll.Model.BlogPost;



public interface BlogPostDao
{
 void addBlogPost(BlogPost blogPost);
 List<BlogPost> getBlogsApproved();
 List<BlogPost> getBlogsWaitingForApproval();
 BlogPost getBlog(int blogPostId);
 void approveBlogPost(BlogPost blogPost);
 void rejectBlogPost(BlogPost blogPost);
}
