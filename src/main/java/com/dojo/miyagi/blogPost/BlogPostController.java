package com.dojo.miyagi.blogPost;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class BlogPostController {
	private static List<BlogPost> posts = new ArrayList<>();
	
	@Autowired
	private BlogPostRepository blogPostRepository;
	
	
	@GetMapping(value = "/blogpost/new")
	public String newPost(BlogPost blogPost) {
		return "blogpost/new";
	}
	
	@GetMapping(value = "/blogpost")
	public String index(BlogPost blogPost, Model model) {
		model.addAttribute("posts", posts);
		return "blogpost/blogPostHome";
	}
	
	@PostMapping(value="/blogpost")
	public String addNewBlogPost(BlogPost blogPost, Model model) {
		blogPostRepository.save(new BlogPost(blogPost.getName(), blogPost.getAuthor(), blogPost.getBody()));
		posts.add(blogPost);
		System.out.println(blogPost);
		model.addAttribute("name", blogPost.getName());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("body", blogPost.getBody());
		return "blogpost/result";
	}

}