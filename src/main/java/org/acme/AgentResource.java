package org.acme;


import jakarta.inject.Inject;
import jakarta.ws.rs.*;
import jakarta.ws.rs.core.MediaType;
import org.acme.application.ReasoningAgent;

@Path("/agent")
@Consumes(MediaType.APPLICATION_JSON)
@Produces(MediaType.APPLICATION_JSON)
public class AgentResource {

    @Inject
    ReasoningAgent reasoningAgent;

    @POST
    public String ask(PromptRequest request) {
        return reasoningAgent.chat(request.prompt());
    }
}
