package es.upm.miw.iwvg_devops.code;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;

import static org.junit.jupiter.api.Assertions.assertEquals;

class SearchesTest {

    private List<User> users;

    @BeforeEach
    void setUp() {
        users = new ArrayList<>();

        List<Fraction> fractions1 = new ArrayList<>();
        fractions1.add(new Fraction(1, 2));
        fractions1.add(new Fraction(3, 4));
        User user1 = new User("1", "John", "Doe", fractions1);

        List<Fraction> fractions2 = new ArrayList<>();
        fractions2.add(new Fraction(2, 5));
        fractions2.add(new Fraction(7, 6));
        User user2 = new User("2", "Jane", "Smith", fractions2);

        List<Fraction> fractions3 = new ArrayList<>();
        fractions3.add(new Fraction(5, 3));
        fractions3.add(new Fraction(10, 5));
        User user3 = new User("3", "Alice", "Johnson", fractions3);

        users.add(user1);
        users.add(user2);
        users.add(user3);
    }

    @Test
    void testFindUserIdBySomeProperFraction() {
        Searches searches = new Searches();

        Stream<String> result = searches.findUserIdBySomeProperFraction(users);

        List<String> resultList = result.toList();

        // Aserciones
        assertEquals(2, resultList.size());
        assertEquals("1", resultList.get(0));
        assertEquals("2", resultList.get(1));
    }
}
