package honux.Calender;

import java.util.Calendar;
import java.util.Scanner;

public class Calender {

	private static final int[] maxDays1 = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };

	public int getMaxDaysOfMonth(int month) {
		return maxDays1[month - 1];
	}

	public static void main(String[] args) {
		System.out.println("Calender");
		System.out.println("일	월	화	수	목	금	토");
		System.out.println("--------------------------------------------------");
		System.out.println("1	2	3	4	5	6	7");
		System.out.println("8	9	10	11	12	13	14");
		System.out.println("15	16	17	18	19	20	21");
		System.out.println("22	23	24	25	26	27	28");
		System.out.println("29	30	31");

		// 숫자를 입력 받아 해당하는 달의 최대일수를 출력하는 방법
		Scanner scanner = new Scanner(System.in);
		Calender cal = new Calender();
		System.out.println("달을 입력하세요");
		int month = scanner.nextInt();

		System.out.printf("%d월의 최대일수는 %d일 입니다.\n", month, cal.getMaxDaysOfMonth(month));
		
		int y,m;
		System.out.println("몇년도 달력을 희망하시나요?");
		y=scanner.nextInt();
		
		//요일 확인 일요일 =1,월요일2,화3수4목5
		for(int j=1;j<=12;j++) {
			cal.set(y,j-1,1);
			int w=cal.get(Calendar.DAY_OF_WEEK);
			int end = cal.getActualMaximum(Calendar.DATE);
			
			System.out.println("\t"+y+"년"+j+"월");
			
			for (int i=1;i<w;i++) {
				System.out.print("\t");
			}
			for(int i = 1;i<=end;i++) {
				System.out.print("\t"+i);
				if(++w%7==1)
					System.out.println();
			}
			System.out.println();
		}
		

		
		scanner.close();
		
		
	}

	private int getActualMaximum(int date) {
		// TODO Auto-generated method stub
		return 0;
	}

	private int get(int dayOfWeek) {
		// TODO Auto-generated method stub
		return 0;
	}

	private void set(int y, int i, int j) {
		// TODO Auto-generated method stub
		
	}
}
