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
                "De gemeente Den Haag investeert in duurzame stadsontwikkeling en groene parken.",
                "Nederland heeft een uitgebreid netwerk van fietspaden dat dagelijks wordt gebruikt.",
                "Kunstmatige intelligentie verandert de manier waarop bedrijven werken.",
                "De Nederlandse spoorwegen verbinden alle grote steden efficiënt met elkaar.",
                "Gezonde voeding speelt een belangrijke rol in het welzijn van mensen.",
                "De Amsterdamse grachten zijn een belangrijk cultureel erfgoed.",
                "Zonnepanelen worden steeds vaker gebruikt op Nederlandse daken.",
                "Universiteiten in Nederland trekken studenten van over de hele wereld aan.",
                "De Nederlandse economie is sterk afhankelijk van internationale handel.",
                "Waterbeheer is cruciaal in een land dat grotendeels onder zeeniveau ligt.",

                "Softwareontwikkeling vereist kennis van programmeertalen zoals Java en Python.",
                "De overheid stimuleert elektrisch rijden om CO2-uitstoot te verminderen.",
                "Musea in Nederland tonen kunst van zowel oude meesters als moderne kunstenaars.",
                "De landbouwsector in Nederland is technologisch zeer geavanceerd.",
                "Veel Nederlandse steden hebben historische centra met oude gebouwen.",
                "Openbaar vervoer wordt steeds duurzamer en efficiënter gemaakt.",
                "Cybersecurity is belangrijk om digitale systemen te beschermen.",
                "De Nederlandse taal wordt door miljoenen mensen gesproken.",
                "Klimaatverandering heeft invloed op de stijgende zeespiegel.",
                "Innovatie speelt een grote rol in de Nederlandse industrie.",

                "Bibliotheken bieden toegang tot boeken, e-books en digitale archieven.",
                "De Rotterdamse haven is een van de grootste ter wereld.",
                "Gezonde levensstijl omvat voldoende beweging en rust.",
                "Nederland organiseert elk jaar veel culturele festivals.",
                "De zorgsector werkt steeds meer met digitale systemen.",
                "Windmolens zijn een bekend symbool van Nederland.",
                "Veel bedrijven werken hybride of volledig op afstand.",
                "Onderwijs in Nederland is toegankelijk en van hoge kwaliteit.",
                "Duurzame energiebronnen worden steeds belangrijker.",
                "De overheid investeert in slimme infrastructuur.",

                "Data-analyse helpt bedrijven betere beslissingen te nemen.",
                "Nederland heeft een rijke geschiedenis van handel en scheepvaart.",
                "Steden zoals Utrecht en Leiden hebben historische universiteiten.",
                "De digitale transformatie verandert de arbeidsmarkt.",
                "Kunst en cultuur zijn belangrijk in de Nederlandse samenleving.",
                "De Noordzee is belangrijk voor visserij en energieproductie.",
                "Technologische startups groeien snel in Nederland.",
                "Fietsen is een populair vervoermiddel in steden.",
                "De bouwsector richt zich steeds meer op duurzaamheid.",
                "Gezondheidszorg wordt ondersteund door innovatieve technologie.",

                "Nederland heeft een gematigd zeeklimaat met milde winters.",
                "Veel mensen gebruiken apps voor dagelijks bankieren.",
                "De overheid ondersteunt duurzame landbouwprojecten.",
                "Internationale samenwerking is belangrijk voor Nederland.",
                "E-commerce groeit snel in de Nederlandse markt.",
                "Scholen gebruiken steeds vaker digitale leermiddelen.",
                "De Nederlandse kust trekt veel toeristen in de zomer.",
                "Bedrijven investeren in kunstmatige intelligentie.",
                "Stedelijke planning richt zich op leefbaarheid en groen.",
                "Nederland is een belangrijk logistiek knooppunt in Europa."
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
