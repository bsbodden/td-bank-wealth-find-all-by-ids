package com.redis.td.repo;

import com.redis.om.spring.repository.RedisDocumentRepository;
import com.redis.td.model.City;
import com.redis.td.util.Finders;

public interface CityRepository extends RedisDocumentRepository<City, String>, Finders<City, String> {
}
