package com.Ninza.hrm.JavaUtility;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

public class JavaUtility {

	
public int getRandomNumber(int upperLimit)
{
	Random random=new Random();
	int randomNum = random.nextInt(upperLimit);
	return randomNum;
}

public void getAlphaRandomNumber(int n)
{
	String AlphaNum = "ABCDEFGHIJKLMNOPQRSTUVWXYZ0123456789abcdefghijklmnopqrstuvwxyz";
	StringBuilder sb=new StringBuilder(n);
	for(int i=0; i<n; i++)
	{
		int index=(int)(AlphaNum.length()*Math.random());
		sb.append(AlphaNum.charAt(index));
	}
	System.out.println(sb);
}

public String getSystemDateYYYYMMDD()
{
	
	Date dateObj=new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	String date = sim.format(dateObj);
	return date;
	
}

public String getRequiredDateYYYYMMDD(int days)
{
	
	Date datteObj =new Date();
	SimpleDateFormat sim=new SimpleDateFormat("yyyy-MM-dd");
	sim.format(datteObj);
	
	Calendar cal=sim.getCalendar();
	cal.add(Calendar.DAY_OF_MONTH, days);
	String reqDate = sim.format(cal.getTime());
	return reqDate;
	
}

}
