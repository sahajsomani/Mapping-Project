import java.util.*;
import java.io.*;

public class Node implements Comparable<Node> {
  private ArrayList<String> adjlist;
  private double lon;
  private double lat;
  private String id;
  private boolean isVisited;

  //constructor
  public Node(String id, double lat, double lon) {
    this.lon = lon;
    this.lat = lat;
    this.id = id;
    this.isVisited = false; //set to false for initialization
    adjlist = new ArrayList<String>();
  }//end constructor

  public Node() {
    //Node(null, 0, 0);
  }

  public void setId(String id) { this.id = id; }

  public void setLon(double lon) { this.lon = lon; }

  public void setLat(double lat) { this.lat = lat; }

  public void setIsVisited(boolean isVisited) { this.isVisited = isVisited; }

  public void addNeighbor(String neighbor) { adjlist.add(neighbor); }

  public String getId() { return id; }

  public double getLon() { return lon; }

  public double getLat() { return lat; }

  public boolean getIsVisited() { return isVisited; }

  public ArrayList<String> getAdjList() { return adjlist; }

@Override
public int compareTo(Node o) {
	// TODO Auto-generated method stub
	return 0;
}


}//end Node class
