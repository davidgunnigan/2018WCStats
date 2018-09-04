package com.wc2018stats;

import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonObject;
import com.google.gson.reflect.TypeToken;

import java.io.*;
import java.lang.reflect.Type;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.List;
import java.util.Map;

public class DataRetriever {

    private static final String API_ENDPOINT = "http://worldcup.sfg.io";
    private static final String API_ENDPOINT_PASTEBIN = "https://pastebin.com/qVTXBsBr";
    private static final String DOC_LOCATION = "C:\\Users\\Dave\\Dropbox\\World Cup JSON files\\WorldCup2018Matches.txt";
    private static final String FLAGS_JSON_ENDPOINT = "https://pastebin.com/KHDkrMjF";
    private static final String FLAGS_LOCATION = "C:\\Users\\Dave\\IdeaProjects\\WorldCup2018\\src\\main\\configuration\\flags.json";

    private String getData(URL url) throws IOException {

        InputStream inputStream =  url.openStream();
        try {
            BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));
            StringBuilder builder = new StringBuilder();
            String line;
            while ((line = reader.readLine()) != null) {
                builder.append(line);
            }
            return builder.toString();
        } finally { //This always gets called before we return
            inputStream.close();
        }
    }

    public String getAllMatches() throws IOException {
        URL url = new URL(API_ENDPOINT + "/matches");

        return getData(url);
    }

    public String getTeams() throws IOException {
        URL url = new URL(API_ENDPOINT + "/teams/results");

        return getData(url);
    }

    public String getMatchesFromFile() throws IOException {
        String matchesFile = readFile(DOC_LOCATION);
        return matchesFile;
    }

    public TeamFlagProvider getFlagProvider() throws IOException {
        String flagsJson = readFile(FLAGS_LOCATION);
        Map<String, String> teamFlags = parseFlags(flagsJson);
        return new TeamFlagProvider(teamFlags);
    }

    public Map<String, String> parseFlags(String flagsJSON) {
        Gson gson = new Gson();
        Type type = new TypeToken<Map<String, String>>() {
        }.getType();
        Map<String, String> myMap = gson.fromJson(flagsJSON, type);
        return myMap;
    }

    public List<Team> parseTeams(String teamsJson) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return gson.fromJson(teamsJson, new TypeToken<List<Team>>(){}.getType());
    }

    public List<Match> parseMatches (String matchesJson) {
        Gson gson = new GsonBuilder()
                .setFieldNamingPolicy(FieldNamingPolicy.LOWER_CASE_WITH_UNDERSCORES)
                .create();
        return gson.fromJson(matchesJson, new TypeToken<List<Match>>(){}.getType());
    }

    public List<Match> getAllMatchesList () throws IOException {
        String matchesJson = this.getMatchesFromFile();
        List<Match> matches = this.parseMatches(matchesJson);
        return matches;
    }


    public String readFile(String filename) throws IOException {
        //InputStream resourceAsStream = DataRetriever.class.getResourceAsStream("configuration/flags.json");
        InputStream inputStream = new FileInputStream(filename);
        BufferedReader reader = new BufferedReader(new InputStreamReader(inputStream));

        StringBuilder fileContents = new StringBuilder();
        String line;
        while ((line = reader.readLine()) != null) {
            fileContents.append(line);
        }

        return fileContents.toString();
    }

/*
    public static void main(String[] args) throws IOException {
        DataRetriever dr = new DataRetriever();
        String teamsJson = dr.getTeams();
        List<Team> teams = dr.parseTeams(teamsJson);
        System.out.println(new Gson().toJson(teams));
    }*/
}
