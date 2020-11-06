package com.zhs.demonacos.config;

import com.alibaba.nacos.api.annotation.NacosProperties;
import com.alibaba.nacos.spring.context.annotation.config.EnableNacosConfig;
import com.alibaba.nacos.spring.context.annotation.config.NacosPropertySource;
import org.springframework.context.annotation.Configuration;

/**
 * @author: zhs
 * @since: 2020/11/6 16:12
 */
@Configuration
@EnableNacosConfig(globalProperties = @NacosProperties(serverAddr = ""))
@NacosPropertySource(dataId = "solomon",autoRefreshed = true)
public class NacosConfiguration {

}
