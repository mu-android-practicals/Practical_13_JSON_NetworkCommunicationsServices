package com.example.practical_13_json_networkcommunicationsservices;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.android.volley.Request;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

public class MainActivity extends AppCompatActivity {
    Button button;
    TextView tname,temail,tmobile;
    String Json_url="http://10.0.2.2/scripts/getInfo.php";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        button=findViewById(R.id.btnShow);
        tname = findViewById(R.id.name);
        tmobile = findViewById(R.id.mobile);
        temail = findViewById(R.id.email);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v)  {
                JsonObjectRequest jsonObjectRequest=new
                        JsonObjectRequest(Request.Method.POST, Json_url, (String) null,
                        new Response.Listener<JSONObject>() {
                            @Override
                            public void onResponse(JSONObject response) {
                                    try {
                                tname.setText("Name:"+response.getString("Name"));
                                temail.setText("Email:"+response.getString("Email");
                                tmobile.setText("Mobile:"+response.getString("Mobile"));
                            }catch (Exception e) {

                            }

                        }

            }, new Response.ErrorListener() {
                @Override
                public void onErrorResponse (VolleyError error) {
                    Toast.makeText(getApplicationContext(), "error", Toast.LENGTH_LONG).show();
                }

            }); MySingleton.getInstance(MainActivity.this).addToRequest(jsonObjectRequest);
        }
    });
}
}


