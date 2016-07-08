/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package mtg_cardchance_algorythm;

import java.util.Scanner;
import java.text.DecimalFormat;


/**
 *
 * @author maxkrawiec
 */
public class MTG_CardChance_Algorythm {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        
        int deckSize;
        int amount;
        int firstHandSize;
        int land;
        int summons;
        int sorceries;
        int instants;
        int artifacts;
        
        //int i = 1;
        //String cardName = "Sire of Stagnation";
        
        CardChanceTester MTG = new CardChanceTester();
        
        
        Scanner input = new Scanner (System.in);
        

        System.out.println("How big is the deck?");
        deckSize = input.nextInt();
        
        System.out.println("How big is the Starting Hand?");
        firstHandSize = input.nextInt();
        
        System.out.println("How many land cards are in your deck?");
        land = input.nextInt();
        
        System.out.println("How many summon cards are in your deck?");
        summons = input.nextInt();
        
        System.out.println("How many sorcery cards are in your deck?");
        sorceries = input.nextInt();
        
        System.out.println("How many instant cards are in your deck?");
        instants = input.nextInt();
        
        System.out.println("How many artifact cards are in your deck?");
        artifacts = input.nextInt();
        
        if(land+summons+sorceries+instants+artifacts != deckSize)
        {
            System.out.println();
            System.out.println("----ERROR----");
            try
            {
                Thread.sleep(2000);                 //1000 milliseconds is one second.
            } 
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
                System.out.println("----Cards don't add up to " + deckSize  + "----");
            try
            {
                Thread.sleep(2000);                 //1000 milliseconds is one second.
            } 
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            
        while(land+summons+sorceries+instants+artifacts != deckSize)
        {
            System.out.println("How big is the deck?");
        deckSize = input.nextInt();
        
        System.out.println("How big is the Starting Hand?");
        firstHandSize = input.nextInt();
        
        System.out.println("How many land cards are in your deck?");
        land = input.nextInt();
        
        System.out.println("How many summon cards are in your deck?");
        summons = input.nextInt();
        
        System.out.println("How many sorcery cards are in your deck?");
        sorceries = input.nextInt();
        
        System.out.println("How many instant cards are in your deck?");
        instants = input.nextInt();
        
        System.out.println("How many artifact cards are in your deck?");
        artifacts = input.nextInt();
        }
        }
        
        
        //System.out.println(MTG.drawStats(cardName, amount, deckSize, firstHand) + "\n\n");
        //System.out.println(MTG.typeStats(land, summons, sorceries, instants, artifacts) + "\n\n\n");
        MTG.cardsLeftChance(land, summons, sorceries, instants, artifacts, deckSize, firstHandSize);
        //MTG.landCardsLeftChance(land, deckSize, firstHand);
        
        int k = (int)(Math.random()+1);
        for(int p = 2; p <=k; p++)
        {
            for(int r = 1; r < k; r++)
            {
                
            }
        }
    }
    
}
