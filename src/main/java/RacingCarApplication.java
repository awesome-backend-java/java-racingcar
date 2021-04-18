import java.util.List;
import racingcar.Car;
import racingcar.RacingCar;

public class RacingCarApplication {
	public static void main(String[] args) {
		
		RacingCar racingCar = new RacingCar();
		List<Car> racingCars = racingCar.inputCars();
		int racingNum = racingCar.inputRaceNumber();
		List<String> result = racingCar.raceStart(racingCars, racingNum);
		System.out.println(result + "가 최종 우승했습니다.");
	}
}
