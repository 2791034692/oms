package oms.io;

import org.json.JSONArray;
import org.json.JSONException;
import oms.ability.ModAbility;
import oms.content.Intent;


public class JsonArray {
    JSONArray jsonArray;
    public JsonArray(){
        this.jsonArray = new JSONArray();
    }
    public JsonArray(String text){
        try {
            this.jsonArray = new JSONArray(text);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    JsonArray(JSONArray array){
        this.jsonArray = array;
    }
    public int size(){
        return jsonArray.length();
    }
    public void put(int point,String s){
        try {
            jsonArray.put(point,s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void put(int point,int s){
        try {
            jsonArray.put(point,s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void put(int point,boolean s){
        try {
            jsonArray.put(point,s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void put(int point,double s){
        try {
            jsonArray.put(point,s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void put(int point,Json s){
        try {
            jsonArray.put(point,s.jsonObject);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void put(int point,JsonArray s){
        try {
            jsonArray.put(point,s.jsonArray);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void put(String s){
        jsonArray.put(s);
    }
    public void put(double s){
        try {
            jsonArray.put(s);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }
    public void put(int s){
        jsonArray.put(s);
    }
    public void put(boolean s){
        jsonArray.put(s);
    }
    public void put(Json json){
        jsonArray.put(json.jsonObject);
    }
    public void put(JsonArray array){
        jsonArray.put(array.jsonArray);
    }


    public Json getJson(int text){
        try {
            return new Json(this.jsonArray.getJSONObject(text));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public JsonArray getJsonArray(int text){
        try {
            return new JsonArray(this.jsonArray.getJSONArray(text));
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }

    public double getDouble(int t){
        try {
            return jsonArray.getDouble(t);
        } catch (JSONException e) {
            e.printStackTrace();
            return 0;
        }
    }

     public int getInt(int t){
         try {
             return jsonArray.getInt(t);
         } catch (JSONException e) {
             e.printStackTrace();
             return 0;
         }
    }

    public String getString(int t){
        try {
            return jsonArray.getString(t);
        } catch (JSONException e) {
            e.printStackTrace();
            return null;
        }
    }




}
