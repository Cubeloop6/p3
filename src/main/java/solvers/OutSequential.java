package solvers;

import cse332.exceptions.NotYetImplementedException;
import cse332.interfaces.BellmanFordSolver;
import main.Parser;
import cse332.graph.GraphUtil;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

public class OutSequential implements BellmanFordSolver {

    public List<Integer> solve(int[][] adjMatrix, int source) {

        int l = adjMatrix[0].length;
        LinkedList<Integer>[] adjList = Parser.parse(adjMatrix);
        int[] D1 = new int[l];
        int[] D2 = new int[l];
        int[] P = new int[l];
        //part 1

        for (int i = 0; i < l; i++) {
            D1[i] = Integer.MAX_VALUE;
            D2[i] = D1[i];
            P[i] = 0;
        }
        D1[source] = 0;
        D2[source] = D1[source];

        for (int i = 0; i < adjList.length; i++) {
            int col = adjList[0].size();
            int v = i;
            D2[v] = D1[v];
            for (int j = 0; j < col - 1; j++) {
                int w = adjList[v].get(j);
                int cost = w - v;
                if (D1[w] > D2[v] + cost) {
                    D1[w] = D2[v] + cost;
                    P[w] = v;
                }
            }
        }
        //part3


        LinkedList<Integer> cycle = (LinkedList<Integer>) GraphUtil.getCycle(P);
        return cycle;

    }
}
