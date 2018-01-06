package com.example.mircea.aplicatiemobila;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by Mircea on 11/16/2017.
 */

public class SearchRequest extends StringRequest{
    public static final String URL = "https://travian-npc.000webhostapp.com/searchCityMircea.php";
    //tool volley pt requesturi !
    private Map<String,String> params;

    public SearchRequest(String name, Response.Listener<String> listener){
        super(Method.POST, URL , listener , null);
        params= new HashMap<>();
        params.put("name",name);
    }

    @Override
    public Map<String,String> getParams(){
        return params;
    }
}
