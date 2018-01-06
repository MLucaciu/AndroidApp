package com.example.mircea.aplicatiemobila.entity;

import android.content.Intent;
import android.support.v7.app.AlertDialog;

import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.toolbox.Volley;
import com.example.mircea.aplicatiemobila.HomeActivity;
import com.example.mircea.aplicatiemobila.LoginActivity;
import com.example.mircea.aplicatiemobila.LoginRequest;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Helper class for providing sample content for user interfaces created by
 * Android template wizards.
 * <p>
 */
public class Orase {

    /**
     * An array of sample (entity) items.
     */
    public static final List<Oras> ITEMS = new ArrayList<Oras>();

    /**
     * A map of sample (entity) items, by ID.
     */
    public static final Map<String, Oras> ITEM_MAP = new HashMap<String, Oras>();

    private static final int COUNT = 25;

  /*  static {
        // Aduc orasele

        for (int i = 1; i <= COUNT; i++) {
            addItem(createOras(i));
        }
    }*/

    public static void loadOrase(JSONArray jsonObject)
    {
             for (int i = 0; i < jsonObject.length(); i++)
             {
                JSONObject oras = new JSONObject();
                 try {
                     oras = jsonObject.getJSONObject(i);
                 } catch (JSONException e) {
                     e.printStackTrace();
                 }
                 try {
                     ITEMS.add(new Oras(oras.getString("id"),
                             oras.getString("Descriere"),
                             oras.getString("Populatie"),
                             oras.getString("Densitate"),
                             oras.getString("Muzee"),
                             oras.getString("Nume"),
                             oras.getString("Tara"),
                             oras.getString("Ape importante"),
                             oras.getString("Primar"),
                             oras.getString("Personalitati"))
                     );
                     ITEM_MAP.put(oras.getString("id"),new Oras(oras.getString("id"),
                             oras.getString("Descriere"),
                             oras.getString("Populatie"),
                             oras.getString("Densitate"),
                             oras.getString("Muzee"),
                             oras.getString("Nume"),
                             oras.getString("Tara"),
                             oras.getString("Ape importante"),
                             oras.getString("Primar"),
                             oras.getString("Personalitati"))
                     );

                 } catch (JSONException e) {
                     e.printStackTrace();
                 }

             }

             List<Oras> ce = ITEMS;

    }
   /* private static void addItem(Oras item) {
        ITEMS.add(item);
        ITEM_MAP.put(item.id, item);
    }


    private static String makeDetails(int position) {
        StringBuilder builder = new StringBuilder();
        builder.append("Details about Item: ").append(position);
        for (int i = 0; i < position; i++) {
            builder.append("\nMore details information here.");
        }
        return builder.toString();
    }*/

    /**
     * A entity item representing a piece of content.
     */
    public static class Oras {
        public final String id;
        public final String content;
        public  String details = "\n" ;
        public float populatie;
        public String tara;

        public Oras(String id, String desriere, String populatie,String densitate,String muzee,String nume,String tara,String ape,String primar,String personalitati) {
            this.id = id;
            this.content = nume ;
            this.tara = tara;
            this.populatie = Float.parseFloat(populatie);
            this.details += "\n" + "Scurta descriere: " + "\n" + desriere +
                    "\n" + "Populatie aproximativa : " + "\n" + populatie +
                    "\n" + "Densitate: " + "\n"  + densitate +
                    "\n"  + "Muzee Importante: " + "\n" + muzee +
                    "\n"  + "Tara : " + "\n"  + tara +
                    "\n" +  "Prin el trece : " + "\n"  + ape +
                    "\n" + "Primarul este : " + "\n"  + primar +
                    "\n"  + "Personalitati importante: " + "\n" + personalitati + "\n"  ;
        }

        @Override
        public String toString() {
            return content;
        }
    }
}
