import java.util.*;

class BFS {

    static class Edge{
        int src;
        int dest;
        int wt;

        public Edge(int src,int dest, int wt){
            this.src = src;
            this.dest = dest;
            this.wt =wt;
        }
    }

    public static void CreateGraph(ArrayList<Edge>[] graph){
        int V = graph.length;

        for(int i=0;i<V;i++){
            graph[i] = new ArrayList<Edge>();
        }

        graph[0].add(new Edge(0, 1, 1));
        graph[0].add(new Edge(0, 2, 1));


        graph[1].add(new Edge(1, 0, 1));
        graph[1].add(new Edge(1, 3, 1));

        graph[2].add(new Edge(2, 0, 1));
        graph[2].add(new Edge(2, 4, 1));

        graph[3].add(new Edge(3, 1, 1));
        graph[3].add(new Edge(3, 5, 1));
        graph[3].add(new Edge(3, 4, 1));

        graph[4].add(new Edge(4, 2, 1));
        graph[4].add(new Edge(4, 3, 1));
        graph[4].add(new Edge(4, 5, 1));

        graph[5].add(new Edge(5, 3, 1));
        graph[5].add(new Edge(5, 4, 1));
        graph[5].add(new Edge(5, 6, 1));

        graph[6].add(new Edge(6, 5, 1));


    }

    public static void bfs(ArrayList<Edge>[] graph){ // O(V+E)  // O(V^2) IN MATRIX
        Queue<Integer> q = new LinkedList<>();
        boolean[] vis = new boolean[graph.length];

        q.add(3); // src

        while(!q.isEmpty()){
            int curr = q.remove();

            if(!vis[curr]){
                System.out.print(curr + " ");

                vis[curr] = true;

                for(int i=0;i<graph[curr].size();i++){
                    Edge e = graph[curr].get(i);
                    
                    q.add(e.dest);
                }
            }
        }

    }

    public static void main(String[] args) {
        int V = 7;

        ArrayList<Edge>[] graph = new ArrayList[V];

        CreateGraph(graph);

        bfs(graph);

    }
}

