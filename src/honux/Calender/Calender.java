package honux.Calender;

import java.util.Scanner;

public class Calender {
	
	public static void main(String[] args) {
		System.out.println("Calender");
		System.out.println("일	월	화	수	목	금	토");
		System.out.println("--------------------------------------------------");
		System.out.println("1	2	3	4	5	6	7");
		System.out.println("8	9	10	11	12	13	14");
		System.out.println("15	16	17	18	19	20	21");
		System.out.println("22	23	24	25	26	27	28");
		System.out.println("29	30	31");
		
		
		//숫자를 입력받아 해당하는 달의 최대일수를 출력하는 방법
		Scanner scanner = new Scanner(System.in);
		System.out.println("달을 입력하세요");
		int month = scanner.nextInt();
		
		int[] maxDays = {31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31};
		
		System.out.printf("%d월의 최대일수는 %d일 입니다.\n", month, maxDays[month - 1]);
		scanner.close();
	}
}

