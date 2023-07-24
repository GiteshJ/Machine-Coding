package org.cache.eviction;

public interface EvictionPolicy<Key> {

  Key evictKey();

  void keyAccessed(Key key);
}
