package spring_java_cofig;

import com.movit.study.spring.spring_java_config.CDPlayer;
import com.movit.study.spring.spring_java_config.CDPlayerConfig;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import static org.junit.Assert.assertEquals;

/**
 * Created by admin on 2017/2/28.
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(classes = CDPlayerConfig.class )
public class CDPlayerTest {

    @Autowired
    private CDPlayer cdPlayer;

    @Test
    public void test(){
        cdPlayer.play();

    }

}
