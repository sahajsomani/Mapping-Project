// Authors: Sahaj Somani, Nikita Kim

import java.util.*;
import javax.swing.JFrame;

public class StreetMap {
	static double length = 500;
	static double width = 500;

	public static void main(String[] args) {
		String file = args[0];
		Graph g = new Graph(file);
		System.out.println(file);
		ArrayList<String> com = new ArrayList<String>();
		for(String s: args) {
			com.add(s);
		}
		
		if(com.contains("--directions")) {
			String to = args[(args.length-1)];
			String from = args[args.length -2];
			//Node origin = new Node(to, g.vertices.get(to).getLat(), g.vertices.get(to).getLon());
			//Node destination = new Node(from, g.vertices.get(from).getLat(), g.vertices.get(from).getLon());
			Node origin = g.vertices.get(to);
			Node destination = g.vertices.get(from);
			List<Node> n = g.shortestPath(origin, destination);
			System.out.println("Path: " + destination.toString());
			System.out.println("Distance: " + Double.toString(destination.getWeight()) + " Miles");
			
			if(com.contains("--show")) {
				JFrame frame = new JFrame();
				Canvas can = new Canvas(g, n);
				frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
				frame.setSize(700, 600);
				frame.setResizable(true);
				frame.add(can);
				frame.setVisible(true);
			}
		} else if (com.contains("--show")) {
			JFrame frame2 = new JFrame();
			Canvas can2 = new Canvas(g);
			frame2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
			frame2.setSize(500, 600);
			frame2.setResizable(true);
			frame2.add(can2);
			frame2.setVisible(true);
		}

	}
	
}