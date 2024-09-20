package com.example.pesertaapi.controller;

import com.example.pesertaapi.model.Peserta;
import com.example.pesertaapi.service.PesertaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Optional;

@RestController
@RequestMapping("/api/peserta")
public class PesertaController {

    @Autowired
    private PesertaService pesertaService;

    @GetMapping
    public ResponseEntity<Page<Peserta>> getAllPeserta(
            @RequestParam(defaultValue = "0") int page,
            @RequestParam(defaultValue = "10") int size) {
        Page<Peserta> pesertaPage = pesertaService.getAllPeserta(page, size);
        return new ResponseEntity<>(pesertaPage, HttpStatus.OK);
    }

    @GetMapping("/{idPeserta}")
    public ResponseEntity<Peserta> getPesertaById(@PathVariable Long idPeserta) {
        Optional<Peserta> peserta = pesertaService.getPesertaById(idPeserta);
        return peserta.map(ResponseEntity::ok).orElseThrow(() -> new RuntimeException("Peserta not found with id: " + idPeserta));
    }

    @ExceptionHandler(RuntimeException.class)
    public ResponseEntity<String> handleNotFoundException(RuntimeException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
