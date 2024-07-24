package Lec12;

public class Graph_Client {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Graph g = new Graph(7);
		g.addEdge(1, 2, 7);
		g.addEdge(1, 3, 5);
		g.addEdge(2, 4, 4);
		g.addEdge(3, 4, 1);
		g.addEdge(5, 3, 2);
		g.addEdge(5, 6, 3);
		g.addEdge(5, 7, 2);
		g.Display();
		System.out.println(g.BFS(1, 6));

	}

}
