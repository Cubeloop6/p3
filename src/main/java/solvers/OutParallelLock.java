package solvers;

import cse332.exceptions.NotYetImplementedException;
import cse332.graph.GraphUtil;
import cse332.interfaces.BellmanFordSolver;
import main.Parser;
import paralleltasks.ArrayCopyTask;
import paralleltasks.RelaxOutTaskLock;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;

import static paralleltasks.RelaxOutTaskLock.parallel;


public class OutParallelLock implements BellmanFordSolver {

    public List<Integer> solve(int[][] adjMatrix, int source) {
        int l = adjMatrix.length;
        ArrayList<HashMap<Integer, Integer>> adjList = Parser.parse(adjMatrix);
        int len = adjList.size();
        int[] D1 = new int[l];
        int[] D2 = new int[l];
        int[] P = new int[l];

        RelaxOutTaskLock[] d1 = new RelaxOutTaskLock[l];
        RelaxOutTaskLock[] d2 = new RelaxOutTaskLock[l];
        int[] p = new int[l];


        // Step 1: Initialize distances from src to all
        // other vertices as INFINITE
        int size = 0;
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

            //   for (int k = 0; k < D1.length; k++) {
            //     D2[k] = D1[k];
            //}

            D2 = ArrayCopyTask.copy(D1);


            ;



            parallel(D2, D1, P, adjList);
                    /*
                for (int h = 0; h < len; h++) {

                    if (adjList.get(j).containsKey(h)) {
                        weight = adjList.get(j).get(h);
                        if (D1[h] > D2[j] + weight) {
                            D1[h] = D2[j] + weight;
                            P[h] = j;
                        }
                    }

                }

            }

*/
        }


        LinkedList<Integer> cycle = (LinkedList<Integer>) GraphUtil.getCycle(P);

        if (cycle.size() <= 1) {
            return new ArrayList<Integer>();
        }

        return cycle;

    }

}