package com.singularidad.pcolazurdo.coremetrics_test;

import android.app.Activity;
import android.os.Bundle;

public class CMAndroidTagging extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        TaggingRequest myRequest = TaggingHttpClient.getInstance().createRequest();
        myRequest.firePageview("AND:PAGEID","AND:CAT","99999999999999999999999");
    }
}