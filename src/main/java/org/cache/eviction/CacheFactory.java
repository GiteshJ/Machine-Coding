package org.cache.eviction;

import org.cache.Cache;
import org.cache.storage.HashMapBasedStorage;
import org.cache.storage.StoragePolicy;
import org.cache.storage.StorageType;

public class CacheFactory<Key, Value> {

  public Cache<Key, Value> getCache(StorageType storageType, EvictionType evictionType, int capacity){
    EvictionPolicy<Key> evictionPolicy;
    StoragePolicy<Key, Value> storagePolicy;

    switch (storageType){
      case HASH_MAP:
      default:
        storagePolicy = new HashMapBasedStorage<Key, Value>(capacity);
        break;
    }

    switch (evictionType){
      case LRU:
      default:
        evictionPolicy = new LRUCache<Key>();
        break;
    }
    return new Cache<Key, Value>(evictionPolicy, storagePolicy);
  }
}
