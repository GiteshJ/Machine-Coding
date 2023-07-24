package org.cache.storage;

import java.util.HashMap;
import org.cache.exception.NotFoundException;
import org.cache.exception.StorageFullException;

public class HashMapBasedStorage<Key, Value> implements StoragePolicy<Key, Value>{


  private final HashMap<Key, Value> hashMap;
  private final int capacity;
  public HashMapBasedStorage(int capacity){
    this.capacity = capacity;
    this.hashMap = new HashMap<>();
  }
  @Override
  public void add(Key key, Value value) throws StorageFullException {
    if(hashMap.size() >= capacity) throw new StorageFullException();
    hashMap.put(key, value);
  }

  @Override
  public Value get(Key key) {
    if(!hashMap.containsKey(key)) throw new NotFoundException();
    return hashMap.get(key);
  }

  @Override
  public void remove(Key key) throws NotFoundException {
    if(!hashMap.containsKey(key)) throw new NotFoundException();
    hashMap.remove(key);
  }
}
