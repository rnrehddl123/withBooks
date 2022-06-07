package com.mvc.withbooks;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class BookController {
	
	
	@RequestMapping("/readBook")
	public String ReadBook() {
		return "/book/readBook";
	}
}
