package racingGame.domain;

import org.apache.commons.lang3.StringUtils;

import java.util.Objects;

public class Car {

    private static final int START_POSITION = 0;
    private static final int MAXIMUM_NAME_LENGTH = 5;

    private final String name;
    private int position;

    public Car(String name) {
        if (validateNullOrEmpty(name) || validateNameLength(name)) {
            throw new IllegalArgumentException(String.format("이름은 %s자 이하까지 입력할 수 있습니다.", MAXIMUM_NAME_LENGTH));
        }

        this.name = name;
        this.position = START_POSITION;
    }

    private boolean validateNullOrEmpty(String name) {
        return StringUtils.isBlank(name);
    }

    private boolean validateNameLength(String name) {
        return name.length() > MAXIMUM_NAME_LENGTH;
    }

    public void advance(AdvanceStrategy advanceStrategy) {
        if (advanceStrategy.canAdvance()) {
            position++;
        }
    }

    public String name() {
        return name;
    }

    public int position() {
        return position;
    }

    public boolean isMaxPosition(int foundMaxPosition) {
        return foundMaxPosition == this.position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Car car = (Car) o;
        return position == car.position && Objects.equals(name, car.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, position);
    }
}
