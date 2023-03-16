//import java.util.*;
public class Celle{
    boolean levende = false;
    Celle[] naboer = new Celle[8]; //array med 8 celle elementer
    int antLevendeNaboer = 0;
    int antNaboer = 0;

    public void settDoed(){ //sjekker status
        levende = false;
    }
    public void settLevende(){ //sjekker status
        levende = true;
    }
    public boolean erLevende(){ // sjekker status
        if(levende){
            return true;
        }else{
            return false;
        }
    }
    public char hentStatusTegn(){ //returnerer statustegn
        if (erLevende()){
            return 'O';
        }else{
            return 'Ø';
        }
    }
    public void leggTilNabo(Celle nynabo){ //legger til nabo
        naboer[antNaboer] = nynabo;
        antNaboer++;
      
    }

    public void tellLevendeNaboer(){ //teller levende naboer
        antLevendeNaboer = 0;
        for(int i=0; i < antNaboer;i++){
            if (naboer[i].erLevende()){
                antLevendeNaboer++; //øker variabelen
            }
        }
    }
    public void oppdaterStatus(){ //bruker spillets regel til å bestemme status
        if(erLevende() == true){
            if(antLevendeNaboer < 2){
                settDoed();
            }else if(antLevendeNaboer > 3 ){
                settDoed();
            }
        }else if(erLevende()==false){
            if(antLevendeNaboer == 3){
                settLevende();
            }
        }
    }
}

