package com.redis.td.model;

import com.redis.om.spring.annotations.Document;
import com.redis.om.spring.annotations.Searchable;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import org.springframework.data.annotation.Id;

@Data
@RequiredArgsConstructor(staticName = "of")
@Document("city")
public class City {
  @Id
  @NonNull
  private String id;

  @Searchable
  @NonNull
  private String name;
}
