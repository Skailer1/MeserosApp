package com.example.meserosapp.data.request;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Routes {
    private String id;
    private JSONObject routes;

    public Routes(String id) {
        this.routes = new JSONObject();
        this.id = id;
        addRoute();

    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }

    public void addRoute(){

    try {
        this.routes.put("addProduct","v1/pedido");
        this.routes.put("createEmployee","v1/empleado");
        this.routes.put("deleteOrder","v1/pedido/"+getId()+"");
        this.routes.put("listByOrder", "v1/pedido/detalle/"+getId());
        this.routes.put("listByCatgory","v1/producto/tipo/"+getId()+"");


    } catch (Exception e){

    }
         }

    public JSONObject getRoutes() {
        return routes;
    }

    public void setRoutes(JSONObject routes) {
        this.routes = routes;
    }
}
