import java.util.LinkedList;

public class Main {
  public static void main(String[] args)
  {
    Graph test = new Graph("ur.txt");
    Node start = test.vertices.get("GILBERT-LONG");
    Node end = test.vertices.get("GAVETT");
    LinkedList<Node> fuck = test.shortestPath(start, end);
	System.out.println(fuck.size());
    for(int i = 0; i < fuck.size(); i++)
    {
    		System.out.println(fuck.get(i).getId());
    }
  }
}
