package com.workshop.common.service;

import javax.ws.rs.DefaultValue;
import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.QueryParam;

import java.util.Random;

import org.springframework.stereotype.Component;

@Path("/common")
@Component
public class CommonEndpoint {

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
}
