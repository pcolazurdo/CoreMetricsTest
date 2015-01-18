package com.singularidad.pcolazurdo.coremetrics_test;

import org.apache.http.HttpVersion;
import org.apache.http.client.HttpClient;
import org.apache.http.conn.ClientConnectionManager;
import org.apache.http.conn.params.ConnManagerParams;
import org.apache.http.conn.scheme.PlainSocketFactory;
import org.apache.http.conn.scheme.Scheme;
import org.apache.http.conn.scheme.SchemeRegistry;
import org.apache.http.impl.client.DefaultHttpClient;
import org.apache.http.impl.conn.tsccm.ThreadSafeClientConnManager;
import org.apache.http.params.BasicHttpParams;
import org.apache.http.params.HttpParams;
import org.apache.http.params.HttpProtocolParams;

public class TaggingHttpClient {
	private static TaggingHttpClient instance;
	private HttpClient httpClient;

	private TaggingHttpClient() {
        // Create and initialize HTTP parameters
        HttpParams params = new BasicHttpParams();
        ConnManagerParams.setMaxTotalConnections(params, 100);
        HttpProtocolParams.setVersion(params, HttpVersion.HTTP_1_1);
        
        // Create and initialize scheme registry 
        SchemeRegistry schemeRegistry = new SchemeRegistry();
        schemeRegistry.register(new Scheme("http", PlainSocketFactory.getSocketFactory(), 80));
        schemeRegistry.register(new Scheme("https", PlainSocketFactory.getSocketFactory(), 443));
        
        // Create an HttpClient with the ThreadSafeClientConnManager for thread-safe.
        ClientConnectionManager cm = new ThreadSafeClientConnManager(params, schemeRegistry);
        this.httpClient = new DefaultHttpClient(cm, params);
	}

	public static TaggingHttpClient getInstance() {
		if (null == instance){
			instance = new TaggingHttpClient();
		}
		
		return instance;
	}

	public TaggingRequest createRequest() {
		TaggingRequest request = new TaggingRequest(this.httpClient);
		
		return request;
	}
}