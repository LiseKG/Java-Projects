public class Verden {
    public int rader;
    public int kolonner;
    public Rutenett rutenett;
    int genNr = 0; 

    
    public Verden(int rad,int kol){
        rader = rad;
        kolonner = kol;
        rutenett = new Rutenett(rader,kolonner);
        rutenett.fyllMedTilfeldigeCeller(); //fyller tilfeldig celler
        rutenett.kobleAlleCeller(); //kobler de sammen
    }

    public String tegn(){ //tegner brettet
       return rutenett.tegnRutenett();
    }
    public int antallLev(){ //returnerer antall levende
        return rutenett.antallLevende();
    }
    public void oppdatering(){
        genNr++;
        for(int rad = 0; rad < rader; rad++){
             for (int kol = 0; kol < kolonner; kol++){
                //henter celle objekt
                Celle rute = rutenett.hentCelle(rad,kol);
                //teller levende naboer
                 rute.tellLevendeNaboer();
                }
            }
        for(int i= 0; i < rader;i++){
            for(int y=0; y < kolonner;y++){
               Celle celle = rutenett.hentCelle(i,y);
                celle.oppdaterStatus();
                //oppdaterer statusen til cellen
                }
            }

        }
}
        
