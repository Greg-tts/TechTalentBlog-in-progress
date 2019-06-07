package com.dojo.miyagi.blogPost;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.view.RedirectView;

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
		DateFormat dateFormat = new SimpleDateFormat("yyyy/MM/dd HH:mm:ss");
		model.addAttribute("serverTime", dateFormat.format(new Date()));
		model.addAttribute("posts", posts);
		return "blogpost/blogPostHome";
	}
	
	@PostMapping(value="/blogpost/new")
	public String addNewBlogPost(BlogPost blogPost, Model model) {		
		blogPostRepository.save(blogPost);
		posts.add(blogPost);
		model.addAttribute("postId", blogPost.getPostId());
		model.addAttribute("title", blogPost.getName());
		model.addAttribute("author", blogPost.getAuthor());
		model.addAttribute("blogEntry", blogPost.getBody());
		return "blogpost/result";
	}
	
	public void delete(long id){
        int postIndex = -1;
        for(BlogPost post : posts) {
            if(post.getPostId() == id) {
                postIndex = posts.indexOf(post);
                continue;
            }
        }
        if(postIndex > -1){
            posts.remove(postIndex);
        }
    }
//	Delete URL: localhost:8080/blogpost/1
	@RequestMapping(value = "/blogpost/{id}", method = RequestMethod.DELETE)
	public RedirectView deletePostWithId(@PathVariable Long id, BlogPost blogpost)
	{
		System.out.println("!!!!!!~~~~~~~" + id + "~~~~~~~~~~!!!!!!!");
		delete(id);
		blogPostRepository.deleteById(id);
		return new RedirectView("/");
	}
}