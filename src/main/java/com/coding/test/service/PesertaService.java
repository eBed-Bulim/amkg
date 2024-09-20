package com.example.demo.service;

import com.example.demo.entity.Peserta;
import com.example.demo.repository.PesertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class PesertaService {

    @Autowired
    private PesertaRepository pesertaRepository;

    public List<Peserta> getAllPeserta() {
        return pesertaRepository.findAll();
    }

    public Optional<Peserta> getPesertaById(Long idPeserta) {
        return pesertaRepository.findById(idPeserta);
    }
}
