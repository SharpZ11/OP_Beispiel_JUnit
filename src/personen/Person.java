package personen;

public class Person {
    private String vorname;
    private String nachname;

    public Person(String vorname, String nachname) {
        if (vorname == null || nachname == null) {
            throw new IllegalArgumentException("Vorname und Nachname dürfen nicht null sein.");
        }
        this.vorname = vorname;
        this.nachname = nachname;
    }

    public String getNachname() {
        return nachname;
    }
    
    public String getVorname() {
    	return vorname;
    }
}
