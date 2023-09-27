package es.upm.miw.iwvg_devops.code;

import java.util.List;
import java.util.stream.Stream;

public class Searches {

    private List<User> users;

    public List<User> getUsers() {
        return users;
    }

    public Searches(List<User> users) {
        this.users = users;
    }

    public Stream<String> findUserIdBySomeProperFraction() {
        return users.stream()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(User::getId)
                .distinct();
    }

    public Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isImproper)
                .map(Fraction::decimal);
    }

}
