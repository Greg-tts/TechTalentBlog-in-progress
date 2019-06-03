package com.dojo.miyagi.blogPost;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {
	private BlogPost blogPost;

	@Autowired
	private BlogPostRepository blogPostRepository;
	
	
	@GetMapping(value="/blogpost")
	public String index(BlogPost blogPost) {
		return "blogpost/index";
	}
	
	@PostMapping(value="/blogpost")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
//		blogPostRepository.save(new BlogPost(blogPost.getName(), blogPost.getAuthor(), blogPost.getBody()));
		model.addAttribute("name", blogPost.getName());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("body", blogPost.getBody());
		return "blogpost/result";
	}

}