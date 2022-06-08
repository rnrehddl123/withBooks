package com.mvc.withbooks;

import javax.servlet.http.HttpServletRequest;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class CartController {
	@RequestMapping("/list_cart.do")
	public String listCart() {
		return "cart/cartList";
	}
	
	@RequestMapping("/order_cart.do")
	public String order() {
		return "cart/order";
	}
}
