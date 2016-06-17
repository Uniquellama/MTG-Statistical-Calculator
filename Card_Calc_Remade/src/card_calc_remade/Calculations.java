/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_calc_remade;
import java.util.Scanner;

import card_calc_remade.Deck;
import card_calc_remade.Card;
import java.text.DecimalFormat;
import java.util.ArrayList;
/**
 *
 * @author maxkrawiec
 */
public class Calculations {
    
    int amountLand;
    int amountCreature;
    int amountInstance;
    int amountSorcery;
    int amountArtifact;
    int amountEnchantment;
    int amountPlaneswalker;
    
    Scanner input = new Scanner (System.in);
    
    public void fillDeck(ArrayList<Card> deck)
    {
        //Fills the deck based off what the players specified the amount of cards in the deck are.
        
        Card Land = new Card("Land");
        Card Creature = new Card("Creature");
        Card Instance = new Card("Instance");
        Card Sorcery = new Card("Sorcery");
        Card Artifact = new Card("Artifact");
        Card Enchantment = new Card("Enchantment");
        Card Planeswalker = new Card("Planeswalker");
        
        
        
        System.out.println("How many Land cards?");
        amountLand = input.nextInt();
        
        for(int i = 0; i < amountLand; i++)
        {
            deck.add(Land);
        }
        
        System.out.println("How many Creature cards?");
        amountCreature = input.nextInt();
        
        for(int i = 0; i < amountCreature; i++)
        {
            deck.add(Creature);
        }
        
        System.out.println("How many Instance cards?");
        amountInstance = input.nextInt();
        
        for(int i = 0; i < amountInstance; i++)
        {
            deck.add(Instance);
        }
        
        System.out.println("How many Sorcery cards?");
        amountSorcery = input.nextInt();
        
        for(int i = 0; i < amountSorcery; i++)
        {
            deck.add(Sorcery);
        }
        
        System.out.println("How many Artifact cards?");
        amountArtifact = input.nextInt();
        
        for(int i = 0; i < amountArtifact; i++)
        {
            deck.add(Artifact);
        }
        
        System.out.println("How many Enchantment cards?");
        amountEnchantment = input.nextInt();
        
        for(int i = 0; i < amountEnchantment; i++)
        {
            deck.add(Enchantment);
        }
        
        System.out.println("How many Planeswalker cards?");
        amountPlaneswalker = input.nextInt();
        
        for(int i = 0; i < amountPlaneswalker; i++)
        {
            deck.add(Planeswalker);
        }
        
    }
    
    public int getPercOfOne(Deck deck)
    {
        //Returns what proportion of the deck 1 card is. 
        return 1/deck.getSize();
    }
    
    
    public int amountOfCards(ArrayList<Card> deck, String lookingFor)
    {
        //Returns how many of a specific card type there is in a deck.
        
        int counter = 0;
        
        for(int i = 0; i < deck.size(); i++)
        {
            if(lookingFor.equals(deck.get(i).getType()))
            {
                counter++;
            }
        }
        return counter;
    }
    
    public int probabilityOfDraw(Deck deck, String lookingFor, ArrayList<Card> cards)
    {
        //probability of drawing a card type based off of what's specified.
        return amountOfCards(cards, lookingFor)*getPercOfOne(deck);
    }
    
    public void geometCdf(Deck deck, int handSize, ArrayList<Card> cards)
    {
        //Probability of card types being in starting hand based on the amonut of each type and the deck size.
        
        int amountLand = amountOfCards(cards, "Land");
        int amountCreature = amountOfCards(cards, "Creature");
        int amountSorcery = amountOfCards(cards, "Sorcery");
        int amountInstance = amountOfCards(cards, "Instance");
        int amountEnchantment = amountOfCards(cards, "Enchantment");
        int amountPlaneswalker = amountOfCards(cards, "Planeswalker");
        
        DecimalFormat df = new DecimalFormat("#.000");
        
        
        double geometCdfLand = 0;
        double geometCdfLandEqu;
        
        double geometCdfCreature = 0;
        double geometCdfCreatureEqu;  
        
        double geometCdfSorcery = 0;
        double geometCdfSorceryEqu;  
        
        double geometCdfInstant = 0;
        double geometCdfInstantEqu;  
        
        double geometCdfEnchantment = 0;
        double geometCdfEnchantmentEqu; 
        
        double geometCdfPlaneswalker = 0;
        double geometCdfPlaneswalkerEqu; 
        
        for(int i = 1; i <= handSize; i++)
        {
            geometCdfLandEqu = probabilityOfDraw(deck,"Land", cards)*Math.pow((1-probabilityOfDraw(deck,"Land", cards)), i-1);
            geometCdfLand += geometCdfLandEqu;
            
            geometCdfCreatureEqu = probabilityOfDraw(deck,"Creature", cards)*Math.pow((1-probabilityOfDraw(deck,"Creature", cards)), i-1);
            geometCdfCreature += geometCdfCreatureEqu;
            
            geometCdfSorceryEqu = probabilityOfDraw(deck,"Sorcery", cards)*Math.pow((1-probabilityOfDraw(deck,"Sorcery", cards)), i-1);
            geometCdfSorcery += geometCdfSorceryEqu;
            
            geometCdfInstantEqu = probabilityOfDraw(deck,"Instant", cards)*Math.pow((1-probabilityOfDraw(deck,"Instant", cards)), i-1);
            geometCdfInstant += geometCdfInstantEqu;
            
            geometCdfEnchantmentEqu = probabilityOfDraw(deck,"Enchantment", cards)*Math.pow((1-probabilityOfDraw(deck,"Enchantment", cards)), i-1);
            geometCdfEnchantment += geometCdfEnchantmentEqu;
            
            geometCdfPlaneswalkerEqu = probabilityOfDraw(deck,"Planeswalker", cards)*Math.pow((1-probabilityOfDraw(deck,"Planeswalker", cards)), i-1);
            geometCdfPlaneswalker += geometCdfPlaneswalkerEqu;
        }
        
        System.out.println("Starting hand draw chances:");
        System.out.println("Land:                " + df.format(geometCdfLand) + "%");
        System.out.println("A Creature:          " + df.format(geometCdfCreature) + "%");
        System.out.println("A Sorcery:           " + df.format(geometCdfSorcery) + "%");
        System.out.println("An Instant:          " + df.format(geometCdfInstant) + "%");
        System.out.println("An Enchantment:      " + df.format(geometCdfEnchantment) + "%");
        System.out.println("An Planeswalker:     " + df.format(geometCdfPlaneswalker) + "%");
    }
    
    public void usedCard()
    {
        Scanner input = new Scanner (System.in);
        //DecimalFormat df = new DecimalFormat("#.000"); 
        
        System.out.println("How many cards did you play this turn?");
        int amountPlayed = input.nextInt();
    }
    
    
    
}
