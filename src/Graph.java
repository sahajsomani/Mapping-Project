import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Graph {
  //using a Hashmap to prevent duplicate intersecions
  Hashmap<String, Node> vertices;

  //These will be useful for painting the graph
	double maxlat;
	double minlat;
	double maxlon;
	double minlon;

  //Constructing a graph from the text file
  public Graph(String filename) {
    try {
      String contents = new String(Files.readAllBytes(Paths.get(filename))); // reading the file
      String[] lines = contents.split("\n");

      for(int i = 0; i < lines.length; i++) {
        String[] temp = lines[i].split("\\s+");

        if(temp[0].equals("i")) {
          this.addVertice(temp[1], Double.parseDouble(temp[2]), Double.parseDouble(temp[3]));
        } else if (temp[0].equals("r")) {
          this.addEdge(temp[2], temp[3]);
        }
      }
    } catch (Exception e) {
        System.out.println("Error with reading the file");
      }
  }//end constructor

  public void addVertice(String id, double lat, double lon) {

		vertices.put(id, new Node(id, lat, lon)); //add Node to HashSet

		// keeping track of max and min lat and lon
		if (lat > maxlat) {
			maxlat = lat;
		} else if (lat < minlat) {
			minlat = lat;
		}
		if (lon > maxlon) {
			maxlon = lon;
		} else if (lon < minlon) {
			minlon = lon;
		}
  }//end addIntersection

  public void addEdge(String one, String two) {
    Node a = vertices.get(one);
    Node b = vertices.get(two);
    a.addNeighbor(b);
    b.addNeighbor(a);
  }

  public LinkedList<Node> shortestPath(Node start, Node end) {
    int visited = 0;
    start.setWeight(0);
    Collection<Node> d = vertices.values();
    PriorityQueue<Node> queue = new PriorityQueue(d.size(), new ourComparator());
    for(int i = 0; i < d.size(); i++) {
      queue.add(d[i]);
    }

    while(visited < d.size()) {
      Node min = queue.poll();
      ArrayList<Node> neighbors = min.getAdjList();
      for(int i = 0; i < neighbors.size(); i++) {
        if(!neighbors[i].getIsVisited() && (min.getWeight() + Node.computeEdge(min, neighbors[i]) < neighbors[i].getWeight())) {
          neighbors[i].setWeight(min.getWeight() + Node.computeEdge(min, neighbors[i]));
          neighbors[i].setPathList(min.getPathList);
          neighbors[i].addPathList(min);
        }
      }
      vertices.get(min.getId()).setIsVisited(true);
      visited++;
      if(min.equals(end)) {
        visited = d.size();
      }
    }

    return end.getPathList;

  }

  private class ourComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
      return a.compareTo(b);
    }
  }


}//end Graph class
