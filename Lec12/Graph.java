package Lec12;

import java.util.*;

public class Graph {
	private HashMap<Integer, HashMap<Integer, Integer>> map;

	public Graph(int v) {
		// TODO Auto-generated constructor stub
		map = new HashMap<>();
		for (int i = 1; i <= v; i++) {
			map.put(i, new HashMap<>());
		}
	}

	public void addEdge(int v1, int v2, int cost) {
		map.get(v1).put(v2, cost);
		map.get(v2).put(v1, cost);
	}

	public void Display() {
		for (int k : map.keySet()) {
			System.out.println(k + " " + map.get(k));
		}
	}

	public boolean BFS(int src, int des) {
		Queue<Integer> q = new LinkedList<>();
		q.add(src);
		HashSet<Integer> visited = new HashSet<>();
		while (!q.isEmpty()) {
			// 1 . remove
			int rv = q.poll();
			// 2. Ignore if Already visited
			if (visited.contains(rv)) {
				continue;
			}
			// 3. Marked visited
			visited.add(rv);
			// 4. self Work
			if (rv == des) {
				return true;
			}
			// 5. Add unvisited Nbrs
			for (int nbrs : map.get(rv).keySet()) {
				if (!visited.contains(nbrs)) {
					q.add(nbrs);
				}
			}

		}
		return false;
	}

	public boolean DFS(int src, int des) {
		Stack<Integer> s = new Stack<>();
		s.push(src);
		HashSet<Integer> visited = new HashSet<>();
		while (!s.isEmpty()) {
			// 1 . remove
			int rv = s.pop();
			// 2. Ignore if Already visited
			if (visited.contains(rv)) {
				continue;
			}
			// 3. Marked visited
			visited.add(rv);
			// 4. self Work
			if (rv == des) {
				return true;
			}
			// 5. Add unvisited Nbrs
			for (int nbrs : map.get(rv).keySet()) {
				if (!visited.contains(nbrs)) {
					s.push(nbrs);
				}
			}

		}
		return false;
	}

	public void BFT() {
		Queue<Integer> q = new LinkedList<>();
		HashSet<Integer> visited = new HashSet<>();
		for (int src : map.keySet()) {
			if (visited.contains(src)) {
				continue;
			}
			q.add(src);
			while (!q.isEmpty()) {
				// 1 . remove
				int rv = q.poll();
				// 2. Ignore if Already visited
				if (visited.contains(rv)) {
					continue;
				}
				// 3. Marked visited
				visited.add(rv);
				// 4. self Work
				System.out.print(rv + " ");
				// 5. Add unvisited Nbrs
				for (int nbrs : map.get(rv).keySet()) {
					if (!visited.contains(nbrs)) {
						q.add(nbrs);
					}
				}

			}
		}
		System.out.println();
	}
}
