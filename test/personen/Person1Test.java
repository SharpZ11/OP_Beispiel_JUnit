package personen;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.Test;

class Person1Test {

	@Test
	void testVornameUndNachname() {
		
		Person1 person = new Person1("Elke","Musterfrau");
		
		assertTrue(person.getVorname().equals("Elke") &&
				person.getNachname().equals("Musterfrau"),
				"Ja der Vorname und Nachname werden korrekt übergeben ");
	}
	
	@Test
	void testVornamenUndNachnameNullHandling() {
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Person1(null, "Musterfrau");
		},"Konstruktor sollte IllegalArgumentException werfen, wenn der Vorname null ist.");
		
		assertThrows(IllegalArgumentException.class, () -> {
			new Person1("Elke",null);
		},"Konstruktor sollte IllegalArgumentException werfen, wenn der Nachname null ist.");
	}

}
