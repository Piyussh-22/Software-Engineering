public class LinkedList {
    private Node head;
    private static class Node{ //node class blueprint
        int data;
        Node next;
        Node(int data){
            this.data = data;
            this.next = null;
        }
    }


    public void add(int data){
        Node newNode = new Node(data); //node object
        if(head == null){ //check if list is empty
            head = newNode;
            return;
        }
        Node current = head;
        while(current.next != null){
            current = current.next;
        }
        current.next = newNode;
    }
    public void deleteFirst(){
        if(head==null){
            return;
        }
        head = head.next;
    }
    public void deleteViaValue(int value){
        while(head != null && head.data == value){
            head = head.next;
        }
        Node current = head;
        while(current != null && current.next != null){
            if(current.next.data == value){
                current.next = current.next.next;
            }else{
                current = current.next;
            }
        }
    }
    public void deleteAll(){
        head = null;
    }
    public void printList(){
        Node current = head;
        while(current != null){
            System.out.print(current.data + "->");
            current = current.next;
        }
        System.out.println("null");
    }
    public static void main(String[] args){
        LinkedList ll = new LinkedList();
        ll.add(10);
        ll.add(20);
        ll.add(40);
        ll.add(30);
        ll.add(40);
        ll.add(50);
        ll.deleteFirst();
        ll.deleteViaValue(40);
        ll.printList();
        ll.deleteAll();
        ll.printList();
    }
}
