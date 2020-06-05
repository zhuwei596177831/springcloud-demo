package irule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.RandomRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zww
 * @date 2020-05-28 11:05
 * @description 随机策略配置类
 */
@Configuration
public class RandomRuleConfig {

    @Bean
    public IRule iRule(){
        return new RandomRule();
    }

}
