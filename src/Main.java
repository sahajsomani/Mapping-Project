
public class Main {
  public static void main(String[] args)
  {
    Node a = new Node("GILBERT-LONG", 43.130480, -77.631559);
    Node b = new Node("GILBERT-COMMON", 43.130584, -77.631216);
    a.addNeighbor(b);
    b.addNeighbor(a);

    System.out.println(Node.computeEdge(a, b));
  }
}
