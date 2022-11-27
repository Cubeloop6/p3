package solvers;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.BellmanFordSolver;
import main.Parser;
import cse332.graph.GraphUtil;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

public class OutSequential implements BellmanFordSolver {

    public List<Integer> solve(int[][] adjMatrix, int source) {

        //       int l = adjMatrix[0].length;
        //     LinkedList<Integer>[] adjList = Parser.parse(adjMatrix);
        //   int[] D1 = new int[l];
        // int[] D2 = new int[l];
        // int[] P = new int[l];
        //part 1

        //  for (int i = 0; i < l; i++) {
        //     D1[i] = Integer.MAX_VALUE;
        //    P[i] = 0;
        //  }
        // D1[source] = 0;

        //      for (int i = 0; i < adjList.length; i++) {
        //        for (int j = 0; j < l; j++) {
        //          D2[j] = D1[j];
        //    }

        //  int v = i;
        //for (Integer j : adjList[i]) {
        //  int w = j;
        //int cost = w - v;
        // if (D1[w] > D2[v] + cost) {
        //   D1[w] = D2[v] + cost;
        // P[w] = v;
        // }
        // }
        // }
        //part3


        // LinkedList<Integer> cycle = (LinkedList<Integer>) GraphUtil.getCycle(P);
        //return cycle;

        int l = adjMatrix.length;
        ArrayList<HashMap<Integer, Integer>> adjList = Parser.parse(adjMatrix);
        int len = adjList.size();
        int[] D1 = new int[l];
        int[] D2 = new int[l];
        int[] P = new int[l];


        // Step 1: Initialize distances from src to all
        // other vertices as INFINITE
    //    int size = 0;
        for (int i = 0; i < len; ++i) {
            D1[i] = Integer.MAX_VALUE;
       //     D2[i] = Integer.MAX_VALUE;
            P[i] = -1;
        }
      //  D1[source] = 0;
        D1[source] = 0;


        // Step 2: Relax all edges |V| - 1 times. A simple
        // shortest path from src to any other vertex can
        // have at-most |V| - 1 edges

            for (int i = 0; i < l; ++i) {
              //  int ln = adjList.size();
                for (int k = 0; k < D1.length; k++) {
                    D2[k] = D1[k];
                }


                for (int j = 0; j < len; ++j) {


                    int weight;

                    for (int h = 0; h < len; h++) {


                        if (adjList.get(j).containsKey(h) && adjList.get(j) != null && D2[j] != Integer.MAX_VALUE) {
                            weight = adjList.get(j).get(h);
                            if (D1[h] > D2[j] + weight) {
                                D1[h] = D2[j] + weight;
                                P[h] = j;
                            }
                        }

                    }

                }
            }


        LinkedList<Integer> cycle = (LinkedList<Integer>) GraphUtil.getCycle(P);

            if (cycle.size() <= 1) {
                return new ArrayList<>();
            }

            return cycle;
    }
}
