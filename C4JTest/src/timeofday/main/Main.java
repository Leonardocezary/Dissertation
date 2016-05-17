package timeofday.main;

import timeofday.TimeOfDay;

/**
 * 
 * @author leoky
 *
 */
public class Main{
	
	
	/**
	 * 
	 * @param args
	 */
	public static void main (String[] args){
		
		TimeOfDay timeOfDayContract = new TimeOfDay(20, 42, 34);
		timeOfDayContract.setHour(23);

		System.out.println(timeOfDayContract.getHour());
	}
}
