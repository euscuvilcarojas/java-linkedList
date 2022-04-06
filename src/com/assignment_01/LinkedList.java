package com.assignment_01;

import java.util.NoSuchElementException;

public class LinkedList<T extends Comparable<T>>  {
    private Node<T> head;
    private Node<T> tail;
    private int size;

    // Milestone 01
    public LinkedList(){
        clear();
    }

    public void addFirst(T element){
        Node<T> newNode = new Node<T>(element, null, head);
        if(isEmpty()){
            setTail(newNode);
        } else {
            head.setPrevious(newNode);
        }
        setHead(newNode);
        setSize(getSize() + 1);
    }

    public void addLast(T element){
        Node<T> newNode = new Node<T>(element, tail, null);
        if(isEmpty()){
            setHead(newNode);
        } else {
            tail.setNext(newNode);
        }
        setTail(newNode);
        setSize(getSize() + 1);
    }

    public void clear(){
        setHead(null);
        setTail(null);
        setSize(0);
    }

    public boolean isEmpty(){
        return getSize() == 0;
    }

    public T getFirst(){
        if (isEmpty()){
            throw new NoSuchElementException();
        }
        return this.getHead().getElement();
    }

    public T getLast(){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        return this.getTail().getElement();
    }

    public T setFirst(T element){
        T oldHeadElement = getFirst();
        this.getHead().setElement(element);
        return oldHeadElement;
    }

    public T setLast(T element){
        T oldTailElement = getLast();
        this.getTail().setElement(element);
        return oldTailElement;
    }

    //Milestone02
    public T removeFirst(){
        return removeNodeByPosition(1);
    }

    public T removeLast(){
        return removeNodeByPosition(getSize());
    }

    public T get(int position){
        return findNodeByPosition(position).getElement();
    }

    public T remove(int position){
        return removeNodeByPosition(position);
    }

    public T set(T element, int position){
        Node<T> node = findNodeByPosition(position);
        T oldElement = node.getElement();
        node.setElement(element);
        return oldElement;
    }

    public void addAfter(T element, int position){
        addNodeByPosition(element, position, false, true);
    }

    public void addBefore(T element, int position){
        addNodeByPosition(element, position, true, false);
    }

    //Milestone03
    public T get(T element){
        return findNodeByElement(element).getElement();
    }

    public void addAfter(T element, T oldElement){
        addNodeByElements(element, oldElement, false, true);
    }

    public void addBefore(T element, T oldElement){
        addNodeByElements(element, oldElement, true, false);
    }

    public T remove(T element){
        return removeNodeByElement(element);
    }

    public T set(T element, T oldElement){
        return setNode(element, oldElement);
    }

    public void insert(T element){
        if (isEmpty()){
            addFirst(element);
        } else {
            Node<T> currentNode = head;
            for(int nodeIndex = 1; nodeIndex <= getSize(); nodeIndex++){
                if(currentNode.getElement().compareTo(element) > 0) {
                    addBefore(element, nodeIndex);
                    break;
                } else if(currentNode.getElement().compareTo(element) < 0){
                    if (nodeIndex == getSize()){
                        addLast(element);
                        break;
                    }
                    currentNode = currentNode.getNext();
                } else {
                    addBefore(element, nodeIndex);
                    break;
                }
            }
        }
    }

    public void sortAscending(){

        Node<T> currentNode = head;
        clear();

        while(currentNode != null) {
            insert(currentNode.getElement());
            currentNode = currentNode.getNext();
        }
    }

    //Helper Methods
    public void addNodeByPosition(T element, int position, boolean isBefore, boolean isAfter){
        if (position <= 0 || isEmpty() || position > getSize()){
            throw new NoSuchElementException();
        }
        Node<T> newNode = new Node<T>(element);
        if(isAfter){
            if(position == 1){
                arrangeNodesAfter(newNode, head);
            } else if(position == getSize()){
                addLast(element);
            } else {
                arrangeNodesAfter(newNode, findNodeByPosition(position));
            }
        } else if (isBefore){
            if (position == 1){
                addFirst(element);
            } else if(position == this.getSize()){
                arrangeNodesBefore(newNode, tail);
            } else {
                arrangeNodesBefore(newNode, findNodeByPosition(position));
            }
        }
    }

    public void addNodeByElements(T element, T oldElement, boolean isBefore, boolean isAfter){
        Node<T> currentNode = findNodeByElement(oldElement);
        Node<T> newNode = new Node<T>(element);
        if(isAfter){
            if(currentNode.getElement() == head.getElement()){
                arrangeNodesAfter(newNode, head);
            } else if(currentNode.getElement() == tail.getElement()){
                addLast(element);
            } else {
                arrangeNodesAfter(newNode, currentNode);
            }
        } else if (isBefore){
            if(currentNode.getElement() == head.getElement()){
                addFirst(element);
            } else if(currentNode.getElement() == tail.getElement()){
                arrangeNodesBefore(newNode, tail);
            } else {
                arrangeNodesAfter(newNode, currentNode);
            }
        }
    }

    public T removeNodeByElement(T element){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(element == null){
            throw new NoSuchElementException();
        }
        if(element == head.getElement()) {
            return arrangeNodesAfterRemoval(findNodeByPosition(1));
        }
        if(element == tail.getElement()){
            return arrangeNodesAfterRemoval(findNodeByPosition(getSize()));
        }

        return arrangeNodesAfterRemoval(findNodeByElement(element));
    }

    public T removeNodeByPosition(int position){
        if (position <= 0 || isEmpty() || position > this.getSize()){
            throw new NoSuchElementException();
        }
        if (position == 1){
            return arrangeNodesAfterRemoval(findNodeByPosition(1));
        }
        if (position == getSize()){
            return arrangeNodesAfterRemoval(findNodeByPosition(getSize()));
        }
        return arrangeNodesAfterRemoval(findNodeByPosition(position));
    }

    public T arrangeNodesAfterRemoval(Node<T> node){
        if(node.getElement() == head.getElement()){
            if(getSize() == 1){
                clear();
            } else {
                head.getNext().setPrevious(null);
                setHead(head.getNext());
                setSize(getSize() -1);
            }
        } else if(node.getElement() == tail.getElement()){
            if(getSize() == 1){
                clear();
            } else {
                tail.getPrevious().setNext(null);
                setTail(tail.getPrevious());
                setSize(getSize() -1);
            }
        } else {
            node.getPrevious().setNext(node.getNext());
            node.getNext().setPrevious(node.getPrevious());
            setSize(getSize() -1);
        }
        return node.getElement();
    }

    public Node<T> findNodeByPosition(int position){
        if (position <= 0 || this.getSize() == 0 || position > this.getSize()){
            throw new NoSuchElementException();
        }
        if(position == 1){
            return head;
        }
        if(position == getSize()){
            return tail;
        }

        Node<T> currentNode = head;
        for(int nodeIndex = 1; nodeIndex <= this.getSize() - 1; nodeIndex++){
            if(nodeIndex != position){
                currentNode = currentNode.getNext();
            } else {
                break;
            }
        }
        return currentNode;
    }

    public Node<T> findNodeByElement(T element){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(element == null){
            throw new NullPointerException();
        }
        if(head.getElement() == element){
            return head;
        }
        if(tail.getElement() == element){
            return tail;
        }

        Node<T> currentNode = head;
        for(int nodeIndex = 1; nodeIndex <= this.getSize() - 1; nodeIndex++){
            if(currentNode.getElement().compareTo(element) != 0){
                currentNode = currentNode.getNext();
            } else {
                break;
            }
        }
        if(currentNode.getElement() != element){
            throw new NoSuchElementException();
        }
        return currentNode;
    }

    public void arrangeNodesBefore(Node<T> newNode, Node<T> node){
        newNode.setNext(node);
        newNode.setPrevious(node.getPrevious());
        node.getPrevious().setNext(newNode);
        node.setPrevious(newNode);
        setSize(getSize() + 1);
    }

    public void arrangeNodesAfter(Node<T> newNode, Node<T> node){
        newNode.setPrevious(node);
        newNode.setNext(node.getNext());
        if(node.getNext() != null){
            node.getNext().setPrevious(newNode);
        } else {
           setTail(newNode);
        }
        node.setNext(newNode);

        setSize(getSize() + 1);
    }

    public T setNode(T element, T oldElement){
        if(isEmpty()){
            throw new NoSuchElementException();
        }
        if(oldElement == null){
            throw new NullPointerException();
        }
        Node<T> node = findNodeByElement(oldElement);
        T foundElement = node.getElement();
        node.setElement(element);
        return foundElement;
    }

    //Getters and Setters -- Self-Generated
    public int getSize() {
        return size;
    }

    public void setSize(int size) {
        this.size = size;
    }

    public Node<T> getHead() {
        return head;
    }

    public void setHead(Node<T> head) {
        this.head = head;
    }

    public Node<T> getTail() {
        return tail;
    }

    public void setTail(Node<T> tail) {
        this.tail = tail;
    }
}

