package com.example.mircea.aplicatiemobila;

import com.android.volley.Response;
import com.android.volley.toolbox.StringRequest;

import java.util.Map;

/**
 * Created by Mircea on 1/2/2018.
 */

public class GetOraseRequest extends StringRequest{
    public static final String URL = "https://travian-npc.000webhostapp.com/getCityMircea.php";

    private Map<String,String> params;

    public GetOraseRequest(Response.Listener<String> listener){
        super(Method.GET, URL , listener , null);
    }

    @Override
    public Map<String,String> getParams(){
        return params;
    }
}
