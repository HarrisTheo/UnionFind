// AM4674 CHARALAMPOS THEODORIDIS
//AM4646 PANAGIOTIS GEORGIADIS
import java.io.*;

public class UnionFind {

    private int[] Pi;     // parent array
    private int[] size;   // size of each set 
    private int N;        // number of items
    private int count;

    UnionFind(int N) {
        this.N = N;
        this.count=N;
        Pi = new int[N + 1];
        size = new int[N + 1];
        for (int k = 0; k <= N; k++) {
            Pi[k] = k;
            size[k] = 1;
        }
    }

    int find(int v) {
        /* enter your code */
        int find=v;
        int temp=v;
        int parent=0;
        while(find !=Pi[find]){
            find=Pi[find];
        }
        while(temp!=find){
            parent=Pi[temp];
            Pi[temp]=find;
            temp=parent;
         } 
        return find;
        // change appropriately 
    }

    void unite(int v, int u) {
        /* enter your code */
        int findV=find(v);
        int findU=find(u);
        if(findV!=findU){
            if(size[findV]>=size[findU]){
            size[findU]+=size[findV];
            Pi[findV]=findU;
            count--;
           }
           else{
            size[findV]+=size[findU];
            Pi[findU]=findV;
            count--;
           }
        }
    }

    int setCount() {
        /* enter your code */
        return count;
         // change appropriately 
    }
    
    void print() {
        System.out.println("Set Union Data Structure");
        for (int k=1; k<=N; k++) {
            System.out.println("Pi["+k+"]="+Pi[k]);
            if (Pi[k]==k) System.out.println("size["+k+"]="+size[k]);
        }
    }

    public static void main(String[] args) {
        System.out.println("Test UnionFind");

        int N = 16; 
        UnionFind UF = new UnionFind(N);
        
        for (int k=1; k<=3; k++){
            UF.unite(k+1,k);
            UF.unite(k+5,k+4);
            UF.unite(k+9,k+8);
            UF.unite(k+13,k+12);
        }
        UF.unite(1,5);
        UF.unite(9,13);
        UF.print();
        UF.unite(1,13);
        UF.find(2);
        UF.print();
    }
}
