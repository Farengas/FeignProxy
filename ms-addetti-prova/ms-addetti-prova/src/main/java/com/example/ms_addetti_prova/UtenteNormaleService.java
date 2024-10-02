package com.example.ms_addetti_prova;

import com.example.ms_addetti_prova.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class UtenteNormaleService {

    @Autowired
    private UtenteRepository utenteRepository;

    public List<Utente> findAll() {
        return utenteRepository.findAll();
    }

    public Optional<Utente> findById(Long id) {
        return utenteRepository.findById(id);
    }

    public Utente save(Utente utente) {
        return utenteRepository.save(utente);
    }

    public void deleteById(Long id) {
        utenteRepository.deleteById(id);
    }

    public Optional<Utente> findByCodiceFiscale(String codiceFiscale) {
        return utenteRepository.findByCodiceFiscale(codiceFiscale);
    }
}