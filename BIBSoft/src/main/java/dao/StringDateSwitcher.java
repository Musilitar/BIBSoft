
package dao;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class StringDateSwitcher {
	public static Date toDate(String str) {
        String pattern = "dd/MM/yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date myDateObj = null;
        if (str != null){
        	try {
                myDateObj = formatter.parse(str);
                //System.out.println("Date in text format: " + myDateStr);
                //System.out.println("Date in java.util.Date Obj : " + myDateObj);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return myDateObj;
    }
	
	public static String datetoString(Date dat) {
		String mysqlDateString = null;
		if (dat != null){
			String pattern = "dd/MM/yyyy";
	        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	        mysqlDateString = formatter.format(dat);
	        //System.out.println("Java's Default Date Format: " + dat);
	        //System.out.println("Mysql's Default Date Format: " + mysqlDateString);
		}
        return mysqlDateString;
    }
	
	public static Date toDateTime(String str) {
        String pattern = "yyyy-MM-dd HH:mm:ss";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date myDateObj = null;
        if (str != null){
        	try {
                myDateObj = formatter.parse(str);
                //System.out.println("Date in text format: " + myDateStr);
                //System.out.println("Date in java.util.Date Obj : " + myDateObj);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return myDateObj;
    }
	
	public static String dateTimetoString(Date dat) {
		String mysqlDateString = null;
		if (dat != null){
			String pattern = "yyyy-MM-dd HH:mm:ss";
	        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
	        mysqlDateString = formatter.format(dat);
	        //System.out.println("Java's Default Date Format: " + dat);
	        //System.out.println("Mysql's Default Date Format: " + mysqlDateString);
		}
        return mysqlDateString;
    }
	
	public static String dateToStringYear(Date dat){
		String mysqlDateString = null;
		
		if(dat != null){
			String pattern = "yyyy";
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			mysqlDateString = formatter.format(dat);
		}
		return mysqlDateString;
	}
	
	public static Date toDateYear(String str) {
        String pattern = "yyyy";
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        Date myDateObj = null;
        if (str != null){
        	try {
                myDateObj = formatter.parse(str);
                //System.out.println("Date in text format: " + myDateStr);
                //System.out.println("Date in java.util.Date Obj : " + myDateObj);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return myDateObj;
    }
	
	public static String dateToStringMonthYear(Date dat){
		String mysqlDateString = null;
		
		if(dat != null){
			String pattern = "MM/yyyy";
			SimpleDateFormat formatter = new SimpleDateFormat(pattern);
			mysqlDateString = formatter.format(dat);
		}
		return mysqlDateString;
	}
	
	
}