package com.tecnodestreza.siga.config.tenant;

import org.flywaydb.core.Flyway;
import org.springframework.context.annotation.Configuration;

import jakarta.annotation.PostConstruct;
import javax.sql.DataSource;
import java.util.Arrays;
import java.util.List;

@Configuration
public class FlywayMultiTenantConfiguration {

    private final DataSource dataSource;

    public FlywayMultiTenantConfiguration(DataSource dataSource) {
        this.dataSource = dataSource;
    }

    @PostConstruct
    public void migrateTenants() {
        List<String> tenants = Arrays.asList("siga_jrpocaterra", "siga_plaza");
        for (String tenant : tenants) {
            Flyway flyway = Flyway.configure()
                    .dataSource(dataSource)
                    .schemas(tenant)
                    .locations("classpath:db/migration")
                    .baselineOnMigrate(true)
                    .load();
            flyway.repair();
            flyway.migrate();
        }
    }

    @org.springframework.context.annotation.Bean
    public org.springframework.boot.autoconfigure.flyway.FlywayMigrationStrategy flywayMigrationStrategy() {
        return flyway -> {
            flyway.repair();
            flyway.migrate();
        };
    }
}
