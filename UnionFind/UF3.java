package UnionFind;

import java.util.Arrays;


//
public class UF3 {
    int[] parent;
    //在UF2 的基础上增加size数组记录【以该节点为根的节点个数 】 ,该版本的并查集基本能够使用
    int[] size;
    int cnt;
    UF3(int n){
        parent=new int[n];
        size=new int[n];
        cnt=n;
        for(int i=0;i<cnt;i++){
            parent[i]=i;
        }
        Arrays.fill(size, 1);
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
        if(size[pRoot]<size[qRoot]){
            parent[pRoot]=qRoot;
            size[qRoot]+=size[pRoot];
        }
        else{
            parent[qRoot]=pRoot;
            size[pRoot]+=size[qRoot];
        }
        
    }
    
    boolean isConnected(int p,int q){
        return find(p)==find(q);
    }
    public static void main(String[] args) {
        int cnt=10;
        UF3 uf3=new UF3(cnt);
        for(int i=0;i<cnt;i++){
            uf3.union((int) (Math.random()*(cnt-1)), (int) (Math.random()*(cnt-1)));
        }
        System.out.println(uf3.isConnected(1, 5));
        
    }
}
