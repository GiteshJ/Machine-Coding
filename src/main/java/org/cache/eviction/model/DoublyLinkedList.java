package org.cache.eviction.model;

import java.util.NoSuchElementException;
import org.cache.exception.InvalidElementException;
import org.cache.exception.InvalidNodeException;

public class DoublyLinkedList<Value> {

  DoublyLinkedListNode<Value> dummyHead;
  DoublyLinkedListNode<Value> dummyTail;

  public DoublyLinkedList(){
    this.dummyHead = new DoublyLinkedListNode<Value>(null);
    this.dummyTail = new DoublyLinkedListNode<Value>(null);
    dummyHead.next = dummyTail;
    dummyTail.prev = dummyHead;
  }

  public void detach(DoublyLinkedListNode<Value> node){
    if(node == null) throw  new InvalidNodeException();
    node.prev.next = node.next;
    node.next.prev = node.prev;
  }

  public DoublyLinkedListNode<Value> addElementAtLast(Value value){
    if(value == null) throw new InvalidElementException();
    DoublyLinkedListNode<Value> doublyLinkedListNode = new DoublyLinkedListNode<Value>(value);
    addNodeAtLast(doublyLinkedListNode);
    return doublyLinkedListNode;
  }

  public void addNodeAtLast(DoublyLinkedListNode<Value> node){
    if(node == null) throw  new InvalidNodeException();
    dummyTail.prev.next = node;
    node.prev = dummyTail.prev;
    dummyTail.prev = node;
    node.next = dummyTail;
  }

  public boolean isEmpty(){
    return dummyHead.next == dummyTail;
  }

  public DoublyLinkedListNode<Value> getFirstNode() throws NoSuchElementException {
    DoublyLinkedListNode<Value> item = null;
    if (isEmpty()) {
      return null;
    }
    return dummyHead.next;
  }

  public DoublyLinkedListNode<Value> getLastNode() throws NoSuchElementException {
    DoublyLinkedListNode<Value> item = null;
    if (isEmpty()) {
      return null;
    }
    return dummyTail.prev;
  }
}
