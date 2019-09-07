package com.react.zpserver.config;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Configuration;

@Configuration
public class RedisFactory {

    @Value("${spring.redis.host}")
    private String host;
    @Value("${spring.redis.database}")
    private String database;
    @Value("${spring.redis.port}")
    private String port;
    @Value("${spring.redis.password}")
    private String password;
    @Value("${spring.redis.timeout}")
    private String timeout;
    @Value("${spring.redis.jedis.pool.max-active}")
    private String maxActive;
    @Value("${spring.redis.jedis.pool.max-wait}")
    private String maxIdle;
    @Value("${spring.redis.jedis.pool.max-idle}")
    private String maxWait;
    @Value("${spring.redis.jedis.pool.min-idle}")
    private String minIdle;


    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public String getDatabase() {
        return database;
    }

    public void setDatabase(String database) {
        this.database = database;
    }

    public String getPort() {
        return port;
    }

    public void setPort(String port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getTimeout() {
        return timeout;
    }

    public void setTimeout(String timeout) {
        this.timeout = timeout;
    }

    public String getMaxActive() {
        return maxActive;
    }

    public void setMaxActive(String maxActive) {
        this.maxActive = maxActive;
    }

    public String getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(String maxIdle) {
        this.maxIdle = maxIdle;
    }

    public String getMaxWait() {
        return maxWait;
    }

    public void setMaxWait(String maxWait) {
        this.maxWait = maxWait;
    }

    public String getMinIdle() {
        return minIdle;
    }

    public void setMinIdle(String minIdle) {
        this.minIdle = minIdle;
    }

    @Override
    public String toString() {
        return "RedisFactory{" +
                "host='" + host + '\'' +
                ", database='" + database + '\'' +
                ", port='" + port + '\'' +
                ", password='" + password + '\'' +
                ", timeout='" + timeout + '\'' +
                ", maxActive='" + maxActive + '\'' +
                ", maxIdle='" + maxIdle + '\'' +
                ", maxWait='" + maxWait + '\'' +
                ", minIdle='" + minIdle + '\'' +
                '}';
    }
}
