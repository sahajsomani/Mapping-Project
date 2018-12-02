public class Main {
  public static void main(String[] args)
  {
    new Node a = new Node("GILBERT-LONG", 43.130480, -77.631559);
    new Node b = new Node("GILBERT-COMMON", 43.130584, -77.631216);
    a.addNeighbor(Node b);
    b.addNeighbor(Node a);

    System.out.println(computeEdge(a, b));
  }
}
