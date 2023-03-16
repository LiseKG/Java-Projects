import javax.swing.*;
import java.awt.*;

public class GameofLifeFrame{
    int versjon = 0;
    JFrame vindu = new JFrame("Game of Life");
    JLabel lab;
    JLabel tekst;
    Font font = new Font("Arial",0, 20); 
    String brett;
    JButton Knapp;
    Verden verden = new Verden(5,5);
    public static void main(String[] args){

        new GameofLifeFrame();

    }
    public GameofLifeFrame(){
        vindu.setSize(600,600);
        vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        vindu.setLayout(null);
        vindu.getContentPane().setBackground(new Color(255, 233, 161));

        brett = verden.tegn(); //brettet i game of life
        lab = new JLabel("<html>" +brett); // legger til i vinduet
        lab.setHorizontalAlignment(JLabel.CENTER); //midtstiller
        lab.setFont(font);
        
        lab.setBounds(0,0,600,600); //setter posisjon
        vindu.add(lab);

        tekst = new JLabel("Versjon 0"); // legger til i vinduet
        tekst.setFont(font);
        tekst.setBounds(250,0,500,100); //setter posisjon
        vindu.add(tekst);
        
        //lager knapper
        JButton nyBrettKnapp = new JButton("lag nytt brett!");
        JButton oppdaterKnapp = new JButton("Oppdater brettet!");
       
       //setter posisjon
        nyBrettKnapp.setBounds(200,500,100,50);
        oppdaterKnapp.setBounds(300,500,150,50);

        //legger til egenskaper
        nyBrettKnapp.addActionListener(e -> nyVerden()); 
        oppdaterKnapp.addActionListener(e -> oppdaterVerden());
       //legger inn i vinduet
        vindu.add(nyBrettKnapp);
        vindu.add(oppdaterKnapp);
        vindu.setVisible(true);
    }
    
    public void oppdaterVerden(){
        //oppdaterer brettet
       versjon++;
       verden.oppdatering();
        brett = verden.tegn();
        lab.setText("<html>"+ brett);
        tekst.setText("<html>Versjon "+versjon + "<br> antall levende: "+verden.antallLev());

    }
    public void nyVerden(){
        //lager ny brett/verden
        versjon = 0;
        tekst.setText("<html>Versjon "+versjon + "<br> antall levende: "+verden.antallLev());
        verden = new Verden(5,5);
        brett = verden.tegn();
        lab.setText("<html>"+ brett);

        
    }
}
   
   
