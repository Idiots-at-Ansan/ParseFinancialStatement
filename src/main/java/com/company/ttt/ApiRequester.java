package com.company.ttt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;

import com.company.dto.SearchDTO;

@Controller
public class ApiRequester {
	private static final Logger logger = LoggerFactory.getLogger(ApiRequester.class);
	private String api_key = "crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff";
	
	private String api_search_uri = "https://opendart.fss.or.kr/api/list.json?" + api_key;
	
	public static String test_api_search_uri = "https://opendart.fss.or.kr/api/list.json?crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff&corp_code=005930&bgn_de=20190101&end_de=20200117&last_reprt_at=Y&pblntf_ty=A&pblntf_detail_ty=A001&page_no=1&page_count=10";
	
	//https://opendart.fss.or.kr/api/fnlttXbrl.xml?crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff&rcept_no=20190401004781&reprt_code=11011
	private String api_get_xbrl_uri = "https://opendart.fss.or.kr/api/fnlttXbrl.xml?=" + api_key;// + "&rcept_no=%s&reprt_code=%s";
	static public String test_api_get_xbrl_uri = "https://opendart.fss.or.kr/api/fnlttXbrl.xml?crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff&rcept_no=20190401004781&reprt_code=11011";
	@RequestMapping(value="getList")
	public String test(@ModelAttribute("searchDTO")SearchDTO searchDTO) throws Exception {
		System.out.println("code : " + searchDTO.getCorp_code());
		System.out.println("type : " + searchDTO.getPblntf_detail_ty());
		System.out.println("stDate : " + searchDTO.getDgn_de());
		System.out.println("endDate : " + searchDTO.getEnd_de());
		String url = api_search_uri;
		String type = searchDTO.getPblntf_detail_ty();
		String bgn_de = searchDTO.getDgn_de();
		String end_de = searchDTO.getEnd_de();
		
		bgn_de = bgn_de.replaceAll("-", "");
		end_de = end_de.replaceAll("-", "");
		url = url + "&corp_code=" + searchDTO.getCorp_code();
		url = url + "&bgn_de=" + bgn_de;
		url = url + "&end_de=" + end_de;
		if(type == "A" || type.equals("A"))
			url = url + "&pblntf_ty=" + searchDTO.getPblntf_detail_ty();
		else 
			url = url + "&pblntf_detail_ty=" + searchDTO.getPblntf_detail_ty();
		
		System.out.println(url);
		String result_json = this.Requester(url);
		System.out.print(result_json);
		return "test";
	
	}
	
	public String Requester(String uri) throws ClientProtocolException, IOException {
		CloseableHttpClient httpClient = HttpClients.createDefault();
		HttpGet httpGet = new HttpGet(uri);
		httpGet.addHeader("User-Agent", "Mozila/5.0");
		CloseableHttpResponse httpResponse = httpClient.execute(httpGet);
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();
		httpClient.close();
		//System.out.println(response.toString());
		logger.info(response.toString());
		return response.toString();
	}
	
}
