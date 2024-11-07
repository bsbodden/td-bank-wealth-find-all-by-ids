package com.redis.td.util;

import java.util.List;

public interface Finders<T, ID> {
  /**
   * Returns all instances of the type {@code T} with the given IDs.
   * <p>
   * If some or all ids are not found, no entities are returned for these IDs.
   * <p>
   * Note that the order of elements in the result is not guaranteed.
   *
   * @param ids must not be {@literal null} nor contain any {@literal null} values.
   * @return guaranteed to be not {@literal null}. The size can be equal or less than the number of given
   *         {@literal ids}.
   * @throws IllegalArgumentException in case the given {@link Iterable ids} or one of its items is {@literal null}.
   */
  List<T> findAllById(Iterable<ID> ids);
}
