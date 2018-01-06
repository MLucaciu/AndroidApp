package com.example.mircea.aplicatiemobila;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mircea on 1/2/2018.
 */

public class RegisterRequest extends StringRequest{
    public static final String URL = "https://travian-npc.000webhostapp.com/RegisterMircea.php";

    private Map<String,String> params;

    public RegisterRequest(String username, String password, String email,Response.Listener<String> listener){
        super(Method.POST, URL , listener , null);
        params= new HashMap<>();
        params.put("username",username);
        params.put("password", password);
        params.put("email",email);
    }

    @Override
    public Map<String,String> getParams(){
        return params;
    }
}
