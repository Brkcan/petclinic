package com.java.petclinic.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

/**
 * @author Burak
 *
 */

// Controller bean ile Spring container'da bean yaratılarak ilgili metotlar çalıştırılacak 

@Controller  
public class PetClinicController {

//	ResponseBody olmazsa "welcome to petClinic world" cumlesini bir view olarak görür ve render etmeye çalışır.
//	Spring boot @RequestMapping anotasyonu ile eşleşmayen web isteklerini static resource olarak çözümler.
	
	@RequestMapping(value = "welcome")
	@ResponseBody
	public String welcome() {
		return "Welcome to petClinic world!";
	}
	
}
