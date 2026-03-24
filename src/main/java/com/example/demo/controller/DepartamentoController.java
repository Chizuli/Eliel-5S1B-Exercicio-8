package com.example.demo.controller;

import com.example.demo.models.DepartamentoModel;
import com.example.demo.repositories.DepartamentoRepository;
import com.example.demo.service.DepartamentoService;
import jdk.jfr.Frequency;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping(path = "/departamento")
public class DepartamentoController {
    @Autowired
    private DepartamentoService departamentoService;

    @GetMapping
    public List<DepartamentoModel> findAll() {
        return departamentoService.findAll();
    }

    @GetMapping("/{id}")
    public Optional<DepartamentoModel> findById(@PathVariable Long id) {
        return departamentoService.findById(id);
    }

    @DeleteMapping
    public void deleteById(@RequestParam Long id) {
        departamentoService.deleteById(id);
    }

    @PostMapping
    public ResponseEntity<DepartamentoModel> criarDepartamento(@RequestBody DepartamentoModel departamentoModel){
        DepartamentoModel request = departamentoService.criarDepartamento(departamentoModel);
        URI uri = ServletUriComponentsBuilder.fromCurrentRequestUri().path("/{id}").buildAndExpand(departamentoModel.getId()).toUri();
        return  ResponseEntity.created(uri).body(request);
    }
}
