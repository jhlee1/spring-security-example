package lee.joohan.springpinkbookexample.pojo;

import static org.hamcrest.MatcherAssert.assertThat;
import static org.hamcrest.core.Is.is;
import static org.junit.jupiter.api.Assertions.*;

import java.util.List;
import java.util.Map;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

/**
 * Created by Joohan Lee on 2019/10/29
 */

@RunWith(SpringRunner.class)
@SpringBootTest
class FruitPropertyTest {
  @Autowired
  FruitProperty fruitProperty;

  @Test
  public void test() {
    List<Map> fruitData = fruitProperty.getList();

    System.out.println("Fruit data: " + fruitData);

    assertThat(fruitData.get(0).get("name"), is("banana"));
    assertThat(fruitData.get(0).get("color"), is("yellow"));

    assertThat(fruitData.get(1).get("name"), is("apple"));
    assertThat(fruitData.get(1).get("color"), is("red"));

    assertThat(fruitData.get(2).get("name"), is("water melon"));
    assertThat(fruitData.get(2).get("color"), is("green"));
  }
}

//fruit:
//  list:
//    - name: banana
//      color: yellow
//    - name: applie
//      color: red
//    - name: water melon
//      color: green