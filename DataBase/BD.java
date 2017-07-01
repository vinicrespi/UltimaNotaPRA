package DataBase;

import com.sleepycat.bind.serial.StoredClassCatalog;
import com.sleepycat.je.Database;
import com.sleepycat.je.DatabaseConfig;
import com.sleepycat.je.DatabaseException;
import com.sleepycat.je.Environment;
import com.sleepycat.je.EnvironmentConfig;
import java.io.File;


public class DB {
    
    private static final String CLASS_CATALOG = "java_class_catalog";
    private static final String STORE = "store";
    private Environment env;
    private Database facDb;
    
    private StoredClassCatalog javaCatalog;
    
    public DB(String dir) throws DatabaseException{
        EnvironmentConfig envConfig = new EnvironmentConfig();
        envConfig.setTransactional(true);
        envConfig.setAllowCreate(true);
        env = new Environment(new File(dir), envConfig);
        
        DatabaseConfig dbConfig = new DatabaseConfig();
        dbConfig.setTransactional(true);
        dbConfig.setAllowCreate(true);
        
        Database catalogDb = env.openDatabase(null, CLASS_CATALOG, dbConfig);
        javaCatalog = new StoredClassCatalog(catalogDb);
        facDb = env.openDatabase(null, STORE, dbConfig);
    }
    
    public final Environment getEnvironment(){
        return env;
    }
    
    public final StoredClassCatalog getClassCatalog(){
        return javaCatalog;
    }
    
    public final Database getPartDatabase(){
        return facDb;
    }
    
    public void close(){
        facDb.close();
        javaCatalog.close();
        env.close();
    }
}
