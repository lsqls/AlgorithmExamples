package UnionFind;
/*
并查集支持两个动作：
union(p,q)
find(p)
能够轻易回答
isConnected(p,q)
*/
public class UF1 {
    int[] ids;
    int cnt;
    UF1(int n){
        ids=new int[n];
        cnt=n;
        for(int i=0;i<cnt;i++){
            ids[i]=i;
        }

    }
    int find(int p){
        if(p>cnt||p<0)
            return -1;
        return ids[p];
    }
    void union(int p,int q){
        if(p>cnt||q>cnt)
            return;
        int pId=ids[p],qId=ids[q];
        if(pId==qId)
            return;
        for(int i=0;i<cnt;i++){
            if(ids[i]==qId)
                ids[i]=pId;
        }
    }
    boolean isConnected(int p,int q){
        return find(p)==find(p);
    }
    public static void main(String[] args) {
        int cnt=10;
        UF1 uf1=new UF1(cnt);
        for(int i=0;i<cnt;i++){
            uf1.union((int) (Math.random()*(cnt-1)), (int) (Math.random()*(cnt-1)));
        }
        System.out.println(uf1.isConnected(1, 5));
        
    }

}
