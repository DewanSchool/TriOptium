package org.acme.application;

import dev.langchain4j.data.document.Document;
import dev.langchain4j.data.document.Metadata;
import dev.langchain4j.model.embedding.EmbeddingModel;
import dev.langchain4j.store.embedding.EmbeddingStoreIngestor;
import io.quarkiverse.langchain4j.pgvector.PgVectorEmbeddingStore;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.domain.Text;

import java.util.List;
import java.util.Map;

@ApplicationScoped
public class TextService {

    @Inject
    EntityManager em;

    @Inject
    EmbeddingModel embeddingModel;

    public List<Float> embedText(String text){


        return embeddingModel.embed(text).content().vectorAsList();
    }

    @Transactional
    public void createText() {
        Text text = new Text();
        text.setName("hello");
        em.persist(text);
    }

}
