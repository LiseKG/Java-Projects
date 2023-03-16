public class Rutenett {
    public int antRader;
    public int antKolonner;
    public Celle[][] rutene; //dobbel array med celler
    public int antallL;
    
    public Rutenett(int rader,int kolonner){
        antRader = rader;
        antKolonner = kolonner;
        rutene = new Celle[antRader][antKolonner]; //legger inn lengden på arrayen

    }
    public void lagCelle(int rad, int kol){ 
        //lager celler som lever med 0.3 prosent sannsynlighet
         rutene[rad][kol] = new Celle();
       if(Math.random()<=0.33){
        rutene[rad][kol].settLevende();
       }
    }
    public void fyllMedTilfeldigeCeller(){
        //sender en og en celle til lagcelle()
        for(int radnr=0; radnr < antRader; radnr++){
            for(int konr = 0; konr < antKolonner; konr++){
                lagCelle(radnr,konr);
            }
        }
    }
    public Celle hentCelle(int rad, int kol){
        if(rad >= antRader || kol >= antKolonner){
            return null;
        }else if(rad < 0 || kol < 0){
            return null;
        }else{
            return rutene[rad][kol];
        }
        //henter cellene hvis de eksisterer
    }

    public String tegnRutenett(){
        //tegner rutenettet
        String tekst = " ";
        for(int radnr=0; radnr < antRader; radnr++){
            tekst += "<br>"; //fin utskrift
            tekst += "|"; //fin utskift
            for(int konr = 0; konr < antKolonner; konr++){
                tekst += " "+""+rutene[radnr][konr].hentStatusTegn()+" ";
            }
            tekst += "|";
            tekst += "<br>"; //fin utskrift
        }
         tekst += "<br>"; //fin utskrift

         return tekst;
 
    } 
    public void settNaboer(int rad,int kol){
        for (int i = -1; i< 2; i++){
            for(int y = -1; y< 2; y++){
                if(y == 0 && i == 0){
                    //Orginal cellen
                }else{
                    //henter celler objektet
                    Celle cel = hentCelle(rad+i,kol+y);
                    if (cel != null){
                        //legger til naboen
                        rutene[rad][kol].leggTilNabo(cel);
                    }
                }
            }
        }
    }
    public void kobleAlleCeller(){
        //legger inn alle cellene
        for(int rad = 0; rad < antRader; rad++){
            for (int kol = 0; kol < antKolonner; kol++){
                settNaboer(rad,kol);  
            }
        }
    }
    
    public int antallLevende(){
        //teller antall levende celler
        int lev = 0;
        for(int rad = 0; rad < antRader; rad++){
            for (int kol = 0; kol < antKolonner; kol++){
                if(rutene[rad][kol].erLevende()){
                    lev++;
                }
            }
        }
        return lev; //returner antall levenede celler
    }
}
