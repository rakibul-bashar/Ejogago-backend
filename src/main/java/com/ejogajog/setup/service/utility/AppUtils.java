package com.ejogajog.setup.service.utility;

import java.util.Calendar;
import java.util.Date;

public class AppUtils {
	public static Date addDaysInCurrentDate(int days) {
		 Calendar current = Calendar.getInstance();
		    current.add(Calendar.DATE, 30);

		return current.getTime();
	}
	
}
