package com.dhw.shirodemo1.config;

import org.apache.shiro.spring.LifecycleBeanPostProcessor;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: dinghw
 * Date: 2019/3/27
 * Time: 9:20
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Configuration
public class ShiroLifecycleBeanPostProcessorConfig {

    /**
     * Shiro生命周期处理器
     *
     * @return
     */

    @Bean (name = "lifecycleBeanPostProcessor")
    public LifecycleBeanPostProcessor getLifecycleBeanPostProcessor() {
        return new LifecycleBeanPostProcessor();
    }
}