package es.upm.miw.iwvg_devops.code;

import java.util.List;
import java.util.Optional;
import java.util.stream.Stream;

public class Searches {

    private final List<User> users;


    public Searches(List<User> users) {
        this.users = users;
    }

    Stream<String> findUserIdBySomeProperFraction() {
        return users.stream()
                .filter(user -> user.getFractions().stream().anyMatch(Fraction::isProper))
                .map(User::getId)
                .distinct();
    }

    Stream<Double> findDecimalImproperFractionByUserName(String name) {
        return users.stream()
                .filter(user -> user.getName().equals(name))
                .flatMap(user -> user.getFractions().stream())
                .filter(Fraction::isImproper)
                .map(Fraction::decimal);
    }

    Stream<String> findUserFamilyNameByAllNegativeSignFractionDistinct() {
        return users.stream()
                .filter(user -> user.getFractions().stream().allMatch(Fraction::isNegative))
                .map(User::getFamilyName)
                .distinct();
    }

    Optional<Fraction> findFractionAdditionByUserId(String id) {
        return users.stream()
                .filter(user -> user.getId().equals(id))
                .flatMap(user -> user.getFractions().stream())
                .reduce(Fraction::add);
    }
}
