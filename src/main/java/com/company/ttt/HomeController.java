package com.company.ttt;

import java.io.IOException;
import java.text.DateFormat;
import java.util.Date;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import javax.servlet.http.*;
import com.company.ttt.service.HomeService;

/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	private HomeService homeService;
	/**
	 * Simply selects the home view to render by returning its name.
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(Model model) {
		ApiRequester tester = new ApiRequester();
		String val = "";
		try  {
			val = tester.Requester(ApiRequester.test_api_search_uri);
		} catch (IOException e) {
			logger.debug("IOException error");
		}
		
		model.addAttribute("testvalue", val );
		
		//return "home";
		return "test";
	}
	@RequestMapping(value="",method = RequestMethod.POST) 
	public String getList(Model model) throws Exception {
		logger.info("getList");
		return "";
	}
}
