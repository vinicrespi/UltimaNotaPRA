package Main;

import GUI.Menu;

public class Main {
    
    private final String diretorio;
    private final Menu menu = new Menu();
    
    public Main(String diretorio) {
        this.diretorio = diretorio;
    }
    
    
    
    public static void main(String[] args){
       Menu menu = new Menu();
       menu.setVisible(true);
        
    }
    
}
