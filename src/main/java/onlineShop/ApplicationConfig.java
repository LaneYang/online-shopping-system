package onlineShop;

import java.util.Properties;
import javax.sql.DataSource;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.jdbc.datasource.DriverManagerDataSource;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

// TODO: 2/24/21
@Configuration
@EnableWebMvc

public class ApplicationConfig {

  @Bean(name = "sessionFactory")
  public LocalSessionFactoryBean sessionFactory() {
    LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
    sessionFactory.setDataSource(dataSource());
    sessionFactory.setPackagesToScan("onlineShop.entity");
    sessionFactory.setHibernateProperties(hibernateProperties());
    return sessionFactory;
  }

//  @Bean(name = "serverLogger")
//  public Logger logger() {
//    return new ServerLogger();
//  }
//
//  @Bean(name = "pageLogger")
//  public Logger pagelogger() {
//    return new PageLogger();
//  }

  @Bean(name = "dataSource")
  public DataSource dataSource() {
    DriverManagerDataSource dataSource = new DriverManagerDataSource();
    dataSource.setDriverClassName("com.mysql.jdbc.Driver");
    // 只需要修改红色部分, 保留其他内容
    dataSource.setUrl("jdbc:mysql://onlineshopdb.cucrag2zp7wh.us-east-2.rds.amazonaws.com:3306/ecommerce?createDatabaseIfNotExist=true&serverTimezone=UTC");
    dataSource.setUsername("admin");
    dataSource.setPassword("");

    return dataSource;
  }


  private final Properties hibernateProperties() {
    Properties hibernateProperties = new Properties();
    hibernateProperties.setProperty("hibernate.hbm2ddl.auto", "update");
    hibernateProperties.setProperty("hibernate.dialect", "org.hibernate.dialect.MySQL5InnoDBDialect");
    hibernateProperties.setProperty("hibernate.show_sql", "true");
    return hibernateProperties;
  }
}
