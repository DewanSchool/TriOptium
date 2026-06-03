//package org.acme;
//
//import io.quarkus.runtime.Startup;
//import jakarta.enterprise.context.ApplicationScoped;
//import jakarta.enterprise.event.Observes;
//import org.acme.application.EmbeddingsService;
//
//import java.util.List;
//
//@ApplicationScoped
//public class EmbeddingsSeeder {
//
//    private final EmbeddingsService embeddingsService;
//
//    public EmbeddingsSeeder(EmbeddingsService embeddingsService) {
//        this.embeddingsService = embeddingsService;
//    }
//
//    void onStart(@Observes Startup event) {
//
//        List<String> dutchTexts = List.of(
//                "De gemeente Den Haag organiseert evenementen voor inwoners en bezoekers.",
//                "Nederland staat bekend om zijn fietscultuur en goede infrastructuur.",
//                "Kunstmatige intelligentie wordt gebruikt om processen slimmer te maken.",
//                "De Nederlandse keuken bevat gerechten zoals stamppot en erwtensoep.",
//                "Een gezonde levensstijl bestaat uit bewegen, goede voeding en voldoende slaap.",
//                "De trein is een belangrijk onderdeel van het openbaar vervoer in Nederland.",
//                "Softwareontwikkelaars bouwen applicaties met moderne programmeertalen.",
//                "De Noordzee speelt een belangrijke rol in de Nederlandse economie.",
//                "Bibliotheken bieden boeken, cursussen en digitale informatie aan.",
//                "Duurzame energie wordt steeds belangrijker door klimaatverandering."
//        );
//
//        dutchTexts.forEach(embeddingsService::embedText);
//    }
//}
