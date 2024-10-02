package com.example.ms_addetti_prova.model;

import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "utenti")
@AllArgsConstructor
@NoArgsConstructor
@Setter
@Getter
public class Utente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(name = "nome", nullable = false)
    private String nome;

    @Column(name = "cognome", nullable = false)
    private String cognome;

    @Column(name = "codice_fiscale", unique = true, nullable = false)
    private String codiceFiscale;

    @Column(name = "email", unique = true)
    private String email;
}