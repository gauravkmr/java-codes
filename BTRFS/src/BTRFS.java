import java.util.HashMap;


public class BTRFS 
{
	public static void main(String[] args) 
	{
		Tree tree = new Tree(new Node(0));
		int values[] = {1,4,10,1,2,5,6,7,10,11,8};
		tree.insert(values);
		tree.display(tree.getRoot());
		HashMap<Integer, Integer> extentmap = new HashMap<>();
		tree.updatemap(tree.getRoot(), tree, extentmap);
		System.out.println(extentmap);
		
		//Tree cloned = new Tree(tree.clone(tree,extentmap));
		//cloned.updatemap(cloned.getRoot(), cloned, extentmap);
		//System.out.println("cloned now");
		//cloned.display(cloned.getRoot());
		//System.out.println(extentmap);
		
		tree.demoCOW(11, extentmap);

	}

}
