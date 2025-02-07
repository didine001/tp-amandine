package com.ipi.jva320.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.server.ResponseStatusException;

public class SalarieException404 extends ResponseStatusException {
    public SalarieException404(String message) {
        super(HttpStatus.NOT_FOUND, message);
    }
}
