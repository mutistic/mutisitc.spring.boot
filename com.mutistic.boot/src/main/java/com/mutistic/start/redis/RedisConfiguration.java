package com.mutistic.start.redis;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;

import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.CachingConfigurerSupport;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.cache.RedisCacheWriter;
import org.springframework.data.redis.connection.RedisPassword;
import org.springframework.data.redis.connection.RedisStandaloneConfiguration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.*;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.Jackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.JdkSerializationRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializer;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import com.alibaba.fastjson.support.spring.GenericFastJsonRedisSerializer;

import net.bytebuddy.utility.JavaType;
import redis.clients.jedis.JedisPool;
import redis.clients.jedis.JedisPoolConfig;

@Configuration
@EnableCaching
public class RedisConfiguration extends CachingConfigurerSupport{
    private Logger logger = LoggerFactory.getLogger(this.getClass());

    @Value("${spring.redis.host}")
    private String host;

    @Value("${spring.redis.port}")
    private int port;

    @Value("${spring.redis.password}")
    private String password;

    @Value("${spring.redis.timeout}")
    private int timeout;

    @Value("${spring.redis.jedis.pool.max-idle}")
    private int maxIdle;

    @Value("${spring.redis.jedis.pool.max-wait}")
    private long maxWaitMillis;

    @Value("${shiro.session.session-prefix}")
    private String sessionPrefix;

    @Value("${shiro.session.session-time}")
    private int sessionTime;

    @Value("${shiro.cache.cache-prefix}")
    private String cachePrefix;

    @Value("${shiro.cache.cache-time}")
    private int cacheTime;

    @Bean
    public JedisPool redisPoolFactory() {
        logger.info("JedisPool注入成功！！");
        JedisPool jedisPool = new JedisPool(getJedisPoolConfig(), host, port, timeout, password);
        // JedisPool jedisPool = new JedisPool(getJedisPoolConfig(), host, port, timeout);
        return jedisPool;
    }

    @Bean
    public JedisPoolConfig getJedisPoolConfig(){
        JedisPoolConfig jedisPoolConfig = new JedisPoolConfig();
        jedisPoolConfig.setMaxIdle(maxIdle);
        jedisPoolConfig.setMaxWaitMillis(maxWaitMillis);
        return jedisPoolConfig;
    }

    @Bean
    public JedisConnectionFactory jedisConnectionFactory(){
        RedisStandaloneConfiguration redisStandaloneConfiguration = new RedisStandaloneConfiguration();
        redisStandaloneConfiguration.setHostName(host);
        redisStandaloneConfiguration.setPassword(RedisPassword.of(password));
        redisStandaloneConfiguration.setPort(port);
        JedisConnectionFactory jedisConnectionFactory = new JedisConnectionFactory(redisStandaloneConfiguration);
        logger.info("JedisConnectionFactory注入成功！！");
        return jedisConnectionFactory;
    }

    @Bean
    public CacheManager cacheManager(JedisConnectionFactory jedisConnectionFactory) {
        logger.info("cacheManager注入成功！！");

        RedisCacheConfiguration redisCacheConfiguration = RedisCacheConfiguration.defaultCacheConfig();

        RedisCacheWriter redisCacheWriter = RedisCacheWriter.nonLockingRedisCacheWriter(jedisConnectionFactory);
        RedisCacheManager redisCacheManager = new RedisCacheManager(redisCacheWriter, redisCacheConfiguration);
        //设置缓存过期时间

        return redisCacheManager;
    }

    @Bean(name = "redisTemplate")
    public RedisTemplate<String, Object> getRedisTemplate() {
        logger.info("redisTemplatet注入成功！！");
        RedisTemplate<String, Object> redisTemplate = new RedisTemplate<>();
        redisTemplate.setKeySerializer(new StringRedisSerializer());
        redisTemplate.setValueSerializer(new JdkSerializationRedisSerializer());
        redisTemplate.setHashKeySerializer(new StringRedisSerializer());
        redisTemplate.setHashValueSerializer(new GenericFastJsonRedisSerializer());
        redisTemplate.setConnectionFactory(jedisConnectionFactory());
        return redisTemplate;
    }

    public String getSessionPrefix() {
        return sessionPrefix;
    }

    public void setSessionPrefix(String sessionPrefix) {
        this.sessionPrefix = sessionPrefix;
    }

    public String getCachePrefix() {
        return cachePrefix;
    }

    public void setCachePrefix(String cachePrefix) {
        this.cachePrefix = cachePrefix;
    }

    public int getSessionTime() {
        return sessionTime;
    }

    public void setSessionTime(int sessionTime) {
        this.sessionTime = sessionTime;
    }

    public int getCacheTime() {
        return cacheTime;
    }

    public void setCacheTime(int cacheTime) {
        this.cacheTime = cacheTime;
    }
    public String getHost() {
        return host;
    }

    public void setHost(String host) {
        this.host = host;
    }

    public int getPort() {
        return port;
    }

    public void setPort(int port) {
        this.port = port;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public int getTimeout() {
        return timeout;
    }

    public void setTimeout(int timeout) {
        this.timeout = timeout;
    }

    public int getMaxIdle() {
        return maxIdle;
    }

    public void setMaxIdle(int maxIdle) {
        this.maxIdle = maxIdle;
    }

    public long getMaxWaitMillis() {
        return maxWaitMillis;
    }

    public void setMaxWaitMillis(long maxWaitMillis) {
        this.maxWaitMillis = maxWaitMillis;
    }

}
