package com.example.ms_addetti_prova;

import com.example.ms_addetti_prova.model.Utente;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
@RequestMapping("/addetti")
public class AddettiController {

    @Autowired
    private UtenteNormaleService utenteService;

    @GetMapping
    public ResponseEntity<List<Utente>> getAllAddetti() {
        List<Utente> addetti = utenteService.findAll();
        return ResponseEntity.ok(addetti);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Utente> getAddettoById(@PathVariable Long id) {
        Optional<Utente> addetto = utenteService.findById(id);
        return addetto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }

    @PostMapping
    public ResponseEntity<Utente> createAddetto(@RequestBody Utente utente) {
        Utente createdAddetto = utenteService.save(utente);
        return ResponseEntity.status(HttpStatus.CREATED).body(createdAddetto);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Utente> updateAddetto(@PathVariable Long id, @RequestBody Utente utente) {
        Optional<Utente> existingAddetto = utenteService.findById(id);
        if (existingAddetto.isPresent()) {
            utente.setId(id);  // Set the ID to the one from the path
            Utente updatedAddetto = utenteService.save(utente);
            return ResponseEntity.ok(updatedAddetto);
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteAddetto(@PathVariable Long id) {
        if (utenteService.findById(id).isPresent()) {
            utenteService.deleteById(id);
            return ResponseEntity.noContent().build();
        } else {
            return ResponseEntity.notFound().build();
        }
    }

    @GetMapping("/anagrafica/{codiceFiscale}")
    public ResponseEntity<Utente> getAddettoByCodiceFiscale(@PathVariable String codiceFiscale) {
        Optional<Utente> addetto = utenteService.findByCodiceFiscale(codiceFiscale);
        return addetto.map(ResponseEntity::ok)
                .orElse(ResponseEntity.notFound().build());
    }
}