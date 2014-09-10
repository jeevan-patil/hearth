package org.hearth;

import java.util.TimeZone;

public class TimeCheck {
    public static void main(String a[]) {
	long startOf1900UTC = -2208988800000L;
	for(String id : TimeZone.getAvailableIDs()) {
	    TimeZone zone = TimeZone.getTimeZone(id);
	    if(zone.getRawOffset() != zone.getOffset(startOf1900UTC - 1)) {
		System.out.println(id);	
	    }
	}
    }
}
