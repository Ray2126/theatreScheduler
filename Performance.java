package tss;


import tss.Time;

public class Performance {
	/**
	 * Create a performance object with the specified artist, start time
	 * of the performance and duration of the performance
	 * @param artist	The artist object for this performance
	 * @param startTime	The start time and date of the performance
	 * @param duration	How long the performance is going to last in minutes
	 */


	/**
	 * Reference to the artist that this performance is scheduled for.
	 */
	private Artist _artist;
	/**
	 * The duration of the performance.
	 */
	private int _duration;
	/**
	 * The full start time of the performance including date and time in string format.
	 */
	private String _startTimeString;
	/**
	 * The start time of the performance in 24hr time in integer format.
	 */
	private int _startTime;
	/**
	 * The end time of the performance.
	 */
	private int _endTime;

	public Performance(Artist artist, String startTime, int duration) {
		_artist = artist;
		_startTimeString = startTime;
		//Invokes the static method getStartTime to turn the String of date and time to just the time in integer format
		_startTime = Time.getStartTime(startTime);
		_duration = duration;
		//Invoke static method getEndTime to get the end time of the performance
		_endTime = Time.getEndTime(_startTimeString, _duration);
		System.out.println("@Performance object created with artist " + artist.toString() + " at " + _startTimeString + " with duration " + _duration);
	}

	/**
	 * Return the artist for this performance.
	 * @return The {@link Artist} for this performance.
	 */

	public Artist getArtist() {
		return _artist;
	}

	/**
	 * Return the start time for this performance.
	 * @return The start time for this performance.
	 */
	public int startTime() {
		return _startTime;
	}

	/**
	 * Return the end time for this performance.
	 * @return The end time for this performance.
	 */
	public int endTime() {
		return _endTime;
	}

	/**
	 * Return the duration for this performance.
	 * @return The duration for this performance.
	 */
	public int getDuration() {
		return _duration;
	}

	public	String startTimeString() {
		return _startTimeString;
	}

	/**
	 * Determine whether this performance overlaps with the performance provided.
	 * Performance A overlaps with performance B if A's start time is before B's, but it
	 * finishes after B starts, or vice versa.
	 * @param existingPerformance The {@link Performance} to compare against.
	 * @return true if the two performances overlap otherwise false.
	 */
	public boolean overlaps(Performance existingPerformance) {
		if((_startTime <= existingPerformance.startTime()) && (_endTime >= existingPerformance.startTime())) {
			//Check if the dates are the same if the times overlap
			if(Time.sameDate(existingPerformance.startTimeString(), _startTimeString) == true) {
				return true;
			}
		} 
		else if ((existingPerformance.startTime() <= _startTime) && (existingPerformance.endTime() >= _startTime)) {
			//Check if the dates are the same if the times overlap
			if(Time.sameDate(existingPerformance.startTimeString(), _startTimeString) == true) {
				return true;
			}
		}
		return false;
	}


	@Override
	public String toString() {
		return _artist.toString() + ", " + _startTimeString + ", " + Integer.toString(_duration);
	}
}
