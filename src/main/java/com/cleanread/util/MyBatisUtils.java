package com.cleanread.util;

import java.io.IOException;
import java.io.InputStream;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

public class MyBatisUtils {

	private static final String configXml="mybatis-config-utils.xml";
	private static SqlSessionFactory sqlSessionFactory = null;
	
	public static SqlSessionFactory getSqlSessionFactory(){
		if (sqlSessionFactory != null) return sqlSessionFactory;
		InputStream is = null;
		try {
			is = Resources.getResourceAsStream(configXml);
			sqlSessionFactory = new SqlSessionFactoryBuilder().build(is);
			return sqlSessionFactory;
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			IOUtils.closeSecurity(is);
		}
		return null;
	}
}
