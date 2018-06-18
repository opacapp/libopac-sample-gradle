package de.codefor.opacapi.exception;


import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Invalid search term")

public class InvalidSearchTerm extends RuntimeException {
    public InvalidSearchTerm(String searchTerm) {
    }
}
