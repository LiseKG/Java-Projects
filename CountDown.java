import java.awt.*;
import java.awt.event.*;
import java.util.Scanner;
import javax.swing.*;
import java.awt.Font;


public class CountDown{
    ImageIcon img;
    JFrame vindu = new JFrame("Timer");
    Timer timer;
    JLabel lab;
    JButton stop;
    JButton start;
    int second = 0;
    int minutes = 50;
    Font font = new Font("Arial",0, 40); 
    public static void main(String[] args){

        new CountDown();
        
        
    }
    public CountDown(){
       vindu.setSize(300,200);
       vindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       vindu.setLayout(null);
       vindu.getContentPane().setBackground(new Color(255, 233, 161));

    //  JPanel panel = new JPanel();
      // vindu.add(panel);

      lab = new JLabel("Start timeren!");
       lab.setHorizontalAlignment(JLabel.CENTER);
        lab.setFont(font);
      // JButton tidKnapp = new JButton("Exit");
       // panel.add(tidKnapp);

       stop = new JButton("stop!");
       stop.addActionListener(e-> knappStop());

       start = new JButton("start!");
       start.addActionListener(e-> knappStart());
       lab.setBounds(0,0,300,100);
       start.setBounds(0,100,50,50);
       stop.setBounds(50,100,50,50);
       vindu.add(lab);
       vindu.add(stop);
       vindu.add(start);
        vindu.setVisible(true);
       // img = new ImageIcon("test.jpg");


       // second = 0;
        //minutes = 50;
       // Scanner inp = new Scanner(System.in);
       // System.out.println("Hvor lenge");
       // int tall = inp.nextLine();
     //   while(tall > 60){
       //     minutes++;
         //   second = second-60;
        //}
        

        countdowntimer();
    
    }
    
    public void simpleTimer(){
        timer = new Timer(1000, new ActionListener(){
            
            @Override
            public void actionPerformed(ActionEvent e){
                //System.out.print(second);
                second++;
                //System.out.print(second);
                if(second == 60){
                    second = 0;
                    minutes++;

                }
                if(second == 100){timer.stop(); System.out.print(second); }
    
               lab.setText(minutes+ ":" +second);
            }
        });
    }

    public void countdowntimer(){
        timer = new Timer(1000, new ActionListener(){
            
            public void actionPerformed(ActionEvent e){
                second--;

                if(second < 0){
                    second = 59;
                    minutes--;
                }
                if(minutes == 0 && second==0){
                    System.out.println("HER");
                    timer.stop();
                    
                }
                lab.setText(minutes+ ":" +second);

            }
        });
    }
    public void knappStart(){
        timer.start();
    }

    public void knappStop(){
        timer.stop();

}
}

