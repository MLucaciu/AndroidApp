package com.example.mircea.aplicatiemobila;

import android.content.Intent;
import android.content.pm.PackageInstaller;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class LoginActivity extends AppCompatActivity {

    Session sesiune;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        sesiune = new Session(this);
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        //daca e logat ->> home
        if(sesiune.getLogged())
        {
            Intent goHome = new Intent(LoginActivity.this, HomeActivity.class);
            LoginActivity.this.startActivity(goHome);
        }

        final EditText username = (EditText) findViewById(R.id.field_username);
        final Button buttonLoggin = (Button) findViewById(R.id.button_login);
        final EditText password = (EditText) findViewById(R.id.field_password);
        final Button buttonRegister = (Button) findViewById(R.id.button_register);

        //punem listener pe buton
        buttonLoggin.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
               /* AlertDialog.Builder build = new AlertDialog.Builder(LoginActivity.this);
                build.setMessage("Am trecut de login").setNegativeButton("Retry",null).create().show();*/

                final String user = username.getText().toString();
                String pass = password.getText().toString();

                final Response.Listener<String> resp = new Response.Listener<String>() {
                    @Override
                    public void onResponse(String response) {
                        //vine raspunsul
                        //   String erori = raspuns.getString("errors");

                        try {
                            JSONObject raspuns = new JSONObject(response);
                            //username si succes cu valoare true
                            //error si succes cu valoare fals

                            if (raspuns.getBoolean("succes")) {
                                //succes
                                String user_r = raspuns.getString("username");
                                //din login in home
                                sesiune.setLoggedIn(true);
                                sesiune.setUsername(user_r);
                                //redirect
                                Intent login = new Intent(LoginActivity.this,HomeActivity.class);
                                LoginActivity.this.startActivity(login);

                            } else {
                                //eroare
                                String erori = raspuns.getString("errors");
                                //redirect
                                AlertDialog.Builder build = new AlertDialog.Builder(LoginActivity.this);
                                build.setMessage(erori).setNegativeButton("Retry", null).create().show();

                            }
                        } catch (JSONException e) {
                            //adica nimic
                            e.printStackTrace();
                        }
                    }
                };

                LoginRequest loginRequest = new LoginRequest(user, pass, resp);

                //trebuie trimis
                //def request
                RequestQueue queue = Volley.newRequestQueue(LoginActivity.this);
                queue.add(loginRequest);

            }



        });


        buttonRegister.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {

                Intent register = new Intent(LoginActivity.this,RegisterActivity.class);
                LoginActivity.this.startActivity(register);
            }



        });

    }
}
