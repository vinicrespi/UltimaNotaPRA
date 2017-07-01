package Entily;

import java.io.Serializable;
import java.util.Objects;
import javax.swing.JOptionPane;

public class Leitor implements Serializable{

    private String codLeitor;
    private String nomeLeitor;
    
    public Leitor(String codLeitor,String nomeLeitor){
        this.codLeitor = codLeitor;     
        this.nomeLeitor = nomeLeitor;
    }

    @Override
    public String toString() {
        JOptionPane.showMessageDialog(null,"Leitor = " + nomeLeitor,"",JOptionPane.INFORMATION_MESSAGE);
        return "codLeitor=" + codLeitor + ", nomeLeitor=" + nomeLeitor;
    }

    @Override
    public int hashCode() {
        int hash = 7;
        hash = 59 * hash + Objects.hashCode(this.codLeitor);
        hash = 59 * hash + Objects.hashCode(this.nomeLeitor);
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
        final Leitor other = (Leitor) obj;
        if (this.codLeitor != other.codLeitor) {
            return false;
        }
        if (!Objects.equals(this.nomeLeitor, other.nomeLeitor)) {
            return false;
        }
        return true;
    }
    
    public String getCodLeitor() {
        return codLeitor;
    }

    public void setCodLeitor(String codLeitor) {
        this.codLeitor = codLeitor;
    }

    public String getNomeLeitor() {
        return nomeLeitor;
    }

    public void setNomeLeitor(String nomeLeitor) {
        this.nomeLeitor = nomeLeitor;
    }
    
    
}
