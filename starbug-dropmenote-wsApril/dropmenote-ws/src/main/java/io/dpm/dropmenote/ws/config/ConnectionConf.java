package io.dpm.dropmenote.ws.config;

import java.util.Properties;

import javax.sql.DataSource;

import org.hibernate.jpa.HibernatePersistenceProvider;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.cache.annotation.EnableCaching;
import org.springframework.cache.ehcache.EhCacheCacheManager;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.DependsOn;
import org.springframework.data.jpa.repository.config.EnableJpaRepositories;
import org.springframework.jdbc.datasource.lookup.JndiDataSourceLookup;
import org.springframework.orm.jpa.JpaTransactionManager;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.transaction.annotation.EnableTransactionManagement;
import org.springframework.transaction.support.AbstractPlatformTransactionManager;

import io.dpm.dropmenote.db.constant.CacheConstants;
import io.dpm.dropmenote.ws.utils.LogMessageUtil;
import net.sf.ehcache.Cache;

/**
 * Nastvuje JNDI connection pre entity. Inicializuje DB vrstvu
 * 
 * @author Martin Jurek
 * 
 */
@Configuration
@EnableTransactionManagement
@EnableCaching
@EnableScheduling
@ComponentScan({ "io.dpm.dropmenote.db.dao", "io.dpm.dropmenote.db.entity", "io.dpm.dropmenote.db.repository" })
@EnableJpaRepositories(entityManagerFactoryRef = "entityManagerFactory", transactionManagerRef = "transactionManager", basePackages = { "io.dpm.dropmenote.db.repository" })
public abstract class ConnectionConf {

    private static Logger LOG = LoggerFactory.getLogger(ConnectionConf.class);

    {
        LOG.debug("Inicializujem spring objekty");
    }

    private static final String DATA_SOURCE = "jdbc/postgres/loader";
    private static final String PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN = io.dpm.dropmenote.db.entity.ConfigurationEntity.class.getPackage().getName();

    /**
     * FIXME VERY BAD HACK
     */
    public static EhCacheCacheManager ehCacheCacheManager;

    /**
     * 
     * @return
     */
    @Bean(name = "dataSource", destroyMethod = "")
    public DataSource dataSource() {
        final JndiDataSourceLookup dsLookup = new JndiDataSourceLookup();
        dsLookup.setResourceRef(true);
        DataSource dataSource = dsLookup.getDataSource(DATA_SOURCE);

        if (dataSource != null) {
            LOG.info("Pripojenie na JNDI bolo uspesne, datasource:" + dataSource);
        } else {
            LOG.error("Nepodarilo sa vytvorit pripojenie na JNDI!!!, datasource:" + dataSource);
        }
        return dataSource;
    }

    /**
     * 
     * @return
     */
    @Bean(name = "entityManagerFactory")
    public LocalContainerEntityManagerFactoryBean entityManagerFactory() {
        LocalContainerEntityManagerFactoryBean entityManagerFactoryBean = new LocalContainerEntityManagerFactoryBean();
        entityManagerFactoryBean.setJpaProperties(hibProperties());

        // entityManagerFactoryBean.setJtaDataSource(dataSource());
        entityManagerFactoryBean.setDataSource(dataSource());

        entityManagerFactoryBean.setPersistenceProviderClass(HibernatePersistenceProvider.class);
        entityManagerFactoryBean.setPackagesToScan(PROPERTY_NAME_ENTITYMANAGER_PACKAGES_TO_SCAN);
        return entityManagerFactoryBean;
    }

    /**
     * 
     * @return
     */
    @DependsOn("entityManagerFactory")
    @Bean(name = "transactionManager")
    public AbstractPlatformTransactionManager msdTransactionManager() {
        return transactionManager();
    }

    /**
     * 
     * @return
     */
    protected JpaTransactionManager transactionManager() {
        final JpaTransactionManager transactionManager = new JpaTransactionManager();
        // transactionManager.setTransactionManagerName("weblogic.transaction.TransactionManager");
        return transactionManager;
    }

    /**
     * 
     * @param properties
     */
    protected void putPostgreSqlHibernateProperties(Properties properties) {
        properties.put("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        // TODO toot je pre devel zakomentovane kedze to spomaluje pracu, v
        // prode to nemoze byt vypnute!!!!
        // properties.put("hibernate.hbm2ddl.auto", "validate");
        properties.put("hibernate.hbm2ddl.auto", "none");
        // properties.put("hibernate.generateDdl", "true");
        properties.put("hibernate.show_sql", "false");
        properties.put("hibernate.format_sql", "false");
        properties.put("hibernate.type", "trace");
        // Property je potrebna pre LAZY load, ale je to nebezpecne
        // https://vladmihalcea.com/the-hibernate-enable_lazy_load_no_trans-anti-pattern/
        properties.put("hibernate.enable_lazy_load_no_trans", "true");
        // properties.put("hibernate.transaction.jta.platform",
        // "org.hibernate.service.jta.platform.internal.WeblogicJtaPlatform");
        
        // Fix slow running hibernate
        
        properties.put("hibernate.temp.use_jdbc_metadata_defaults", "false");
        

        /*
         * For Hibernate 4, use org.hibernate.cache.ehcache.EhCacheRegionFactory instead
         * of net.sf.ehcache.hibernate.EhCacheRegionFactory and
         * org.hibernate.cache.ehcache.SingletonEhCacheRegionFactory instead of
         * net.sf.ehcache.hibernate.SingletonEhCacheRegionFactory.
         */
        properties.put("hibernate.cache.region.factory_class", org.hibernate.cache.ehcache.EhCacheRegionFactory.class.getCanonicalName());
    }

    @Bean
    public org.springframework.cache.CacheManager cacheManager() {
        long timeToLiveSeconds = 24 * 60 * 60;

        net.sf.ehcache.CacheManager result = net.sf.ehcache.CacheManager.create();
        result.addCache(new Cache(CacheConstants.CONFIGURATIONREPOSITORY_FINDBYKEY, 0, false, false, timeToLiveSeconds, timeToLiveSeconds));

        ehCacheCacheManager = new EhCacheCacheManager(result);

        reloadCache();

        return ehCacheCacheManager;
    }

    /**
     * Reinicializuje cache, necaka na restart servera alebo 24 hod (toto je
     * aktualne nastavena dlzka zivotnosti cache pre objekty)
     */
    public void reloadCache() {
        LOG.info("Call realodCachce.");
        if (ehCacheCacheManager != null) {

            for (String cacheName : ehCacheCacheManager.getCacheManager().getCacheNames()) {
                try {
                    ehCacheCacheManager.getCacheManager().getCache(cacheName).flush();
                } catch (Exception e) {
                    LOG.info("Nepodarilo sa reloadnut cache hodnotu:" + cacheName + ". Reason:" + LogMessageUtil.getExceptionMessage(e));
                }
            }
            LOG.info("Call realodCachce. Done.");
        }
    }

    /**
     * 
     * @return
     */
    private Properties hibProperties() {
        Properties properties = new Properties();
        putPostgreSqlHibernateProperties(properties);
        return properties;
    }
}
