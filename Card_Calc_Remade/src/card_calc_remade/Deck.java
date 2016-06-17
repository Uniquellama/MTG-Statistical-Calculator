   /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_calc_remade;
import java.util.ArrayList;
/**
 *
 * @author maxkrawiec
 */
public class Deck {
    
    private int size;
    
    ArrayList<Card> deck;
    
    public Deck(int deckSize)
    {
        size = deckSize;
        deck = new ArrayList<Card>();
    }
    
    public int getSize()
    {
        return this.size;
    }
    
    public ArrayList<Card> getDeck()
    {
        return deck;
    }
    
    
    
}
