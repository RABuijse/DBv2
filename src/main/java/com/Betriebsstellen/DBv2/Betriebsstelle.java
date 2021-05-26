package com.Betriebsstellen.DBv2;

import javax.persistence.Entity;
import javax.persistence.Id;
import java.util.Objects;

/**
 * Java File in der die Klasse Betriebsstelle spezifiziert wird.
 * Als "@Entity" markiert, sodass JPA weiß, dass diese Klasse zu einem JPARepository hinzugefügt werden kann.
 */
@Entity
public class Betriebsstelle {

    //-----------------------------------------------------------------------------------------------------------------
    // Attribute der Klasse Betriebsstelle werden der csv-Datei entnommen. Bei anderen Formaten der csv-Datei
    // müsste auf eine dynamische Erstellung einer Klasse, anhand der ersten Zeile der Datei zurückgegriffen werden.
    // die Abkürzung wird als "@Id" markiert, sodass später im repository bekannt ist anhand welchem Attributs, das
    // richtige Objekt rausgesucht wird.
    private @Id String abk;
    private String name;
    private String kurzname;
    private String typ;
    private String betrZust;
    private String primaryLocationCode;
    private String uic;
    private String rb;
    private String gueltigVon;
    private String gueltigBis;
    private String netzKey;
    private String fplRel;
    private String fplGr;

    //-----------------------------------------------------------------------------------------------------------------
    // Standard erstellung einer Betriebsstellen Instanz, welche für das Ausführen
    // des CommandLineRunners benötigt wird.
    Betriebsstelle() {}

    //-----------------------------------------------------------------------------------------------------------------
    // Beschreibung zum Aufbau der Klasse Betriebsstelle
    Betriebsstelle(String abk, String name, String kurzname, String typ, String betrZust, String primaryLocationCode,
                   String uic, String rb, String gueltigVon, String gueltigBis, String netzKey,
                   String fplRel, String fplGr) {
        this.abk = abk;
        this.name = name;
        this. kurzname = kurzname;
        this.typ = typ;
        this.betrZust = betrZust;
        this.primaryLocationCode = primaryLocationCode;
        this.uic = uic;
        this.rb = rb;
        this.gueltigVon = gueltigVon;
        this.gueltigBis = gueltigBis;
        this.netzKey = netzKey;
        this.fplRel = fplRel;
        this.fplGr = fplGr;
    }

    //-----------------------------------------------------------------------------------------------------------------
    // get-/ und set-methoden für die einzelnen Attribute.
    public String getAbk() {
        return abk;
    }

    public String getName() {
        return name;
    }

    public String getKurzname() {
        return kurzname;
    }

    public String getTyp() {
        return typ;
    }

    public String getBetrZust() {
        return betrZust;
    }

    public String getPrimaryLocationCode() {
        return primaryLocationCode;
    }

    public String getUic() {
        return uic;
    }

    public String getRb() {
        return rb;
    }

    public String getGueltigVon() {
        return gueltigVon;
    }

    public String getGueltigBis() {
        return gueltigBis;
    }

    public String getNetzKey() {
        return netzKey;
    }

    public String getFplRel() {
        return fplRel;
    }

    public String getFplGr() {
        return fplGr;
    }

    public void setAbk(String abk) {
        this.abk = abk;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setKurzname(String kurzname) {
        this.kurzname = kurzname;
    }

    public void setTyp(String typ) {
        this.typ = typ;
    }

    public void setBetrZust(String betrZust) {
        this.betrZust = betrZust;
    }

    public void setPrimaryLocationCode(String primaryLocationCode) {
        this.primaryLocationCode = primaryLocationCode;
    }

    public void setUic(String uic) {
        this.uic = uic;
    }

    public void setRb(String rb) {
        this.rb = rb;
    }

    public void setGueltigVon(String gueltigVon) {
        this.gueltigVon = gueltigVon;
    }

    public void setGueltigBis(String gueltigBis) {
        this.gueltigBis = gueltigBis;
    }

    public void setNetzKey(String netzKey) {
        this.netzKey = netzKey;
    }

    public void setFplRel(String fplRel) {
        this.fplRel = fplRel;
    }

    public void setFplGr(String fplGr) {
        this.fplGr = fplGr;
    }

    //-----------------------------------------------------------------------------------------------------------------
    // Überschreiben von bereits bestehenden Objektmethoden für diese Klasse.
    // Equals zum Vergleich von zwei Objekten
    @Override
    public boolean equals(Object o) {
        //-------------------------------------------------------------------------------------------------------------
        // Das selbe Objekt ist equal zu sich selbst.
        if (this == o)
            return true;
        //-------------------------------------------------------------------------------------------------------------
        // Wenn das Objekt keine Instanz der Klasse BEtriebsstelle ist, kann es nicht gleich sein.
        if (!(o instanceof Betriebsstelle))
            return false;
        //-------------------------------------------------------------------------------------------------------------
        // Wenn das Objekt eine Instanz der Klasse Betriebsstelle ist und alle Attribute übereinstimmen, dann ist
        // es das gleiche Objekt.
        Betriebsstelle betriebsstelle = (Betriebsstelle) o;
        return Objects.equals(this.abk, betriebsstelle.abk) &&
                Objects.equals(this.name, betriebsstelle.name) &&
                Objects.equals(this.kurzname, betriebsstelle.kurzname) &&
                Objects.equals(this.typ, betriebsstelle.typ) &&
                Objects.equals(this.betrZust, betriebsstelle.betrZust) &&
                Objects.equals(this.primaryLocationCode, betriebsstelle.primaryLocationCode) &&
                Objects.equals(this.uic, betriebsstelle.uic) &&
                Objects.equals(this.rb, betriebsstelle.rb) &&
                Objects.equals(this.gueltigVon, betriebsstelle.gueltigVon) &&
                Objects.equals(this.gueltigBis, betriebsstelle.gueltigBis) &&
                Objects.equals(this.netzKey, betriebsstelle.netzKey) &&
                Objects.equals(this.fplRel, betriebsstelle.fplRel) &&
                Objects.equals(this.fplGr, betriebsstelle.fplGr);
    }

    //-----------------------------------------------------------------------------------------------------------------
    // Überschreiben der Funktion hashCode(), welche bestimmt, welche Attribute des Objektes zu Erstellung eines
    // HashCodes von Relevanz sind.
    @Override
    public int hashCode() {
        return Objects.hash(this.abk, this.name, this.kurzname, this.typ, this.betrZust,
                this.primaryLocationCode, this.uic, this.rb, this.gueltigVon, this.gueltigBis, this.netzKey,
                this.fplRel, this.fplGr);
    }
    //-----------------------------------------------------------------------------------------------------------------
    // Überschreiben der toString methode, welche angibt wie das Objekt als String ausgegeben werden soll.
    @Override
    public String toString() {
        return "Betriebsstelle{" + "abk=" + this.abk + ", name='" + this.name + '\'' +
                ", kurzname='" + this.kurzname + '\'' + ", typ='" + this.typ + '\'' +
                ", betrZust='" + this.betrZust + '\'' + ", primaryLocationCode='" + this.primaryLocationCode + '\'' +
                ", uic='" + this.uic + '\'' + ", rb='" + this.rb + '\'' +
                ", gueltigVon='" + this.gueltigVon + '\'' + ", gueltigBis='" + this.gueltigBis + '\'' +
                ", netzKey='" + this.netzKey + '\'' + ", fplRel='" + this.fplRel + '\'' +
                ", fplGr='" + this.fplGr + '\'' + '}';
    }
}
