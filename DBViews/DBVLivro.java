package DBViews;

import com.sleepycat.bind.serial.ClassCatalog;
import com.sleepycat.collections.StoredMap;
import DB.DB;
import com.sleepycat.bind.EntryBinding;
import com.sleepycat.bind.serial.SerialBinding;
import Entily.Livro;
import com.sleepycat.collections.StoredEntrySet;
import java.util.Iterator;

public class DBVLivro {
    
    private final StoredMap cache;
    
    public DBVLivro(DB db){
        ClassCatalog catalog = db.getClassCatalog();
        EntryBinding livroKeyBinding = new SerialBinding(catalog, String.class);
        EntryBinding livroDataBinding = new SerialBinding(catalog, Livro.class);
        cache = new StoredMap(db.getPartDatabase(), livroKeyBinding, livroDataBinding, true);
    }
    
    public StoredMap getCache(){
        return cache;
    }
    
    public final StoredEntrySet getLivroEntrySet(){
        return (StoredEntrySet) cache.entrySet();
    }
   /* public final void listAll(){
        StoredEntrySet set = getLivroEntrySet();
        for(Iterator iterator = set.iterator(); Iterator.hashNext();){
           Livro next = (Livro) iterator.next();
            System.out.println(next.getISBN()+ next.getTitulo());
        }
    }*/
}