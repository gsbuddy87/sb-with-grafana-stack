package com.gsbuddy.prac.multimodule.sbproject.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClient;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@SpringBootApplication
@RestController
@RequestMapping("/cart")
public class ShoppingCartApplication {

	RestClient restClient = RestClient.create();

	@GetMapping("/getCartAndWishlistItems")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, List<String>> listWishListedItems() {

		List<String> cartItems = List.of("Pager","Pen","Addidas Shoe","Socket");

		List wishListedItems = restClient.get()
				.uri("http://localhost:8001/wish/getWishListedItems")
				.retrieve()
				.body(List.class);

        Map<String, List<String>> result = new HashMap<>();
		result.put("CartItems",cartItems);
		result.put("WishListItems",wishListedItems);

		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

}
