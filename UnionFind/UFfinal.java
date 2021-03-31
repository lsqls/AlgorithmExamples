package UnionFind;

import java.util.Arrays;
//经过优化的并查集的操作的的算法复杂度基本都是O(1)的
public class UFfinal {
    int[] parent;
    //基于size 优化，并添加路径压缩
    int[] size;
    int cnt;
    UFfinal(int n){
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
        
        if(parent[p]!=p)
            parent[p]=find(parent[p]);
        return parent[p];
        // 
        // else
        //     return p;
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
        UFfinal uf=new UFfinal(cnt);
        uf.union(1, 2);
        uf.union(3, 4);
        uf.union(5, 6);
        uf.union(7, 8);
        uf.union(2, 3);
        uf.union(6, 7);
        uf.union(2, 7);
        System.out.println(Arrays.toString(uf.parent));
        uf.find(8);
        System.out.println(Arrays.toString(uf.parent));
        uf.find(4);
        uf.find(6);
        System.out.println(Arrays.toString(uf.parent));

        // System.out.println(uf.isConnected(1, 5));
        
    }
}
