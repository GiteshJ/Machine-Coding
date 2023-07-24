package org.cache.eviction.model;

public class DoublyLinkedListNode<Value> {

  public Value value;
  public DoublyLinkedListNode<Value> next;
  public DoublyLinkedListNode<Value> prev;

  public DoublyLinkedListNode(Value value){
    this.value = value;
    this.next  = null;
    this.prev = null;
  }

}
