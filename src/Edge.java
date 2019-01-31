// Authors: Sahaj Somani, Nikita Kim

public class Edge {
	String id;
	double weight;

	// constructor
	public Edge(String id, Node o, Node d) {
		this.id = id;
		this.weight = distance(o.getLat(), o.getLon(), d.getLat(), d.getLon());
	}

	// find distance between two edges (in meters)
	// the following code for the Haversin Functon is taken from:
	// https://github.com/jasonwinn/haversine/blob/master/Haversine.java
	private static final int EARTH_RADIUS = 3959; // Approx Earth radius in MILEs

	private static double distance(double startLat, double startLong, double endLat, double endLong) {

		double dLat = Math.toRadians((endLat - startLat));
		double dLong = Math.toRadians((endLong - startLong));

		startLat = Math.toRadians(startLat);
		endLat = Math.toRadians(endLat);

		double a = haversin(dLat) + Math.cos(startLat) * Math.cos(endLat) * haversin(dLong);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

		return EARTH_RADIUS * c; // <-- d
		// returns distance in miles

	}//end distance

	private static double haversin(double val) {
		return Math.pow(Math.sin(val / 2), 2);
	}

}//end Edge class
