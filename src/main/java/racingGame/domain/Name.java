package racingGame.domain;

public class Name {
    private static final int NAME_MAX_LENGTH = 5;
    String name;

    public Name(String name) {
        validate(name);
        this.name = name;
    }

    private void validate(String name) {
        if (null == name || name.isEmpty()) {
            throw new RuntimeException("자동차 이름은 공백값을 가질 수 없습니다.");
        }

        if (name.length() > NAME_MAX_LENGTH) {
            throw new RuntimeException("자동차 이름은 최대 5자를 초과할 수 없습니다.");
        }
    }
}
