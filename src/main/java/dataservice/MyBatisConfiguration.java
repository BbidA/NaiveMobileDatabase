package dataservice;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.io.InputStream;

/**
 * Author: J.D. Liao
 * Date: 2018/10/27
 * Description:
 */
public class MyBatisConfiguration {

    private static final SqlSessionFactory sessionFactory;

    private static final String RESOURCE = "mybatis-config.xml";

    private static final Logger log = LoggerFactory.getLogger("DataConfig");

    static {
        sessionFactory = buildSqlSessionFactory();
    }

    public static SqlSessionFactory getSessionFactory() {
        return sessionFactory;
    }

    private static SqlSessionFactory buildSqlSessionFactory() {
        try {
            InputStream inputStream = Resources.getResourceAsStream(RESOURCE);
            return new SqlSessionFactoryBuilder().build(inputStream);
        } catch (IOException e) {
            e.printStackTrace();
            log.error("Database connection is wrong");
            throw new IllegalStateException("Database connection is wrong");
        }
    }
}
