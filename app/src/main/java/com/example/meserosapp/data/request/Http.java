package com.example.meserosapp.data.request;

import android.os.AsyncTask;

import com.android.volley.toolbox.JsonObjectRequest;

import org.json.JSONObject;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.io.OutputStreamWriter;
import java.net.HttpURLConnection;
import java.net.URL;

public class Http extends AsyncTask <Void,Void,String>  {

    private Routes routes;
    private String host;
    private String useRoute;
    private String token;
    private JSONObject jsonObject;
    private Integer method;
    private Long id;



    public Http(String route, String token, JSONObject jsonObject, Integer peticion) {
        this.routes = new Routes();
        this.host = "http://sgp-unibague.herokuapp.com:80/";
        this.useRoute = route;
        this.token = token;
        this.jsonObject = jsonObject;
        this.method = peticion;



    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    @Override
    protected String doInBackground(Void... voids) {
        try {


            JSONObject tempRoute = routes.getRoutes();
            if(getId()!= null){
                this.routes.setId(getId());
            }
            String urlServer = host +  tempRoute.getString(this.useRoute);
            URL url = new URL (urlServer);
            HttpURLConnection httpURLConnection = (HttpURLConnection)url.openConnection() ;
            httpURLConnection.setDoOutput(true);
            if (method == 1){
            httpURLConnection.setRequestMethod("POST");}
            else if (method ==2){
            httpURLConnection.setRequestMethod("GET");}
            else if (method == 3){
            httpURLConnection.setRequestMethod("DELETE");}
            httpURLConnection.setRequestProperty("Content-Type","application/json");
            httpURLConnection.setRequestProperty("Authorization","Bearer "+ token );
            httpURLConnection.setUseCaches(false);
            httpURLConnection.setAllowUserInteraction(false);
            //httpURLConnection
            httpURLConnection.setConnectTimeout(15000);
            httpURLConnection.setReadTimeout(15000);
            httpURLConnection.connect();
            OutputStreamWriter wr = new OutputStreamWriter(httpURLConnection.getOutputStream());
            wr.write(this.jsonObject.toString());
            wr.flush();
            wr.close();
            try{
                BufferedReader br = new BufferedReader(new InputStreamReader(httpURLConnection.getInputStream()));
                StringBuilder sb = new StringBuilder();
                String line;
                while ((line = br.readLine()) != null) {
                    sb.append(line + "\n");
                }
                br.close();
                return sb.toString();
            }catch (Exception e){
                System.out.println(e);
                return "500";
            }
        }catch (Exception e){
            System.out.println(e);
            return "404";
        }

    }
    @Override
    protected void onPostExecute(String s) {

    }

}
