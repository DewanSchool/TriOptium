package org.acme.application;


import org.acme.domain.Embeddings;
import org.acme.domain.Embeddings_;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;

public final class ProductIndexFields {

    private ProductIndexFields() {
    }

    public static final String TEXT = Embeddings_.TEXT;
    public static final String ID = Embeddings_.ID;


    public static final String TEXT_SORT = "text_sort";
}