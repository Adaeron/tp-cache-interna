package ar.ciu.bbdd.tp_cache_interna.config;

import java.time.Duration;
import java.util.UUID;

import javax.cache.CacheManager;
import javax.cache.Caching;
import javax.cache.spi.CachingProvider;


import org.ehcache.config.CacheConfiguration;
import org.ehcache.config.builders.CacheConfigurationBuilder;
import org.ehcache.config.builders.ExpiryPolicyBuilder;
import org.ehcache.config.builders.ResourcePoolsBuilder;
import org.ehcache.config.units.MemoryUnit;
import org.ehcache.jsr107.Eh107Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import ar.ciu.bbdd.tp_cache_interna.model.Aeropuerto;

@Configuration
public class EhCacheConfig {

  @Bean
  public CacheManager EhcacheManager() {
    
    CacheConfiguration<UUID, Aeropuerto> cacheConfiguration = 
    CacheConfigurationBuilder.newCacheConfigurationBuilder(UUID.class,
        Aeropuerto.class, 
        ResourcePoolsBuilder
          .newResourcePoolsBuilder()
          .offheap(10, MemoryUnit.MB) /*RAM*/
          .build())
        .withExpiry(ExpiryPolicyBuilder.timeToIdleExpiration(Duration.ofSeconds(90))) /*TTI*/
        .build();
    
    CachingProvider provider = Caching.getCachingProvider();  
    CacheManager cacheManager = provider.getCacheManager(); 

    javax.cache.configuration.Configuration<UUID, Aeropuerto> configuration = Eh107Configuration.fromEhcacheCacheConfiguration(cacheConfiguration);
    cacheManager.createCache("aeropuertosCache", configuration);
    return cacheManager;
  }  
}
