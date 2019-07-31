package com.dhw.gatewayservice.config;

import com.dhw.gatewayservice.filters.RequestTimeFilter;
import com.dhw.gatewayservice.filters.TokenFilter;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

/**
 * Created with IntelliJ IDEA.
 * User: dinghw
 * Date: 2019/7/30
 * Time: 17:17
 * To change this template use File | Settings | File Templates.
 * Description:
 */
@Configuration
public class FiltersConfig {

    @Bean ("tokenFilter")
    public TokenFilter tokenFilter() {
        return new TokenFilter();
    }

    @Bean ("requestTimeFilter")
    public RequestTimeFilter requestTimeFilter() {
        return new RequestTimeFilter();
    }

}