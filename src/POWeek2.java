import java.util.Arrays;
import java.util.Scanner;

public class POWeek2 {
/* For Java and Python;

Write a code to Convert sorted array to balanced binary search tree. */
	static Node root;
	
	Node sortedToBST(int arr[], int start, int end) {
		if(start > end) {
			return null;
		}
		
		int mid = (start + end) / 2;
		Node node = new Node(arr[mid]);
		
		node.left = sortedToBST(arr, start, mid - 1);
		
		node.right = sortedToBST(arr, mid + 1, end);
		
		return node;
	}
	
	void preOrder(Node node) {
		if(node == null) {
			return;
		}
		
		System.out.print(node.data + " ");
		preOrder(node.left);
		preOrder(node.right);
	}
	
	public static void main(String[] args) {
		POWeek2 tree = new POWeek2();
		Scanner in = new Scanner(System.in);
		int len = in.nextInt();
		int arr[] = new int[len];
		
		for(int i = 0; i < len; i++) {
			arr[i] = in.nextInt();
		}
		
		root = tree.sortedToBST(arr, 0, len - 1);
		tree.preOrder(root);
	}
	
}

class Node {
	
	int data;
	
	Node left, right;
	
	Node(int d){
		data = d;
		left = right = null;
	}
}