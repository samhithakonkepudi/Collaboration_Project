package com.niit.collaborate.test;

import static org.junit.Assert.*;

import org.junit.BeforeClass;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

import com.niit.collaborate.dao.BlogDAO;
import com.niit.collaborate.model.Blog;


public class BlogDAOTestCase
{
	@Autowired
	static BlogDAO blogDAO;
	
	
	@BeforeClass
	public static void initalize()
	{
		AnnotationConfigApplicationContext annotationConfigAppContext=new AnnotationConfigApplicationContext ();
		annotationConfigAppContext.scan("com.niit.collaborate");
		annotationConfigAppContext.refresh();
		
		blogDAO=(BlogDAO)annotationConfigAppContext.getBean("blogDAO");
		
	}

	@Test
	public void createBlogTest() 
	{
		Blog blog=new Blog();
		
		blog.setBlogId(14);
		blog.setBlogName("Jithin");
		blog.setBlogContent("Jithin is studying in niit with konkepudi");
		blog.setUserId("jtnrdy@gmail.com");
		blog.setCreateDate(new java.util.Date());
		blog.setStatus("NA");
		blog.setLikes(0);
		boolean flag = blogDAO.createBlog(blog);
		assertEquals("Problem in blog creation",blogDAO.createBlog(blog));
		
	}

}
