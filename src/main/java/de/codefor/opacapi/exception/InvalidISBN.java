package de.codefor.opacapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.BAD_REQUEST, reason = "Not a valid ISBN number")
public class InvalidISBN extends RuntimeException {

}