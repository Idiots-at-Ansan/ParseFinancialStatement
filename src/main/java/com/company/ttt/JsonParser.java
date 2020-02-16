package com.company.ttt;

import java.io.IOException;

import org.springframework.stereotype.Controller;

import com.fasterxml.jackson.core.JsonParseException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.company.dto.SearchResultDTO;
@Controller
public class JsonParser {
	public static String test_val = "{\n" + 
			"	\"status\":\"000\",\n" + 
			"	\"message\":\"정상\",\n" + 
			"	\"page_no\":1,\n" + 
			"	\"page_count\":10,\n" + 
			"	\"total_count\":4,\n" + 
			"	\"total_page\":1,\n" + 
			"	\"list\":[\n" + 
			"		{\n" + 
			"			\"corp_code\":\"00126380\",\n" + 
			"			\"corp_name\":\"삼성전자\",\n" + 
			"			\"stock_code\":\"005930\",\n" + 
			"			\"corp_cls\":\"Y\",\n" + 
			"			\"report_nm\":\"분기보고서 (2019.09)\",\n" + 
			"			\"rcept_no\":\"20191114001273\",\n" + 
			"			\"flr_nm\":\"삼성전자\",\n" + 
			"			\"rcept_dt\":\"20191114\",\n" + 
			"			\"rm\":\"\"\n" + 
			"		},\n" + 
			"		{\n" + 
			"			\"corp_code\":\"00126380\",\n" + 
			"			\"corp_name\":\"삼성전자\",\n" + 
			"			\"stock_code\":\"005930\",\n" + 
			"			\"corp_cls\":\"Y\",\n" + 
			"			\"report_nm\":\"반기보고서 (2019.06)\",\n" + 
			"			\"rcept_no\":\"20190814002218\",\n" + 
			"			\"flr_nm\":\"삼성전자\",\n" + 
			"			\"rcept_dt\":\"20190814\",\n" + 
			"			\"rm\":\"\"\n" + 
			"		},\n" + 
			"		{\n" + 
			"			\"corp_code\":\"00126380\",\n" + 
			"			\"corp_name\":\"삼성전자\",\n" + 
			"			\"stock_code\":\"005930\",\n" + 
			"			\"corp_cls\":\"Y\",\n" + 
			"			\"report_nm\":\"분기보고서 (2019.03)\",\n" + 
			"			\"rcept_no\":\"20190515001605\",\n" + 
			"			\"flr_nm\":\"삼성전자\",\n" + 
			"			\"rcept_dt\":\"20190515\",\n" + 
			"			\"rm\":\"\"\n" + 
			"		},\n" + 
			"		{\n" + 
			"			\"corp_code\":\"00126380\",\n" + 
			"			\"corp_name\":\"삼성전자\",\n" + 
			"			\"stock_code\":\"005930\",\n" + 
			"			\"corp_cls\":\"Y\",\n" + 
			"			\"report_nm\":\"사업보고서 (2018.12)\",\n" + 
			"			\"rcept_no\":\"20190401004781\",\n" + 
			"			\"flr_nm\":\"삼성전자\",\n" + 
			"			\"rcept_dt\":\"20190401\",\n" + 
			"			\"rm\":\"연\"\n" + 
			"		}\n" + 
			"	]\n" + 
			"}";
	public SearchResultDTO test(String json) throws JsonMappingException, JsonParseException, IOException  {
		ObjectMapper mapper = new ObjectMapper();
		SearchResultDTO result = mapper.readValue(json, SearchResultDTO.class);
		return result;
	}
}
