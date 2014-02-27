import java.io.IOException;
import java.util.*;


public class graphadtmatrix
{
	int arrayvertices[][];
	int k=0;
	public void creatematrix(int i)
	{
		k=i;
		arrayvertices=new int[i][i];
		
		
	}
	public void addvertex()
	{
		int i=k;
		int arr[][]=new int[++k][++k];
		for(int j=0;j<i;j++)
		{
			for(int l=0;l<i;l++)
				{
				arr[j][l]=arrayvertices[j][l];
				System.out.println(arr[j][l]);
				}
		}
		arrayvertices=arr;
		arr=null;
		
	}
	
	public void addedge(int fromv,int tov)
	{
		arrayvertices[--fromv][--tov]=1;
	}
	
	public boolean isedge(int ver1,int ver2)
	{
		if(arrayvertices[--ver1][--ver2]==1 || arrayvertices[ver2][ver1]==1)
			return true;
		return false;
	}
	
		public void printgraphstatus()
	{
			System.out.print("\t");
		for(int j=0;j<k;j++)
			System.out.print(j+1+" ");
		System.out.println();
		
		for(int j=0;j<k;j++)
		{
			System.out.print(j+1+"\t");
			for(int l=0;l<k;l++)
				System.out.print(arrayvertices[j][l]+" ");
			System.out.println();
		}
		
		
	}
	
	public static void main(String args[])throws IOException
	{
		graphadtmatrix p=new graphadtmatrix();
		p.creatematrix(5);
		p.addedge(1, 2);
		p.printgraphstatus();
	//	p.addvertex();
	//	p.addvertex();
	//	p.addvertex();
		p.addvertex();
		p.addedge(2, 3);
		p.addedge(4, 2);
		p.addedge(1, 4);
		p.printgraphstatus();
		p.deletevertex(4);
		p.printgraphstatus();
		
		System.out.println("\n"+p.isedge(3, 1));
		
	}
}

