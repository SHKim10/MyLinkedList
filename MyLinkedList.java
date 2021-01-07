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

  public void add(int index, String value){
    if (index > size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    if (index == size){
      add(value);
    } else if (index == 0){
      Node insert = new Node(value);
      insert.setNext(start);
      start.setPrev(insert);
      start = insert;
      size++;
    } else {
      Node insert = new Node(value);
      Node current = getNode(index);
      Node prev = current.getPrev();
      prev.setNext(insert);
      insert.setPrev(prev);
      insert.setNext(current);
      current.setPrev(insert);
      size++;
    }
  }

  public String get(int index){
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    return getNode(index).getData();
  }

  public String set(int index, String value){
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    Node current = getNode(index);
    String answer = current.data();
    current.setData(value);
    return answer;
  }
  
  public String toString();
  //Any helper method that returns a Node object MUST BE PRIVATE!
}
