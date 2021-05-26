package com.Betriebsstellen.DBv2;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

import java.util.Locale;

/**
 * Eine eigene Exceptionklasse, welche die RuntimeExceptions extended.
 * Kann so angepasst werden, dass ein bestimmter Fehlercode ausgeworfen wird.
 */
@ResponseStatus(code = HttpStatus.NOT_FOUND)
public class BetriebsstelleNotFoundException extends RuntimeException {

    BetriebsstelleNotFoundException(String abk) {
        //-------------------------------------------------------------------------------------------------------------
        // Beispielprint in der Konsole
        System.out.println("Betriebsstelle mit Abkürzung " + abk.toUpperCase(Locale.ROOT) + " wurde nicht gefunden");
    }
}
