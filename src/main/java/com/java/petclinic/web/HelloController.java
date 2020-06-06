package com.java.petclinic.web;

import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.java.petclinic.service.PetClinicService;

/**
 * @author Burak
 *
 */
@Controller
public class HelloController {

	@Autowired
	private PetClinicService petClinicService;
	
	@RequestMapping(value = "/owners")
	public ModelAndView getOwners() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("owners", petClinicService.findOwners());
		modelAndView.setViewName("owner");
		return modelAndView;
	}
	
	@RequestMapping(value = "/sayHello")
	public ModelAndView sayHello() {
		ModelAndView modelAndView = new ModelAndView();
		modelAndView.addObject("message", "Hello");
		modelAndView.addObject("currentTime", new Date());
		modelAndView.setViewName("hello");
		return modelAndView;
	}
}
