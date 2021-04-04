package racingcar;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Optional;
import java.util.Scanner;
import java.util.stream.Collectors;
import utils.Utils;

public class RacingCar {

	public List<Car> inputCars() {
		System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분)");
		Scanner sc = new Scanner(System.in);
		String input = sc.nextLine();
		Utils utils = new Utils();
		String[] values = utils.splitByComma(input);
		List<Car> cars = new ArrayList<>();
		for(String value : values) {
			Car car = new Car(value, 0);
			cars.add(car);
		}
		return cars;
	}

	public int inputRaceNumber() {
		System.out.println("시도할 횟수는 몇회인가요?");
		Scanner sc = new Scanner(System.in);
		int racingNumber = Optional.ofNullable(sc)
				.map(s -> Integer.parseInt(s.nextLine()))
				.orElseThrow(NumberFormatException::new);
		return racingNumber;
	}

	public List<String> raceStart(List<Car> cars, int racingNumber) {
		for(int i = 0; i < racingNumber; i++){
			printRacingCar(cars);
		}
		return selectWinner(cars);
	}

	private void makeRandomNumber(List<Car> cars, int idx) {
		int randNum = (int)(Math.random()*10);
		if(randNum > 3){
			cars.get(idx).addPosition();
		}
	}

	private void printRacingCar(List<Car> cars) {
		for(int i = 0; i < cars.size(); i++){
			makeRandomNumber(cars, i);
			int num = cars.get(i).getPosition();
			System.out.println(cars.get(i).getName() + " : " + String.join("", Collections.nCopies(num, "-")));
		}
		System.out.println();
	}

	public List<String> selectWinner(List<Car> cars) {
		Optional<Integer> numberOrder = cars.stream()
				.sorted(Comparator.comparing(Car::getPosition).reversed())
				.findFirst()
				.map(Car::getPosition);

		return cars.stream()
				.filter(s -> s.getPosition() == numberOrder.get())
				.map(Car::getName)
				.collect(Collectors.toList());
	}
}
