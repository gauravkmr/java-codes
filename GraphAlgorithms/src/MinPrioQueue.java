import java.util.ArrayList;
import java.util.List;


public class MinPrioQueue 
{
	private List<Node> minheap;
	private int heapsize;
	public MinPrioQueue()
	{
		super();
		minheap = new ArrayList<Node>();
		heapsize = 0;
	}
	
	public int parent(int i)
	{
		return i/2 - 1;
	}
	
	public int left(int i)
	{
		return 2*i + 1;
	}
	
	public int right(int i)
	{
		return 2*i + 2;
	}
	
	public void buildMinHeap(List<Node> nodes)
	{
		heapsize = nodes.size();
		int n = heapsize;
		
		for (Node node : nodes) 
		{
			minheap.add(node);
		}
				
		for (int i = (n/2)-1; i >= 0; i--) 
		{
			minHeapify(i);
		}
		
//		for (Node node : minheap) 
//		{
//			System.out.println(node.getKey());
//		}
	}
		
	public void minHeapify(int i)
	{
		int l = left(i);
		int r = right(i);
		int smallest;
		
		if(l < heapsize && minheap.get(l).getPrim_key() < minheap.get(i).getPrim_key())
			smallest = l;
		else
			smallest = i;
		
		if(r < heapsize)
			if(minheap.get(r).getPrim_key() < minheap.get(smallest).getPrim_key())
				smallest = r;
		
		if(smallest != i)
		{
			System.out.println("smallest: " + smallest + ", i: " + i);
			if(i > smallest)
			{
				Node t = minheap.remove(i);
				minheap.add(i, minheap.get(smallest));
				minheap.remove(smallest);
				minheap.add(smallest, t);
			}
			else
			{
				Node t = minheap.remove(smallest);
				minheap.add(smallest, minheap.get(i));
				minheap.remove(i);
				minheap.add(i, t);
			}
			minHeapify(smallest);
			
		}
	}

	public Node heapMinimum()
	{
		return minheap.get(0);
	}

	public Node heapExtractMin()
	{
		if(heapsize < 1)
			System.err.println("heap underflow");
		
		Node min = minheap.remove(0);
		if(heapsize > 1)
			minheap.add(0, minheap.remove(heapsize-2));
		
		heapsize--;
		
//		int n = heapsize;
		
//		System.out.println("sys");	
//		for (int i = 0; i < heapsize; i++) 
//		{
//			System.out.println(minheap.get(i).getKey());
//		}
//		System.out.println("n" + n);
//		for (int i = (n/2)-1; i >= 0; i--) 
//		{
//			minHeapify(i);
//			System.out.println("check");
//		}
//		minHeapify(0);
		return min;
	}
	
	public void heapify()
	{
		int n = heapsize;
		for (int i = (n/2) - 1; i >= 0; i--) 
		{
			minHeapify(i);
		}
//		System.out.println("sys");	
//		for (int i = 0; i < heapsize; i++) 
//		{
//			System.out.println(minheap.get(i).getKey());
//		}
	}

	public List<Node> getMinheap() 
	{
		return minheap;
	}

	public void setMinheap(List<Node> minheap) 
	{
		this.minheap = minheap;
	}

	public int getHeapsize() 
	{
		return heapsize;
	}

	public void setHeapsize(int heapsize) 
	{
		this.heapsize = heapsize;
	}

}
