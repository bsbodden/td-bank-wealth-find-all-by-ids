package com.redis.td;

import com.redis.om.spring.annotations.EnableRedisDocumentRepositories;
import com.redis.td.model.City;
import com.redis.td.repo.CityRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;

import java.util.List;
import java.util.Set;

@SpringBootApplication
@EnableRedisDocumentRepositories
public class TdApplication {

  @Bean
  public JedisConnectionFactory redisConnectionFactory() {
    RedisStandaloneConfiguration config = new RedisStandaloneConfiguration("localhost", 6379);
    return new JedisConnectionFactory(config);
  }

  public static void main(String[] args) {
    SpringApplication.run(TdApplication.class, args);
  }

}
