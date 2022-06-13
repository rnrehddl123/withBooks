package com.mvc.withbooks;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	@RequestMapping("/listCart")
	public String listCart() {
		return "cart/cartList";
	}
	
	@RequestMapping("/orderCart")
	public String order() {
		return "cart/order";
	}
}
