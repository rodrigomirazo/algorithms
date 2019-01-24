package com.basic.algortithms.sectionG;

import java.util.Iterator;
import java.util.LinkedList;

public class BreathFirstSearch
{
    private int V;   // No. of vertices
    private LinkedList<Integer> adj[]; //Adjacency Lists
    private LinkedList<Integer> adjDistance[]; //Adjacency Lists

    // Constructor
    BreathFirstSearch(int v) {
        V = v;
        //Distance = distance;
        adj = new LinkedList[v];
        adjDistance = new LinkedList[v];

        for (int i=0; i<v; ++i) {
            adj[i] = new LinkedList();
            adjDistance[i] = new LinkedList();
        }
    }

    // Function to add an edge into the graph
    void addEdge(int v,int w, int distance) {
        adj[v].add(w);
        adjDistance[v].add(distance);
    }

    // prints BFS traversal from a given source s
    void BFS(int s)
    {
        // Mark all the vertices as not visited(By default
        // set as false)
        boolean visited[] = new boolean[V];

        // Create a queue for BFS
        LinkedList<Integer> queue = new LinkedList<Integer>();

        // Mark the current node as visited and enqueue it
        visited[s]=true;
        queue.add(s);

        while (queue.size() != 0)
        {
            // Dequeue a vertex from queue and print it
            s = queue.poll();
            //System.out.print("s = " + s+" => ");

            // Get all adjacent vertices of the dequeued vertex s
            // If a adjacent has not been visited, then mark it
            // visited and enqueue it
            Iterator<Integer> i = adj[s].listIterator();
            while (i.hasNext())
            {
                int n = i.next();
                if (!visited[n]) {
                    System.out.print(adjDistance[s].get( adjDistance[s].size()-1 ) + " ");
                    visited[n] = true;
                    queue.add(n);
                }
            }

        }
    }

    // Driver method to
    public static void main(String args[])
    {
        System.out.println("Following is Breadth First Traversal\n");
        BreathFirstSearch g1 = new BreathFirstSearch(5);

        g1.addEdge(1, 2, 6);
        g1.addEdge(1, 3, 6);
        g1.addEdge(2, 4, -1);

        System.out.print("Starting from vertex 1: ");

        g1.BFS(1);

        /**
         * From Vertex 2
         */
        BreathFirstSearch g2 = new BreathFirstSearch(5);

        g2.addEdge(3, 1, -1);
        g2.addEdge(2, 3, 6);

        System.out.print("\nStarting from vertex 2: ");

        g2.BFS(2);

    }
}
