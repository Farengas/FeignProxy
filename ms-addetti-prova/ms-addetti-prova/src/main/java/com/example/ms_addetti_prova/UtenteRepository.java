package com.example.ms_addetti_prova;

import com.example.ms_addetti_prova.model.Utente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Optional;

@Repository
public interface UtenteRepository extends JpaRepository<Utente, Long> {
    Optional<Utente> findByCodiceFiscale(String codiceFiscale);

}
