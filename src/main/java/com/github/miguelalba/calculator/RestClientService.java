package com.github.miguelalba.calculator;

import com.github.miguelalba.calculator.model.Operation;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.reactive.function.client.WebClient;
import org.springframework.web.reactive.function.client.WebClient.RequestHeadersSpec;

import java.io.Serializable;

@SuppressWarnings("serial")
@Service
public class RestClientService implements Serializable {

    /**
     * The port changes depending on where we deploy the app
     */
    @Value("${server.port}")
    private String serverPort;

    public int calculateOperation(String operator, int a, int b) {

        final String url = String.format("http://localhost:%s/operation/%s/%d/%d", serverPort, operator, a, b);

        final RequestHeadersSpec<?> spec = WebClient.create().get().uri(url);
        final Operation response = spec.retrieve().toEntity(Operation.class).block().getBody();

        return response.getResult();
    }

}

