package Lec13;

import java.util.HashMap;
import java.util.LinkedList;
import java.util.Queue;

public class Is_Graph_Bipartite {
	class Solution {
		public boolean isBipartite(int[][] graph) {
			HashMap<Integer, Integer> visited = new HashMap<>();
			Queue<BipartitePair> q = new LinkedList<>();
			for (int i = 0; i < graph.length; i++) {// vtx
				if (visited.containsKey(i)) {
					continue;
				}
				q.add(new BipartitePair(i, 0));
				while (!q.isEmpty()) {
					BipartitePair rp = q.poll();
					if (visited.containsKey(rp.vtx)) {
						if (visited.get(rp.vtx) != rp.dis) {// odd length
							return false;
						}
						else {
							continue;// even  length
						}
					}
					visited.put(rp.vtx, rp.dis);
					for(int nbrs:graph[rp.vtx]) {
						if(!visited.containsKey(nbrs)) {
							q.add(new BipartitePair(nbrs, rp.dis+1));
						}
					}
					
				}

			}
			return true;
		}
	}

	class BipartitePair {
		int vtx;
		int dis;

		public BipartitePair(int vtx, int dis) {
			// TODO Auto-generated constructor stub
			this.vtx = vtx;
			this.dis = dis;

		}
	}
}
