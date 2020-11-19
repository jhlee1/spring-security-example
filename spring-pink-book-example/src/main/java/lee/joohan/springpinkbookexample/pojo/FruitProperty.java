package lee.joohan.springpinkbookexample.pojo;

import java.util.List;
import java.util.Map;
import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * Created by Joohan Lee on 2019/10/29
 */

@Data
@Component
@ConfigurationProperties("fruit")
public class FruitProperty {
  private List<Map> list;
//  private List<Fruit> list; Map 대신 POJO로 받을 수 있음. 이게 더 추천되는 방식
}
