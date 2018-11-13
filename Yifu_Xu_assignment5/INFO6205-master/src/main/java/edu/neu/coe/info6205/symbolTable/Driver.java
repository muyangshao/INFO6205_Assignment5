package edu.neu.coe.info6205.symbolTable;

import java.util.ArrayList;
import java.util.Random;

public class Driver {

    public static void balace(ArrayList<Comparable> A, int l, int r )
    {
        if(l>r) return;
        int mid = (l+r) >> 1;
        A.add(mid);
        if (l == r) return;
        balace(A,l,mid-1);
        balace(A,mid+1,r);
    }


    public static double log(double value, double base) {
        return Math.log(value) / Math.log(base);
    }

    public static  void showsingle(int N, int M, int X){
         ArrayList<Comparable> a = new ArrayList();
               balace(a,0,N);
                BSTSimple bst = new BSTSimple();
                //bst.put(101,1);

               for (int i = 0; i< N;i++ )
                {
                    bst.put(a.get(i),1);
                }
               System.out.println("The original depth = "+bst.btdep(bst.root));

                for (int i = 0; i< X;i++ )
                {
                    Random rand1 =new Random();
                    int s;
                    s = rand1.nextInt(M);
                    if(bst.get(s)!=null){  bst.delete(s); }
                        else {  bst.put(s,1); }
                    System.out.println("X = "+ i + "  depth = "+ bst.btdep(bst.root));
                }
        System.out.println("The last depth =" + bst.btdep(bst.root) + "   lgN = "+ log(N,2)+  "  1/2^N = "+Math.sqrt(N) );
     }

            public static  void calcgeneral(int N, int M, int X){
             ArrayList<Comparable> a = new ArrayList();
                   balace(a,0,N);
                    BSTSimple bst = new BSTSimple();
                    //bst.put(101,1);

                   for (int i = 0; i< N;i++ )
                    {
                        bst.put(a.get(i),1);
                    }
                   System.out.println("The original depth = "+bst.btdep(bst.root));

                    for (int i = 0; i< X;i++ )
                    {
                        Random rand1 =new Random();
                        int s;
                        s = rand1.nextInt(M);
                        if(bst.get(s)!=null){  bst.delete(s); }
                            else {  bst.put(s,1); }
                        //System.out.println("X = "+ i + "  depth = "+ bst.btdep(bst.root));
                    }
                System.out.println("N = "+ N +"  The last depth =" + bst.btdep(bst.root) + "   lgN = "+ log(N,2)+  "  1/2^N = "+Math.sqrt(N) );
         }


    public static void main(String[] args){
           int N = 500;
           int M = 1000;
           int X = 1000;
           System.out.println("=======================================================================");
           System.out.println("Depth of same keys for ascending X:");
           showsingle(N,M,X);
           System.out.println("=======================================================================");
           System.out.println("Test of different original keys for X times insert and delete:");
           int[] n = {100,200,300,400,500,600,700,800,900};
           for(int i=0;i<n.length;i++)
           {
               calcgeneral(n[i],2*n[i],X);
           }

    }

}
