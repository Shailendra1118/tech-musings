package com.sports.rafael.leetcode;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;

public class RestCore {

    public static void main(String[] args) throws IOException, JSONException {
        String team = "Barcelona";
        int year = 2011;
        //first call
        Integer homeGoals = 0;
        Integer awayGoals = 0;
        int page = 0;
        getHomeGoals(team, year, homeGoals, page);
        //getAwayGoals(team, year, awayGoals, page);
        System.out.println("homeGoals: "+homeGoals);
        System.out.println("awayGoals: "+awayGoals);
    }

    private static void getHomeGoals(String team, int year, Integer homeGoals, int page) throws IOException, JSONException {
        URL url = new URL("https://jsonmock.hackerrank.com/api/football_matches?year="+year+"&team1="+team+"&page="+page);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        StringBuilder output = new StringBuilder();
        JSONObject jsonObject;
        String temp;
        System.out.println("Output from Server .... \n");
        while ((temp = br.readLine()) != null) {
            output.append(temp);
            System.out.println(output);
            System.out.println("Next...");
        }
        jsonObject = new JSONObject(output.toString());
        JSONArray arr = jsonObject.getJSONArray("data");
        for(int i=0; i<arr.length(); i++){
            JSONObject obj = (JSONObject) arr.get(i);
            homeGoals += Integer.valueOf(obj.getString("team1goals"));
        }
        System.out.println("Goals: "+homeGoals);

        int totalPages = jsonObject.getInt("total_pages");
        System.out.println("TotalPage: "+totalPages);
        int curPage = Integer.valueOf(jsonObject.getString("page"));
        System.out.println("CurPage: "+curPage);
        if(curPage < totalPages) {
            getHomeGoals(team, year, homeGoals, ++page);
        }else{
            conn.disconnect();
            return;
        }

    }

    private static void getAwayGoals(String team, int year, Integer awayGoals, int page) throws IOException, JSONException {
        URL url = new URL("https://jsonmock.hackerrank.com/api/football_matches?year="+year+"&team2="+team+"&page="+page);
        HttpURLConnection conn = (HttpURLConnection) url.openConnection();
        conn.setRequestMethod("GET");
        conn.setRequestProperty("Accept", "application/json");

        if (conn.getResponseCode() != 200) {
            throw new RuntimeException("Failed : HTTP error code : "
                    + conn.getResponseCode());
        }

        BufferedReader br = new BufferedReader(new InputStreamReader(
                (conn.getInputStream())));

        StringBuilder output = new StringBuilder();
        JSONObject jsonObject;
        String temp;
        System.out.println("Output from Server .... \n");
        while ((temp = br.readLine()) != null) {
            output.append(temp);
            //System.out.println(output);
            //System.out.println("Next...");
        }
        jsonObject = new JSONObject(output.toString());
        JSONArray arr = jsonObject.getJSONArray("data");
        for(int i=0; i<arr.length(); i++){
            JSONObject obj = (JSONObject) arr.get(i);
            awayGoals += Integer.valueOf(obj.getString("team2goals"));
        }

        int totalPages = jsonObject.getInt("total_pages");
        int curPage = Integer.valueOf(jsonObject.getString("page"));
        if(curPage < totalPages) {
            getAwayGoals(team, year, awayGoals, ++page);
        }else{
            conn.disconnect();
            return;
        }

    }
}
