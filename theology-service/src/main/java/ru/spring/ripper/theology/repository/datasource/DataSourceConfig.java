package ru.spring.ripper.theology.repository.datasource;

import org.h2.jdbcx.JdbcDataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.sql.DataSource;

/**
 * Created by dkorolev on 9/23/2018.
 */
@Configuration
public class DataSourceConfig {
    //TEMP_DIRECTORY = C:\Users\Dmitrii\AppData\Local\Temp\
    private static final String TEMP_DIRECTORY = System.getProperty("java.io.tmpdir");
    @Bean(name = "mainDataSource")
    public DataSource createMainDataSource() {
        JdbcDataSource ds = new JdbcDataSource();
        ds.setURL("jdbc:h2:"+TEMP_DIRECTORY+"/testdata;");
        return ds;
    }
}
