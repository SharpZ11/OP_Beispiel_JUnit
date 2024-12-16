package personen;

import static org.junit.jupiter.api.Assertions.*;

import java.util.function.BooleanSupplier;
import java.util.function.Supplier;

import org.junit.jupiter.api.Test;

class PersonTest {
	
	

	@Test
	void testNachnameMitMessageSupplier(){
		
		// Arrange
        String nachname = "Mustermann";
        Person person = new Person("Max", nachname);
        
        // Expliziter Aufruf des Supplier Interfaces
		Supplier<String> messageSupplier = new Supplier<String>() {
			// T get() des Interfaces überschreiben, um eine Rückgabe
			// zu erhalten
			@Override
			public String get() {
				return "Das Attribut 'nachname' sollte mit dem Parameterwert '" + nachname + "' gefüllt werden.";
			}
		};

        // Act & Assert
        assertTrue(
            person.getNachname().equals(nachname),
            messageSupplier
        );
	
	}
	
	@Test
	void testNachnameMitBooleanSupplier() {
		// Arrange
        String nachname = "Mustermann";
        Person person = new Person("Max", nachname);
        
        BooleanSupplier conditionSupplier = new BooleanSupplier() {
        	
        	public boolean getAsBoolean() {
				return person.getNachname().equals(nachname);
        		
        	}
        };

        // Act & Assert
        assertTrue(
            conditionSupplier.getAsBoolean(),
            "Das Attribut 'nachname' wurde nicht korrekt gesetzt."
        );
        
        /* Alternative mit Lambda Ausdrücken
         * 
        @Test
    	void testNachnameMitMessageSupplier() {
	        // Arrange
	        String nachname = "Mustermann";
	        Person person = new Person("Max", nachname);
	
	        // Act & Assert
	        assertTrue(
	            person.getNachname().equals(nachname),
	            () -> "Das Attribut 'nachname' sollte mit dem Parameterwert '" + nachname + "' gefüllt werden."
	        );
	    }

	    @Test
	    void testNachnameMitConditionSupplier() {
        // Arrange
        String nachname = "Mustermann";
        Person person = new Person("Max", nachname);

        // Act & Assert
        assertTrue(
            (BooleanSupplier) () -> person.getNachname().equals(nachname),
            "Das Attribut 'nachname' wurde nicht korrekt gesetzt."
        );
    }
         */
	}
}
