package com.company.ttt;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

import javax.inject.Inject;

import org.apache.http.client.ClientProtocolException;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.servlet.ModelAndView;

import com.company.dto.SearchDTO;
import com.company.dto.SearchItem;
import com.company.dto.SearchResultDTO;
import javax.servlet.http.*;
//import com.company.ttt.service.HomeService;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	@Inject
	SearchResultController searchResultController;
	
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(@ModelAttribute("searchDTO")SearchDTO searchDTO, Model model) throws Exception {
		return "home";
	}
	
	@RequestMapping(value = "/getList")
	public ModelAndView GetResult(@ModelAttribute("searchDTO")SearchDTO searchDTO,Model model) throws Exception {
		SearchResultDTO result_obj = ApiRequester.GetSearchResult(searchDTO, model);
		return searchResultController.SearchResultView(result_obj, model);
	}
	
	@RequestMapping(value = "/download")
	public String Download(@ModelAttribute("rcept_no")String rcept_no,Model model) throws ClientProtocolException, IOException {
		ApiRequester.DownloadTest(rcept_no);
		return "ForTest";
	}
}
