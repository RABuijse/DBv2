package com.Betriebsstellen.DBv2;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

/**
 * Klasse zur Initialisierung einer Betriebsstellen Database anhand der Informationen,
 * welche im Format einer csv-Datei übermittelt werden.
 *
 * @author Ruben Buijse
 */

@Configuration
class LoadDatabase {

    //-----------------------------------------------------------------------------------------------------------------
    // Die path Variable gibt an an welchem Ort die zu untersuchende csv-Datei liegt.
    // Der path könnte theoretisch auch vom User übermittelt werden, bzw man könnte den Pfad auch
    // in eine path Variable für den Ordner und eine file Variable einteilen bei der man dann einfacher
    // eine andere csv Datei aus dem selben Ordner auswählen könnte.
    String path = "E:/CaseStudyDB/DBNetz-Betriebsstellenverzeichnis-Stand2018-04.csv";
    String line = "";

    //-----------------------------------------------------------------------------------------------------------------
    // Funktion, welche über Spring automatisch beim runnen der Applikation ausgeführt wird.
    // Einmaliges Laden der Betriebsstellen-Objekte in eine H2 Database.
    @Bean
    CommandLineRunner initDatabase(BetriebsstellenRepository repository) {
        return args -> {

            //---------------------------------------------------------------------------------------------------------
            // Das Einlesen der csv-Datei mit Hilfe eines BufferedReaders wird in einen try-catch Block gesetzt,
            // da gegebenenfalls "FileNotFound" oder ähnliche Exceptions auftreten können. Zum Beispiel im Falle eines
            // falschen paths, oder einer falsch aufgebauten csv-Datei.
            try {
                BufferedReader br = new BufferedReader(new FileReader(path));

                //-----------------------------------------------------------------------------------------------------
                // Die erste Zeile wird bereits eingelesen, da diese nur die Informationen für die Klasse
                // Betriebsstelle beinhaltet. Beim dynamischen Erstellen einer Klasse aus der csv-Datei könnte
                // man die erste Zeile verwenden. In diesem Fall wird allerdings darauf verzichtet.
                line = br.readLine();

                //-----------------------------------------------------------------------------------------------------
                // Die csv-Datei wird von oben nach unten, Zeile für Zeile durchgelesen.
                while ((line = br.readLine()) != null) {

                    //-------------------------------------------------------------------------------------------------
                    // Die Zeilen der csv-Datei werden anhand des ";" geteilt. Im Falle einer Datei, welche durch ","
                    // getrennt wird kann das Trennzeichen angepasst werden. Hier wäre es ebenfalls möglich das
                    // Trennzeichen vom User übermittelt zu bekommen.
                    // Die -1 als zweiter Parameter im split Befehl sorgt dafür, dass "leere Einträge" am Ende der
                    // Zeile verworfen werden.
                    String[] values = line.split(";", -1);


                    //-------------------------------------------------------------------------------------------------
                    // Dem Betriebsstellen Repository werden die Einträge aus der csv-Datei hinzugefügt.
                    repository.save(new Betriebsstelle(values[0], values[1], values[2], values[3],
                            values[4], values[5], values[6], values[7], values[8], values[9], values[10], values[11],
                            values[12]));
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        };
    }
}
