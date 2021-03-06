package racingGame.domain;

import java.util.List;
import java.util.stream.Collectors;

public class Cars {

    private static final int START_POSITION = 0;
    private final List<Car> cars;

    public Cars(List<String> carNames) {
        this.cars = carNames.stream()
                .map(Car::new)
                .collect(Collectors.toList());
    }

    public List<Car> list() {
        return cars;
    }

    public List<String> findWinners() {
        int maxPosition = findMaxPosition();

        return cars.stream()
                .filter(Car -> Car.isMaxPosition(maxPosition))
                .map(Car::name)
                .collect(Collectors.toList());
    }

    public int findMaxPosition() {
        return cars.stream()
                .map(Car::position)
                .max(Integer::compareTo)
                .orElse(START_POSITION);
    }
}

