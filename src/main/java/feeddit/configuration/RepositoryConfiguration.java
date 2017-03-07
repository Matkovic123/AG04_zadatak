package feeddit.configuration;


import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.transaction.annotation.EnableTransactionManagement;

/**
 * Created by Matkovic on 7.3.2017..
 */

@Configuration
@EnableAutoConfiguration
@EntityScan(basePackages = {"feeddit.entities"})
@EnableJpaRepositories(basePackages = {"feeddit.repositories"})
@EnableTransactionManagement
public class RepositoryConfiguration {
}
