List<Integer> Q=new LinkedList<Integer>();
    public void BFS(int s)
    {
        colorbfs=new char[k];
        distbfs=new int[k];
        predbfs=new int[k];
       
        for(int u=0;u<k;u++)
        {
            if(u==s) continue;
            colorbfs[u]='w';
            distbfs[u]=-1;
            predbfs[u]=-1;                       
        }   
        colorbfs[s]='g';
        distbfs[s]=0;
        predbfs[s]=-1;
       
        ((LinkedList<Integer>) Q).addLast(s);
       
        while(((LinkedList<Integer>) Q).peek()!=null)
        {
            int u= ((LinkedList<Integer>) Q).removeFirst();
             for(int v=0;v<k;v++)
            {
                if(arrayvertices[u][v]==0 )
                    continue;
                if(colorbfs[v]=='w')
                    colorbfs[v]='g';
               
               
                distbfs[v]=distbfs[u]+1;
                predbfs[v]=u;
                ((LinkedList<Integer>) Q).addLast(v);
            }
           
            colorbfs[u]='b';
        }
    }   
           
    public void BFS_tree(int s,int v)
    {
       
        if(s==v)
            System.out.print(" "+v);
        else
            if(predbfs[v]==-1)
                System.out.print(" no path exists ");
                else
                      BFS_tree(s,predbfs[v]);
                        System.out.print(" "+v);
               
    }
