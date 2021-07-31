package com.workshop.common.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.util.Random;

import org.springframework.stereotype.Component;

import org.springframework.beans.factory.annotation.Autowired;
import com.workshop.common.entity.*;
import java.util.List;
import java.util.ArrayList;
import java.util.Iterator;

@Path("/common")
@Component
public class CommonEndpoint {

    //Define Repository
    @Autowired
    private VehicleRepository repository;

    @GET
    @Path("/carplate")
    @Produces("application/json")
    public String getCarPlate(@QueryParam("type") @DefaultValue("WEEKEND") String type) {
        String plateNo = "SNA";

        Random rnd = new Random();
        int number = rnd.nextInt(9999);

        char[] normal = {'A', 'B', 'C', 'D', 'E', 'F', 'G', 'H', 'I', 'J'};
        char[] weekend = {'K', 'L', 'M', 'N', 'O', 'P', 'Q', 'R', 'S', 'T'};
        int nextChar = rnd.nextInt(9);

        plateNo = plateNo + String.valueOf(number);
        
        if("WEEKEND".equals(type)) {
            plateNo = plateNo + weekend[nextChar];
        } else {
            plateNo = plateNo + normal[nextChar];
        }

        return plateNo;
    }

    @GET
    @Path("/getvehiclebyuser")
    @Produces("application/json")
    public List<VehicleEntity> getVehiclesByUser(@QueryParam("user") String user) {
        List<VehicleEntity> result = null;

        if (user == null) {
            result = new ArrayList<VehicleEntity>();
            Iterator<VehicleEntity> iter = repository.findAll().iterator();
            while(iter.hasNext()) {
                result.add(iter.next());
            }
        } else {
            result = repository.findByUser(user); 
        }
        return result;
    }

    @GET
    @Path("/getvehiclebycarplate")
    @Produces("application/json")
    public List<VehicleEntity> getVehiclesByCarplate(@QueryParam("carplate") @DefaultValue("NOASSIGN") String carplate) {
        return repository.findByCarplate(carplate);
    }
}
