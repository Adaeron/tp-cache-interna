package ar.ciu.bbdd.tp_cache_interna;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cache.annotation.EnableCaching;

@SpringBootApplication
@EnableCaching
public class TpCacheInternaApplication {

	public static void main(String[] args) {
		SpringApplication.run(TpCacheInternaApplication.class, args);
	}

}
