package com.tecnodestreza.siga.config.tenant;

import org.hibernate.context.spi.CurrentTenantIdentifierResolver;
import org.hibernate.engine.jdbc.connections.spi.MultiTenantConnectionProvider;
import org.springframework.boot.autoconfigure.orm.jpa.HibernatePropertiesCustomizer;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class MultiTenantJpaConfiguration {

    @Bean
    public HibernatePropertiesCustomizer hibernatePropertiesCustomizer(
            MultiTenantConnectionProvider connectionProvider,
            CurrentTenantIdentifierResolver tenantResolver) {
        return hibernateProperties -> {
            hibernateProperties.put("hibernate.multiTenancy", "SCHEMA");
            hibernateProperties.put("hibernate.multi_tenant_connection_provider", connectionProvider);
            hibernateProperties.put("hibernate.tenant_identifier_resolver", tenantResolver);
        };
    }
}
