package Factory;

import DB.DB;
import DBViews.DBVAutor;
import Entily.Autor;
import java.util.Collection;
import java.util.Map;


public class AutorFactory {
    
    private transient final DB DB;
    private transient final DBVAutor views;
    
    transient Map<String, Autor> cache;

    public AutorFactory(String dir){
        DB = new DB(dir);
        views = new DBVAutor(DB);
        this.cache = views.getCache();
    }

    public void close(){
        DB.close();
    }
    
    public void store(Autor a){
        Autor put = cache.put(a.getCodAutor(), a);
    }
    
    public void excluir(Autor a){
        cache.remove(a.getCodAutor());
    }
    
    public Autor lookup(String codAutor){
        Autor autor = null;
        if(cache.get(codAutor) != null){
            autor = cache.get(codAutor);
        }
        return autor;
    }
    
    public Collection<Autor> getAll(){
        return cache.values();
    }
    
}
