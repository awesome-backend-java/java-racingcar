package racingcar;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

class RacingCarTest {
	RacingCar racingCar;
	String[] testRcCars;

	@BeforeEach
	public void setup(){
		racingCar = new RacingCar();
		testRcCars = racingCar.splitCars("a,b,c");
	}

	@Test
	void input_car_test(){
		String[] res = racingCar.splitCars("a,b,c");
		Assertions.assertEquals(res[0], "a");
	}

	@Test
	void select_winner_test() {
		Map<String, Integer> mapTest = new HashMap<>();
		mapTest.put("a", 3);
		mapTest.put("b", 3);
		mapTest.put("c", 2);
		List<String> res = new ArrayList<>();
		res.add("a");
		res.add("b");
		Assertions.assertEquals(racingCar.selectWinner(testRcCars, mapTest), res);
	}
}
