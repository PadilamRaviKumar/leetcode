package lc138.cloneusingrandompointers;

class Solution {
	
    public Node copyRandomList(Node head) {
    	int[] ar=new int[20];
    	if(head==null) return null;
    	Node prev=null;
    	Node chead=head;
    	Node head1=head;
    	Node head2=null;
    	while(head.next!=null){    		
    		chead=new Node(head.val);
    		if(head2==null) head2=chead;
    		chead.random=head;
    		if(prev!=null)
    		prev.next=chead;
    		head=head.next;
    		prev=chead;
    	}
       chead.next=null;
       chead=tmp;
       while(chead!=null){
    	   chead.random.next=chead;
    	   chead=chead.next;
       }
       chead=tmp;
       while(chead!=null){
    	   if(chead.random.random!=null)
    	   chead.random=chead.random.random.next;
    	   else
    		   chead.random=null;
    	   chead=chead.next;
       }
    	return tmp;
    }
}