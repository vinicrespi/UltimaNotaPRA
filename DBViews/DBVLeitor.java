package DBViews;

import com.sleepycat.collections.StoredMap;
import DB.DB;
import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.ClassCatalog;
import com.sleepycat.bind.serial.SerialBinding;
import Entily.Leitor;
import com.sleepycat.collections.StoredEntrySet;
import java.util.Iterator;

public class DBVLeitor {
    
    private StoredMap cache;
    
    public DBVLeitor(DB db){
        ClassCatalog catalog = db.getClassCatalog();
        EntryBinding leitorKeyBinding = new SerialBinding(catalog, String.class);
        EntryBinding leitorDataBinding = new SerialBinding(catalog, Leitor.class);
        cache = new StoredMap(db.getPartDatabase(), leitorKeyBinding, leitorDataBinding, true);
    }
    
    public StoredMap getCache(){
        return cache;
    }
    
    public final StoredEntrySet getLeitorEntrySet(){
        return(StoredEntrySet) cache.entrySet();
    }
    
    public final void listAll(){
        StoredEntrySet set = getLeitorEntrySet();
        for(Iterator iterator = set.iterator(); iterator.hasNext();){
           Leitor next = (Leitor) iterator.next();
            System.out.println(next.getCodLeitor()+ next.getNomeLeitor());
        }
    }
}