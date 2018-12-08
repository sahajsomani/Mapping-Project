import java.util.*;

public class Main {
  public static void main(String[] args)
  {
	  long startTime = new Date().getTime();
    Graph test = new Graph("ur.txt");
    Node start = test.vertices.get("ANDERSON");
    Node end = test.vertices.get("HYLAN");  
    
    LinkedList<Node> temp = test.shortestPath(start, end);
    
    System.out.println(temp.size());
    for(Node i : temp)
    {
    	System.out.println(i.getId());
    }
    System.out.println(test.vertices.get("HYLAN").getWeight());

    long endTime = new Date().getTime();
    System.out.println("It took " + (endTime - startTime) + " ms to run.");
  }
}