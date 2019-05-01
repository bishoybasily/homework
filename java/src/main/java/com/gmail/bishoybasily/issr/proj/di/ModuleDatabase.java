package com.gmail.bishoybasily.issr.proj.di;

import com.zaxxer.hikari.HikariConfig;
import com.zaxxer.hikari.HikariDataSource;
import dagger.Module;
import dagger.Provides;
import org.flywaydb.core.Flyway;

@Module
public class ModuleDatabase {

    @Provides
    public HikariConfig hikariConfig() {
        return new HikariConfig(getClass().getResource("/db/mysql.properties").getFile());
    }

    @Provides
    public HikariDataSource hikariDataSource(HikariConfig hikariConfig) {
        return new HikariDataSource(hikariConfig);
    }

    @Provides
    public Flyway flyway(HikariDataSource ds) {
        return Flyway.configure()
                .dataSource(ds)
                .baselineOnMigrate(true)
                .validateOnMigrate(false)
                .load();
    }

}
