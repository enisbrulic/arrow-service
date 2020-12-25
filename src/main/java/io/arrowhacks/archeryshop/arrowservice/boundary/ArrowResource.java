package io.arrowhacks.archeryshop.arrowservice.boundary;

import org.eclipse.microprofile.metrics.annotation.Counted;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.Random;

@Path("/speed")
public class ArrowResource {

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    @Counted(name = "speed_service_performed", description = "count the service invokes.")
    public String getSpeed() {
        return String.format("arrow speed measured: %s fps", getRandomArrowSpeed());
    }

    private int getRandomArrowSpeed() {
        return new Random()
                .ints(1, 250, 390)
                .findFirst()
                .orElse(-1);
    }

}