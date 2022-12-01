package main;

import cse332.exceptions.NotYetImplementedException;


import java.util.ArrayList;
import java.util.HashMap;
import java.util.LinkedList;

public class Parser {

    /**
     * Parse an adjacency matrix into an adjacency list.
     * @param adjMatrix Adjacency matrix
     * @return Adjacency list
     */
    public static ArrayList<HashMap<Integer, Integer>> parse(int[][] adjMatrix) {
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
        int cost = 0;
        int l = adjMatrix[0].length;
        ArrayList<HashMap<Integer, Integer>> al = new ArrayList<HashMap<Integer, Integer>>(l);
        for (int i=0; i<l; i++) {
            al.add(i, new HashMap<Integer, Integer>());
        }
        for (int i = 0; i < l; i++) {
            for (int j = 0; j < adjMatrix.length; j++) {
                if (adjMatrix[i][j] != Integer.MAX_VALUE) {//!= 0 || adjMatrix[i][j] != Integer.MAX_VALUE) {//Integer.MAX_VALUE) {
                    al.get(i).put(j, adjMatrix[i][j]);
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
    public static ArrayList<HashMap<Integer, Integer>> parseInverse(int[][] adjMatrix) {
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
/*
        int l = adjMatrix.length;
        LinkedList<Integer>[] al = (LinkedList<Integer>[]) new LinkedList[l];
        for (int i=0; i<l; i++) {
            al[i]=new LinkedList<Integer>();
        }
        for (int i = 0; i < adjMatrix[0].length; i++) {
            for (int j = 0; j < l; j++) {
                if (adjMatrix[i][j] == 1) {
                    al[i].add(j);
                }
            }
        }
*/
        int cost = 0;
        int l = adjMatrix[0].length;
        ArrayList<HashMap<Integer, Integer>> al = new ArrayList<HashMap<Integer, Integer>>(l);
        for (int i=0; i<l; i++) {
            al.add(i, new HashMap<Integer, Integer>());
        }
        for (int i = 0; i < adjMatrix.length; i++) {
            for (int j = 0; j < l; j++) {
                if (adjMatrix[i][j] != Integer.MAX_VALUE) {//!= 0 || adjMatrix[i][j] != Integer.MAX_VALUE) {//Integer.MAX_VALUE) {
                    al.get(j).put(i, -adjMatrix[i][j]);
                }
            }
        }



        return al;







    }
}


