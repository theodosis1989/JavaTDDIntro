import model.Car;

import java.util.ArrayList;
import java.util.List;

public class CarStore {
    List<Car> cars = new ArrayList<Car>();

    public List<Car> findByPartiallyMatchedModel(String modelName) {
        List<Car> results = new ArrayList<Car>();
        for(Car car : cars) {
            if (car.model().contains(modelName)) {
                results.add(car);
            }
        }
        return results;
    }

    public void add(Car car) {
        cars.add(car);
    }

    public List<Car> findByDate(int fromDate, int toDate) {
        List<Car> results = new ArrayList<Car>();
        for(Car car : cars) {
            if (car.releaseDate() > fromDate && car.releaseDate() < toDate) {
                results.add(car);
            }
        }
        return results;
    }
}
