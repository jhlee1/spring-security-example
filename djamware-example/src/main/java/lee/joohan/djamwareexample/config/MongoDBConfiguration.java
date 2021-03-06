package lee.joohan.djamwareexample.config;

import lombok.Getter;
import lombok.RequiredArgsConstructor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.mongodb.MongoDbFactory;
import org.springframework.data.mongodb.core.convert.DbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultDbRefResolver;
import org.springframework.data.mongodb.core.convert.DefaultMongoTypeMapper;
import org.springframework.data.mongodb.core.convert.MappingMongoConverter;
import org.springframework.data.mongodb.core.mapping.MongoMappingContext;

/**
 * Created by Joohan Lee on 2019/10/23
 */

@Configuration
@RequiredArgsConstructor
@Getter
public class MongoDBConfiguration {
  private final MongoDbFactory mongoDbFactory;
  private final MongoMappingContext mongoMappingContext;

  @Bean
  public MappingMongoConverter mappingMongoConverter() {
    DbRefResolver dbRefResolver = new DefaultDbRefResolver(mongoDbFactory);
    MappingMongoConverter converter = new MappingMongoConverter(dbRefResolver, mongoMappingContext);

    converter.setTypeMapper(new DefaultMongoTypeMapper(null));

    return converter;
  }
}
