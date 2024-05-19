import java.util.NoSuchElementException;

public class LinkedList<T> implements List<T> {
    Node<T> head;    //if list is empty, set to null
    Node<T> tail;    //if list is empty, set to null
    int size;        //if list ist empty, set to 0

    public LinkedList() {
        this.head = null;
        this.tail = null;
        this.size = 0;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }



    // Interface methods

    public void addAtIndex(T data, int index) throws IllegalArgumentException {
        Node<T> current = head;

        if (index > this.size || index < 0) {
            throw new IllegalArgumentException("Your index is out of the list bounds");
        }

        if (data == null) {
            throw new IllegalArgumentException("You cannot add null data to the list");
        }

        if (this.size == 0) {
            this.head = new Node<T>(data);
            this.tail = this.head;
            this.size = this.size + 1;
            return;
        }

        if (index == 0) {
            Node<T> temp = this.head;
            this.head = new Node<T>(data);
            this.head.setNext(temp);
            this.size = this.size + 1;
            return;
        }

        
        Node<T> previous = current;
        if (current.getNext() != null) {
            current = current.getNext();
        }
        int i = 1;

        while (current != null) {
            previous = current;
            current = current.getNext();
            if (i == index) {
                break;
            }
            i++;
        }

        previous.setNext(new Node<T>(data));
        if (current != null) {
            if (current.getNext() == null) {
                this.tail = current;
            } else {
                previous.getNext().setNext(current);
            }
        } else { 
            this.tail = previous.getNext();
        }
        this.size = this.size + 1;
        return;
    }


    public T getAtIndex(int index) throws IllegalArgumentException {

        if (index > this.size - 1 || index < 0) {
            throw new IllegalArgumentException("Invalid index");
        }
        
        Node<T> current = head;
        int indexCounter = 0;

        while (current != null) {
            
            if (indexCounter == index) {
                return current.getData();
            }

            if (current.getNext() != null) {
                current = current.getNext();
                indexCounter++;
            } else {
                return current.getData();
            }
        }
        return null;
    }

    public T removeAtIndex(int index) throws IllegalArgumentException {
        
        if (this.size < 1) {
            throw new IllegalArgumentException("Invalid index");
        }

        if (index > this.size - 1 || index < 0) {
            throw new IllegalArgumentException("Invalid index");
        }

        Node<T> current = head;
   
        if (current == null) {
            throw new IllegalArgumentException("Invalid index");
        }

        T removeData;

        if (index == 0) {
            removeData = head.getData();
            if (head.getNext() == null) {
                this.head = null;
                this.tail = null;
            } else {
                this.head = head.getNext();
            }
            this.size = size - 1;
            return removeData;
        }

        int indexCounter = 0;
        Node<T> previous = current;
            
        while (current != null) {

            if (index == indexCounter) {
                previous.setNext(current.getNext());
                if (index == this.size - 1) {
                    tail = previous;
                }
                removeData = current.getData();
                current = null;
                this.size = this.size - 1;
                return removeData;
            } else {
                previous = current;
                current = current.getNext();
                indexCounter++;
            }
        }
        return null;
    }

    public T remove(T data) throws NoSuchElementException {

        if (this.head == null) {
            throw new NoSuchElementException();
        }

        T removedData;

        if (this.head.getData() == data) {
            removedData = head.getData();

            if (this.head.getNext() == null) {
                this.tail = null;
            } else if (this.head.getNext() != null) {
                this.head = this.head.getNext();
            }
            this.size = this.size - 1;
            return removedData;
        }

        Node<T> current = this.head.getNext();
        Node<T> previous = this.head;


        while (current != null) {

            if (current.getData() == data) {
                previous.setNext(current.getNext());
                removedData = current.getData();
                this.size = this.size - 1;

                if (current.getNext() == null) {
                    this.tail = previous;
                }

                return removedData;
            }

            previous = current;
            current = current.getNext();
        }
        throw new NoSuchElementException();
    }

    public void clear() {
        Node<T> current = head;
        Node<T> temp;
        while(current != null) {
            if (current.getNext() != null) {
                temp = current.getNext();
                current = null;
                current = temp;
                temp = null;
            } else {
                current = null;
            }
        }
        this.size = 0;
    }

    public boolean isEmpty() {
        if (this.head == null) {
            return true;
        }
        return false;
    }

    public int size() {
        return this.size;
    }


    
   public static void main(String argv[]) {
        
        LinkedList<String> stringList = new LinkedList<String>();
        stringList.addAtIndex("First Song", 0);
        stringList.addAtIndex("Second Song", 1);
        stringList.addAtIndex("Third Song", 2);
        stringList.addAtIndex("Fourth Song", 3);
        stringList.addAtIndex("Fifth Song", 4);
        stringList.addAtIndex("Sixth Song", 5);
        System.out.println("getAtIndex(0-5): " + stringList.getAtIndex(0)
        + stringList.getAtIndex(1)
        + stringList.getAtIndex(2)
        + stringList.getAtIndex(3)
        + stringList.getAtIndex(4)
        + stringList.getAtIndex(5));


        System.out.println("Size(): " + stringList.size());
        System.out.println("removeAtIndex 0: " + stringList.removeAtIndex(0));
        System.out.println("head data: " + stringList.head.getData());
        System.out.println("Size(): " + stringList.size());
        stringList.addAtIndex("Fifth Song", 3);
        System.out.println("getAtIndex(0): " + stringList.getAtIndex(0));

        
    
        /*
        LinkedList<String> stringList = new LinkedList<String>();
        //stringList.remove("First Song");
        stringList.addAtIndex("First Song", 0);

        //System.out.println("isEmpty(): " + stringList.isEmpty());
        //System.out.println("size(): " + stringList.size());
        
        //System.out.println("getAtIndex(0): " + stringList.getAtIndex(0));
        //System.out.println("isEmpty() still: " + stringList.isEmpty());
        stringList.addAtIndex("Second Song", 1);
        stringList.addAtIndex("Third Song", 2);
        stringList.addAtIndex("Before #2", 0);
        stringList.addAtIndex("Before #1", 0);

        //stringList.removeAtIndex(2);
        //System.out.println("getAtIndex(): " + stringList.getAtIndex(0));
        //System.out.println("getAtIndex(): " + stringList.getAtIndex(0) + stringList.getAtIndex(1));
        //System.out.println("getAtIndex(): " + stringList.getAtIndex(0) + stringList.getAtIndex(1) + stringList.getAtIndex(2));
        System.out.println("getAtIndex(): " + stringList.getAtIndex(0) + stringList.getAtIndex(1) + stringList.getAtIndex(2) + stringList.getAtIndex(3));
        //System.out.println("getAtIndex(): " + stringList.getAtIndex(0) + stringList.getAtIndex(1) + stringList.getAtIndex(2) + stringList.getAtIndex(3) + stringList.getAtIndex(4));
        //stringList.removeAtIndex(-100);
        stringList.remove("Before #1");
        System.out.println("getAtIndex(): " + stringList.getAtIndex(0) + stringList.getAtIndex(1) + stringList.getAtIndex(2) + stringList.getAtIndex(3));
        //System.out.println("getAtIndex(): " + stringList.getAtIndex(0) + stringList.getAtIndex(1));

        //System.out.println("getAtIndex(): " + stringList.getAtIndex(-5) + stringList.getAtIndex(1));

        //stringList.clear();
        //System.out.println("getAtIndex(): " + stringList.getAtIndex(0))
         */
    }
     
     
}
