package com.iu.s4.controller;

import java.text.DateFormat;
import java.util.Date;
import java.util.List;
import java.util.Locale;
import java.util.Random;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.iu.s4.model.BoardVO;
import com.iu.s4.service.BoardNoticeService;
import com.iu.s4.util.Pager;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	@Inject
	private BoardNoticeService boardNoticeService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Locale locale, Model model) {
		logger.info("Welcome home! The client locale is {}.", locale);
		
		Date date = new Date();
		DateFormat dateFormat = DateFormat.getDateTimeInstance(DateFormat.LONG, DateFormat.LONG, locale);
		
		String formattedDate = dateFormat.format(date);
		
		model.addAttribute("serverTime", formattedDate );
		
		return "index";
	}
	
	@PostMapping("testAjax")
	public void testAjax(Model model, int num) throws Exception{
		
	}
	@GetMapping("testAjax")
	public void testAjax() throws Exception{
		
	}
	
	@GetMapping("selectAnimal")
	public void selectAnimal(String sel, Model model) throws Exception{
		
		if(sel.equals("Dog")) {
			model.addAttribute("a", "치와와");
			model.addAttribute("b", "푸들");
			model.addAttribute("c", "말티즈");
		}else if(sel.equals("Cat")){
			model.addAttribute("a", "먼치킨");
			model.addAttribute("b", "러시안블루");
			model.addAttribute("c", "코숏");
		}else if(sel.equals("Bird")) {
			model.addAttribute("a", "앵무새");
			model.addAttribute("b", "부엉이");
			model.addAttribute("c", "닭");
			
		}
		
	}
	
}
