package com.example.myapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.app.DownloadManager;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.StringRequest;
import com.android.volley.toolbox.Volley;

public class MainActivity2 extends AppCompatActivity {

    Button b1, b2, b3, b4;
    TextView textView;
    RequestQueue queue;
    boolean change;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        b1 = (Button) findViewById(R.id.button_api);
        b2 = (Button) findViewById(R.id.button_save);
        b3 = (Button)  findViewById(R.id.button_load);
        b4 = (Button)  findViewById(R.id.button_previous);

        textView = (TextView) findViewById(R.id.text);

        change = true;


        queue = Volley.newRequestQueue(this);

        b1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String url = "https://www.reverso.net/orthographe/correcteur-francais/";
                // Request a string response from the provided URL.
                if(change == true)
                {
                    textView.setBackgroundColor(Color.WHITE);

                    StringRequest stringRequest = new StringRequest(Request.Method.GET, url,
                            new Response.Listener<String>() {
                                @Override
                                public void onResponse(String response) {
                                    // Display the first 500 characters of the response string.
                                    textView.setText("Response is: " + response.substring(0, 500));
                                }
                            }, new Response.ErrorListener() {
                        @Override
                        public void onErrorResponse(VolleyError error) {
                            textView.setText("That didn't work!");
                        }
                    });
                    // Add the request to the RequestQueue.
                    queue.add(stringRequest);
                }
                }

        });



        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                startActivity(new Intent(MainActivity2.this, MainActivity.class));
            }
        });


    }
}