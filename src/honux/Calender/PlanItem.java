package honux.Calender;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class PlanItem {
	
	public Date planDate;
	public String detail;
	public String peoples = "";
	
	public static Date getDatefromSting(String strDate) {
		Date date=null;
		try {
			date = new SimpleDateFormat("yyyy-mm-dd").parse(strDate);
		} catch (ParseException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return date;
	}
	
	
	public PlanItem(String date, String detail) {
		this.planDate = getDatefromSting(date);
		this.detail = detail;
	}
	
	public Date getDate() {
		return planDate;
	}
	public void addPeople(String name) {
		peoples += name +",";
	}


	public String saveString() {
		// TODO Auto-generated method stub
		SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
		String sdate = formatter.format(planDate);
		return sdate +"," +"\""+detail +"\""+ "\n";
	}
}
