import java.io.IOException;
import java.util.*;


public class graphadt
{
	vertex arrayofvertices[]=new vertex[50];
	int k=0;
	public void addvertex()
	{
		vertex v=new vertex(++k);
		arrayofvertices[k]=v;
		
	}
	
	public void addedge(int fromv,int tov)
	{
		vertex from=arrayofvertices[fromv];
		vertex to=arrayofvertices[tov];		
		from.list.addLast(to);
		
	}
	
	public boolean isedge(int ver1,int ver2)
	{
		vertex v1,v2;
		 v1=arrayofvertices[ver1];
		 v2=arrayofvertices[ver2];
		
		  ListIterator<vertex> itr = v1.list.listIterator();
		   while(itr.hasNext())
		    {
			   if(itr.next().no==ver2)
				   return true;			   
		    }
		  
		   itr = v2.list.listIterator();
		   while(itr.hasNext())
		    {
			   if(itr.next().no==ver1)
				   return true;			   
		    }
		return false;
	}
	
	public void printgraphstatus()
	{
		
		for(int i=1;i<=k;i++)
		{
			if(arrayofvertices[i]!=null)
			{
				System.out.print("\n vertex "+i+"----> ");
				 ListIterator<vertex> itr =arrayofvertices[i].list.listIterator();
				   while(itr.hasNext())
					  System.out.print("  "+itr.next().no);		   				  
			
			}
			
		}
		
	}
	
	public static void main(String args[])throws IOException
	{
		graphadt p=new graphadt();
		p.addvertex();
		p.addvertex();
		p.addedge(1, 2);
		p.addvertex();
		p.addvertex();
		p.addedge(2, 3);
		p.addedge(4, 2);
		p.addedge(1, 4);
		p.printgraphstatus();
		
		System.out.println("\n"+p.isedge(2, 1));
	}
}
