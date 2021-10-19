package com.example.springboot;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.ui.Model;
import java.text.SimpleDateFormat;  
import java.util.Date;  

@Controller
public class HelloController {

	// @GetMapping("/")
	// public String index() {
	// 	return "Greetings from Spring Boot!";
    // }
    
    @GetMapping("/")
	public String greeting(@RequestParam(name="name", required=false, defaultValue="World") String name, Model model) {
		model.addAttribute("name", name);
		return "greeting";
	}

	@GetMapping("/xkcd")
	public String xkcd() {
		return "xkcd";
	}
    // Request parameter method
	@GetMapping("/xkcdSpec")
	public String xkcdSpecific(@RequestParam(name="id", required=false) String id, Model model) {
		if(id == null){
			id = "200";
		}
		model.addAttribute("id", id);
		return "xkcdSpecific";
	}


	Date date = new Date();  
	SimpleDateFormat formatter = new SimpleDateFormat("yyyy/mm/dd");  
	String currentDate= formatter.format(date); 


	@GetMapping("/nasaapod")
	public String nasaApod(@RequestParam(name="date", required=false) String date, Model model) {
		// if(api_key == null){
		// 	api_key = "65VM0mvvF4QCsovmTQ86mbsLHndn14oLLWw61lgi";
		// }
		if(date == null){
			date = currentDate;
		}
		model.addAttribute("date", date);
		return "nasaApod";
	}

	// path variable method
	// @GetMapping("/xkcdSpec/{id}")
	// public String xkcdSpecific(@PathVariable String id, Model model) {
	// 	model.addAttribute("id", id);
	// 	return "xkcdSpecific";
	// }

	// @GetMapping("/nasaapod/{date}")
	// public String nasaApod(@PathVariable String date, Model model) {
	// 	model.addAttribute("date", date);
	// 	return "nasaApod";
	// }

}
