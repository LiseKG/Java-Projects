
import java.util.Scanner;
import java.util.Random;
import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import javax.swing.*;

public class TrePaRadGUI{

//global verdier
  static ArrayList<Integer> spillerPosisjon = new ArrayList<Integer>();
  static ArrayList<Integer> maskinPosisjon = new ArrayList<Integer>();
  static JFrame spillvindu = new JFrame("Tre Paa Rad");
  static JLabel tekst;

  public static void main(String[] args){
    spillvindu.setSize(300,300);
    spillvindu.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    tekst = new JLabel("tre på rad");
    tekst.setHorizontalAlignment(JLabel.CENTER); 

    spillvindu.add(tekst);
    spillvindu.setVisible(true);
    
    
  // 3 x 3
    char[][] spilleBrett = {{' ','|',' ','|',' '},
                          {'-','+','-','+','-'},
                          {' ','|',' ','|',' '},
                          {'-','+','-','+','-'},
                          {' ','|',' ','|',' '}};

    tegn(spilleBrett);

    //  printspilleBrett(spilleBrett);
    while(true){
      Scanner scan = new Scanner(System.in);
      System.out.println("Skriv in posisjon! (1-9):");
      int spillerPos = scan.nextInt();
      while(spillerPosisjon.contains(spillerPos)||maskinPosisjon.contains(spillerPos)){
        System.out.println("Posisjonenen er tatt, skriv in ny!");
        spillerPos = scan.nextInt();
      }


    //  System.out.println(spillerPos);

      plasser(spilleBrett,spillerPos,"spiller");
      String resultat = sjekkVinner();
      System.out.println(resultat);
        if(resultat != ""){break;}

      Random rand = new Random();
      int maskinPos = rand.nextInt(9) + 1;
      while(maskinPosisjon.contains(maskinPos)|| spillerPosisjon.contains(maskinPos)){
          maskinPos = rand.nextInt(9) + 1;
        }

      plasser(spilleBrett,maskinPos,"maskin");

      printspilleBrett(spilleBrett);
      tegn(spilleBrett);

      resultat = sjekkVinner();
      System.out.println(resultat);
        if(resultat != ""){break;}
      }

    }

  public static void printspilleBrett(char[][] spilleBrett){
    for(char[] row : spilleBrett){
      for(char c : row){
        System.out.print(c);
      }
        System.out.println();
    }

  }
  public static void plasser(char[][] spilleBrett, int pos, String person){
    char symbol = ' ';
    if(person.equals("spiller")){
      symbol = 'X';
      spillerPosisjon.add(pos);
    } else if (person.equals("maskin")){
      symbol = 'O';
      maskinPosisjon.add(pos);

    }
    switch(pos){
      case 1:
        spilleBrett[0][0] = symbol;
        break;
      case 2:
        spilleBrett[0][2] = symbol;
        break;
      case 3:
        spilleBrett[0][4] = symbol;
          break;
      case 4:
        spilleBrett[2][0] = symbol;
        break;
      case 5:
        spilleBrett[2][2] = symbol;
        break;
      case 6:
        spilleBrett[2][4] = symbol;
        break;
      case 7:
          spilleBrett[4][0] = symbol;
          break;
      case 8:
          spilleBrett[4][2] = symbol;
          break;
      case 9:
          spilleBrett[4][4] = symbol;
          break;
      default:
        break;
    }

  }
  public static String sjekkVinner(){
    List topRow = Arrays.asList(1,2,3);
    List midRow = Arrays.asList(4,5,6);
    List botRow = Arrays.asList(7,8,9);

    List leftCol = Arrays.asList(1,4,7);
    List midCol = Arrays.asList(2,5,8);
    List rightCol = Arrays.asList(3,6,9);

    List cross = Arrays.asList(1,5,9);
    List cross2 = Arrays.asList(7,5,3);

    List<List> vinner = new ArrayList<List>();
    vinner.add(topRow);
    vinner.add(midRow);
    vinner.add(botRow);
    vinner.add(leftCol);
    vinner.add(midCol);
    vinner.add(rightCol);
    vinner.add(cross);
    vinner.add(cross2);

    for(List l : vinner){
      if(spillerPosisjon.containsAll(l)){
        tekst.setText("Du vant!");
        return "Gratulerer du vant!!";
      }else if(maskinPosisjon.containsAll(l)){
        tekst.setText("Du tapte!");
        return "maskin vant! Sorry!";
      }else if(spillerPosisjon.size()+maskinPosisjon.size() == 9){
        tekst.setText("Uavgjort!");
        return "Katt, uavgjort!";
      }
    }
    return "";
  }

  public static void tegn(char[][] spilleBrett){
    String innehold = "";
    for(char[] row : spilleBrett){
        for(char c : row){
            if(c == ' '){
                innehold += "&nbsp&nbsp&nbsp";
              }else{
                String test = String.valueOf(c);
                innehold += test;
            }
        }
          innehold += "<br>";
      }
   
    tekst.setText("<html><style>p{color:black;} </style><p>"+innehold+"</p></html>");

  }
}
