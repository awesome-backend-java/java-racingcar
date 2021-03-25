package racingcar;

import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class RacingCar {

	public String[] inputCars() {
		System.out.println("경주할 자동차 이름을 입력하세요 (이름은 쉼표(,)를 기준으로 구분)");
		Scanner sc = new Scanner(System.in);
		String carStr = sc.nextLine();
		return splitCars(carStr);
	}

	public String[] splitCars(String carStr){
		return carStr.split(",");
	}

	public int inputRaceNum(String[] racingCars){
		System.out.println("시도할 횟수는 몇회인가요?");
		Scanner sc = new Scanner(System.in);
		int racingNum = Integer.parseInt(sc.nextLine());
		return racingNum;
	}

	public List<String> raceStart(String[] racingCars, int racingNum){
		Map<String, Integer> rcTotal = new HashMap<>();
		for(String car : racingCars){
			rcTotal.put(car, 0);
		}
		for(int i = 0; i < racingNum; i++){
			printRacingCar(racingCars, rcTotal);
		}
		return selectWinner(racingCars, rcTotal);
	}

	public void randomNum(String[] racingCars, int idx, Map<String, Integer> rcTotal){
		int randNum = (int)(Math.random()*10);
		if(randNum > 3){
			rcTotal.put(racingCars[idx], rcTotal.get(racingCars[idx])+1);
		}
	}

	public void printRacingCar(String[] racingCars, Map<String, Integer> rcTotal){
		for(int i = 0; i < racingCars.length; i++){
			randomNum(racingCars, i, rcTotal);
			int num = rcTotal.get(racingCars[i]);
			System.out.println(racingCars[i] + " : " + String.join("", Collections.nCopies(num, "-")));
		}
		System.out.println();
	}

	public List<String> selectWinner(String[] racingCars, Map<String, Integer> rcTotal){
		int len = 0;
		for(String key : rcTotal.keySet()){
			len = Math.max(len, rcTotal.get(key));
		}
		int finalLen = len;
		return Arrays.stream(racingCars)
			.filter(s -> rcTotal.get(s) == finalLen)
			.collect(Collectors.toList());
	}
}
