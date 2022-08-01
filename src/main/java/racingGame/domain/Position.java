package racingGame.domain;

import java.util.Objects;

public class Position {
    private static final int MIN = 0;
    private static final int MAX = 9;
    private int position;

    public Position(int position) {
        if(position < MIN || position > MAX) {
            throw new RuntimeException();
        }

        this.position = position;
    }

    public Position plus() {
        return new Position(this.position+1);
    }

    public int getPosition() {
        return position;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Position position1 = (Position) o;
        return position == position1.position;
    }

    @Override
    public int hashCode() {
        return Objects.hash(position);
    }

    public boolean lessThan(Position position) {
        return this.position < position.getPosition();
    }
}
