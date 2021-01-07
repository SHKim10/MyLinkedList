public class MyLinkedList{
 private int size;
 private Node start, end;
 public MyLinkedList(){
   size = 0;
 }

 public int size(){
  return size;
 }

 public boolean add(String value){
   Node a = new Node(value);
   if (size == 0){
     start = a;
     end = a;
     size++;
   } else {
     end.setNext(a);
     end = a;
   }
   size++;
   return true;
 }

 public boolean add(int index, String value);
 public String get(int index);
 public String set(int index, String value);
 public String toString();
 //Any helper method that returns a Node object MUST BE PRIVATE!
}
