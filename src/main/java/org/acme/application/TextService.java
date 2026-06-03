package org.acme.application;

import dev.langchain4j.model.embedding.EmbeddingModel;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.domain.Text;

import java.util.List;

@ApplicationScoped
public class TextService {

    @Inject
    EntityManager em;

    @Inject
    EmbeddingModel embeddingModel;

    @Transactional
    public void createText() {
        Text text = new Text();
        text.setName("hello");
        em.persist(text);
    }

    public List<Float> embedText(String text){
        return embeddingModel.embed(text).content().vectorAsList();
    }

}
