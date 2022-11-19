package main;

import cse332.exceptions.NotYetImplementedException;

import java.util.*;
import java.util.LinkedList;
import java.util.Arrays;

public class Parser {

    /**
     * Parse an adjacency matrix into an adjacency list.
     * @param adjMatrix Adjacency matrix
     * @return Adjacency list
     */
    public static LinkedList<Integer>[] parse(int[][] adjMatrix) {
    //    int l = adjMatrix[0].length;
      //  ArrayList<ArrayList<Integer>> al = new ArrayList<>(l);

       // for (int i=0; i < l; i++) {
         //   al.add(new ArrayList<>());
       // }

      //  int i, j;
       // for (i = 0; i < adjMatrix[0].length; i++) {
         //   for (j = 0; j < adjMatrix.length; j++) {
           //     if (adjMatrix[i][j] == 1) {
             //       al.get(i).add(j);
               // }
            //}
        //}

        //return al;

        int l = adjMatrix[0].length;
        LinkedList<Integer>[] al = new LinkedList[l];
        for (int i=0; i<l; i++) {
            al[i]=new LinkedList<Integer>();
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[i][j] == 1) {
                    al[i].add(j);
                }
            }
        }

        return al;
    }



    /**
     * Parse an adjacency matrix into an adjacency list with incoming edges instead of outgoing edges.
     * @param adjMatrix Adjacency matrix
     * @return Adjacency list with incoming edges
     */
    public static Object parseInverse(int[][] adjMatrix) {
  //      int len = adjMatrix[0].length;
    //    LinkedList[] link = new LinkedList[len];

      //  int i, j;
        //for (i = 0; i < adjMatrix[0].length; i++) {
          //  for (j = 0; j < adjMatrix.length; j++) {
            //    if (adjMatrix[i][j] == 1) {
              //      link[j].add(i);
               // }
           // }
        //}


//        return link;

        int l = adjMatrix.length;
        LinkedList<Integer>[] al = (LinkedList<Integer>[]) new LinkedList[l];
        for (int i = 0; i < adjMatrix[0].length; i++) {
            for (int j = 0; j < l; j++) {
                if (adjMatrix[i][j] == 1) {
                    al[j].add(i);
                }
            }
        }

        return al;







    }
}


