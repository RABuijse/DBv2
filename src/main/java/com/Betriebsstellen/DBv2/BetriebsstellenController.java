package com.Betriebsstellen.DBv2;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Locale;

/**
 * Klasse, welche die mapping requests steuert und definiert.
 * "@Restcontroller" kombiniert die "@Controller" und "@ResponseBody" Anmerkung, wodurch ausgaben automatisch
 * in das JSON Format umgewandelt werden.
 */
@RestController
public class BetriebsstellenController {

    private final BetriebsstellenRepository repository;

    //-----------------------------------------------------------------------------------------------------------------
    // Das zum Start der Applikation in LoadDatabase.java erstellte repository wird weitergegeben.
    BetriebsstellenController(BetriebsstellenRepository repository) {
        this.repository = repository;
    }

    //-----------------------------------------------------------------------------------------------------------------
    // Gibt alle Instanzen der Klasse Betriebsstelle aus dem repository in einer Liste aus
    @GetMapping("/betriebsstelle")
    List<Betriebsstelle> all() {
        return repository.findAll();
    }
    //-----------------------------------------------------------------------------------------------------------------
    // Sucht im repository nach der im Pfad angegebenen Abkürzung um die entsprechende Betriebsstelle
    // zu finden und als JSON Objekt auszugeben.
    @GetMapping("/betriebsstelle/{abk}")
    Betriebsstelle one(@PathVariable String abk) {
        //-------------------------------------------------------------------------------------------------------------
        // In diesem Fall wird toUpperCase() verwendet, da die Abkürzungen in der csv Datei groß geschrieben werden
        // und diese als ID im repository verwendet werden. Eine andere Möglichkeit wäre es die mapping requests
        // case sensitive zu machen, oder der Klasse Betriebsstelle eine "Abk_lowercase" Eigenschaft zu geben.
        return repository.findById(abk.toUpperCase(Locale.ROOT))
                //-----------------------------------------------------------------------------------------------------
                // Falls die Abkürzung und somit die Betriebsstelle nicht bekannt ist, wird eine
                // eigene, in der Klasse BetriebsstelleNotFoundException.java erstellte exception ausgegeben.
                .orElseThrow(() -> new BetriebsstelleNotFoundException(abk));
    }
}
