import java.util.List;

import javax.swing.JFrame;
public class test {
	static double width = 500;

	public static void main(String[] args) {
		Graph g = new Graph("nys.txt");
		String to = "i238311";
		String from = "i290070";
		Node origin = new Node(to, g.vertices.get(to).getLat(), g.vertices.get(to).getLon());
		Node destination = new Node(from, g.vertices.get(from).getLat(), g.vertices.get(from).getLon());
		List<Node> n = g.shortestPath(origin, destination);
		System.out.println(n.size());
		System.out.println(n.toString());
		//to draw graph
		
		//to show shortest path too
		JFrame frame = new JFrame();
		Canvas can = new Canvas(g, n);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.setSize(500, 600);
		frame.setResizable(true);
		frame.add(can);
		frame.setVisible(true);
		
		//to show just the map
//		JFrame frame2 = new JFrame();
//		Canvas can2 = new Canvas(g);
//		frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//		frame2.setSize(500, 600);
//		frame2.setResizable(true);
//		frame2.add(can2);
//		frame2.setVisible(true); 

	}
	
}