package Function;

import Entily.Autor;
import Factory.AutorFactory;
import GUI.Menu;
import java.util.Scanner;
import javax.swing.JOptionPane;

public class FuncAutor {
    
    private final String diretorio;
    private final Menu menu = new Menu();

    public FuncAutor(String diretorio) {
        this.diretorio = diretorio;
    }
    
    public void addAutor(String codigo, String nome){
        String codAutor = codigo;
        String nomeAutor = nome;
  
        Autor autor = new Autor(codAutor, nomeAutor);
        
        AutorFactory factory = new AutorFactory(diretorio);
        
        Autor stored = factory.lookup(codAutor);
        if(stored != null){
            JOptionPane.showMessageDialog(null,"CÓDIGO JÁ EXISTE","",JOptionPane.ERROR_MESSAGE);
        }else {
            factory.store(autor);
           
        }   
         menu.setVisible(true);
    }
    
    public Autor findAutor(String codigo){
        AutorFactory factory = new AutorFactory(diretorio);
        Autor a = factory.lookup(codigo);
        if(a == null){
            JOptionPane.showMessageDialog(null,"AUTOR NÃO EXISTE","",JOptionPane.ERROR_MESSAGE);
        }
        else{
            System.out.println(a.toString());
            System.out.println(a.getNomeAutor());
        }
        menu.setVisible(true);
        return a;       
    }
    
    public void alterarAutor(String codigo){
        AutorFactory factory = new AutorFactory(diretorio);
        Autor a = factory.lookup(codigo);
        if(a != null){
            Scanner s = new Scanner(System.in);
            System.out.println("Digite o nome");
            String nome = s.nextLine();
            a.setNomeAutor(nome);
            removerAutor(codigo);
            factory.store(a);
            JOptionPane.showMessageDialog(null,"Autor Alterado");
        }
        else{
            JOptionPane.showMessageDialog(null,"AUTOR NÃO EXISTE","",JOptionPane.ERROR_MESSAGE);
        }
        menu.setVisible(true);
    }
    
    public void removerAutor(String codigo){
        AutorFactory factory = new AutorFactory(diretorio);
        Autor a = factory.lookup(codigo);
        if(a !=null){
            factory.excluir(a);
            JOptionPane.showMessageDialog(null,"Autor Excluido");
        }
        else{
            JOptionPane.showMessageDialog(null,"AUTOR NÃO EXISTE","",JOptionPane.ERROR_MESSAGE);
        }
        menu.setVisible(true);
    }
    
  
}
