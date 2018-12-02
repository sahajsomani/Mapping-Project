import java.util.*;
import java.io.*;

public class Node implements Comparable<Node> {
  private ArrayList<String> adjlist;
  private double lon;
  private double lat;
  private String id;
  private boolean isVisited;
  private double weight;

  //constructor
  public Node(String id, double lat, double lon) {
    this.lon = lon;
    this.lat = lat;
    this.id = id;
    this.isVisited = false; //set to false for initialization
    adjlist = new ArrayList<String>();
    this.weight = Double.MAX_VALUE;
  }//end constructor

  public Node() {
    // this.Node(null, 0, 0);
  }

  public void setId(String id) { this.id = id; }

  public void setLon(double lon) { this.lon = lon; }

  public void setLat(double lat) { this.lat = lat; }

  public void setIsVisited(boolean isVisited) { this.isVisited = isVisited; }

  public void setWeight(double weight) { this.weight = weight; }

  public void addNeighbor(Node neighbor) { adjlist.add(neighbor.getId()); }

  public String getId() { return id; }

  public double getLon() { return lon; }

  public double getLat() { return lat; }

  public boolean getIsVisited() { return isVisited; }

  public double getWeight() { return weight; }

  public ArrayList<String> getAdjList() { return adjlist; }

  public static double computeEdge(Node start, Node end) {
    int EARTH_RADIUS = 3959;
    double startLat = start.getLat();
    double startLon = start.getLon();
    double endLat = end.getLat();
    double endLon = end.getLon();

    double dLat = Math.toRadians(endLat - startLat);
		double dLon = Math.toRadians(endLon - startLon);

    startLat = Math.toRadians(startLat);
    endLat = Math.toRadians(endLat);

    double a = Math.pow(Math.sin(dLat / 2), 2) + Math.cos(startLat) * Math.cos(endLat) * Math.pow(Math.sin(dLon / 2), 2);
		double c = 2 * Math.atan2(Math.sqrt(a), Math.sqrt(1 - a));

    return EARTH_RADIUS * c;
  }//end computeEdge

  @Override
  public int compareTo(Node n) {
    if(this.getWeight() > n.getWeight()) {
      return 1;
    } else if(this.getWeight() == n.getWeight()) {
      return 0;
    } else {
      return -1;
    }
  }//end compareTo


}//end Node class
