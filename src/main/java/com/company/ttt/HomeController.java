package com.company.ttt;

import java.io.IOException;
import java.lang.reflect.Field;
import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Locale;

import javax.inject.Inject;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.company.ttt.service.HomeService;
import com.company.dto.SearchDTO;
import com.company.dto.SearchItemDTO;
import com.company.dto.SearchResultDTO;
import javax.servlet.http.*;
//import com.company.ttt.service.HomeService;
/**
 * Handles requests for the application home page.
 */
@Controller
public class HomeController {
	
	private static final Logger logger = LoggerFactory.getLogger(HomeController.class);
	
	private static void getMemberFields(Object obj) throws IllegalAccessException,
    NoSuchFieldException{
		 HashMap<String, Object> fieldValues = new HashMap<String, Object>();
		        Class<?> objClass = obj.getClass();
		
		Field[] fields = objClass.getDeclaredFields();
		for(Field field : fields)
		{
		    field.setAccessible(true);
		    fieldValues.put(field.getName(), field.get(obj));
		    if (!field.getType().isPrimitive() && !field.getType().getName().contains("java.lang"))
		    {
		        getMemberFields(field.get(obj));
		    }
		}
		Iterator<String> keys = fieldValues.keySet().iterator();
		while( keys.hasNext() ){
            String key = keys.next();
            if (key == "list") {
            	for (SearchItemDTO item: (ArrayList<SearchItemDTO>)fieldValues.get(key)) {
            		getMemberFields(item);
            	}
            }
            logger.info( String.format("키 : %s, 값 : %s", key, fieldValues.get(key)) );
        }
	}
	
	@RequestMapping(value = "/philip", method = RequestMethod.GET)
	public String home_philip(Model model) throws IOException, IllegalAccessException, NoSuchFieldException {
		/*
		ApiRequester tester = new ApiRequester();
		String val = "";
		try  {
			val = tester.Requester(ApiRequester.test_api_search_uri);
		} catch (IOException e) {
			logger.debug("IOException error");
		}
		
		model.addAttribute("testvalue", val );
		
		//return "home";
		 */
		//JsonParser parser = new JsonParser();
		//SearchResultDTO result = parser.test(JsonParser.test_val);
		//getMemberFields(result);
		ApiRequester tester = new ApiRequester();
		String xbrl_log = tester.Requester(ApiRequester.test_api_get_xbrl_uri);
		logger.info(xbrl_log);
		return "test";
	}
	
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
