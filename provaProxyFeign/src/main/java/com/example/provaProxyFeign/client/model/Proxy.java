package com.example.provaProxyFeign.client.model;

import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import static java.util.Objects.nonNull;
import static lombok.Lombok.checkNotNull;

import org.springframework.http.HttpHeaders;


public abstract class Proxy {


    @Autowired
    protected ObjectMapper mapper;

    protected abstract String getOriginEngagedName();

    protected abstract FeignClientBase getFeignClient();

    protected Boolean validateSimpleRestResponse(ResponseEntity<?> response) {
        return nonNull(response) && nonNull(response.getBody());
    }


    protected <T> ResponseEntity<T> performGet(String endpoint, Class<T> responseClass, HttpHeaders headers) {
        checkNotNull(endpoint, "[Proxy:performGet] => endpoint");
        T result = (T) getFeignClient().performGet(endpoint, headers);
        return ResponseEntity.ok(result);
    }


    protected <T, O> ResponseEntity<T> performPost(String endpoint, O body, Class<T> responseClass) {
        checkNotNull(endpoint, "[Proxy:performPost] => endpoint");
        T result = (T) getFeignClient().performPost(endpoint, body);
        return ResponseEntity.ok(result);
    }


    protected <T, O> ResponseEntity<T> performPut(String endpoint, O body, Class<T> responseClass) {
        checkNotNull(endpoint, "[Proxy:performPut] => endpoint");
        T result = (T) getFeignClient().performPut(endpoint, body);
        return ResponseEntity.ok(result);
    }

    // PATCH Method
    protected <T, O> ResponseEntity<T> performPatch(String endpoint, O body, Class<T> responseClass) {
        checkNotNull(endpoint, "[Proxy:performPatch] => endpoint");
        T result = (T) getFeignClient().performPatch(endpoint, body);
        return ResponseEntity.ok(result);
    }

    // DELETE Method
    protected <T> ResponseEntity<T> performDelete(String endpoint, Class<T> responseClass, HttpHeaders headers) {
        checkNotNull(endpoint, "[Proxy:performDelete] => endpoint");
        T result = (T) getFeignClient().performDelete(endpoint, headers);
        return ResponseEntity.ok(result);
    }
}
