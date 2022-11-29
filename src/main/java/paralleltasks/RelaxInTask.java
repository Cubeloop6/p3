package paralleltasks;

import cse332.exceptions.NotYetImplementedException;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.RecursiveAction;

public class RelaxInTask extends RecursiveAction {

    public static final ForkJoinPool pool = new ForkJoinPool();
    public static final int CUTOFF = 1;

    private int[] src;
    private int[] dst;
    private int[] p;
    private int lo, hi;
    private ArrayList<HashMap<Integer, Integer>> adjList;

    public RelaxInTask(int[] src, int[] dst, int[] p, int lo, int hi, ArrayList<HashMap<Integer, Integer>> adjList) {

        this.src = src;
        this.dst = dst;
        this.lo = lo;
        this.hi = hi;
        this.adjList = adjList;
        this.p = p;
    }

    protected void compute() {
        if(hi - lo <= CUTOFF) {
            sequential(src, dst,  p, lo, adjList);
            return;

            //         return new int[0];
        }

        int mid = lo + (hi - lo)/2;
        RelaxInTask left = new RelaxInTask(src, dst,  p, lo, mid, adjList);
        RelaxInTask right = new RelaxInTask(src, dst, p, mid, hi, adjList);
        left.fork();
        right.compute();
        left.join();

        return;
    }



    //  return new int[0];


    public static void sequential(int[] src, int[] dst, int[] p, int lo, ArrayList<HashMap<Integer, Integer>> adjList) {


        //   for (int j = lo; j < hi; j++) {


        int weight = 0;

        for (int h = 0; h < adjList.size(); h++) {


            if (adjList.get(lo).containsKey(h) && adjList.get(h) != null && src[h] != Integer.MAX_VALUE) {
                weight = adjList.get(lo).get(h);
                if (dst[lo] > src[h] - weight) {
                    dst[lo] = src[h] - weight;
                    p[lo] = h;
                }
            }
/*
                    for (int h = 0; h < len; h++) {


                        if (adjList.get(j).containsKey(h) && adjList.get(j) != null && D2[j] != Integer.MAX_VALUE) {
                            weight = adjList.get(j).get(h);
                            if (D1[h] > D2[j] + weight) {
                                D1[h] = D2[j] + weight;
                                P[h] = j;
                            }
                        }

                    }
*/

            //
            //     }
        }


        /*

            int weight = 0;

        for (int h = lo; h < hi; h++) {


            if (adjList.get(lo).containsKey(h) && adjList.get(lo) != null && src[lo] != Integer.MAX_VALUE) {
                weight = adjList.get(lo).get(h);
                if (dst[h] > src[lo] + weight) {
                    dst[h] = src[lo] + weight;
                    p[h] = lo;
                }
            }

        }


        p[hi] = lo;

         */
    }

    public static void parallel(int[] src, int[] dst, int[] p, ArrayList<HashMap<Integer, Integer>> adjList) {
        pool.invoke(new RelaxInTask(src, dst, p, 0, src.length, adjList));


    }

}
