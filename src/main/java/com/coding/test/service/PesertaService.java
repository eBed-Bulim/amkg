package com.example.springrestapi.service;

import com.example.springrestapi.model.Peserta;
import com.example.springrestapi.repository.PesertaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class PesertaService {

    @Autowired
    private PesertaRepository pesertaRepository;

    public Page<Peserta> getAllPeserta(Pageable pageable) {
        return pesertaRepository.findAll(pageable);
    }

    public Optional<Peserta> getPesertaById(Long idPeserta) {
        return pesertaRepository.findById(idPeserta);
    }
}
