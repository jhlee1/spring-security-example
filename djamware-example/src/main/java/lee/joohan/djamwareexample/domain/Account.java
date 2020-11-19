package lee.joohan.djamwareexample.domain;

import lombok.Builder;
import lombok.Getter;
import org.bson.types.ObjectId;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

/**
 * Created by Joohan Lee on 2019/10/23
 */

@Document(collection = "users")
@Getter
public class Account {
  @Id
  private ObjectId _id;

  private String username;
  private String password;

  @Builder
  public Account(String username, String password) {
    _id = ObjectId.get();
    this.username = username;
    this.password = password;
  }
}
