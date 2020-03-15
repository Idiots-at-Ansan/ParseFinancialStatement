package com.company.ttt;

import java.io.IOException;

import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.methods.CloseableHttpResponse;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.CloseableHttpClient;
import org.apache.http.impl.client.HttpClients;

public class HttpManager {
	private static HttpManager _instance;

	public static HttpManager GetInstance() {
		if (_instance == null) {
			_instance = new HttpManager();
		}
		return _instance;
	}
	
	private CloseableHttpClient httpClient;
	private HttpGet httpGet;
	private CloseableHttpResponse httpResponse;
	
	private void MakeHttpSocket() {
		if (httpClient == null) {
			httpClient = HttpClients.createDefault();
		}
		else {
			httpClient = null;
			MakeHttpSocket();
		}
	}
	public CloseableHttpResponse MakeResponse(String uri) throws ClientProtocolException, IOException {
		MakeHttpSocket();
		httpGet = new HttpGet(uri);
		httpGet.addHeader("User-Agent", "Mozila/5.0");
		httpResponse = httpClient.execute(httpGet);
		return httpResponse;
	}
	public void DisposeHttpClient() throws IOException {
		if (httpClient != null)
			httpClient.close();
	}
	private static void DownloadContents(CloseableHttpResponse htpResponse) {
		
	}
}
