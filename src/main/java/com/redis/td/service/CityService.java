package com.redis.td.service;

import com.redis.td.model.City;
import com.redis.td.repo.CityRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Set;

@RestController
@RequestMapping("/cities")
public class CityService {
  private final CityRepository repo;

  public CityService(CityRepository repo) {
    this.repo = repo;
  }

  @GetMapping("load")
  String loadData() {
    repo.deleteAll();
    var cities = Set.of( //
        City.of("001", "San Francisco"), City.of("002","San Jose"), //
        City.of("003", "Los Angeles"), City.of("004","Scottsdale"), //
        City.of("005","Phoenix"), City.of("006","Flagstaff"), //
        City.of("007","Columbus"), City.of("008","Cleveland"), //
        City.of("009","Cincinnati"), City.of("010","Houston"), //
        City.of("011","Dallas"), City.of("012","Austin"), //
        City.of("013","Seattle"), City.of("014","Spokane"), //
        City.of("015","Tacoma"), City.of("016","Atlanta"), //
        City.of("017","Savannah"), City.of("018","Augusta") //
    );
    repo.saveAll(cities);
    return "OK";
  }

  @GetMapping("some")
  Iterable<City> getSomeCitiesById() {
    return repo.findAllById(List.of("004", "005", "007", "009", "012"));
  }
}
