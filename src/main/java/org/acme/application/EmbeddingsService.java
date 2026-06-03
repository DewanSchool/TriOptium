package org.acme.application;

import dev.langchain4j.model.embedding.EmbeddingModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.domain.Embeddings;

import java.util.List;

@ApplicationScoped
public class EmbeddingsService{

    @Inject
    EntityManager em;

    @Inject
    EmbeddingModel embeddingModel;

    @Transactional
    public Embeddings embedText(String text){

        Embeddings embeddings = new Embeddings.Builder()
                .text(text)
                .descriptionEmbedding(embeddingModel
                        .embed(text)
                        .content()
                        .vector())
                .build();
        em.persist(embeddings);
        return embeddings;
    }
}
