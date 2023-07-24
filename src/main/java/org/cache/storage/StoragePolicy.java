package org.cache.storage;

import org.cache.exception.NotFoundException;
import org.cache.exception.StorageFullException;

public interface StoragePolicy<Key, Value> {

  void add(Key key, Value value) throws StorageFullException;

  Value get(Key key) throws NotFoundException;;

  void remove(Key key) throws NotFoundException;
}
