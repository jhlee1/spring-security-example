package lee.joohan.djamwareexample.repository;

import lee.joohan.djamwareexample.domain.Account;
import org.bson.types.ObjectId;
import org.springframework.data.mongodb.repository.MongoRepository;

/**
 * Created by Joohan Lee on 2019/10/23
 */
public interface AccountRepository extends MongoRepository<Account, ObjectId> {
  Account findByUsername(String username);

}
