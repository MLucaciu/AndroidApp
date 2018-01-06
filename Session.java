package com.example.mircea.aplicatiemobila;

import android.content.Context;
import android.content.SharedPreferences;

/**
 * Created by Mircea on 11/16/2017.
 */

public class Session {

    SharedPreferences prefs;
    SharedPreferences.Editor editor;
    Context ctx;

    public Session(Context ctx)
    {
        this.ctx = ctx;
        prefs = ctx.getSharedPreferences("AplicatieMobila", Context.MODE_PRIVATE);
        editor = prefs.edit();
    }

    public void setLoggedIn(boolean loggedin) {
        editor.putBoolean("logged",loggedin);
        editor.commit();
    }

    public void setUsername(String username)
    {
        editor.putString("username",username);
        editor.commit();
    }

    public boolean getLogged()
    {
        return prefs.getBoolean("logged",false);
    }
    public String getUsername(){
        return prefs.getString("username","no-username");
    }
}
