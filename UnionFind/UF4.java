package UnionFind;

import java.util.Arrays;

public class UF4 {
    int[] parent;
    //在UF2 的基础上增加rank数组记录【以该节点为根的子树高度 】 ,事实上与size优化性能上差不多
    int[] rank;
    int cnt;
    UF4(int n){
        parent=new int[n];
        rank=new int[n];
        cnt=n;
        for(int i=0;i<cnt;i++){
            parent[i]=i;
        }
        Arrays.fill(rank, 1);
    }
    int find(int p){
        if(p>cnt||p<0)
            return -1;
        while(parent[p]!=p)
            p=parent[p];
        return p;
    }

    void union(int p,int q){
        if(p>cnt||q>cnt)
            return;
        int pRoot=find(p),qRoot=find(q);
        if(pRoot==qRoot)
            return;
        if(rank[pRoot]<rank[qRoot]){
            parent[pRoot]=qRoot;
        }
        else if(rank[pRoot]>rank[qRoot]){
            parent[qRoot]=pRoot;
        }
        else{
            parent[qRoot]=pRoot;
            rank[pRoot]++;
        }
        
    }
    
    boolean isConnected(int p,int q){
        return find(p)==find(q);
    }
    public static void main(String[] args) {
        int cnt=10;
        UF4 uf4=new UF4(cnt);
        for(int i=0;i<cnt;i++){
            uf4.union((int) (Math.random()*(cnt-1)), (int) (Math.random()*(cnt-1)));
        }
        System.out.println(uf4.isConnected(1, 5));
        
    }
}
