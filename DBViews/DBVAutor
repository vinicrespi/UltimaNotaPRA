package DBViews;

import com.sleepycat.bind.serial.ClassCatalog;
import com.sleepycat.collections.StoredMap;
import DB.DB;
import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import Entily.Autor;
import com.sleepycat.collections.StoredEntrySet;
import java.util.Iterator;

public class DBVAutor {
    
    private static StoredMap cache;

    public DBVAutor(DB db) {
        ClassCatalog catalog = db.getClassCatalog();
        EntryBinding autorKeyBinding = new SerialBinding(catalog,  String.class);
        EntryBinding autorDataBinding = new SerialBinding(catalog, Autor.class);
        cache = new StoredMap(db.getPartDatabase(), autorKeyBinding, autorDataBinding, true);
    }

    public StoredMap getCache() {
        return cache;
    }
    
    public final StoredEntrySet getAutorEntrySet(){
        return(StoredEntrySet) cache.entrySet();
    }
    
    public final void listAll(){
        StoredEntrySet set = getAutorEntrySet();
        for(Iterator iterator = set.iterator(); iterator.hasNext();){
           Autor next = (Autor) iterator.next();
            System.out.println(next.getCodAutor()+ next.getNomeAutor());
        }
    }
}
