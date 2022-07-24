import java.util.Random;

public class Car {
    private final String name;
     int position;

    public Car(String name) {
        validateCarName(name);

        this.name = name;
        position = 1;
    }

    private void validateCarName(String name) {
        if(null == name || name.isEmpty()) {
            throw new RuntimeException();
        }

        if(name.length() > 5) {
            throw new RuntimeException();
        }
    }

    public boolean isMove(int i) {
        if(i >= 4) {
            return true;
        }
        return false;
    }

    public String getPosition() {
        String result = name + " : ";
        for(int i =0 ; i<position; i++) {
            result += "-";
        }

        return result;
    }

    public int createRandomNumber() {
        return new Random().nextInt(9);
    }

    public void move() {
        int randomNumber = createRandomNumber();
        if (isMove(randomNumber)) {
            position++;
        }
        System.out.println(getPosition());
    }

    public String getName() {
        return name;
    }
}
