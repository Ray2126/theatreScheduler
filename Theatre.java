package tss;


/**
 * Imported to be able to use ArrayLists as this makes it much easier to add elements than arrays
 */
import java.util.ArrayList;

public class Theatre {
	/**
	 * Creates a theatre object that will register artists and schedule performances
	 * This object will also hold the arrays of performances and artists and can also
	 * display the current state of the theatre.
	 */

	/**
	 * List of performances
	 */
	private ArrayList<Performance> _performances = new ArrayList<Performance>();
	/**
	 * List of reference types to Artist objects
	 */
	private ArrayList<Artist> _artistList = new ArrayList<Artist>();
	/**
	 * List of the Artist objects' names
	 */
	private ArrayList<String> _artistNames = new ArrayList<String>();

	public Theatre() {

	}

	/**
	 * Displays the current status of the theatre (registered artists
	 * and scheduled performances).
	 */
	public void display() {
		//If no artists have been registered.
		if(_artistList.isEmpty()) {
			System.out.println("No artists registered.");
		}
		else {
			System.out.println("Registered artists: ");
			for(int i = 0; i < _artistList.size(); i++) {
				System.out.println("\t" + _artistList.get(i).toString());
			}
		}
		//If no performances have been scheduled.
		if(_performances.isEmpty()) {
			System.out.println("No performances scheduled.");
		}
		else {
			System.out.println("Scheduled performances: ");
			for(int i = 0; i < _performances.size(); i++) {
				System.out.println("\t" + _performances.get(i).toString());
			}
		}

	}

	/**
	 * Registers an artist with the theatre.
	 * @param artist	The artist to register
	 */
	public void registerArtist(Artist artist) {
		//If the artist has already been registered, will display error message.
		if(_artistNames.contains(artist.toString()) == true) {
			System.out.println(artist.toString() + " has already been registered.");
		}
		else {
			_artistNames.add(artist.toString());
			_artistList.add(artist);
		}
	}

	/**
	 * Schedules the performance for the performance object
	 * @param thisPerformance	The performance object to schedule
	 */
	public void schedulePerformance(Performance thisPerformance) {
		//If the artist has not been registered to the theatre.
		if(_artistNames.contains(thisPerformance.getArtist().toString()) == false) {
			System.out.println("Artist has not been registered.");
		}
		else {
			//Check if performance ends at or after midnight
			if(thisPerformance.endTime() < 2360) {
				int counter = 0;
				//Check for performance time overlap
				for(int i = 0; i < _performances.size(); i++) {
					if(_performances.get(i).overlaps(thisPerformance)) {
						counter++;
					}
				}
				//Only when no overlap was found, will it add to the _performance list.
				if(counter == 0) {
					_performances.add(thisPerformance);
				}
				else {
					System.out.println("Invalid performance time. Performances may not be overlap nor go past midnight.");
				}
			}
			else {
				System.out.println("Invalid performance time. Performances may not be overlap nor go past midnight.");
			}
		}




	}

}