package com.singularidad.pcolazurdo.coremetrics_test;

import android.util.Log;

import org.apache.http.NameValuePair;
import org.apache.http.client.ClientProtocolException;
import org.apache.http.client.HttpClient;
import org.apache.http.client.methods.HttpGet;
import org.apache.http.message.BasicNameValuePair;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.List;

public class TaggingRequest {

	
    private static final String clientID = TaggingProperties.getInstance().getClientID();
    protected static final String appName = TaggingProperties.getInstance().getAppName();
	
    private static final String HOST = TaggingProperties.getInstance().getHost();
    
	private String url;
	private String method;
	private String phoneNum;
	private String sessionID;
	private String tempHost;
	private List<NameValuePair> params;
	private HttpGet getRequest;
	private String result;
	private HttpClient httpClient;
	private String stParam;
	

	public TaggingRequest(HttpClient client){
		this.httpClient = client;
		this.params = new ArrayList<NameValuePair>(2);
	}

	public String getUrl(){
		return this.url;
	}
	
	public void setUrl(String url){
		this.url = url;
	}

	public String getMethod(){
		return this.method;
	}
	
	public void setMethod(String method){
		this.method = method;
	}

	public void addParam(String key, String value){
		this.params.add(new BasicNameValuePair(key, value));
	}

	public String getResult(){
		return this.result;
	}

	public void fireTaggingRequest(String clientID, String username, String phoneNum, String pi, String cg, String lp, String rf) {
		this.phoneNum = phoneNum;

		setUrl(HOST);
		setMethod("GET");
	    
	    addParam("tid", "1");
	    addParam("pv1", clientID);
	    addParam("pv_a1", clientID);
	    addParam("pv2", username);
	    addParam("pv_a2", username);
	    addParam("pv6", "S");
	    addParam("pv_a6", "S");
	    addParam("pv8", "I");
	    addParam("pv_a8", "I");
	    addParam("pv10", "1.0");
	    addParam("pv_a10", "1.0");
	    addParam("ci", "10000020");
	    addParam("vn2", "e4.0");	    
	    addParam("vn1", "4.3.0");
	    addParam("ec", "UTF-8");
	    addParam("pi", pi);
	    addParam("pn", pi);
	    addParam("cg", cg);
	    addParam("ul", lp);
	    addParam("rf", rf);
	    addParam("lp", lp);
	    addParam("cjen", "1");
	    addParam("cjuid", "1000000000000"+phoneNum);
	    addParam("cjvf", "1");
	    
	    Calendar cal = Calendar.getInstance();
	    addParam("st", cal.getTimeInMillis()/1000+"");
	    
	    java.util.Random randomGenerator = new java.util.Random();
	    sessionID = randomGenerator.nextInt(100000)+""+randomGenerator.nextInt(100000)+""+randomGenerator.nextInt(100000)+""+randomGenerator.nextInt(100000);
	    addParam("cjsid", sessionID);

        try {
            executeInNewThread();
        }
        catch (Exception e) {
            Log.d("Exception:", e.toString());
            //Log.d("Exception:", e.toString());
        }
	}

	public void firePageview(String pi, String cg, String phoneNum) {
		
		Calendar cal = Calendar.getInstance();
	    this.stParam = cal.getTimeInMillis()/1000+"";
		
	    this.sessionID = phoneNum.substring(13);
	        
		this.tempHost = HOST + "&tid=1&vn2=mobile&vn1=4.1.1&ec=UTF-8&pi=" + pi + "&cg=" + cg + "&ul=" + appName + "&cjen=1&cjuid=" + phoneNum + "&cjsid=" + sessionID + "&cjvf=1&st=" + stParam;
	    
		setUrl(tempHost);
		setMethod("GET");
		
		execute();
	    
		//Log.w("BOT_PV", tempHost);
	    //Log.w("BOT_PV", "BOT_PV");
	}
	
	public void fireProductview(String pi, String pr, String pm, String cg, String phoneNum) {
		
		Calendar cal = Calendar.getInstance();
	    this.stParam = cal.getTimeInMillis()/1000+"";
		
	    this.sessionID = phoneNum.substring(13);
	        
		this.tempHost = HOST + "&tid=5&vn2=mobile&vn1=4.1.1&ec=UTF-8&pi=" + pi + "&pr=" + pr + "&pm=" + pm + "&cg=" + cg + "&pc=N&ul=" + appName + "&cjen=1&cjuid=" + phoneNum + "&cjsid=" + sessionID + "&cjvf=1&st=" + stParam;
	    
		setUrl(tempHost);
		setMethod("GET");
		
		execute();
		
	    //Log.w("BOT_PRV", tempHost);
	    //Log.w("BOT_PRV", "BOT_PRV");
	}
	
	public void fireShopAction5(String pr, String pm, String qt, String bp, String cg, String cc, String phoneNum) {
		
		Calendar cal = Calendar.getInstance();
	    this.stParam = cal.getTimeInMillis()/1000+"";
		
	    this.sessionID = phoneNum.substring(13);
	        
		this.tempHost = HOST + "&tid=4&vn2=mobile&vn1=4.1.1&ec=UTF-8&at=5&pr=" + pr + "&pm=" + pm + "&qt=" + qt + "&bp=" + bp + "&cc=" + cc + "&cg=" + cg + "&pc=N&ul=" + appName + "&cjen=1&cjuid=" + phoneNum + "&cjsid=" + sessionID + "&cjvf=1&st=" + stParam;
	    
		setUrl(tempHost);
		setMethod("GET");
		
		execute();
		
	    //Log.w("BOT_SH5", tempHost);
	    //Log.w("BOT_SH5", "BOT_SH5");	
	}
	
	public void fireShopAction9(String pr, String pm, String qt, String bp, String cg, String on, String tr, String cd, String cc, String phoneNum) {
		
		Calendar cal = Calendar.getInstance();
	    this.stParam = cal.getTimeInMillis()/1000+"";
		
	    this.sessionID = phoneNum.substring(13);
	        
		this.tempHost = HOST + "&tid=4&vn2=mobile&vn1=4.1.1&ec=UTF-8&at=9&pr=" + pr + "&pm=" + pm + "&qt=" + qt + "&bp=" + bp + "&on=" + on + "&tr=" + tr + "&cd=" + cd + "&cc=" + cc + "&cg=" + cg + "&pc=N&ul=" + appName + "&cjen=1&cjuid=" + phoneNum + "&cjsid=" + sessionID + "&cjvf=1&st=" + stParam;
	    
		setUrl(tempHost);
		setMethod("GET");
		
		execute();
		
	    //Log.w("BOT_SH9", tempHost);
	    //Log.w("BOT_SH9", "BOT_SH9");
	}

	public void fireOrder(String on, String tr, String sg, String cd, String ct, String sa, String zp, String cc, String phoneNum ) {
		
		Calendar cal = Calendar.getInstance();
	    this.stParam = cal.getTimeInMillis()/1000+"";
		
	    this.sessionID = phoneNum.substring(13);
	        
		this.tempHost = HOST + "&tid=3&vn2=mobile&vn1=4.1.1&ec=UTF-8&on=" + on + "&tr=" + tr + "&sg=" + sg + "&cd=" + cd + "&ct=" + ct + "&sa=" + sa + "&zp=" + zp + "&cc=" + cc + "&ul=" + appName + "&cjen=1&cjuid=" + phoneNum + "&cjsid=" + sessionID + "&cjvf=1&st=" + stParam;
	    
		setUrl(tempHost);
		setMethod("GET");
		
		execute();
		
	    //Log.w("BOT_ORD", tempHost);
	    //Log.w("BOT_ORD", "BOT_ORD");
	}
	
	public void fireRegistration(String cd, String em, String ct, String sa, String zp, String phoneNum) {
		
		Calendar cal = Calendar.getInstance();
	    this.stParam = cal.getTimeInMillis()/1000+"";
		
	    this.sessionID = phoneNum.substring(13);
	        
		this.tempHost = HOST + "&tid=2&vn2=mobile&vn1=4.1.1&ec=UTF-8&cd=" + cd + "&em=" + em + "&ct=" + ct + "&sa=" + sa + "&zp=" + zp + "&ul=" + appName + "&cjen=1&cjuid=" + phoneNum + "&cjsid=" + sessionID + "&cjvf=1&st=" + stParam;
	    
	    
		setUrl(tempHost);
		setMethod("GET");
		
		execute();
		
	    //Log.w("BOT_REG", tempHost);
	    //Log.w("BOT_REG", "BOT_REG");
	}
	
	public void fireElement(String eid, String ecat, String phoneNum) {
		
		Calendar cal = Calendar.getInstance();
	    this.stParam = cal.getTimeInMillis()/1000+"";
		
	    this.sessionID = phoneNum.substring(13);
	        
		this.tempHost = HOST + "&tid=15&vn2=mobile&vn1=4.1.1&ec=UTF-8&eid=" + eid + "&ecat=" + ecat + "&pflg=0&ul=" + appName + "&cjen=1&cjuid=" + phoneNum + "&cjsid=" + sessionID + "&cjvf=1&st=" + stParam;
	    
	    
		setUrl(tempHost);
		setMethod("GET");
		
		execute();
		
	    //Log.w("BOT_ELE", tempHost);
	    //Log.w("BOT_ELE", "BOT_ELE");
	}
	
	public void fireConversionEvent(String cid, String cat, String ccid, String cpt, String phoneNum) {
		
		Calendar cal = Calendar.getInstance();
	    this.stParam = cal.getTimeInMillis()/1000+"";
		
	    this.sessionID = phoneNum.substring(13);
	        
		this.tempHost = HOST + "&tid=14&vn2=mobile&vn1=4.1.1&ec=UTF-8&cid=" + cid + "&cat=" + cat + "&ccid=" + ccid + "&cpt=" + cpt + "&ul=" + appName + "&cjen=1&cjuid=" + phoneNum + "&cjsid=" + sessionID + "&cjvf=1&st=" + stParam;
	    
	    
		setUrl(tempHost);
		setMethod("GET");
		
		execute();
		
	    //Log.w("BOT_CVR", tempHost);
	    //Log.w("BOT_CVR", "BOT_CVR");
	}

	public void fireLinkClick(String pi, String nm, String hr, String phoneNum) {
		
		Calendar cal = Calendar.getInstance();
	    this.stParam = cal.getTimeInMillis()/1000+"";
		
	    this.sessionID = phoneNum.substring(13);
	        
		this.tempHost = HOST + "&tid=8&vn2=mobile&vn1=4.1.1&ec=UTF-8&pi=" + pi + "&nm=" + nm + "&hr=" + hr + "&ti=" + stParam + "&ul=" + appName + "&cjen=1&cjuid=" + phoneNum + "&cjsid=" + sessionID + "&cjvf=1&st=" + stParam;
	    
	    
		setUrl(tempHost);
		setMethod("GET");
		
		execute();
		
	    //Log.w("BOT_LCK", tempHost);
	    //Log.w("BOT_LCK", "BOT_LCK");
	}
	
	public void fireImpression(String pi, String sp, String re, String phoneNum) {
		
		Calendar cal = Calendar.getInstance();
	    this.stParam = cal.getTimeInMillis()/1000+"";
		
	    this.sessionID = phoneNum.substring(13);
	        
		this.tempHost = HOST + "&tid=9&vn2=mobile&vn1=4.1.1&ec=UTF-8&pi=" + pi + "&cm_sp=" + sp + "&cm_re=" + re + "&ul=" + appName + "&cjen=1&cjuid=" + phoneNum + "&cjsid=" + sessionID + "&cjvf=1&st=" + stParam;
	    
	    
		setUrl(tempHost);
		setMethod("GET");
		
		execute();
		
	    //Log.w("BOT_IMP", tempHost);
	    //Log.w("BOT_IMP", "BOT_IMP");
	}

    public void executeInNewThread() {
        new Thread(new Runnable() {
            public void run() {
                execute();
            }
        }).start();
    }

	public void execute() {
		try {
			if (this.method.compareToIgnoreCase("GET") == 0) {
				
				//Log.w("TEST","TOP EXECUTE GET");
				
				this.getRequest = new HttpGet(this.getUrl());
				
				//Log.w("TEST","BEFORE GET REQUEST");
				this.httpClient.execute(this.getRequest);
				//Log.w("TEST","AFTER GET REQUEST");
			}/*else if(this.method.compareToIgnoreCase("POST") == 0) {
				this.postRequest = new HttpPost(this.getUrl());
                this.postRequest.setEntity(new UrlEncodedFormEntity(this.params));
                // for(NameValuePair nvp : this.params) {
                // this.postRequest.setParams(new BasicHttpParams().setParameter(nvp.getName(),
                // nvp.getValue()));
                // }
                this.httpClient.execute(this.postRequest);
			}
			*/
			
			this.result = "Request sent ("+phoneNum+") ("+sessionID+")";
						
			
		} catch (ClientProtocolException e) {
			this.result = e.getMessage();
			
			//Log.w("TEST","PROTOCOL EXCEPTION");
		} catch (IOException e) {
			//Log.w("TEST","IO EXCEPTION");
			
			this.result = e.toString();
			//Log.w("TEST",this.result);
			
		}
	}
}