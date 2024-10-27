package org.example.BFF.service;

import org.example.BFF.model.Entity;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import org.springframework.http.*;
import java.util.Collections;

@Service
public class EntityService {

    private final RestTemplate restTemplate = new RestTemplate();

    @Value("${spring.api.url}")
    private String apiUrl;

    public Entity getEntity(Long id) {
        String url = apiUrl + "/entity/" + id;
        return restTemplate.getForObject(url, Entity.class);
    }

    public Entity createEntity(Entity entity) {
        String url = apiUrl + "/entity/";
        return restTemplate.postForObject(url, entity, Entity.class);
    }

    public Entity updateEntity(Long id, Entity entity) {
        String url = apiUrl + "/entity/" + id;
        HttpEntity<Entity> request = new HttpEntity<>(entity);
        ResponseEntity<Entity> response = restTemplate.exchange(url, HttpMethod.PUT, request, Entity.class);
        return response.getBody();
    }

    public void deleteEntity(Long id) {
        String url = apiUrl + "/entity/" + id;
        restTemplate.delete(url);
    }

    public Entity patchEntity(Long id, Entity entity) {
        String url = apiUrl + "/entity/" + id;
        HttpEntity<Entity> request = new HttpEntity<>(entity);
        ResponseEntity<Entity> response = restTemplate.exchange(url, HttpMethod.PATCH, request, Entity.class);
        return response.getBody();
    }
}
