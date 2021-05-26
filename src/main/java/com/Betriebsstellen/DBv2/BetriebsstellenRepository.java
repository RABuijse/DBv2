package com.Betriebsstellen.DBv2;

import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Einfache java Datei, welche das BetriebsstellenRepository als JPARepository extended mit
 * der Klasse Betriebsstelle als Objekt und einem String als ID
 */
interface BetriebsstellenRepository extends JpaRepository<Betriebsstelle, String> {
}
