package Collection;

import Collection.Helper.Person;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

class PersonTest {

    private final Person person = new Person("FirstName", "LastName", 21);

    @Test
    void compareTo() {
        Person person1 = new Person("Person1", "Person1", 21);
        Person person2 = new Person("Person2", "Person2", 23);

        assertEquals(-2, person1.compareTo(person2), "Should person1 be smaller than person2");

        person1 = new Person("Person1", "Person1", 21);
        person2 = new Person("Person2", "Person2", 21);

        assertEquals(0, person1.compareTo(person2), "Should person1 and person2 be equals");

        person1 = new Person("Person1", "Person1", 23);
        person2 = new Person("Person2", "Person2", 21);

        assertEquals(2, person1.compareTo(person2), "Should person1 be bigger than person2");
    }

    @Test
    void groupedAssertions() {
        assertAll("person",
                () -> assertEquals("FirstName", person.getFirstName()),
                () -> assertEquals("LastName", person.getLastName()),
                () -> assertEquals(21, person.getAge())
        );
    }

    @Test
    void dependentAssertions() {
        assertAll("properties",
                () -> {
                    String firstName = person.getFirstName();
                    assertNotNull(firstName);

                    // Executed only if the previous assertion is valid.
                    assertAll("first name",
                            () -> assertTrue(firstName.startsWith("F")),
                            () -> assertTrue(firstName.endsWith("e"))
                    );
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of first name assertions.
                    String lastName = person.getLastName();
                    assertNotNull(lastName);

                    // Executed only if the previous assertion is valid.
                    assertAll("last name",
                            () -> assertTrue(lastName.startsWith("L")),
                            () -> assertTrue(lastName.endsWith("e"))
                    );
                },
                () -> {
                    // Grouped assertion, so processed independently
                    // of results of last name assertions.
                    String age = String.valueOf(person.getAge());
                    assertNotNull(age);

                    // Executed only if the previous assertion is valid.
                    assertAll("age",
                            () -> assertTrue(age.startsWith("2")),
                            () -> assertTrue(age.endsWith("1"))
                    );
                }
        );
    }
}