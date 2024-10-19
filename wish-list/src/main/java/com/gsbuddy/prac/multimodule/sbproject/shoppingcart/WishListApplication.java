package com.gsbuddy.prac.multimodule.sbproject.shoppingcart;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@SpringBootApplication
@RestController
@RequestMapping("/wish")
public class WishListApplication {

	@GetMapping("/getWishListedItems")
	@ResponseStatus(HttpStatus.OK)
	public List<String> listWishListedItems() {

        return List.of("mobile","television","sunglasses");
	}
	public static void main(String[] args) {
		SpringApplication.run(WishListApplication.class, args);
	}

}
