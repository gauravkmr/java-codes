import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;



public class Tree 
{
	private Node root;
	private int id=1;
	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	Tree(Node node) 
	{
		this.root = node;
	}

	public Node getRoot() {
		return root;
	}

	public void setRoot(Node root) {
		this.root = root;
	}
	
	public void insert(Node root,int page) 
	{
		Node found = searchforinsert(root,page);
				
		if(found.getLeft_key() == 0)
			found.setLeft_key(page);
		else if(found.getMiddle_key() == 0)
			found.setMiddle_key(page);
		else if(found.getRight_key()==0)
			found.setRight_key(page);
		else
		{
			Node n = new Node(id++);
			n.setLeft_key(page);
			if(page < found.getMiddle_key())
			{
				found.setLeft(n);
			}
			else if(page >= found.getMiddle_key() && page < found.getRight_key())
			{
				found.setMiddle(n);
			}
			else
			{
				found.setRight(n);
			}
		}
	}
	
	public Node searchforinsert(Node root,int page) 
	{
		Node temp = root;
		
		while(temp != null)
		{
			if(page < temp.getMiddle_key())
			{
				if(temp.getLeft() == null)
					return temp;
				temp = temp.getLeft();
			}
			else if(page >= temp.getMiddle_key() && page < temp.getRight_key())
			{
				if(temp.getMiddle() == null)
					return temp;
				temp = temp.getMiddle();
			}
			else
			{
				if(temp.getRight() == null)
					return temp;
				temp = temp.getRight();
			}
		}
		
		return null;
	}

	public ArrayList<Node> getPath(int page) 
	{
		Node temp = root;
		ArrayList<Node> list = new ArrayList<Node>();
		
		while(temp != null)
		{
			list.add(temp);
			if(page < temp.getMiddle_key())
			{
				if(temp.getLeft() == null)
					return list;
				
				temp = temp.getLeft();
			}
			else if(page >= temp.getMiddle_key() && page < temp.getRight_key())
			{
				if(temp.getMiddle() == null)
					return list;
//				list.add(temp);
				temp = temp.getMiddle();
			}
			else
			{
				if(temp.getRight() == null)
					return list;
//				list.add(temp);
				temp = temp.getRight();
			}
			//System.out.println(list.get(1).getID());
		}
						
		return null;
	}

	public void display(Node node)
	{
		
		if(node!= null)
		{
			System.out.println(node.getLeft_key() + " " + node.getMiddle_key()  + " " + node.getRight_key());
			display(node.getLeft());
			display(node.getMiddle());
			display(node.getRight());
		}
	}
	
	public Node clone(Tree tree,HashMap<Integer, Integer> map)
	{
		Node temp = tree.getRoot();
		if(temp!=null)
		{
			Node cloned = new Node(temp.getID(),temp.getLeft_key(),temp.getMiddle_key(),temp.getRight_key());
			
			cloned.setLeft(temp.getLeft());
			cloned.setMiddle(temp.getMiddle());
			cloned.setRight(temp.getRight());
			updatemap(cloned.getLeft(), map);
			updatemap(cloned.getMiddle(), map);
			updatemap(cloned.getRight(), map);
			
			return cloned;
		}
		else
			return null;
	}

	public Node directorylookup(Node root,int page)
	{
		Node temp = searchforinsert(root,page);
		if(temp.getLeft_key()==page || temp.getMiddle_key()==page || temp.getRight_key()==page)
		{
			return temp;
			
		}
		else
			return null;
	}
	public void insert(int[] pages)
	{
		for (int i = 0; i < pages.length; i++) 
		{
			insert(this.getRoot(),pages[i]);
		}
	}
	
	public void updatemap(Node node,Tree tree,HashMap<Integer, Integer> map)
	{
		if(node!=null)
		{
			if(!map.keySet().contains(node.getID()))
			{
				map.put(node.getID(), 1);
			}
			else
			{
				map.put(node.getID(),map.get(node.getID())+1);
			}
			updatemap(node.getLeft(), tree, map);
			updatemap(node.getMiddle(), tree, map);
			updatemap(node.getRight(), tree, map);
		}
	}
	public void updatemap(Node node,HashMap<Integer, Integer> map)
	{
		map.put(node.getID(), map.get(node.getID())+1);
	}

	public void demoCOW(int page, HashMap<Integer, Integer> map) 
	{
		ArrayList<Node> list = getPath(page);
		for (Node node : list) {
			System.out.print(node.getID() + " ");
		}
		
		ArrayList<Node> newlist = new ArrayList<>();
		HashMap<Integer, Integer> COWmap = new HashMap<>();
		
		Iterator<Integer> iter = map.keySet().iterator();
		while(iter.hasNext())
		{
			int temp = (int) iter.next();
			COWmap.put(temp, map.get(temp));
		}
		
		for(Node node: list)
		{
			Node temp = new Node(node.getID(), node.getLeft_key(), node.getMiddle_key(), node.getRight_key());
			temp.setLeft(node.getLeft());
			temp.setRight(node.getRight());
			temp.setMiddle(node.getMiddle());
			newlist.add(temp);
			
		}
		
		for (int i = 1; i < newlist.size(); i++) 
		{
			int key = newlist.get(i).getID();
			Node temp = list.get(i-1);
			if(temp.getLeft().getID() == key)
			{
				newlist.get(i-1).setLeft(newlist.get(i));
				map.put(temp.getRight().getID(), map.get(temp.getRight().getID())+1);
				map.put(temp.getMiddle().getID(), map.get(temp.getMiddle().getID())+1);
			}
			else if(temp.getMiddle().getID() == key)
			{
				newlist.get(i-1).setMiddle(newlist.get(i));
				map.put(temp.getLeft().getID(), map.get(temp.getLeft().getID())+1);
				map.put(temp.getRight().getID(), map.get(temp.getRight().getID())+1);
			}
			else if(temp.getRight().getID() == key)
			{
				newlist.get(i-1).setRight(newlist.get(i));
				map.put(temp.getLeft().getID(), map.get(temp.getLeft().getID())+1);
				map.put(temp.getMiddle().getID(), map.get(temp.getMiddle().getID())+1);
			}
		}
		System.out.println("aaaaaaaaaaaaaaaa");
		display(newlist.get(0));
		
		insert(newlist.get(0),12);
		System.out.println("bbbbbbbbbbbbbbbbbbb");
		display(newlist.get(0));
		
		System.out.println("old");
		System.out.println(map);
		System.out.println("new");
		System.out.println(COWmap);
		
		System.out.println("now syncing the trees\n\n\n");
		sync(newlist.get(0),map,COWmap);
		newlist.set(0, null);
		display(newlist.get(0));
	}

	public void sync(Node root, HashMap<Integer, Integer> firstmap,HashMap<Integer, Integer> secondmap)//leftover is firstmap  
	{
		Iterator<Integer> iter = firstmap.keySet().iterator();
		while(iter.hasNext())
		{
			int item= iter.next();
			if(firstmap.get(item) != secondmap.get(item))
			{
				firstmap.put(item, firstmap.get(item)-secondmap.get(item));
			}
		}
		System.out.println(firstmap);
		root = null;
		
	}
	
}