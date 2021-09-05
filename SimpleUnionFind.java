// AM4674 CHARALAMPOS THEODORIDIS
//AM4646 PANAGIOTIS GEORGIADIS

import java.io.*;

public class SimpleUnionFind {

    private int[] Pi;     // parent array
    private int N;        // number of items
    private int count;

    SimpleUnionFind(int N) {
        this.N = N;
        this.count=N;
        Pi = new int[N + 1];
        for (int k = 0; k <= N; k++) {
            Pi[k] = k;
        }
    }

    int find(int v) {
        /* enter your code */
        int find=v;
        while(find !=Pi[find]){
            find=Pi[find];
        } 
        return find; // change appropriately 
    }

    void unite(int v, int u) {
        /* enter your code */
        if(find(v)!=find(u)){
            Pi[find(u)]=find(v);
            count--;
        }
    }
    
    int setCount() {
        /* enter your code */
        return count;
         // change appropriately 
    }
    
    void print() {
        System.out.println("Simple Set Union Data Structure");
        for (int k=1; k<=N; k++) {
            System.out.println("Pi["+k+"]="+Pi[k]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Test SimpleUnionFind");

        int N = 16; 
        SimpleUnionFind SUF = new SimpleUnionFind(N);
    
       for (int k=1; k<=3; k++){
            SUF.unite(k+1,k);
            SUF.unite(k+5,k+4);
            SUF.unite(k+9,k+8);
            SUF.unite(k+13,k+12);
        }
        SUF.unite(1,5);
        SUF.unite(9,13);
        SUF.print();
        SUF.unite(1,13);
        SUF.find(2);
        SUF.print();
        SUF.unite(5,7);
        SUF.unite(3,4);
        SUF.unite(3,7);
        System.out.println(SUF.setCount());
    }
}
