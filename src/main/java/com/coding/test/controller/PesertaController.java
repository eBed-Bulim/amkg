package com.example.demo.controller;

import com.example.demo.entity.Peserta;
import com.example.demo.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/api/peserta")
public class PesertaController {

    @Autowired
    private PesertaService pesertaService;

    @GetMapping
    public List<Peserta> getAllPeserta() {
        return pesertaService.getAllPeserta();
    }

    @GetMapping("/{id}")
    public ResponseEntity<Peserta> getPesertaById(@PathVariable Long id) {
        Optional<Peserta> peserta = pesertaService.getPesertaById(id);
        return peserta.map(ResponseEntity::ok).orElseGet(() -> ResponseEntity.notFound().build());
    }
}
