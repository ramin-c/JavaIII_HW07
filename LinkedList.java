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
        Node<T> current = head;
        Node<T> temp;
        int indexCounter = 0;

        if (index > this.size || index < 0) {
            return;
        }

        if (this.size == 0) {
            head = new Node<T>(data);
            this.size = this.size + 1;
            return;
        }
        
        while (indexCounter <= this.size) {
            temp = current;

            if (current.getNext() == null && indexCounter + 1 == index) {
                current.setNext(new Node<T>(data));
                this.size++;
                return;
            }

            if (indexCounter == index) {
                temp = new Node<T>(data);
                temp.setNext(current);
                this.size++;
                return;
            }

            current = current.getNext();
            indexCounter++;
        }
    }

    public T getAtIndex(int index) {

        if (index > this.size - 1 || index < 0) {
            return null;
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
                break;
            }
        }
        return null;
    }

    public T removeAtIndex(int index) {

        if (index > this.size - 1 || index < 0) {
            return null;
        }

        Node<T> current = head;
   
        if (current == null) {
            return null;
        }

        T removedData;

        if (index == 0) {
            removedData = head.getData();
            head = head.getNext();
            this.size = size - 1;
            return removedData;
        }

        int indexCounter = 1;
        Node<T> previous = current;

        while (current != null) {
            current = current.getNext();

            if (indexCounter == index) {

                removedData = current.getData();

                if (current.getNext() == null) {
                    previous.setNext(null);
                } else {
                    previous.setNext(current.getNext());          
                }
                this.size = this.size - 1;
                return removedData;
            }
            previous = previous.getNext();
            indexCounter++;
        }
        return null;
    }

    public T remove(T data) {
        Node<T> current = head;
        T removedData;

        if (current == null) {
            this.size = 0;
            return null;
        }

        Node<T> previous = current;

        if (current.getData() == null) {
            return null;
        } else if (current.getData() == data) {
            head = current.getNext();
            this.size = this.size - 1;
            removedData = current.getData();
            return removedData;
        }

        current = current.getNext();

        while (current.getData() != null) {
            if (current.getData() == data) {
                previous.setNext(current.getNext());
                removedData = current.getData();
                this.size = this.size - 1;
                return removedData;
            }
            if (current.getNext() == null) {
                return null;
            }
            current = current.getNext();
            previous = previous.getNext();
        }
        return null;
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
        System.out.println("isEmpty(): " + stringList.isEmpty());
        stringList.addAtIndex("First Song", 0);
        System.out.println("getAtIndex(0): " + stringList.getAtIndex(0));
        System.out.println("isEmpty() still: " + stringList.isEmpty());
        stringList.addAtIndex("Second Song", 1);
        stringList.addAtIndex("Third Song", 2);
        System.out.println("getAtIndex(): " + stringList.getAtIndex(0) + stringList.getAtIndex(1) + stringList.getAtIndex(2));
        //stringList.removeAtIndex(1);
        stringList.remove("Third Song");
        System.out.println("getAtIndex(): " + stringList.getAtIndex(0) + stringList.getAtIndex(1) + stringList.getAtIndex(2));
        //stringList.clear();
        //System.out.println("getAtIndex(): " + stringList.getAtIndex(0));
    }
}
