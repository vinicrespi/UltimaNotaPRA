package Entily;

import java.io.Serializable;
import java.util.Objects;
import javax.swing.JOptionPane;

public class Livro implements Serializable{
    
    private String codLivro;
    private String tituloLivro;
    
    public Livro(String codLivro,String tituloLivro){
        this.codLivro = codLivro;     
        this.tituloLivro = tituloLivro;
    }

    Livro() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

    @Override
    public String toString() {
        JOptionPane.showMessageDialog(null,"Titulo Livro = " + tituloLivro,"",JOptionPane.INFORMATION_MESSAGE);
        return "codLivro=" + codLivro + ", tituloLivro=" + tituloLivro;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codLivro);
        hash = 59 * hash + Objects.hashCode(this.tituloLivro);
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
        final Livro other = (Livro) obj;
        if (this.codLivro != other.codLivro) {
            return false;
        }
        if (!Objects.equals(this.tituloLivro, other.tituloLivro)) {
            return false;
        }
        return true;
    }
    
    public String getCodLivro() {
        return codLivro;
    }

    public void setCodLivro(String codLivro) {
        this.codLivro = codLivro;
    }

    public String getTituloLivro() {
        return tituloLivro;
    }

    public void setTituloLivro(String tituloLivro) {
        this.tituloLivro = tituloLivro;
    }
}