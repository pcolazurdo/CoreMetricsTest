# CoreMetrics_Test Application
## This sample project will help you to find out how to use the tagging functions for the IBM Digital Analytics for Android Platform 

Each button will fire a different tagging event (right now we are only working with TaggingRequest)

To make this work, you'll have to add a new java class called TaggingProperties where to setup the key variables for your Coremetrics account


```java
package com.ibm.pcolazurdo.coremetrics_test;

public class TaggingProperties {
    private static final String clientID = "your_client_id";
    protected static final String appName = "your_appname_as_defined_in_your_coremetrics_account";


    private static TaggingProperties mInstance = null;

    private TaggingProperties(){

    }

    public static TaggingProperties getInstance(){
        if(mInstance == null)
        {
            mInstance = new TaggingProperties();
        }
        return mInstance;
    }

    public String getClientID() {
        return clientID;
    }

    public String getAppName() {
        return appName;
    }

    public String getHost() {
        return "http://testdata.coremetrics.com/eluminate?ci=" + clientID; // for Coremetrics test environment
	//return "http://www.coremetrics.com/eluminate?ci=" + clientID;
    }
}
