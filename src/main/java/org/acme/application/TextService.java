package org.acme.application;

import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;
import jakarta.persistence.EntityManager;
import jakarta.transaction.Transactional;
import org.acme.domain.Text;

@ApplicationScoped
public class TextService {

    @Inject
    EntityManager em;

    @Transactional
    public void createText() {
        Text text = new Text();
        text.setName("hello");
        em.persist(text);
    }

}
