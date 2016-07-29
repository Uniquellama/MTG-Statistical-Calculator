/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package card_calc_remade;

/**
 *
 * @author maxkrawiec
 */
public class Card{
    
    private String type;
    private String colour;
    private String cost;
    
    public Card(String cardType, String cardColour, String cardCost)
    {
        type = cardType;
        colour = cardColour;
        cost = cardCost;
    }
    
    public Card(String cardType)
    {
        type = cardType;
    }
    
    public String toString()
    {
    	return type;
    }
    
    public String getType()
    {
        return this.type;
    }
    
    public String getColour()
    {
        return this.colour;
    }
    
    public String getCost()
    {
        return this.cost;
    }
    
}
