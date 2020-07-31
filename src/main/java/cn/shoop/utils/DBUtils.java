package cn.shoop.utils;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.util.Properties;

import com.alibaba.druid.pool.DruidDataSource;

public class DBUtils {
	private static DruidDataSource ds;
	
	static {

		Properties p = new Properties();
		InputStream ips = DBUtils.class.getClassLoader()
				.getResourceAsStream("jdbc.properties");
		try {
			p.load(ips);
		} catch (IOException e) {			 
			e.printStackTrace();
		}
		String driver = p.getProperty("db.driver");
		String url = p.getProperty("db.url");
		String name = p.getProperty("db.username");
		String password = p.getProperty("db.password");
		String maxSize = p.getProperty("db.maxActive");
		String initSize = p.getProperty("db.initialSize");
		ds = new DruidDataSource();
		ds.setDriverClassName(driver);
		ds.setUrl(url);
		ds.setUsername(name);
		ds.setPassword(password);
		ds.setInitialSize(Integer.parseInt(initSize));
		ds.setMaxActive(Integer.parseInt(maxSize));
	}

	public static Connection getConn() throws Exception {

		return ds.getConnection();
	}
}
