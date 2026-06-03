package org.acme;

import jakarta.ws.rs.GET;
import jakarta.ws.rs.POST;
import jakarta.ws.rs.Path;
import jakarta.ws.rs.Produces;
import jakarta.ws.rs.core.MediaType;
import org.acme.application.TextService;

@Path("/hello")
public class GreetingResource {

    private  final TextService textService;

    public GreetingResource(TextService textService) {
        this.textService = textService;
    }

    @GET
    @Produces(MediaType.TEXT_PLAIN)
    public String hello() {
        return "Hello from Quarkus REST";
    }

//    @POST
//    public String text(){
//        this.textService.ingest(1L);
//        return  "Created";
//    }
}
