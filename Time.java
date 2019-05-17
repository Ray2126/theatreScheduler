package tss;


public class Time {
	/**
	 * This class will check the timings of the performances
	 */

	public Time() {

	}

	/**
	 * This method extracts the start time from the time and date format
	 * and then turns it into a integer format
	 * @param startTime	The start time and date of performance
	 * @return			The start time of the performance in integer format
	 */
	public static int getStartTime(String startTime) {
		//Splits the string into two parts, one containing the hours and
		//one containing the minutes
		String[] hoursMinutes = startTime.split(":");
		String minutesString = hoursMinutes[1];
		String hoursString = hoursMinutes[0];
		//Take the last two characters from the hours string as we do
		//not want the date part of the string
		hoursString = hoursString.substring(hoursString.length() - 2);
		//Concatenate the two strings
		String totalTime = hoursString + minutesString;
		return Integer.parseInt(totalTime);
	}

	/**
	 * This method works out the end time for the performance from
	 * the start time and duration. Also in the process converts
	 * the start time to integer format from string format
	 * @param startTime	The start time and date of performance
	 * @param duration	The duration of the performance
	 * @return
	 */
	public static int getEndTime(String startTime, int duration) {
		String[] hoursMinutes = startTime.split(":");
		String minutesString = hoursMinutes[1];
		String hoursString = hoursMinutes[0];
		hoursString = hoursString.substring(hoursString.length() - 2);

		String totalTime = hoursString + minutesString;
		int startTimeInt = Integer.parseInt(totalTime);

		int endTimeInt = startTimeInt+((duration / 60)*100)+(duration % 60);
		return endTimeInt;	
	}

	/**
	 * This method checks if the two dates of the performances in 
	 * question are the same
	 * @param performance1	The first performances to compare.
	 * @param performance2	The second performance to compare.
	 * @return	true if they are the same date, false otherwise
	 */
	public static boolean sameDate(String performance1, String performance2) {
		String[] date1 = performance1.split("T");
		String[] date2 = performance2.split("T");

		if(date1[0].equals(date2[0])) {
			return true;
		}
		return false;
	}




}
