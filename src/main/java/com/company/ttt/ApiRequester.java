package com.company.ttt;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;

import javax.inject.Inject;

import org.apache.http.HttpEntity;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoOperations;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.ModelAndView;

import com.company.dto.SearchDTO;
import com.company.dto.SearchItem;
import com.company.dto.SearchResultDTO;
import com.mysql.cj.mysqlx.protobuf.MysqlxConnection.Close;


public class ApiRequester {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	private static final Logger logger = LoggerFactory.getLogger(ApiRequester.class);
	
	private static String api_key = "crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff";
	private static String api_search_uri = "https://opendart.fss.or.kr/api/list.json?" + api_key;
	public static String test_api_search_uri = "https://opendart.fss.or.kr/api/list.json?crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff&corp_code=005930&bgn_de=20190101&end_de=20200117&last_reprt_at=Y&pblntf_ty=A&pblntf_detail_ty=A001&page_no=1&page_count=10";
	// https://opendart.fss.or.kr/api/fnlttXbrl.xml?crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff&rcept_no=20190401004781&reprt_code=11011
	private static String api_get_xbrl_uri = "https://opendart.fss.or.kr/api/fnlttXbrl.xml?=" + api_key;// +																									// "&rcept_no=%s&reprt_code=%s";
	public static String test_api_get_xbrl_uri = "https://opendart.fss.or.kr/api/fnlttXbrl.xml?crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff&rcept_no=20190401004781&reprt_code=11011";
	
	public static void DownloadTest() throws ClientProtocolException, IOException {
		DownloadContent(test_api_get_xbrl_uri);
		System.out.println("done");
	}
	public static SearchResultDTO GetSearchResult (SearchDTO searchDTO, Model model) throws Exception {
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
		String result_json = GetContents(url);
		System.out.print(result_json);
		JsonParser parser = new JsonParser();
		SearchResultDTO result_obj = parser.test(result_json);
		
		
		/*
		 * DB INSERT {
		 * 
		 * }
		*/
		//MongoOperations mongoOps = (MongoOperations)mongoTemplate;
		//mongoOps.save(result_obj);
		
//		searchTest(result_json);
		
		return result_obj;
	}
	
	private static String GetContents(String uri) throws ClientProtocolException, IOException {
		HttpManager httpManager = HttpManager.GetInstance();
		CloseableHttpResponse httpResponse = httpManager.MakeResponse(uri);
		
		BufferedReader reader = new BufferedReader(new InputStreamReader(
				httpResponse.getEntity().getContent()));
		String inputLine;
		StringBuffer response = new StringBuffer();
		while ((inputLine = reader.readLine()) != null) {
			response.append(inputLine);
		}
		reader.close();
		httpManager.DisposeHttpClient();
		logger.info("test : "+response.toString());
		return response.toString();
	}
	
	private static void DownloadContent(String uri) throws ClientProtocolException, IOException {
		HttpManager httpManager = HttpManager.GetInstance();
		CloseableHttpResponse httpResponse = httpManager.MakeResponse(uri);
		HttpEntity entity = httpResponse.getEntity();
		int responseCode = httpResponse.getStatusLine().getStatusCode();
		
		InputStream is = entity.getContent();
		String filePath = System.getProperty("user.dir") + "/tmpdownload";
		File f = new File(filePath);
		if (!f.exists())
		{
			f.mkdirs();
		}
		
		filePath += "/" + System.currentTimeMillis() + ".zip";
		FileOutputStream fos = new FileOutputStream(new File(filePath));
		int inByte;
		while ((inByte = is.read()) != -1) {
			fos.write(inByte);
		}
		is.close();
		fos.close();
		httpManager.DisposeHttpClient();
	}
	
}
