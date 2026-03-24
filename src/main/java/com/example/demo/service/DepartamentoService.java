package com.example.demo.service;

import com.example.demo.models.DepartamentoModel;
import com.example.demo.repositories.DepartamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DepartamentoService {

    @Autowired
    private DepartamentoRepository departamentoRepository;

    public Optional<DepartamentoModel> findById(Long id) {
        return departamentoRepository.findById(id);
    }

    public List<DepartamentoModel> findAll() {
        return departamentoRepository.findAll();
    }

    public void deleteById(Long id) {
        departamentoRepository.deleteById(id);
    }

    public DepartamentoModel criarDepartamento(DepartamentoModel departamentoModel) {
        return departamentoRepository.save(departamentoModel);
    }
}
