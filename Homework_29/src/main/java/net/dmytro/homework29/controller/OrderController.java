package net.dmytro.homework29.controller;

import net.dmytro.homework29.order.Order;
import net.dmytro.homework29.service.Service;

import javax.ws.rs.*;
import javax.ws.rs.core.MediaType;
import javax.ws.rs.core.Response;

@Path("/orders")
public class OrderController {
    Service service = new Service();


    
    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getAll(){
        return Response.ok(service.getAll()).build();
    }

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public Response getOrderById(@QueryParam("id") int id){
        return Response.ok(service.getById(id)).build();
    }
    @POST
    @Produces(MediaType.APPLICATION_JSON)
    public Response addOrder(Order order){
        return Response.ok(service.add(order)).build();
    }

}
