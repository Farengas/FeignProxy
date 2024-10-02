package com.example.provaProxyFeign.client.model;

import com.example.ms_addetti_prova.model.Utente;
import com.example.provaProxyFeign.client.UtentiFeignClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import java.util.List;

@Component
public class UtentiProxy extends  Proxy{
    @Autowired
    private UtentiFeignClient utentiFeignClient; // Inject the Feign client

    public UtentiProxy(UtentiFeignClient utentiFeignClient) {
        this.utentiFeignClient = utentiFeignClient;
    }

    @Override
    protected String getOriginEngagedName() {
        return "ms-addetti-prova";
    }

    @Override
    public UtentiFeignClient getFeignClient() {
        return utentiFeignClient;
    }
    public Utente getAddettoById(Long id) {
        return utentiFeignClient.getAddettoById(id); // Delegate to Feign client
    }

    public List<Utente> getAllAddetti() {
        return utentiFeignClient.getAllAddetti(); // Delegate to Feign client
    }

    public Utente getAddettoByCodiceFiscale(String codiceFiscale) {
        return utentiFeignClient.getAddettoByCodiceFiscale(codiceFiscale); // Delegate to Feign client
    }


}
