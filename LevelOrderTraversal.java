package Lab10;
import java.util.LinkedList;
import java.util.Queue;

public class LevelOrderTraversal {
	
	//creates the tree class to reference through program
	static class Tree {
		int data;
		//left and right fields of current node are created
		Tree left, right;
		Tree(int data){
			//will set the current node equal to input value
			this.data = data;
			//initializes nodes on the next depth
			left = null;
			right = null;
		}
	}
	
	public static void traverse(Tree root, Queue<Tree> list) {
		//if the current node does not hold a value, then the method exits
		if(list.peek() == null) {
			return;
		}
		Tree current = list.poll();
		//prints the current node if it contains a value
		System.out.print(current.data+" ");
		//will check the left and right side and add the root of the subtree to the queue if not null
		//since it adds all nodes on the current depth to the queue, it traverses in level order.
		if (current.left != null) {
			list.add(current.left);
		}
		if (current.right != null) {
			list.add(current.right);
		}
		//data recursively goes through subtree of current node next on queue
		traverse(list.peek(), list);
	}
	
	public static void main(String [] args) {
		//queue is created to store node on each depth level
		Queue<Tree> lot = new LinkedList<>();
		//creating the tree object
		Tree root = new Tree(4);
		root.left = new Tree(2);
		root.right = new Tree(6);
		root.left.left = new Tree(1);
		root.left.right = new Tree(3);
		root.right.left = new Tree(5);
		root.right.right = new Tree(7);
		//if the tree is empty, containing only a null root, then it prints out a message
		if(root != null) {
			//will enqueue root before traverse method since it isn't left or right of anything
			lot.add(root);
			traverse(root, lot);
		}else {
			System.out.println("*Tree is empty*");
		}
	}
	//Test case 1: when attempting to traverse a null tree, the program should output a warning message
	
}
