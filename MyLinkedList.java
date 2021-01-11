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
    } else {
      end.setNext(a);
      a.setPrev(end);
      end = a;
    }
    size++;
    return true;
  }

  public void add(int index, String value){
    Node insert = new Node(value);
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    if (index == size){
      add(value);
    } else if (index == 0){
      insert.setNext(start);
      start.setPrev(insert);
      start = insert;
      size++;
    } else {
      Node current = findNode(index);
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
    return findNode(index).getData();
  }

  public String set(int index, String value){
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    Node current = findNode(index);
    String answer = current.getData();
    current.setData(value);
    return answer;
  }

  public String toString(){
    if (size == 0) return "[]";
    String answer = "[";
    Node current = start;
    for (int i = 0; i < size; i++){
      answer += current.getData();
      if (i != size-1){
        answer += ", ";
      }
      current = current.getNext();
    }
    answer += "]";
    return answer;
  }

  public String toStringReversed(){
    if (size == 0) return "[]";
    String answer = "[";
    Node current = end;
    for (int i = 0; i < size; i++){
      answer += current.getData();
      if (i != size-1){
        answer += ", ";
      }
      current = current.getPrev();
    }
    answer += "]";
    return answer;
  }

  public String remove(int index){
    Node original = findNode(index);
    if (index >= size || index < 0){
      throw new IndexOutOfBoundsException();
    }
    if (index == 0){
      start = start.getNext();
      start.setPrev(null);
    } else if (index == size-1){
      end = end.getPrev();
      end.setNext(null);
    } else {
      Node next = original.getNext();
      Node prev = original.getPrev();
      prev.setNext(next);
      next.setPrev(prev);
    }
    size--;
    return original.getData();
  }

  /*
  *@postcondition: All of the elements from other are removed from the other, and connected to the end of this linked list.
  *@postcondition: The size of other is reduced to 0.
  *@postcondition: The size of this is now the combined sizes of both original lists
  */
  public void extend(MyLinkedList other){
    if (size == 0){
      start = other.start;
      end = other.end;
      size = other.size;
    } else if (other.size != 0){
      end.setNext(other.start);
      other.start.setPrev(end);
      end = other.end;
      size += other.size;
    }
    other.size = 0;
    other.start = null;
    other.end = null;
  }

  //Any helper method that returns a Node object MUST BE PRIVATE!
  private Node findNode(int index){
    Node current = start;
    for(int i = 0; i < index; i++){
      current = current.getNext();
    }
    return current;
  }
}
