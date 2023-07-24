package org.cache.eviction;

import java.util.HashMap;
import org.cache.eviction.model.DoublyLinkedList;
import org.cache.eviction.model.DoublyLinkedListNode;

public class LRUCache<Key> implements EvictionPolicy<Key>{
	
	private HashMap<Key, DoublyLinkedListNode<Key>> map;
	public DoublyLinkedList<Key> doublyLinkedList;


	public LRUCache() {
		this.map = new HashMap<Key, DoublyLinkedListNode<Key>>();
		this.doublyLinkedList = new DoublyLinkedList<Key>();
	}

	@Override
	public void keyAccessed(Key key){
		if(!map.containsKey(key)){
			DoublyLinkedListNode<Key> doublyLinkedListNode = doublyLinkedList.addElementAtLast(key);
			map.put(key, doublyLinkedListNode);
		}
		else{
			doublyLinkedList.detach(map.get(key));
			doublyLinkedList.addNodeAtLast(map.get(key));
		}
	}

	@Override
	public Key evictKey(){
		DoublyLinkedListNode<Key> first = doublyLinkedList.getFirstNode();
		if(first == null) {
			return null;
		}
		doublyLinkedList.detach(first);
		return first.value;
	}

}