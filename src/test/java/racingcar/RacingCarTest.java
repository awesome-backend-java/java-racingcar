package racingcar;

import java.util.ArrayList;
import java.util.List;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import utils.Utils;

class RacingCarTest {
	private RacingCar racingCar;
	private Utils utils;

	@BeforeEach
	public void setup(){
		racingCar = new RacingCar();
		utils = new Utils();
	}

	@Test
	void input_car_test(){
		String[] result = utils.splitByComma("a,b,c");
		Assertions.assertEquals(result[0], "a");
	}

	@Test
	void select_winner_test() {
		List<Car> cars = new ArrayList<>();
		cars.add(new Car("a", 3));
		cars.add(new Car("b", 3));
		cars.add(new Car("c", 2));
		List<String> result = new ArrayList<>();
		result.add("a");
		result.add("b");
		Assertions.assertEquals(racingCar.selectWinner(cars), result);
	}
}
