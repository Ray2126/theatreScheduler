package tss;


public class Artist {
	/**
	 * Create an artist object with the provide name.
	 * @param name The name of the artist.
	 */

	/**
	 * Name of artist object
	 */
	private String _name;

	public Artist(String name) {
		System.out.println("@Artist object created with name " + name);
		_name = name;
	}

	@Override
	public String toString() {
		return _name;
	}
	@Override
	public boolean equals(Object obj) {
		return false;
	}
}
