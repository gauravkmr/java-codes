import java.util.Stack;


public class SortStack 
{
	public Stack<Integer> sort(Stack<Integer> s)
	{
		Stack<Integer> r = new Stack<Integer>();
		
		while(!s.isEmpty())
		{
			int tmp = s.pop();
			while(!r.isEmpty() && r.peek() > tmp)
			{
				s.push(r.pop());
			}
			r.push(tmp);
		}
		return r;
	}
	
	public static void main(String[] args) 
	{
		SortStack ss = new SortStack();
		Stack<Integer> s = new Stack<Integer>();
		
		s.push(2);
		s.push(3);
		s.push(1);
		s.push(6);
		
		Stack<Integer> r = ss.sort(s);
		System.out.println(r.pop());
		System.out.println(r.pop());
		System.out.println(r.pop());
		System.out.println(r.pop());
	}

}
