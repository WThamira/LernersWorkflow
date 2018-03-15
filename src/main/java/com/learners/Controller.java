package com.learners;

import java.util.Map;

import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/test/")
public class Controller {
	
	@RequestMapping(method=RequestMethod.POST,value="me")
    public String fileComplaint(@RequestBody Map<String, String> request) {
		System.err.println(request.get("email"));
		return request.get("email");
    }
	
	@RequestMapping("daily")
    public String file() {
		System.err.println("Thamira");
		return "Thamira";
    }
}
