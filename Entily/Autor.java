package Entily;

import java.io.Serializable;
import java.util.Objects;
import javax.swing.JOptionPane;

public class Autor implements Serializable{

    private String codAutor;
    private String nomeAutor;
    
    public Autor(String codAutor,String nomeAutor){
        this.codAutor = codAutor;
        this.nomeAutor = nomeAutor;
    }

    Autor() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        JOptionPane.showMessageDialog(null,"Autor = " + nomeAutor,"",JOptionPane.INFORMATION_MESSAGE);
        return "codAutor=" + codAutor + ", nomeAutor=" + nomeAutor;
    }

    @Override
    public int hashCode() {
        int hash = 5;
        hash = 23 * hash + Objects.hashCode(this.codAutor);
        hash = 23 * hash + Objects.hashCode(this.nomeAutor);
        return hash;
    }

    @Override
    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null) {
            return false;
        }
        if (getClass() != obj.getClass()) {
            return false;
        }
        final Autor other = (Autor) obj;
        if (this.codAutor != other.codAutor) {
            return false;
        }
        if (!Objects.equals(this.nomeAutor, this.nomeAutor)) {
            return false;
        }
        return true;
    }   

    public String getCodAutor() {
        return codAutor;
    }

    public void setCodAutor(String codAutor) {
        this.codAutor = codAutor;
    }

    public String getNomeAutor() {
        return nomeAutor;
    }

    public void setNomeAutor(String nomeAutor) {
        this.nomeAutor = nomeAutor;
    }   
    
}
