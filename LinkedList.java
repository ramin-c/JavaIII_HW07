public class LinkedList<T> implements List<T> {
    Node<T> head;    //if list is empty, set to null
    Node<T> tail;    //if list is empty, set to null
    int size;        //if list ist empty, set to 0

    public LinkedList() {
        head = null;
        tail = null;
    }

    public Node<T> getHead() {
        return this.head;
    }

    public Node<T> getTail() {
        return this.tail;
    }



    // Interface methods

    public void addAtIndex(T data, int index) {
        System.out.println("add at index call");
        Node<T> current = head;
        Node<T> temp;
        int indexCounter = 0;

        if (index > this.size || index < 0) {
            return;
        }

        if (this.size == 0) {
            System.out.println("Adding to head");
            head = new Node<T>(data);
            this.size = this.size + 1;
            System.out.println("First node set to: " + head.getData());
            return;
        }
        
        while (indexCounter <= this.size) {
            System.out.println("indexCounter = " + indexCounter + ". this.size = " + this.size);
            temp = current;

            if (current.getNext() == null && indexCounter + 1 == index) {
                current.setNext(new Node<T>(data));
                this.size++;
                return;
            }

            if (indexCounter == index) {
                temp = new Node<T>(data);
                temp.setNext(current);
                System.out.println("New node. node.data = " + temp.getData());
                this.size++;
                return;
            }

            current = current.getNext();
            indexCounter++;
        }
    }

    public T getAtIndex(int index) {
        Node<T> current = head;
        int indexCounter = 0;

        if (index > this.size - 1 || index < 0) {
            return null;
        }

        while (current != null) {
            if (indexCounter == index) {
                return current.getData();
            }

            if (current.getNext() != null) {
                current = current.getNext();
                indexCounter++;
            } else {
                break;
            }
        }
        
        return null;
    }

    public T removeAtIndex(int index) {
        Node<T> current = head;
        Node<T> previous;
        T removedData;
        int indexCounter = 0;

        if (current == null) {
            return null;
        }

        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
            this.size = size - 1;
            return removedData;
        }

        while (current != null) {
            previous = current;

            

            if (indexCounter == index) {

                if (current.getNext() == null) {
                    removedData = current.getData();
                    previous.setNext(null);
                    this.size = this.size - 1;
                    return removedData;
                }

                removedData = current.getData();
                previous.setNext(current.getNext());
                this.size = this.size - 1;
                return removedData;
            }


            indexCounter++;
            current = current.getNext();
        }
        return null;
    }

    public T remove(T data) {
        Node<T> current = head;
        Node<T> temp;

        if (current == null) {
            this.size = 0;
            return null;
        }

        while (current != null) {
            if (current.getNext() == data) {
                if (data == head.getData()) {
                    head = current.getNext();
                    break;
                }
                temp = current.getNext();
                current.setNext(temp.getNext());
                temp = null;
            }
        }
        this.size = this.size - 1;
        return data;
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
            }
            if (current.getNext() == null) {
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
        System.out.println("isEmpty(): " + stringList.isEmpty());
        stringList.addAtIndex("First Song", 0);
        System.out.println("getAtIndex(0): " + stringList.getAtIndex(0));
        System.out.println("isEmpty() still: " + stringList.isEmpty());
        stringList.addAtIndex("Second Song", 1);
        stringList.addAtIndex("Third Song", 2);
        System.out.println("getAtIndex(): " + stringList.getAtIndex(0) + stringList.getAtIndex(1) + stringList.getAtIndex(2));
        stringList.removeAtIndex(1);
        System.out.println("getAtIndex(): " + stringList.getAtIndex(0) + stringList.getAtIndex(1) + stringList.getAtIndex(2));
        stringList.clear();
        System.out.println("getAtIndex(): " + stringList.getAtIndex(0));
    }
}
