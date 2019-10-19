package com.eye.op.common.security;


import java.util.Properties;

import org.springframework.beans.factory.FactoryBean;

import com.eye.op.common.utils.DesUtils;


public class DecodeBasicDataSource implements FactoryBean<Properties> {
	
	private Properties properties; 
	
	public Properties getObject() throws Exception {
		// TODO Auto-generated method stub
		return properties;
	}

	@SuppressWarnings({ "unchecked", "rawtypes" })
	public Class getObjectType() {
		return Properties.class;
	}

	public boolean isSingleton() {
		return true;
	}
	
	public void setProperties(Properties properties) {
		try {
			String password = DesUtils.decrypt(properties.getProperty("password"));
			String user = DesUtils.decrypt(properties.getProperty("user"));
			this.properties=properties;
			this.properties.setProperty("user", user);
			this.properties.setProperty("password", password);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		this.properties = properties;
	}

	public static void main(String[] args) throws Exception {
//		System.out.println(DesUtils.encrypt("vm1dta12#$"));
		System.out.println(DesUtils.encrypt("root"));
		System.out.println(DesUtils.decrypt("3180bca483076e740e54a6efee55bd3e"));
//		System.out.println(DesUtils.decrypt("d47274af9211a425"));
	}
}
