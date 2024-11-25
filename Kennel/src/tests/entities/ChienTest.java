package tests.entities;

import entities.KennelEntitiesException;
import entities.Chien;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;

class ChienTest {

    static Chien chien;

    @BeforeEach
    void setUp() {
        chien = new Chien();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"idefix", "R"})
    void testSetNomInvalid(String nom) {
        assertThrows(KennelEntitiesException.class,
                () -> chien.setNom(nom));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Idefix", "Milou", "Rintintin", "Go"})
    void testSetNomValid(String nom) {
        assertDoesNotThrow(() -> chien.setNom(nom));
        assertEquals(nom, chien.getNom());
        assertSame(nom, chien.getNom());

    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"Chien", "c"})
    void testSetEspeceInvalid(String espece) {
        assertThrows(KennelEntitiesException.class,
                () -> chien.setEspece(espece));
    }

    @ParameterizedTest
    @ValueSource(strings = {"chien"})
    void testSetEspeceValid(String espece) {
        assertDoesNotThrow(() -> chien.setEspece(espece));
        assertEquals(espece, chien.getEspece());
        assertSame(espece, chien.getEspece());
    }

    @ParameterizedTest
    @NullSource
    void testSetDateNaissanceInvalid(LocalDate date) {
        assertThrows(KennelEntitiesException.class, () -> chien.setDateNaissance(date));
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"If"})
    void testSetRaceInvalid(String race) {
        assertThrows(KennelEntitiesException.class, () -> chien.setRace(race));
    }

    @ParameterizedTest
    @ValueSource(strings = {"White yorkshire", "Gaulois"})
    void testSetRaceValid(String race) {
        assertDoesNotThrow(() -> chien.setRace(race));
        assertEquals(race, chien.getRace());
        assertSame(race, chien.getRace());
    }
}