import java.util.*;

public class Cars {
    List<Car> cars;

    public Cars(String cars) {
        this.cars = new ArrayList<Car>();
        Arrays.stream(cars.split(",")).forEach(s -> this.cars.add(new Car(s)));
    }

    public void move() {
        for(Car car : cars) {
            car.move();
        }
    }

    public List<Car> max() {
        cars.sort(new Comparator<Car>() {
            @Override
            public int compare(Car o1, Car o2) {
                return o2.position - o1.position;
            }
        });

        List<Car> result = new ArrayList<>();
        cars.forEach(s -> { if(cars.get(0).position == s.position) {
            result.add(s);
        }});

        return result;
    }

    public void result() {
        String result = "";
        List<Car> max = max();

        for(Car car : max) {
            result += car.getName() + ",";
        }

        System.out.println(result.substring(0,result.length()-1) + "가 최종 우승했습니다.");
    }
}
