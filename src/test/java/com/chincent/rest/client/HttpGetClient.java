package com.chincent.rest.client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.nio.charset.Charset;

import org.apache.commons.codec.binary.Base64;
import org.apache.http.HttpHeaders;
import org.apache.http.HttpResponse;
import org.apache.http.HttpStatus;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.impl.client.HttpClientBuilder;

public class HttpGetClient {
	private final static String URL_SECURED_BY_BASIC_AUTHENTICATION = "http://localhost:7001/RestApp2/rest/msg/get/3";
	private final static String USER = "weblogic";
	private final static String PASSWORD = "weblogic15";

	public static void main(String a[]) {

		HttpGet request = new HttpGet(URL_SECURED_BY_BASIC_AUTHENTICATION);
		String auth = USER + ":" + PASSWORD;
		byte[] encodedAuth = Base64.encodeBase64(auth.getBytes(Charset.forName("ISO-8859-1")));
		String authHeader = "Basic " + new String(encodedAuth);
		request.setHeader(HttpHeaders.AUTHORIZATION, authHeader);

		HttpClient client = HttpClientBuilder.create().build();
		HttpResponse response = null;
		try {
			response = client.execute(request);
			int statusCode = response.getStatusLine().getStatusCode();
			if (HttpStatus.SC_OK == statusCode) {
				BufferedReader rd = new BufferedReader(
						new InputStreamReader(response.getEntity().getContent()));

					StringBuffer result = new StringBuffer();
					String line = "";
					while ((line = rd.readLine()) != null) {
						result.append(line);
					}
					
					System.out.println(result);
			} else {
				throw new RuntimeException("Failed!");
			}
		} catch (ClientProtocolException e) {
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

		// int statusCode = response.getStatusLine().getStatusCode();
		// assertThat(statusCode, HttpStatus.SC_OK);
	}
}