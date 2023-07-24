package org.cache;

import org.cache.eviction.CacheFactory;
import org.cache.eviction.EvictionType;
import org.cache.storage.StorageType;

public class CacheSystem {

  public static void main(String[] args) {

    CacheFactory<Integer, Integer> cacheFactory = new CacheFactory<>();
    Cache<Integer, Integer> cache = cacheFactory.getCache(StorageType.HASH_MAP, EvictionType.LRU, 5);

    cache.put(1, 10);
    cache.put(2, 20);
    cache.put(3, 30);
    cache.put(4, 40);
    cache.put(5, 50);
    cache.put(6, 60);

    cache.get(1);
  }

}