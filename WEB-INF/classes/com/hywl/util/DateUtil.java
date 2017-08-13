package com.hywl.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;



public class DateUtil {  
  public static String getDateTime()
  {
   Calendar cal  = Calendar.getInstance();
   SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
   String mDateTime=formatter.format(cal.getTime());
   return mDateTime;
  }
  
 
}
