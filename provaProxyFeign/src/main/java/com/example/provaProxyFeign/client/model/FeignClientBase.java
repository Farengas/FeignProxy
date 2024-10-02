package com.example.provaProxyFeign.client.model;

import org.springframework.http.HttpHeaders;

public interface FeignClientBase {
    <R> R performGet(String endpoint, HttpHeaders headers);
    <R, O> R performPost(String endpoint, O body);
    <R, O> R performPut(String endpoint, O body);
    <R, O> R performPatch(String endpoint, O body);
    <R> R performDelete(String endpoint, HttpHeaders headers);
}
