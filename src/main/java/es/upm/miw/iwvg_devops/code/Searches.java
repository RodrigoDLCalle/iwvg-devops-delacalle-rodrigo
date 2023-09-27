package es.upm.miw.iwvg_devops.code;

import java.util.List;
import java.util.stream.Stream;

public class Searches {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public Stream<String> findUserIdBySomeProperFraction(List<User> users) {
        return users.stream()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(User::getId)
                .distinct();
    }

}
