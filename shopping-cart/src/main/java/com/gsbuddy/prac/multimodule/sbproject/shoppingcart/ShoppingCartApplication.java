package com.gsbuddy.prac.multimodule.sbproject.shoppingcart;

import lombok.extern.slf4j.Slf4j;
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
@Slf4j
public class ShoppingCartApplication {

	private final RestClient restClient;

	public ShoppingCartApplication(RestClient.Builder restClientBuilder) {
		this.restClient = restClientBuilder.baseUrl("http://localhost:8001").build();
	}

	@GetMapping("/getCartAndWishlistItems")
	@ResponseStatus(HttpStatus.OK)
	public Map<String, List<String>> listWishListedItems() {

		log.info("I am in ShoppingCartApplication");
		List<String> cartItems = List.of("Pager","Pen","Addidas Shoe","Socket");

		log.info("About to call WishListApplication from ShoppingCartApplication");
		List wishListedItems = restClient.get()
				.uri("/wish/getWishListedItems")
				.retrieve()
				.body(List.class);

        Map<String, List<String>> result = new HashMap<>();
		result.put("CartItems",cartItems);
		result.put("WishListItems",wishListedItems);
		log.info("Ready to return the map");

		return result;
	}

	public static void main(String[] args) {
		SpringApplication.run(ShoppingCartApplication.class, args);
	}

}
