package com.company.ttt;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import javax.inject.Inject;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.ui.Model;

import com.company.dto.FinaccialResultDTO;
import com.company.dto.FinancialDTO;
import com.company.dto.SearchDTO;
import com.company.dto.SearchResultDTO;


public class ApiRequester {
	
	@Autowired
	private MongoTemplate mongoTemplate;
	
	@Inject
	private static JsonParser parser = new JsonParser();
	
	private static final Logger logger = LoggerFactory.getLogger(ApiRequester.class);
	
	private static String api_key = "crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff";
	private static String api_search_uri = "https://opendart.fss.or.kr/api/list.json?" + api_key;
	public static String test_api_search_uri = "https://opendart.fss.or.kr/api/list.json?crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff&corp_code=005930&bgn_de=20190101&end_de=20200117&last_reprt_at=Y&pblntf_ty=A&pblntf_detail_ty=A001&page_no=1&page_count=10";
	// https://opendart.fss.or.kr/api/fnlttXbrl.xml?crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff&rcept_no=20190401004781&reprt_code=11011
	private static String api_get_xbrl_uri = "https://opendart.fss.or.kr/api/fnlttXbrl.xml?" + api_key;// +																									// "&rcept_no=%s&reprt_code=%s";
	public static String test_api_get_xbrl_uri = "https://opendart.fss.or.kr/api/fnlttXbrl.xml?crtfc_key=2dbd19cc94394f79a0f7c17c1efad4a9c20b79ff&rcept_no=20190401004781&reprt_code=11011";
	private static String api_get_financialdata_uri = "https://opendart.fss.or.kr/api/fnlttSinglAcntAll.json?" + api_key;
	
	public static FinancialDTO DownloadTest(String corp_code, String year, String type) throws ClientProtocolException, IOException {
		//https://opendart.fss.or.kr/api/fnlttSinglAcntAll.json?crtfc_key=xxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxxx&corp_code=00356370&bsns_year=2018&reprt_code=11011&fs_div=OFS
		String uri = api_get_financialdata_uri + "&corp_code=" + corp_code + "&bsns_year=" + year + "&reprt_code=" + type + "&fs_div=CFS";
		String testVal = GetContents(uri);
		System.out.println(testVal);

		FinancialDTO result_obj = parser.FinancialResultDTOFromJSON(testVal);
		
		return result_obj;
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
		
		SearchResultDTO result_obj = parser.MakeSearchResultDTOFromJSON(result_json);
		
		
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
	
//	private static void DownloadContent(String uri) throws ClientProtocolException, IOException {
//		HttpManager httpManager = HttpManager.GetInstance();
//		CloseableHttpResponse httpResponse = httpManager.MakeResponse(uri);
//		HttpEntity entity = httpResponse.getEntity();
//		int responseCode = httpResponse.getStatusLine().getStatusCode();
//		
//		InputStream is = entity.getContent();
//		String filePath = System.getProperty("user.dir") + "/tmpdownload";
//		File f = new File(filePath);
//		if (!f.exists())
//		{
//			f.mkdirs();
//		}
//		
//		filePath += "/" + System.currentTimeMillis() + ".zip";
//		FileOutputStream fos = new FileOutputStream(new File(filePath));
//		int inByte;
//		while ((inByte = is.read()) != -1) {
//			fos.write(inByte);
//		}
//		is.close();
//		fos.close();
//		httpManager.DisposeHttpClient();
//	}
	
}
