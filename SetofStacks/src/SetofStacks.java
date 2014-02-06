import java.util.*;

class Stack
{
	int capacity = 10;
	int top = -1;
	int[] buffer = new int[capacity];
	
	public Stack(){}
	
	public void push(int d)
	{
		top++;
		buffer[top] = d;
	}
	
	public int pop()
	{
		int d = buffer[top];
		buffer[top] = 0;
		top--;
		return d;
	}
}

public class SetofStacks
{
	ArrayList<Stack> stacks = new ArrayList<Stack>();
	
	public boolean push(int d)
	{
		if(stacks.size() > 0)
		{
			Stack s = getLastStack();
			if(s.top < s.capacity-1)
			{
				s.push(d);
				stacks.add(s);
				return true;
			}
			stacks.add(s);
		}
		Stack st = new Stack();
		st.push(d);
		stacks.add(st);
		return true;
	}
	
	public int pop()
	{
		if(stacks.size() > 0)
		{
			Stack s = getLastStack();
			int d = s.pop();
			if(s.top > -1)
				stacks.add(s);
			return d;
		}
		else
			return -1;
		
		
		
	}
	
	public Stack getLastStack()
	{
		return stacks.remove(stacks.size()-1);
	}
	
	public static void main(String[] args) 
	{
		SetofStacks set = new SetofStacks();
		
		set.push(1);
		set.push(2);
		set.push(3);
		set.push(4);
		set.push(5);
		set.push(6);
		set.push(7);
		set.push(8);
		set.push(9);
		set.push(10);
		set.push(11);
		set.push(12);
		set.push(13);
		set.push(14);
		set.push(15);
		int val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);
		val = set.pop();
		System.out.println(val==-1?"satck is empty":"popped value is: "+val);

	}

}
