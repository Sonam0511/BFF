package org.example.BFF.contoller;

import org.example.BFF.model.Entity;
import org.example.BFF.service.EntityService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/bff/entity")
public class BffController {

    @Autowired
    private EntityService entityService;

    @GetMapping("/{id}")
    public Entity getEntity(@PathVariable Long id) {
        return entityService.getEntity(id);
    }

    @PostMapping
    public Entity createEntity(@RequestBody Entity entity) {
        return entityService.createEntity(entity);
    }

    @PutMapping("/{id}")
    public Entity updateEntity(@PathVariable Long id, @RequestBody Entity entity) {
        return entityService.updateEntity(id, entity);
    }

    @PatchMapping("/{id}")
    public Entity patchEntity(@PathVariable Long id, @RequestBody Entity entity) {
        return entityService.patchEntity(id, entity);
    }

    @DeleteMapping("/{id}")
    public void deleteEntity(@PathVariable Long id) {
        entityService.deleteEntity(id);
    }
}
