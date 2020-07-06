package com.wmk.testcase.duotai;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class DB2Config extends DbInfoConfig{
	private String other_type;
	private static DB2Config instance;
	private static ArrayList<DB2Config> dbConfigList = new ArrayList<DB2Config>();

	private DB2Config(){
		DbInfoConfig a = new DbInfoConfig();
		a.setHost("192.168.239.50");
		a.setPort("50005");
		a.setUser("db2inst5");
		a.setPassword("oracle");
		a.setDatabase("MYDB");
		setOther_type("aaa");
    	dbConfigList.add((DB2Config) a);

		a = new DbInfoConfig();
		a.setHost("192.168.226.45");
		a.setPort("5000");
		a.setUser("db2inst1");
		a.setPassword("aaa");
		a.setDatabase("bbb");
		dbConfigList.add((DB2Config) a);

    	setDbConfig(dbConfigList.get(0));
    }
	
    public void setDbConfig(int i) {
    	if (i < dbConfigList.size())
    		setDbConfig(dbConfigList.get(i));
    	else 
			System.out.println("Input error!");			

    }  

	public static DB2Config getDbConfig() {
		if(instance == null){
			instance = new DB2Config();
		}
		return instance;
	}

	public static DB2Config getDbConfig(int i) {
		if (i < dbConfigList.size())
			setDbConfig(dbConfigList.get(i));
		else
			System.out.println("Input error!");
		return instance;
	}

	public static List<Object> getDbConfigList() {
		return Collections.singletonList(dbConfigList);
	}

	public static void setDbConfig(DB2Config dbConfig) {
		DB2Config.instance = dbConfig;
	}

	public String getOther_type() {
		return other_type;
	}

	public void setOther_type(String other_type) {
		this.other_type = other_type;
	}
	
}
