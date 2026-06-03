package org.acme.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import jakarta.persistence.*;
import org.hibernate.annotations.Array;
import org.hibernate.annotations.JdbcTypeCode;
import org.hibernate.search.engine.backend.types.Sortable;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.FullTextField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.Indexed;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.KeywordField;
import org.hibernate.search.mapper.pojo.mapping.definition.annotation.VectorField;
import org.hibernate.type.SqlTypes;

import java.time.LocalDateTime;
import java.util.List;

@Entity
@Indexed
public class Embeddings {

    @Id
    @GeneratedValue
    private Long id;

// https://www.the-main-thread.com/p/full-text-vector-hybrid-search-quarkus-java
    @JsonIgnore
    @VectorField(dimension = 384)
    @JdbcTypeCode(SqlTypes.VECTOR)
    @Array(length = 384)
    public float[] descriptionEmbedding;

    @FullTextField(analyzer = "dutch")
    @KeywordField(name = "text_sort", sortable = Sortable.YES, normalizer = "lowercase")
    @Column(columnDefinition = "text")
    private String text;

    @Column(name = "created_at")
    private LocalDateTime createdAt;

    public Embeddings() {
    }

    public Embeddings(float[] descriptionEmbedding, String text) {
        this.descriptionEmbedding = descriptionEmbedding;
        this.text = text;
        this.createdAt = LocalDateTime.now();
    }

    public static Builder builder() {
        return new Builder();
    }

    public static class Builder {
        private float[] descriptionEmbedding;
        private String text;
        private LocalDateTime createdAt;


        public Builder descriptionEmbedding(float[] descriptionEmbedding) {
            this.descriptionEmbedding = descriptionEmbedding;
            return this;
        }

        public Builder text(String text) {
            this.text = text;
            return this;
        }
        public Embeddings build() {
            return new Embeddings(descriptionEmbedding, text);
        }
    }

    public Long getId() {
        return id;
    }

    public float[] getDescriptionEmbedding() {
        return descriptionEmbedding;
    }

    public String getText() {
        return text;
    }

    public LocalDateTime getCreatedAt() {
        return createdAt;
    }
}