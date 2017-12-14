package queues;

public class LinkedDequeue<T> {
    
    private Node<T> first;
    private Node<T> last;
    private int size;
    
    public LinkedDequeue()
    {
        first = null;
        last = null;
    }
    
    public void AddToFront(T item)
    {
        Node newNode = new Node(null, item, first);
        
        if ( first == null )
        {
            last = newNode;
        }
        else
        {
            first.previous = newNode;
        }
        size++;
        first = newNode;
    }
    
    public void AddToBack(T item)
    {
        Node newNode = new Node(last, item, null);
        
        if ( last == null )
        {
            first = newNode;
        }
        else
        {
            last.next = newNode;
        }
        size++;
        last = newNode;
    }
    
    public T getFront()
    {
        if ( first == null )
        {
            return null;   
        }
        return first.data;
    }
    
    public T getBack()
    {
        if ( last == null )
        {
            return null;   
        }
        return last.data;
    }
    
    public T removeFront()
    {
        T item = getFront();
        
        first = first.next;
        
        if ( first != null )
        {
            first.previous = null;
        }
        else
        {
            last = null;
        }
        size--;
        return item;
    }
    
    public T removeBack()
    {
        T item = getBack();
        
        last = last.previous;
        
        if ( last != null )
        {
            last.next = null;
        }
        else
        {
            first = null;
        }
        size--;
        return item;
    }
    
    public boolean isEmpty()
    {
        return first == null && last == null;
    }
    
    public int size() {
        return size;
    }
    
    private class Node<T>
    {
        public T data;
        public Node previous;
        public Node next;
        
        public Node(Node previous, T data, Node next)
        {
            this.previous = previous;
            this.data = data;
            this.next = next;
        }
    }
}
