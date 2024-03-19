package com.example.practical_13_json_networkcommunicationsservices;

import android.content.Context;
import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.toolbox.Volley;

public class MySingleton (

        private static MySingleton mySingleton;
        private RequestQueue requestQueue;
        private static Context mctx;

        public MySingleton(Context contect) {
                mctx=context;
                requestQueue= getRequestQueue();
            }

    public RequestQueue getRequestQueue() {
        if (requestQueue == null) {
            requestQueue = Volley.newRequestQueue(mctx.getApplicationContext());
        }
        return requestQueue;
    }

    public static synchronized MySingleton getInstance(Context context) {
        if (mySingleton == null) {
            mySingleton = new MySingleton(context);
        }
        return mySingleton;
    }

    public <T> void addToRequest(Request<T> request) {
        requestQueue.add(request);

    }
}
