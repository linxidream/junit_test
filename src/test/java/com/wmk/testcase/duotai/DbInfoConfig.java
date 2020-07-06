package com.wmk.testcase.duotai;

import java.util.List;

public class DbInfoConfig {
	private String host;
	private String port;
	private String user;
	private String password;
	private String database;
	private DbInfoConfig dbInfoConfig;

	public String getHost() {
		return host;
	}
	public void setHost(String host) {
		this.host = host;
	}
	public String getPort() {
		return port;
	}
	public void setPort(String port) {
		this.port = port;
	}
	public String getUser() {
		return user;
	}
	public void setUser(String user) {
		this.user = user;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}

	public String getDatabase() {
		return database;
	}

	public void setDatabase(String database) {
		this.database = database;
	}

	public static DbInfoConfig getDbConfig(){
		return null;
	}

	public static DbInfoConfig getDbConfig(int i){
		return null;
	}

	public static List<Object> getDbConfigList(){
		return null;
	}
}
