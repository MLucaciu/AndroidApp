package com.example.mircea.aplicatiemobila;

import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;

import org.json.JSONException;
import org.json.JSONObject;

public class RegisterActivity extends AppCompatActivity {

    Session sesiune;
    EditText username;
    EditText password;
    EditText email;
    Button reg_button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        this.username = (EditText) findViewById(R.id.reg_field_username);
        this.password = (EditText) findViewById(R.id.reg_field_password);
        this.email = (EditText) findViewById(R.id.reg_field_email);
         this.reg_button = (Button) findViewById(R.id.buttonRegisterReg);

    }

    protected void onStart(){
        super.onStart();
        sesiune = new Session(this);



        reg_button.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {
                String user = username.getText().toString();
                String pass = password.getText().toString();
                String em = email.getText().toString();

                final Response.Listener<String> resp = new Response.Listener<String>(){

                    @Override
                    public void onResponse(String response) {
                        //vine raspunsul
                        //   String erori = raspuns.getString("errors");

                        try {
                            JSONObject raspuns = new JSONObject(response);
                            //username si succes cu valoare true
                            //error si succes cu valoare fals

                            if (raspuns.getBoolean("succes")) {

                                //TODO - pentru email , dar e trimis de pe server

                              /*  Intent intent = new Intent(Intent.ACTION_SENDTO); // it's not ACTION_SEND
                                intent.setType("text/plain");
                                intent.putExtra(Intent.EXTRA_SUBJECT, "Subject of email");
                                intent.putExtra(Intent.EXTRA_TEXT, "Body of email");
                                intent.setData(Uri.parse("mailto:default@recipient.com")); // or just "mailto:" for blank
                                intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK); // this will make such that when user returns to your app, your app is displayed, instead of the email app.
                                startActivity(intent);*/

                                //TODO ##################################

                                //succes
                                String user_r = raspuns.getString("username");
                                //din login in home
                                sesiune.setLoggedIn(true);
                                sesiune.setUsername(user_r);
                                //redirect
                                Intent home = new Intent(RegisterActivity.this,HomeActivity.class);
                                RegisterActivity.this.startActivity(home);

                            } else {
                                //eroare
                                String erori = raspuns.getString("errors");
                                //redirect
                                AlertDialog.Builder build = new AlertDialog.Builder(RegisterActivity.this);
                                build.setMessage(erori).setNegativeButton("Retry", null).create().show();

                            }
                        } catch (JSONException e) {
                            //adica nimic
                            e.printStackTrace();
                        }
                    }
                };
                RegisterRequest regRequest = new RegisterRequest(user, pass, em,resp);

                //trebuie trimis
                //def request
                RequestQueue queue = Volley.newRequestQueue(RegisterActivity.this);
                queue.add(regRequest);
            }
        });

    }
}
