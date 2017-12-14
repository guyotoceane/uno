package upmc.game;


import java.util.ArrayList;

public class Paquet {
    private String color_card[] = {"0","1","2","3","4","5","6","7","8","9","interdit","changement","plus2"};
    private String color[] = {"jaune", "bleu", "rouge", "vert"};
    private String joker_card[] = {"changement","plus4"};
    private ArrayList<Carte> paquet =new ArrayList();

    public static ArrayList<Carte> paquet_melange =new ArrayList();

    private void create(){
        for (int i = 0; i < color.length; i++) {
            for (int j = 0; j < color_card.length; j++) {
                Carte carte = new ColorCard(color[i], color_card[j]);
                paquet.add(carte);


                if(!color_card[j].equals("0")){
                    paquet.add(carte);
                }

            }
        }

        for(int k=0; k<4 ; k++){
            Carte changement = new ColorCard("joker", joker_card[0]);
            paquet.add(changement);

            Carte plus4 = new ColorCard("joker", joker_card[1]);
            paquet.add(plus4);
        }
    }

    private void melange() {
        for (int k = 0; k < 108; k++) {
            int random = (int) (Math.random() * (108 - k));
            paquet_melange.add(paquet.get(random));
            this.paquet.remove(paquet.get(random));
        }
    }

    public void init(){
        create();
        melange();
    }
}