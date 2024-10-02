package com.example.provaProxyFeign.client;

import com.example.ms_addetti_prova.model.Utente;
import com.example.provaProxyFeign.client.model.FeignClientBase;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import java.util.List;

@FeignClient(name = "ms-addetti-prova")
public interface UtentiFeignClient extends  FeignClientBase{

    @GetMapping("/addetti/{id}")
    Utente getAddettoById(@PathVariable("id") Long id);

    @GetMapping("/addetti")
    List<Utente> getAllAddetti();

    @GetMapping("/addetti/anagrafica/{codiceFiscale}")
    Utente getAddettoByCodiceFiscale(@PathVariable("codiceFiscale") String codiceFiscale);


}