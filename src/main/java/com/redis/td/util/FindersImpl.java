package com.redis.td.util;

import com.redis.om.spring.RediSearchIndexer;
import com.redis.om.spring.ops.RedisModulesOperations;
import com.redis.td.model.City;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.StreamSupport;

public class FindersImpl<T, ID> implements Finders<T, ID>{

  private final RedisModulesOperations<Object> modulesOperations;
  private final RediSearchIndexer indexer;

  public FindersImpl(RedisModulesOperations<Object> modulesOperations, RediSearchIndexer indexer) {
    this.modulesOperations = modulesOperations;
    this.indexer = indexer;
  }

  @Override
  public List findAllById(Iterable ids) {
    Object[] keys = StreamSupport.stream(ids.spliterator(), false).map(this::getKey).toArray(String[]::new);
    Class<T> javaType = (Class<T>) City.class;

    return modulesOperations.opsForJSON().mget(javaType, keys).stream().collect(Collectors.toList());
  }

  private String getKey(Object id) {
    return indexer.getKeyspaceForEntityClass(City.class) + id.toString();
  }

}
