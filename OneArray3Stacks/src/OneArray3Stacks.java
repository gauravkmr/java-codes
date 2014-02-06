
public class OneArray3Stacks 
{
	int stacksize = 100;
	int[] buffer = new int[stacksize*3];
	int[] stackptr = {-1, -1, -1};
	
	public void push(int stacknum, int value)
	{
		if(stackptr[stacknum] >= stacksize - 1)                //check is the stack is full
			return;
		int index = stacksize*stacknum + stackptr[stacknum] + 1;
		buffer[index] = value;
		stackptr[stacknum]++;
	}
	
	public int pop(int stacknum)
	{
		int index = stacksize*stacknum + stackptr[stacknum];
		int d = buffer[index];
		buffer[index] = 0;
		stackptr[stacknum]--;
		return d;
		
	}
	
	public int peek(int stacknum)
	{
		int index = stacksize*stacknum + stackptr[stacknum];
		return buffer[index];
	}
	
	public boolean isEmpyty(int stacknum)
	{
		return stackptr[stacknum] == -1;
	}
	
	public boolean isFull(int stacknum)
	{
		return stackptr[stacknum] == stacksize - 1; 
	}
	
	public static void main(String[] args) 
	{
		OneArray3Stacks stacks = new OneArray3Stacks();
		stacks.push(0, 1);
		stacks.push(0, 2);
		stacks.push(0, 3);
		stacks.push(0, 4);
		stacks.push(1, 1);
		stacks.push(1, 2);
		stacks.push(1, 3);
		stacks.push(1, 4);
		stacks.push(2, 1);
		stacks.push(2, 2);
		stacks.push(2, 3);
		stacks.push(2, 4);
		
		int d = stacks.pop(0);
		System.out.println("popped value: " + d + ", " + "top: " + stacks.peek(0));
	}

}
