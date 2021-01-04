package com.rpdly.rpdlyapi.domain;

import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.config.AbstractMongoClientConfiguration;
import org.springframework.data.mongodb.repository.config.EnableMongoRepositories;

@Configuration
@EnableMongoRepositories
public class ApplicationConfig extends AbstractMongoClientConfiguration {

  @Override
  protected String getDatabaseName() {
    return "rpdly-service";
  }
}
