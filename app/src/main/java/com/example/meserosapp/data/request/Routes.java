package com.example.meserosapp.data.request;

import org.json.JSONArray;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

public class Routes {
    private Long id;
    private JSONObject routes;

    public Routes() {
        this.routes = new JSONObject();
        addRoute();

    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public void addRoute(){

    try {
        this.routes.put("addProduct","v1/pedido");
        this.routes.put("createEmployee","v1/empleado");
        this.routes.put("deleteOrder","v1/pedido/101");
        this.routes.put("listByOrder", "v1/pedido/detalle/102");
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
