package lee.joohan.springpinkbookexample;

import static org.hamcrest.CoreMatchers.is;
import static org.hamcrest.MatcherAssert.assertThat;

import java.util.List;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Joohan Lee on 2019/10/29
 */
@RunWith(SpringRunner.class)
@SpringBootTest
public class AutoConfigurationApplicationTests {
  @Value("${property.test.name}")
  private String propertyTestName;

  @Value("${propertyTest}")
  private String propertyTest;

  @Value("${noKey:default value}") //noKey라는 값이 없으면 "default value"로 맵핑
  private String defaultValue;

  @Value("${propertyTestList}") // a,b,c를 [a, b,c]로 변환
  private String[] propertyTestArray;

  @Value("#{'${propertyTestList}'.split(',')}") // SpEL 사용
  private List<String> propertyTestList;

  @Test
  public void testValue() {
    assertThat(propertyTestName, is("property depth test"));
    assertThat(propertyTest, is("test"));
    assertThat(defaultValue, is("default value"));

    assertThat(propertyTestArray[0], is("a"));
    assertThat(propertyTestArray[1], is("b"));
    assertThat(propertyTestArray[2], is("c"));

    assertThat(propertyTestList.get(0), is("a"));
    assertThat(propertyTestList.get(1), is("b"));
    assertThat(propertyTestList.get(2), is("c"));
  }


}
