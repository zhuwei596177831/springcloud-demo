package irule;

import com.netflix.loadbalancer.IRule;
import com.netflix.loadbalancer.WeightedResponseTimeRule;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * @author zww
 * @date 2020-05-28 18:07
 * @description 服务响应时间加权策略配置类
 */
@Configuration
public class WeightedResponseTimeRuleConfig {
    @Bean
    public IRule iRule() {
        return new WeightedResponseTimeRule();
    }
}
