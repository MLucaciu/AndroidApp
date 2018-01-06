package com.example.mircea.aplicatiemobila;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mircea.aplicatiemobila.entity.Orase;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

public class HomeActivity extends AppCompatActivity {
    Session sesiune;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        TextView home = (TextView) findViewById(R.id.text_home);
        Button logout = (Button) findViewById(R.id.button_logout);
        Button search = (Button) findViewById(R.id.button_search);
        Button orase = (Button) findViewById(R.id.button_orase);
        Button grafic = (Button) findViewById(R.id.button_chart);
        sesiune = new Session(this);
        if(sesiune.getLogged())
        {
            //daca e logat
            home.setText("Bine ai venit domnule   " + sesiune.getUsername());


        }
        else
        {
            Intent login = new Intent(HomeActivity.this,LoginActivity.class);
            HomeActivity.this.startActivity(login);
        }

        Response.Listener<String> responseListener = new Response.Listener<String>() {
            @Override
            public void onResponse(String response) {

                try {
                    JSONObject r = new JSONObject(response);

                    if (r.getBoolean("succes")) {
                        JSONArray orase = r.getJSONArray("orase");
                        Orase.loadOrase(orase);
                        int c=2;

                    } else {

                      int a=2;
                    }
                } catch (JSONException e) {
                    e.printStackTrace();
                }

            }
        };
        GetOraseRequest getOraseRequest = new GetOraseRequest(responseListener);
        RequestQueue queue = Volley.newRequestQueue(HomeActivity.this);
        queue.add(getOraseRequest);



        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(sesiune.getLogged())
                {
                    sesiune.setLoggedIn(false);
                    sesiune.setUsername("");
                    Intent login = new Intent(HomeActivity.this,LoginActivity.class);
                    HomeActivity.this.startActivity(login);
                }
            }
        });

        orase.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent oras = new Intent(HomeActivity.this,OrasListActivity.class);
                HomeActivity.this.startActivity(oras);
            }
        });


        grafic.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                Intent graf = new Intent(HomeActivity.this,CevaActivity.class);
                HomeActivity.this.startActivity(graf);
            }
        });

        search.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

            }
        });
    }
}
