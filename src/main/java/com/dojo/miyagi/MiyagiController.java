package com.dojo.miyagi;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

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
