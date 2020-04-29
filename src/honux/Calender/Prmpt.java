package honux.Calender;

import java.text.ParseException;
import java.util.Scanner;

public class Prmpt {
	public void printMenu() {
		System.out.println("-----------------------");
		System.out.println(" 1. �������");
		System.out.println(" 2. �����˻�");
		System.out.println(" 3. �޷º���");
		System.out.println(" h. ����");
		System.out.println(" q. ����");
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
		// ���ڸ� �Է¹޾� �ش� ���� �ִ� �ϼ��� ���
		Scanner scanner = new Scanner(System.in);

//				System.out.println("�ݺ�Ƚ���� �Է��ϼ���");
//				int repeat = scanner.nextInt();
		boolean isLoop = true;
		while (isLoop) {
			System.out.println("��� (1,2,3,h,q)");
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
		System.out.println("�⵵�� �Է��ϼ��� ");
		System.out.print("YEAR >");
		year = s.nextInt();

		System.out.println("���� �Է��ϼ��� ");
		System.out.print("MONTH >");
		month = s.nextInt();

		if (month > 12 || month < 1) {
			System.out.println("�߸��� �Է�");
			return;
		}
		c.printSample(year, month);

	}

	private void cmdSearch(Scanner s, Calender c) {
		// TODO Auto-generated method stub
		System.out.println("���� �˻�");
		System.out.println("��¥ �Է� ( yyyy-mm-dd)");
		String date = s.next();
		PlanItem plan;
		plan= c.searchPlan(date);
		if(plan != null) {
			
		
		System.out.println(plan.detail);
		}
		else {
			System.out.println("������ �����ϴ�.");
		}
	}

	private void cmdResigister(Scanner s, Calender c) throws ParseException {
		System.out.println("�� ���� ���");
		System.out.println("��¥ �Է� ( yyyy-mm-dd)");
		String date = s.next();
		String text = "";
		System.out.println("������ �Է����ּ��� - ;�� ġ�� �������");
		String word;
		while(!(word = s.next()).endsWith(";")){
			text +=word + " ";
		}
		word = word.replaceAll(";", "");
		c.resisterPlan(date, text);

	}

}
