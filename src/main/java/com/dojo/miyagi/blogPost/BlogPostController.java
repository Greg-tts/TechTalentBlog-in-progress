package com.dojo.miyagi.blogPost;

public class BlogPostController {
	
	@GetMapping(value="/")
	public String index(BlogPost blogPost) {
		return "blogpost/index";
	}

}