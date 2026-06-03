package org.acme.application;


import java.util.Arrays;
import java.util.concurrent.TimeUnit;

import com.github.benmanes.caffeine.cache.Cache;
import com.github.benmanes.caffeine.cache.Caffeine;

import dev.langchain4j.model.embedding.EmbeddingModel;
import jakarta.annotation.PostConstruct;
import jakarta.enterprise.context.ApplicationScoped;
import jakarta.inject.Inject;

@ApplicationScoped
public class QueryEmbeddingService {

    @Inject
    EmbeddingModel embeddingModel;

    private Cache<String, float[]> cache;

    @PostConstruct
    void init() {
        cache = Caffeine.newBuilder()
                .maximumSize(1000)
                .expireAfterWrite(30, TimeUnit.MINUTES)
                .build();
    }

    public float[] embed(String query) {
        float[] stored = cache.get(query, key -> {
            float[] vector = embeddingModel.embed(key).content().vector();
            return Arrays.copyOf(vector, vector.length);
        });
        return Arrays.copyOf(stored, stored.length);
    }
}