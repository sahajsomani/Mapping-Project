import java.io.*;
import java.util.*;
import java.nio.file.*;

public class Graph {
  //using a Hashmap to prevent duplicate intersecions
  HashMap<String, Node> vertices;

  //These will be useful for painting the graph
	double maxlat;
	double minlat;
	double maxlon;
	double minlon;

  //Constructing a graph from the text file
  public Graph(String filename) {
	  vertices = new HashMap<String, Node>();
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
	  	Node n = new Node(id, lat, lon);
		vertices.put(id, n); //add Node to HashMap

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
    PriorityQueue<Node> queue = new PriorityQueue<Node>(d.size(), new ourComparator());
    
    Iterator<Node> it = d.iterator();
    while(it.hasNext()) {
    		queue.add(it.next());
    }

    while(visited < d.size()) {
      Node min = queue.poll();
      ArrayList<Node> neighbors = min.getAdjList();
      for(int i = 0; i < neighbors.size(); i++) {
        if(!neighbors.get(i).getIsVisited() && (min.getWeight() + Node.computeEdge(min, neighbors.get(i)) < neighbors.get(i).getWeight())) {
        		neighbors.get(i).setWeight(min.getWeight() + Node.computeEdge(min, neighbors.get(i)));
        		neighbors.get(i).setPathList(min.getPathList());
        		neighbors.get(i).addPathList(min);
        }
      }
      vertices.get(min.getId()).setIsVisited(true);
      visited++;
      if(min.equals(end)) {
        visited = d.size();
      }
    }

    return end.getPathList();

  }

  private class ourComparator implements Comparator<Node> {
    public int compare(Node a, Node b) {
      return a.compareTo(b);
    }
  }


}//end Graph class
