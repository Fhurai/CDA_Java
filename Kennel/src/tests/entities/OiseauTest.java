package tests.entities;

import entities.KennelEntitiesException;
import entities.Oiseau;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.NullAndEmptySource;
import org.junit.jupiter.params.provider.NullSource;
import org.junit.jupiter.params.provider.ValueSource;

import java.time.LocalDate;

import static org.junit.jupiter.api.Assertions.*;
class OiseauTest {

    static Oiseau oiseau;

    @BeforeEach
    void setUp() {
        oiseau = new Oiseau();
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"titi", "G"})
    void testSetNomInvalid(String nom) {
        assertThrows(KennelEntitiesException.class, () -> oiseau.setNom(nom));
    }

    @ParameterizedTest
    @ValueSource(strings = {"Titi", "Bipbip"})
    void testSetNomValid(String nom) {
        assertDoesNotThrow(() -> oiseau.setNom(nom));
        assertEquals(nom, oiseau.getNom());
        assertSame(nom, oiseau.getNom());
    }

    @ParameterizedTest
    @NullAndEmptySource
    @ValueSource(strings = {"Oiseau", "o"})
    void testSetEspeceInvalid(String espece) {
        assertThrows(KennelEntitiesException.class, () -> oiseau.setEspece(espece));
    }

    @ParameterizedTest
    @ValueSource(strings = {"oiseau"})
    void testSetEspeceValid(String espece) {
        assertDoesNotThrow(() -> oiseau.setEspece(espece));
        assertEquals(espece, oiseau.getEspece());
        assertSame(espece, oiseau.getEspece());
    }

    @ParameterizedTest
    @NullSource
    void testSetDateNaissance(LocalDate date) {
        assertThrows(KennelEntitiesException.class, () -> oiseau.setDateNaissance(date));
    }

    @ParameterizedTest
    @ValueSource(ints = {-5, -200})
    void testSetNombreDePlumesInvalid(int nombreDePlumes) {
        assertThrows(KennelEntitiesException.class, () -> oiseau.setNombreDePlumes(nombreDePlumes));
    }

    @ParameterizedTest
    @ValueSource(ints = {0, 200, 3000})
    void testSetNombreDePlumesValid(int nombreDePlumes) {
        assertDoesNotThrow(() -> oiseau.setNombreDePlumes(nombreDePlumes));
        assertEquals(nombreDePlumes, oiseau.getNombreDePlumes());
    }
}