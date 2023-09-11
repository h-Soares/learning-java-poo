import org.example.Person;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;
import static org.junit.jupiter.api.Assertions.*;

class PersonTest {
    Person person;

    @Test
    void shouldPersonBeCreatedCorrectly() {
        person = new Person("Lucas", LocalDate.of(1990, 5, 7));

        assertNotNull(person);
        assertEquals("Lucas", person.getName());
        assertEquals(LocalDate.of(1990, 5, 7), person.getBirthdayDate());
    }

    @Test
    void shouldCalculateAgeCorrectly() {
        person = new Person("Moura", LocalDate.of(2003, 3, 7));

        assertEquals(20, person.getAge());
    }

    @Test
    void shouldAgeBeGreaterOrEqualsTo18() {
        person = new Person("Soares", LocalDate.of(2003, 3, 7));

        boolean isAgeGreatherOrEqualsTo18 = person.getAge() >= 18;

        assertTrue(isAgeGreatherOrEqualsTo18);
    }
}