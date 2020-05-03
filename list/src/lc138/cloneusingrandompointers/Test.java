package lc138.cloneusingrandompointers;

import java.util.HashMap;

public class Test {

	public static Node generateInputList(Integer[][] ar) {
		HashMap<Integer, Node> map = new HashMap<Integer, Node>();
		Node sentinel = null;
		Node head = null;
		Node prev = null;
		for (Integer tmp[] : ar) {
			head = new Node(tmp[0]);
			map.put(tmp[0], head);
			if (sentinel == null) {
				sentinel = head;
				prev = head;
			}
			if (prev != null)
				prev.next = head;
			prev = head;

			head = head.next;
		}
		prev.next = null;
		head = sentinel;
		for (Integer tmp[] : ar) {
			head.random = map.get(tmp[1]);
			head = head.next;
		}
		return sentinel;
	}

	public static void main(String[] args) {
		Integer[][] input={{7,null},{13,0},{11,4},{10,2},{1,0}};
		Node node=new Solution().copyRandomList(Test.generateInputList(input));
		Test.printSolution(node);
	}

	private static void printSolution(Node node) {
		Node head=node;
		while(head.next!=null){
			
			System.out.print("["+head.val+","+head.random+"]");
			System.out.print(" ");
			
		}
		
	}
}
