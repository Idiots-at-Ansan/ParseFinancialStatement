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
import java.util.regex.Matcher;
import java.util.regex.Pattern;

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
	
	private String[] GetReportTypeFromReportNM(String report_nm) {
		/*
		    1분기보고서 : 11013
			반기보고서 : 11012
			3분기보고서 : 11014
			사업보고서 : 11011
		 */
		String data = "분기보고서 (2019.09)";
		data = data.replaceAll("[^\\d]","");
		String year =  data.substring(0, 4);
		int month = Integer.parseInt(data.substring(4, 6));
		String type = "";
		switch (month) {
		case 3:
			type = "11013";
			break;
		case 6:
			type = "11012";
			break;
		case 9:
			type = "11014";
			break;
		case 12:
			type = "11011";
			break;
		default:
			break;
		}
		String[] ret = {year, type};
		return ret;
	}
	@RequestMapping(value = "/download")
	public String GetFinancialResult(@ModelAttribute("corp_code")String corp_code,@ModelAttribute("report_nm")String report_nm, Model model) throws ClientProtocolException, IOException {
	//public String Download(String corp_code,Model model) throws ClientProtocolException, IOException {
		String[] value = GetReportTypeFromReportNM(report_nm);
		ApiRequester.DownloadTest(corp_code, value[0], value[1]);
		return "ForTest";
	}
}
