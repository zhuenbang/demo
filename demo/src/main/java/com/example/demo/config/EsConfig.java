package com.example.demo.config;

import org.elasticsearch.client.transport.TransportClient;
import org.elasticsearch.common.settings.Settings;
import org.elasticsearch.common.transport.InetSocketTransportAddress;
import org.elasticsearch.transport.client.PreBuiltTransportClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * @author zhuenbang
 * @description
 * @date 2018/9/3 18:43
 */
@Configuration
public class EsConfig {
    @Bean
    public TransportClient client() throws UnknownHostException {
        InetSocketTransportAddress node = new InetSocketTransportAddress(
                InetAddress.getByName("192.168.0.64"),9300
        );
        Settings settings = Settings.builder()
                .put("cluster.name","search")
                .build();
        TransportClient clent = new PreBuiltTransportClient(settings);
        clent.addTransportAddress(node);
        return clent;
    }
}
