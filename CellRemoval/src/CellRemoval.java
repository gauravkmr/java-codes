import java.util.HashSet;
import java.util.Set;

class cNode
{
	public int cname;
	cNode nextcNode;
	
//default constructor
	cNode()
	{
		cname = -1;
		nextcNode = null;
	}
	
//constructor
	cNode(int x)
	{
		cname = x;
		nextcNode = null;
	}

}

class pNode extends cNode
{
	public int pname;
	public pNode nextpNode;
	public cNode child;
	
//default constructor
	pNode()
	{
		pname = -52;
		nextpNode = null;
		child = null;
	}
	
//constructor
	pNode(int i)
	{
		pname = i;
		nextpNode = null;
		child = null;
	}
	
//adding elements to the list of nodes present
	public void parentList(pNode parentListhead, int i)
	{
		if(parentListhead.pname < 0 )
		{
			parentListhead.pname = i;
		}
		else
		{
			pNode tail = parentListhead;
			
			while(tail.nextpNode != null)
				tail = tail.nextpNode;
			
			pNode temp = new pNode(i);
			tail.nextpNode = temp;
		}
		
	}

//add child to parent	
	public void addChildToItsParent(pNode parentListHead, int parent, int child)
	{
		pNode temp = parentListHead;
		
		while(temp.pname != parent)
		{
			temp = temp.nextpNode;
		}
		
		cNode childnode = new cNode(child);
		
		if(temp.nextcNode == null)
			temp.nextcNode = childnode;
		else
		{
			cNode clist = temp.nextcNode;
			
			while(clist.nextcNode != null)
			{
				clist = clist.nextcNode;
			}
			
			clist.nextcNode = childnode;
		}
		
	}
	
}


public class CellRemoval extends pNode
{
	public int root;
	public int leafnodecount;
	Set<Integer> h = new HashSet<Integer>();
	
//default constructor
	CellRemoval(){}
	
	public void checkChildNodes(cNode chlds)
	{
		
	}
	
	
//delete a cell
	public void delete(pNode root, int del)
	{
		pNode temp = root;
		
		while(temp.pname != del)
		{
			temp = temp.nextpNode;
		}
		
/*		if(h.contains(del))
		{
			h.remove(del);
			leafnodecount--;
		}
*/
		if(temp.nextcNode == null)
		{
			leafnodecount--;
			return;
		}

		else
		{
			cNode chlds = temp.nextcNode;
//			checkChildNodes(chlds);
			while(chlds != null)
			{
				delete(root, chlds.cname);
				chlds = chlds.nextcNode;
			}
		
		}
			
	}
	
	
//create and display graph	
	public int cellsLeft(int[] parent, int deletedCell)
	{
		pNode parentListHead = new pNode();
		
//create single-linked list of parent nodes
		for (int i = 0; i < parent.length; i++) 
		{
			parentListHead.parentList(parentListHead, i);
		}


//adding child to nodes
		for (int i = 0; i < parent.length; i++) 
		{
			if(parent[i] == -1)
				root = i;
			else
				parentListHead.addChildToItsParent(parentListHead, parent[i], i);
		}
		
		pNode root = parentListHead;

//display graph
		while(parentListHead != null)
		{
			System.out.print(parentListHead.pname + "--> ");

			cNode temp = parentListHead.nextcNode;
			
			if(temp != null)
			{
				System.out.print(temp.cname);
				
				while(temp.nextcNode != null)
				{
					temp = temp.nextcNode;
					System.out.print("-->" + temp.cname);
				}
				
			}
			else
			{
				h.add(parentListHead.pname);
				leafnodecount++;
			}
						
			parentListHead = parentListHead.nextpNode;
			System.out.println();
		}
		
//deleting a cell
		delete(root, deletedCell);
		
		
		return leafnodecount;
	}
	
	public static void main(String[] args) 
	{
		
		CellRemoval cell = new CellRemoval();
//		int[] parent = {-1,0,0,1,1};
//		int deletedCell = 2;		

//		int[] parent = {-1,0,0,2,2,4,4,6,6};
//		int deletedCell = 4;
		
		int[] parent = {26,2,32,36,40,19,43,24,30,13,21,14,24,21,19,4,30,10,44,12,7,32,17,43,
				 35,18,7,36,10,16,5,38,35,4,13,-1,16,26,1,12,2,5,18,40,1,17,38,44,14};
		int deletedCell = 24;
		
		int n = cell.cellsLeft(parent, deletedCell);
		
		System.out.println(n);
	}

}
