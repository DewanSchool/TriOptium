package org.acme;

import dev.langchain4j.agent.tool.P;
import jakarta.inject.Inject;
import jakarta.transaction.Transactional;
import jakarta.ws.rs.*;
import org.acme.application.EmbeddingsService;
import org.acme.application.ProductIndexFields;
import org.acme.application.QueryEmbeddingService;
import org.acme.domain.Embeddings;
import org.acme.domain.Embeddings_;
import org.hibernate.search.mapper.orm.mapping.SearchMapping;
import org.hibernate.search.mapper.orm.session.SearchSession;
import org.jboss.resteasy.reactive.RestForm;
import org.jboss.resteasy.reactive.RestQuery;

import java.util.List;

@Path("/embed")
public class EmbedController {
    @Inject
    SearchSession searchSession;

    @Inject
    SearchMapping searchMapping;

    @Inject
    QueryEmbeddingService queryEmbeddingService;

    @Inject
    EmbeddingsService embeddingsService;


    @POST
    @Path("/{text}")
    public String embed(@PathParam("text") String text){
        List<String> dutchTexts = List.of(
                "De gemeente Den Haag organiseert evenementen voor inwoners en bezoekers.",
                "Nederland staat bekend om zijn fietscultuur en goede infrastructuur.",
                "Kunstmatige intelligentie wordt gebruikt om processen slimmer te maken.",
                "De Nederlandse keuken bevat gerechten zoals stamppot en erwtensoep.",
                "Een gezonde levensstijl bestaat uit bewegen, goede voeding en voldoende slaap.",
                "De trein is een belangrijk onderdeel van het openbaar vervoer in Nederland.",
                "Softwareontwikkelaars bouwen applicaties met moderne programmeertalen.",
                "De Noordzee speelt een belangrijke rol in de Nederlandse economie.",
                "Bibliotheken bieden boeken, cursussen en digitale informatie aan.",
                "Duurzame energie wordt steeds belangrijker door klimaatverandering."
        );

        dutchTexts.forEach(embeddingsService::embedText);
        return "created";
    }


    @GET
    @Path("/fulltext")
    @Transactional
    public List<Embeddings> fulltext(@RestQuery String q, @RestQuery @DefaultValue("10") int size) {
        return searchSession.search(Embeddings.class)
                .where(f -> q == null || q.isBlank()
                        ? f.matchAll()
                        : f.simpleQueryString()
                        .fields(ProductIndexFields.TEXT)
                        .matching(q))
                .sort(f -> f.field(ProductIndexFields.TEXT_SORT).asc())
                .fetchHits(size);
    }
}
