package Deque;

import java.util.Iterator;
import java.util.NoSuchElementException;

public class LinkedDeque<T> implements DequeInterface<T> {

    // first & last node variables
    private DLNode firstNode;
    private DLNode lastNode;

    // initailize deque as empty
    public LinkedDeque() {
        firstNode = null;
        lastNode = null;
    }

    // add element to front
    @Override
    public void addToFront(T newEntry) {
        // create new node with data
        DLNode newNode = new DLNode(newEntry);

        // if deque is empty, first and last node to new node
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
            // if not empty, link new node to the front
            newNode.setNextNode(firstNode);
            firstNode.setPreviousNode(newNode);
            firstNode = newNode;
        }
    }

    // add new element to back of deque
    @Override
    public void addToBack(T newEntry) {
        // create new node with date
        DLNode newNode = new DLNode(newEntry);

        //  if deque is empty, set first and last node to new node
        if (isEmpty()) {
            firstNode = newNode;
            lastNode = newNode;
        } else {
        	// if not empty, link new node to the back
            newNode.setPreviousNode(lastNode);
            lastNode.setNextNode(newNode);
            lastNode = newNode;
        }
    }

    //remove elements from front of deque, then return
    @Override
    public T removeFront() {
        // throwexception if dq is empty
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        }

        // get data from first node
        T front = firstNode.getData();

        // if only one node, set  first and last to null
        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            //if not only one node, remove front node
            firstNode = firstNode.getNextNode();
            firstNode.setPreviousNode(null);
        }

        return front;
    }

    // remove elements from back of deque, return
    @Override
    public T removeBack() {
        // throwexception if deque is empty
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        }

        // get data from back of node
        T back = lastNode.getData();

        //if only one node, set F+L=null
        if (firstNode == lastNode) {
            firstNode = null;
            lastNode = null;
        } else {
            //if not, remove back node
            lastNode = lastNode.getPreviousNode();
            lastNode.setNextNode(null);
        }

        return back;
    }

    // return element at front of dq, witout removing
    @Override
    public T getFront() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        }

        return firstNode.getData();
    }

    //return element at back without removing
    @Override
    public T getBack() {
        if (isEmpty()) {
            throw new EmptyQueueException("Queue is empty.");
        }

        return lastNode.getData();
    }

    //check if dq empty
    @Override
    public boolean isEmpty() {
        return firstNode == null && lastNode == null;
    }

    //set both F+L=null, to clear
    @Override
    public void clear() {
        firstNode = null;
        lastNode = null;
    }

    // dq iterator
    @Override
    public Iterator<T> iterator() {
        return new IteratorForLinkedList();
    }

    // dq getiterator
    @Override
    public Iterator<T> getIterator() {
        return new IteratorForLinkedList();
    }

    // node in dq
    private class DLNode {
        private T data;
        private DLNode nextNode;
        private DLNode previousNode;

        // node condtructor
        private DLNode(T dataPortion) {
            this(dataPortion, null, null);
        }

        //node constructor with NN & PN
        private DLNode(T dataPortion, DLNode nextNode, DLNode previousNode) {
            data = dataPortion;
            this.nextNode = nextNode;
            this.previousNode = previousNode;
        }

        // return data in node
        private T getData() {
            return data;
        }

        // get next node
        private DLNode getNextNode() {
            return nextNode;
        }

        //set next node
        private void setNextNode(DLNode nextNode) {
            this.nextNode = nextNode;
        }

        // get previous node
        private DLNode getPreviousNode() {
            return previousNode;
        }

        // set previous node
        private void setPreviousNode(DLNode previousNode) {
            this.previousNode = previousNode;
        }
    }

    //iterator class, to iterate deque
    private class IteratorForLinkedList implements Iterator<T> {
        private DLNode nextNode;

        //start at front node
        private IteratorForLinkedList() {
            nextNode = firstNode;
        }

        // boolean next noe
        @Override
        public boolean hasNext() {
            return nextNode != null;
        }

        // get data from next node, move node
        @Override
        public T next() {
            if (!hasNext()) {
                throw new NoSuchElementException();
            }

            T data = nextNode.getData();
            nextNode = nextNode.getNextNode();
            return data;
        }
    }
}
