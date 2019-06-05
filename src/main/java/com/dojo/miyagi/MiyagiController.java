package com.dojo.miyagi;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import com.dojo.miyagi.blogPost.BlogPost;


@Controller
public class MiyagiController {
	
	@GetMapping(value="/")
	public String index()
	{
		return "pages/index";
	}
	
	@GetMapping(value="/about")
	public String about()
	{
		return "pages/about";
	}
	
}
