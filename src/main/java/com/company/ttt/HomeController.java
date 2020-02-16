package com.company.ttt;

import java.io.IOException;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.ttt.service.HomeService;
import com.copany.dto.SearchDTO;

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
	public String home(@ModelAttribute("searchDTO")SearchDTO searchDTO,Model model) {
		
//		ApiRequester tester = new ApiRequester();
//		String val = "";
//		try  {
//			val = tester.Requester(ApiRequester.test_api_search_uri);
//		} catch (IOException e) {
//			logger.debug("IOException error");
//		}
//		
//		model.addAttribute("testvalue", val );
//		
		return "home";
		//return "test";
	}
//	@RequestMapping(value="getList",method = RequestMethod.POST) 
//	public String getList(@ModelAttribute("searchDTO")SearchDTO searchDTO) throws Exception {
//		logger.info("getList");
//		System.out.println("code : " + searchDTO.getCorp_code());
//		System.out.println("type : " + searchDTO.getPblntf_detail_ty());
//		System.out.println("stDate : " + searchDTO.getDgn_de());
//		System.out.println("endDate : " + searchDTO.getEnd_de());
//		return "/";
//	}
}
