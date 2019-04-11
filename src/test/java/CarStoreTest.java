import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.Matchers.contains;
import static org.hamcrest.Matchers.containsInAnyOrder;
import static org.junit.Assert.*;

import model.Car;
import org.junit.Before;
import org.junit.Test;

import java.util.List;

public class CarStoreTest {

    private final CarStore carStore = new CarStore();
    private final Car almera = new Car("Nissan Almera", 2005);
    private final Car primera = new Car("Nissan Primera", 2010);
    private final Car tesla = new Car("Tesla", 2018);

    @Before
    public void setUp() {
        carStore.add(almera);
        carStore.add(primera);
        carStore.add(tesla);
    }

    @Test
    public void returnsNoResultsIfNameNoPartiallyMatchedWhenCarStoreIsEmpty() throws Exception {
        CarStore emptyCarStore = new CarStore();
        List<Car> results = emptyCarStore.findByPartiallyMatchedModel("bmw");

        assertThat(results.size(), is(0));
    }

    @Test
    public void returnsNoResultsIfNameNoPartiallyMatchedWhenCarStoreIsNotEmpty() throws Exception {

        List<Car> results = carStore.findByPartiallyMatchedModel("bmw");

        assertThat(results.size(), is(0));
    }

    @Test
    public void returnResultsIfNamePartiallyMatched() throws Exception {

        List<Car> results = carStore.findByPartiallyMatchedModel("Nissan");
        assertThat(results.size(), is(2));
        assertThat(results, containsInAnyOrder(almera, primera));
    }

    @Test
    public void returnsResultsIfCarWithinFromAndToDate() throws Exception {

        List<Car> results = carStore.findByDate(2008, 2012);
        assertThat(results.size(), is(1));
        assertThat(results, containsInAnyOrder(primera));
    }
}