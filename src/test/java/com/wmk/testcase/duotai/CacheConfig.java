package com.wmk.testcase.duotai;

import java.util.ArrayList;

public class CacheConfig {
    private static DbInfoConfig dbConfig;
    private static ArrayList<DbInfoConfig> dbConfigList =  new ArrayList<>();
    private static CacheConfig instance = null;

    private CacheConfig(){
        DbInfoConfig c = new DbInfoConfig();
        c.setHost("192.168.239.50");
        c.setPort("1973");
        c.setUser("_SYSTEM");
        c.setPassword("test");
        c.setDatabase("USER");
        dbConfigList.add(c);

        c = new DbInfoConfig();
        c.setHost("192.168.226.29");
        c.setPort("1972");
        c.setUser("_SYSTEM");
        c.setPassword("test");
        c.setDatabase("USER");
        dbConfigList.add(c);
        setDbConfig(dbConfigList.get(0));
    }

    public static CacheConfig getInstance() {
        if(instance == null){
            instance = new CacheConfig();
        }
        return instance;
    }

    public static void setDbConfig(int i) {
        if (i < dbConfigList.size())
            setDbConfig(dbConfigList.get(i));
        else
            System.out.println("Input error");
    }

    public static void setDbConfig(DbInfoConfig dbConfig) {
        CacheConfig.dbConfig = dbConfig;
    }

    public static DbInfoConfig getDbConfig() {
        return dbConfig;
    }

    public static ArrayList<DbInfoConfig> getDbConfigList() {
        return dbConfigList;
    }

    public static void setDbConfigList(ArrayList<DbInfoConfig> dbConfigList) {
        CacheConfig.dbConfigList = dbConfigList;
    }
}
