package honux.Calender;

import java.text.ParseException;
import java.util.Scanner;

public class Prmpt {
	public void printMenu() {
		System.out.println("-----------------------");
		System.out.println(" 1. 일정등록");
		System.out.println(" 2. 일정검색");
		System.out.println(" 3. 달력보기");
		System.out.println(" h. 도움말");
		System.out.println(" q. 종료");
	}

	public int parseDay(String week) {
		switch (week) {
		case "su":
			return 0;
		case "mo":
			return 1;
		case "tu":
			return 2;
		case "we":
			return 3;
		case "th":
			return 4;
		case "fr":
			return 5;
		case "sa":
			return 6;
		default:
			return 0;
		}
	}

	public void runPrompt() throws ParseException {
		printMenu();
		Calender cal = new Calender();
		// 숫자를 입력받아 해당 달의 최대 일수를 출력
		Scanner scanner = new Scanner(System.in);

//				System.out.println("반복횟수를 입력하세요");
//				int repeat = scanner.nextInt();
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("명령 (1,2,3,h,q)");
			String cmd = scanner.next();
			
			switch (cmd) {
			case "1":
				cmdResigister(scanner, cal);
				break;
			case "2":
				cmdSearch(scanner, cal);
				break;
			case "3":
				cmdCal(scanner, cal);
				break;
			case "h":
				printMenu();
				break;
			case "q":
				isLoop = false;
				break;
			}
		}
		System.out.println("Bye!~");
		scanner.close();
	}

	private void cmdCal(Scanner s, Calender c) {
		// TODO Auto-generated method stub
		int month = 1;
		int year = 1;

		// TODO Auto-generated method stub
		System.out.println("년도를 입력하세요 ");
		System.out.print("YEAR >");
		year = s.nextInt();

		System.out.println("달을 입력하세요 ");
		System.out.print("MONTH >");
		month = s.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("잘못된 입력");
			return;
		}
		c.printSample(year, month);

	}

	private void cmdSearch(Scanner s, Calender c) {
		// TODO Auto-generated method stub
		System.out.println("일정 검색");
		System.out.println("날짜 입력 ( yyyy-mm-dd)");
		String date = s.next();
		PlanItem plan;
		plan= c.searchPlan(date);
		if(plan != null) {
			
		
		System.out.println(plan.detail);
		}
		else {
			System.out.println("일정이 없습니다.");
		}
	}

	private void cmdResigister(Scanner s, Calender c) throws ParseException {
		System.out.println("새 일정 등록");
		System.out.println("날짜 입력 ( yyyy-mm-dd)");
		String date = s.next();
		String text = "";
		System.out.println("일정을 입력해주세요 - ;를 치면 일정등록");
		String word;
		while(!(word = s.next()).endsWith(";")){
			text +=word + " ";
		}
		word = word.replaceAll(";", "");
		c.resisterPlan(date, text);

	}

}
