package com.example.mircea.aplicatiemobila;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mircea on 11/16/2017.
 */

public class LoginRequest extends StringRequest{
    public static final String URL = "https://travian-npc.000webhostapp.com/LogIn.php";
    //tool volley pt requesturi !
    private Map<String,String> params;

    public LoginRequest(String username, String password, Response.Listener<String> listener){
        super(Method.POST, URL , listener , null);
        params= new HashMap<>();
        params.put("username",username);
        params.put("password", password);
    }

    @Override
    public Map<String,String> getParams(){
        return params;
    }
}
