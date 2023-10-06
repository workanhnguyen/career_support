package com.nva.server.utils;

import java.text.SimpleDateFormat;
import java.util.Date;

public class DateFormat {
   public static String format(Date date, String pattern) {
       return new SimpleDateFormat(pattern).format(date);
   }
}
