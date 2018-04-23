package de.codefor.opacapi.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value = HttpStatus.NOT_FOUND, reason = "Library not found.")
public class LibraryNotFound extends RuntimeException {

    public LibraryNotFound(String libraryName) {

    }
}