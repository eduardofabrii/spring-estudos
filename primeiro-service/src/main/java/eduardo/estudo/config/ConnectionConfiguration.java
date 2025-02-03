package eduardo.estudo.config;

import external.dependency.Connection;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Primary;

@Configuration
public class ConnectionConfiguration {

    @Bean
    @Primary
    public Connection connectionMySQL() {
        return new Connection("localhost", "eduardoSQL", "toestudando");
    }

    @Bean
    public Connection connectionMongo() {
        return new Connection("localhost", "eduardoMongo", "toestudando");
    }
}
