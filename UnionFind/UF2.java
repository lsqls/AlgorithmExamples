package UnionFind;

public class UF2 {
    int[] parent;

    int cnt;
    UF2(int n){
        parent=new int[n];
        cnt=n;
        for(int i=0;i<cnt;i++){
            parent[i]=i;
        }
    }
    int find(int p){
        if(p>cnt||p<0)
            return -1;
        while(parent[p]!=p)
            p=parent[p];
        return p;
    }

    //最朴素的方法
    void union(int p,int q){
        if(p>cnt||q>cnt)
            return;
        int pParent=find(p),qParent=find(q);
        if(pParent==qParent)
            return;
        parent[pParent]=qParent;
    }
    
    boolean isConnected(int p,int q){
        return find(p)==find(q);
    }


}
  