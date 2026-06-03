package org.acme;

import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.application.TextService;

import java.util.List;

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

    @POST
    public String text(){
        this.textService.createText();
        return  "Created";
    }

    @PATCH
//    @Path("/embed")
    public List<Float> embed(){
        String text = "This is embeded text";
        return this.textService.embedText(text);
    }
}
