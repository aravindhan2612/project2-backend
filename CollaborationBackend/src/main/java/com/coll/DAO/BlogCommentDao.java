package com.coll.DAO;

import java.util.List;

import com.coll.Model.BlogComment;

public interface BlogCommentDao 
{
void addBlogComment(BlogComment blogComment);
List<BlogComment> getAllBlogComments(int blogPostId);
void deleteBlogComment(BlogComment blogComment);
}
