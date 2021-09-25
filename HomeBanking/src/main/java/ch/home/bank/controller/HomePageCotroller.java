package ch.home.bank.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class HomePageCotroller {
	
	@RequestMapping("/")
	public String index(){
		return "First page html" ;
	}

}
