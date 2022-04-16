package com.hobby.sharing.global.config.cache;

import com.fasterxml.jackson.databind.ObjectMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.cache.CacheManager;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.cache.RedisCacheConfiguration;
import org.springframework.data.redis.cache.RedisCacheManager;
import org.springframework.data.redis.connection.RedisConnectionFactory;
import org.springframework.data.redis.serializer.GenericJackson2JsonRedisSerializer;
import org.springframework.data.redis.serializer.RedisSerializationContext;
import org.springframework.data.redis.serializer.StringRedisSerializer;

import java.time.Duration;

@RequiredArgsConstructor
@Configuration
@EnableCaching
public class CacheConfig {

    private final ObjectMapper objectMapper;
    private final RedisConnectionFactory connectionFactory;

    @Bean
    public CacheManager cacheManager() {
        RedisCacheConfiguration redisConfiguration = RedisCacheConfiguration.defaultCacheConfig()
                .serializeKeysWith(RedisSerializationContext.SerializationPair.
                        fromSerializer(new StringRedisSerializer()))
                .serializeValuesWith(RedisSerializationContext.SerializationPair
                        .fromSerializer(new GenericJackson2JsonRedisSerializer(objectMapper)))
                .disableCachingNullValues()
                .entryTtl(Duration.ofSeconds(180));

        return RedisCacheManager.RedisCacheManagerBuilder
                .fromConnectionFactory(connectionFactory)
                .cacheDefaults(redisConfiguration)
                .build();
    }
}
