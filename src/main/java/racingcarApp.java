import java.util.List;

import racingcar.RacingCar;

public class racingcarApp {
	public static void main(String[] args) {
		RacingCar racingCar = new RacingCar();
		String[] racingCars = racingCar.inputCars();
		int racingNum = racingCar.inputRaceNum(racingCars);
		List<String> result = racingCar.raceStart(racingCars, racingNum);
		System.out.println(result + "가 최종 우승했습니다.");
	}
}
