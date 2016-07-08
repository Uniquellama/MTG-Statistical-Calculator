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
public class CardChanceTester {
    
    Scanner input = new Scanner (System.in);
    Scanner backupInput = new Scanner (System.in);

    
    private double amount;
    private double deckSize;
    private double oneperc;
    private double cardChance;
    private double geometPdf;
    private int lookingSpecAmount; 
   
    
    public CardChanceTester()
    {
        
    }
    
    public CardChanceTester(double cardAmount, double playerDeckSize)
    {
        this.amount = cardAmount;
        this.deckSize = playerDeckSize;
    }
    
    public double cardChanceCalc(double amount, double deckSize) 
    {
        //probability of drawing a card from a full deck based on amount in deck and deck size
        oneperc = (1/deckSize);
        cardChance = amount*oneperc;
        return cardChance;
    }
    
    public double cardChanceCalcPerc(double amount, double deckSize) 
    {
        //probability of drawing a card based on amount in deck and deck size
        oneperc = (1/deckSize)*100;
        cardChance = amount*oneperc;
        return cardChance;
    }
    
    public double firstDrawChance(double amount, double deckSize, double firstDraw)
    {
        //probability of card being in the starting hand
        double geometCdf = 0;
        double geometCdfEqu;        
        for(double i = 1; i <= firstDraw; i++)
        {
            geometCdfEqu = cardChanceCalc(amount, deckSize)*(Math.pow(1-cardChanceCalc(amount, deckSize), i-1));
            geometCdf += geometCdfEqu;
        }
        
       
        return geometCdf;
        
    }
     
    public double firstDrawChancePerc(double amount, double deckSize, double firstDraw)
    {

        double geometCdf = 0;
        double geometCdfEqu;        
        for(double i = 1; i <= firstDraw; i++)
        {
            geometCdfEqu = (cardChanceCalc(amount, deckSize)*(Math.pow(1-cardChanceCalc(amount, deckSize), i-1)))*100;
            geometCdf += geometCdfEqu;
        }
        
       
        return geometCdf;
        
    }
    
    public void geometCdf()
    {
        //Probability of card types being in starting hand based on the amonut of each type and the deck size
        DecimalFormat df = new DecimalFormat("#.000");
        Scanner input = new Scanner(System.in);
        
        double geometCdfLand = 0;
        double geometCdfLandEqu;
        
        double geometCdfSummons = 0;
        double geometCdfSummonsEqu;  
        
        double geometCdfSorceries = 0;
        double geometCdfSorceriesEqu;  
        
        double geometCdfInstants = 0;
        double geometCdfInstantsEqu;  
        
        double geometCdfArtifacts = 0;
        double geometCdfArtifactsEqu; 
        
        double geometCdfSpecific = 0;
        double geometCdfSpecificEqu;
        
        System.out.println("How many card in your deck?");
        int deckSize = input.nextInt();
        System.out.println("How many cards in your starting hand?");
        int handSize = input.nextInt();
        
        System.out.println("How many land in your deck?");
        int land = input.nextInt();
        System.out.println("How many summons in your deck?");
        int summons = input.nextInt();
        System.out.println("How many sorceries in your deck?");
        int sorceries = input.nextInt();
        System.out.println("How many instants in your deck?");
        int instants = input.nextInt();
        System.out.println("How many artifacts in your deck?");
        int artifacts = input.nextInt();
        
        System.out.println("Are you looking for a specific card?");
        String lookingSpec = input.nextLine();
        
        System.out.println("How many of it is in your deck?");
        int lookingSpecAmount = input.nextInt();
        
        for(double i = 1; i <= handSize; i++)
        {
            geometCdfLandEqu = (cardChanceCalc(land, deckSize)*(Math.pow(1-cardChanceCalc(land, deckSize), i-1)))*100;
            geometCdfLand += geometCdfLandEqu;
            
            geometCdfSummonsEqu = (cardChanceCalc(summons, deckSize)*(Math.pow(1-cardChanceCalc(summons, deckSize), i-1)))*100;
            geometCdfSummons += geometCdfSummonsEqu;
            
            geometCdfSorceriesEqu = (cardChanceCalc(sorceries, deckSize)*(Math.pow(1-cardChanceCalc(sorceries, deckSize), i-1)))*100;
            geometCdfSorceries += geometCdfSorceriesEqu;
            
            geometCdfInstantsEqu = (cardChanceCalc(instants, deckSize)*(Math.pow(1-cardChanceCalc(instants, deckSize), i-1)))*100;
            geometCdfInstants += geometCdfInstantsEqu;
            
            geometCdfArtifactsEqu = (cardChanceCalc(artifacts, deckSize)*(Math.pow(1-cardChanceCalc(artifacts, deckSize), i-1)))*100;
            geometCdfArtifacts += geometCdfArtifactsEqu;
            
            if(lookingSpec.equals("Yes") || lookingSpec.equals("yes"))
            {
                geometCdfSpecificEqu = (cardChanceCalc(lookingSpecAmount, deckSize)*(Math.pow(1-cardChanceCalc(lookingSpecAmount, deckSize), i-1)))*100;
                geometCdfSpecific += geometCdfSpecificEqu; 
            }
        }
        System.out.println("Starting hand draw chances:");
        System.out.println("Land:        " + df.format(geometCdfLand) + "%.");
        System.out.println("A Summon:    " + df.format(geometCdfSummons) + "%.");
        System.out.println("A Sorcery:   " + df.format(geometCdfSorceries) + "%.");
        System.out.println("An Instant:  " + df.format(geometCdfInstants) + "%.");
        System.out.println("An Artifact: " + df.format(geometCdfArtifacts) + "%.");
        System.out.println("A Specific:  " + df.format(geometCdfSpecific) + "%.");
        
    }
    
    public void geometCdfTypes(int land, int summons, int sorceries, int instants, int artifacts, int deckSize, int handSize)
    {
        //Probability of card types being in starting hand based on the amonut of each type and the deck size
        DecimalFormat df = new DecimalFormat("#.000");
        Scanner input = new Scanner(System.in);
        
        double geometCdfLand = 0;
        double geometCdfLandEqu;
        
        double geometCdfSummons = 0;
        double geometCdfSummonsEqu;  
        
        double geometCdfSorceries = 0;
        double geometCdfSorceriesEqu;  
        
        double geometCdfInstants = 0;
        double geometCdfInstantsEqu;  
        
        double geometCdfArtifacts = 0;
        double geometCdfArtifactsEqu; 
        
        double geometCdfSpecific = 0;
        double geometCdfSpecificEqu;
        
        System.out.println("Are you looking for a specific card?");
        String lookingSpec = input.nextLine();
        if(lookingSpec.equals("Yes")||lookingSpec.equals("yes"))
        {
            System.out.println("How many of it is in your deck?");
            lookingSpecAmount = input.nextInt();
        }
        
        //System.out.println("Did you go first?");
        //String goFirst = backupInput.nextLine();
        //if(goFirst.equals("No")||goFirst.equals("no"))
        //{
        //    handSize =+ 1;
        //}
        
        
        for(double i = 1; i <= handSize; i++)
        {
            geometCdfLandEqu = (cardChanceCalc(land, deckSize)*(Math.pow(1-cardChanceCalc(land, deckSize), i-1)))*100;
            geometCdfLand += geometCdfLandEqu;
            
            geometCdfSummonsEqu = (cardChanceCalc(summons, deckSize)*(Math.pow(1-cardChanceCalc(summons, deckSize), i-1)))*100;
            geometCdfSummons += geometCdfSummonsEqu;
            
            geometCdfSorceriesEqu = (cardChanceCalc(sorceries, deckSize)*(Math.pow(1-cardChanceCalc(sorceries, deckSize), i-1)))*100;
            geometCdfSorceries += geometCdfSorceriesEqu;
            
            geometCdfInstantsEqu = (cardChanceCalc(instants, deckSize)*(Math.pow(1-cardChanceCalc(instants, deckSize), i-1)))*100;
            geometCdfInstants += geometCdfInstantsEqu;
            
            geometCdfArtifactsEqu = (cardChanceCalc(artifacts, deckSize)*(Math.pow(1-cardChanceCalc(artifacts, deckSize), i-1)))*100;
            geometCdfArtifacts += geometCdfArtifactsEqu;
            
            if(lookingSpec.equals("Yes") || lookingSpec.equals("yes"))
            {
                geometCdfSpecificEqu = (cardChanceCalc(lookingSpecAmount, deckSize)*(Math.pow(1-cardChanceCalc(lookingSpecAmount, deckSize), i-1)))*100;
                geometCdfSpecific += geometCdfSpecificEqu; 
            }
        }
        System.out.println("Starting hand draw chances:");
        System.out.println("Land:        " + df.format(geometCdfLand) + "%");
        System.out.println("A Summon:    " + df.format(geometCdfSummons) + "%");
        System.out.println("A Sorcery:   " + df.format(geometCdfSorceries) + "%");
        System.out.println("An Instant:  " + df.format(geometCdfInstants) + "%");
        System.out.println("An Artifact: " + df.format(geometCdfArtifacts) + "%");
        if(lookingSpec.equals("Yes") || lookingSpec.equals("yes"))
        {
            System.out.println("A Specific:  " + df.format(geometCdfSpecific) + "%");
        }
        
    }
    
    public double binomPdf(int amount, int deckSize)
    {
        
        double successFact = 1;
        double deckFact = 1;
        
        double success = 1;
        double binomPdfEqu;
        double binomPdf;
        
        double nMinusr = deckSize - success;
        double nMinusrFact = 1;
        
        for(double r = success; r > 0; r--)
        {
            successFact = successFact * r;
        }
        
        for(double n = deckSize; n > 0; n--)
        {
            deckFact = deckFact * n;
        }
        
        for(double i = nMinusr; i > 0; i--)
        {
            nMinusrFact = nMinusrFact * i;
        }
        
        binomPdfEqu = ((((deckFact)/(successFact*(nMinusrFact))*(Math.pow(cardChanceCalc(amount, deckSize), success)))*(Math.pow(1-cardChanceCalc(amount, deckSize), nMinusr))));
        binomPdf = binomPdfEqu;
        return binomPdf;
    }
   
      
      public void cardsLeftChance(int land, int summons, int sorceries, int instants, int artifacts, int deckSize, int handSize)
    {
        //each turn the probability of drawing each card type is calculated by the amount of card types in the library and the deck size
        //the user tells the programme how many cards he/she drew that round as well as how many were put in the library
        Scanner input = new Scanner (System.in);
        
        DecimalFormat df = new DecimalFormat("#.000");      //to round to 3 decimal places
        
        double[] cardsLeft = new double[deckSize];
        double[] cardsLeftLand = new double[deckSize];
        double[] cardsLeftSummons = new double[deckSize];
        double[] cardsLeftSorceries = new double[deckSize];
        double[] cardsLeftInstants = new double[deckSize];
        double[] cardsLeftArtifacts = new double[deckSize];
        
        double x = deckSize - handSize;
        
        int specCard;
        
        double added;
        double subtracted;
        double draws;
        
        int turn = 1;
        
        System.out.println();
        geometCdfTypes(land, summons, sorceries, instants, artifacts, deckSize, handSize);
        
        try
        {
            Thread.sleep(1500);                 //1000 milliseconds is one second.
        } 
        catch(InterruptedException ex)
        {
            Thread.currentThread().interrupt();
        }
        
        /*System.out.println("\nDid you go first?");
        String goFirst = input.nextLine();
        if(goFirst.equals("No") || goFirst.equals("no"))    //extra card is drawn if going second
        {
            x -= 1;
            handSize +=1;
            
            System.out.println("\nYou draw an extra card in your turn\n");
            try
            {
                Thread.sleep(2000);                 //1000 milliseconds is one second.
            } 
            catch(InterruptedException ex)
            {
                Thread.currentThread().interrupt();
            }
        } */

        while((land + summons + sorceries + instants + artifacts) != x)
        {
            System.out.println("\nHow many land cards did you draw in your starting hand?");
            double firstDrawL = input.nextInt();                //how many of each card is drawn in the starting hand
            if(firstDrawL > 0)
            {
                land -= firstDrawL;
            }
        
            System.out.println("How many summon cards did you draw in your starting hand?");
            double firstDrawS = input.nextInt();
            if(firstDrawS > 0)
            {
                summons -= firstDrawS;
            }
            
            System.out.println("How many sorcery cards did you draw in your starting hand?");
            double firstDrawM = input.nextInt();
            if(firstDrawM > 0)
            {
                sorceries -= firstDrawM;
            }
            
            System.out.println("How many instant cards did you draw in your starting hand?");
            double firstDrawI = input.nextInt();
            if(firstDrawI > 0)
            {
                instants -= firstDrawI;
            }
            
            System.out.println("How many artifact cards did you draw in your starting hand?");
            double firstDrawA = input.nextInt();
            if(firstDrawA > 0)
            {
                artifacts -= firstDrawA;
            }
            
            
            
            if(firstDrawL + firstDrawS + firstDrawM + firstDrawI + firstDrawA != handSize)
            {
                land += firstDrawL;             //reset the deck size
                summons += firstDrawS;
                sorceries += firstDrawM;
                instants += firstDrawI;
                artifacts += firstDrawA;
                
                System.out.println();
                System.out.println("----ERROR----");    //to stop incorrect probabilities from mis-type
                try
                {
                    Thread.sleep(2000);                 //1000 milliseconds is one second.
                } 
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                System.out.println(/*\u001B[1m*/"----Cards don't add up to " + handSize + "----");
                try
                {
                    Thread.sleep(2000);                 //1000 milliseconds is one second.
                } 
                catch(InterruptedException ex)
                {
                    Thread.currentThread().interrupt();
                }
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
                }
            else
            {
                System.out.println("\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n\n");
            }
        }
        
            System.out.print("Turn: " + turn);
            System.out.println("  You have " + x + "\b\b cards left in your library\n");
            
        for(int i = cardsLeft.length-handSize-1; i >= 0;/* i--*/)
        { 
            
            //Data for the current turn
            
            cardsLeftLand[i] = ((1/x)*land);
            if(land < 10 && cardsLeftLand[i]*100 > 100)         //formatting
            {
                System.out.println("You have " + land + " land cards left in your library There is a         100% chance of drawing a land card");
            }
            else if(land < 10)                                  //formatting
            {
                System.out.println("You have "  + land + " land cards left in your library there is a        " + df.format(cardsLeftLand[i]*100) + "%  chance of drawing a land card");
            }
            else if (land > 9)                                  //formatting
            {
                System.out.println("You have "  + land + " land cards left in your library there is a        " + df.format(cardsLeftLand[i]*100) + "%  chance of drawing a land card");
            }
            else if ( land > 9 && cardsLeftLand[i]*100 > 100)   //formatting
            {
                System.out.println("You have " + land + " land cards left in your library There is a        100% chance of drawing a land card");
            }
            
            cardsLeftSummons[i] = ((1/x)*summons);
            if(summons < 10 && cardsLeftSummons[i]*100 > 100)
            {
                System.out.println("You have " + summons + " summon cards left in your library There is a      100% chance of drawing a summon card");
            }
            else if(summons < 10)
            {
                System.out.println("You have " + summons + " summon cards left in your library there is a      " + df.format(cardsLeftSummons[i]*100) + "%  chance of drawing a summon card");
            }
            else if (summons > 9)
            {
                System.out.println("You have " + summons + " summon cards left in your library there is a      " + df.format(cardsLeftSummons[i]*100) + "%  chance of drawing a summon card");
            }
            else if (summons > 9 && cardsLeftSummons[i]*100 > 100)
            {
                System.out.println("You have " + summons + " summon cards left in your library There is a     100% chance of drawing a summon card");
            }
            
            cardsLeftSorceries[i] = ((1/x)*sorceries);
            if(sorceries < 10 && cardsLeftSorceries[i]*100 > 100)
            {
                System.out.println("You have " + sorceries + " sorcery cards left in your library There is a       100%  chance of drawing a sorcery card");
            }
            else if(sorceries < 10)
            {
                System.out.println("You have "  + sorceries + " sorcery cards left in your library there is a      " + df.format(cardsLeftSorceries[i]*100) + "%   chance of drawing a sorcery card");
            }
            else if(sorceries > 9)
            {
                System.out.println("You have "  + sorceries + " sorcery cards left in your library there is a     " + df.format(cardsLeftSorceries[i]*100) + "%   chance of drawing a sorcery card");
            }
            else if(sorceries > 9 && cardsLeftSorceries[i]*100 > 100)
            {
                System.out.println("You have " + sorceries + " sorcery cards left in your library There is a       100%  chance of drawing a sorcery card");
            }
            
            cardsLeftInstants[i] = ((1/x)*instants);
            if(instants < 10 && cardsLeftInstants[i]*100 > 100)
            {
                System.out.println("You have " + instants + "  instant cards left in your library There is a      100% chance of drawing an instant card");
            }
            else if (instants < 10)
            {
                System.out.println("You have "  + instants + "  instant cards left in your library there is a     " + df.format(cardsLeftInstants[i]*100) + "%  chance of drawing an instant card");
            }
            else if (instants > 9)
            {
                System.out.println("You have "  + instants + "  instant cards left in your library there is a    " + df.format(cardsLeftInstants[i]*100) + "%  chance of drawing an instant card");
            }
            else if(instants > 9 && cardsLeftInstants[i]*100 > 100)
            {
                System.out.println("You have " + instants + "  instant cards left in your library There is a     100% chance of drawing an instant card");
            }
                
            cardsLeftArtifacts[i] = ((1/x)*artifacts);
            if(cardsLeftArtifacts[i]*100 > 100)
            {
                System.out.println("You have " + artifacts + "  artifact cards left in your library There is a     100%  chance of drawing an artifact card");
            }
            else if (artifacts < 10)
            {
                System.out.println("You have "  + artifacts + "  artifact cards left in your library there is a    " + df.format(cardsLeftArtifacts[i]*100) + "%   chance of drawing an artifact card");
         
            }
            else if(artifacts > 9)
            {
                System.out.println("You have "  + artifacts + "  artifact cards left in your library there is a   " + df.format(cardsLeftArtifacts[i]*100) + "%   chance of drawing an artifact card");
            }
            else if (artifacts > 9 && cardsLeftArtifacts[i]*100 > 100)
            {
                 System.out.println("You have " + artifacts + "  artifact cards left in your library There is a    100%  chance of drawing an artifact card");
            }
            
            
            System.out.println("\nAre you looking for a specific card to draw?");       //repeated every turn in case card is drawn or not needed anymore
            String lookingForCard = backupInput.nextLine();
            if(lookingForCard.equals("Yes") || lookingForCard.equals("yes"))
            {
                System.out.println("\nHow many of that card is left in your library?");
                specCard = input.nextInt();
                cardsLeft[i] = ((1/x)*specCard);
                System.out.println("\nThere is a " + df.format(cardsLeft[i]*100) + "% chance of drawing your card.");
            }
            
            
            //Data input for the next turn
            
            
            System.out.println("\nHow many cards were drawn this turn?");
            draws = input.nextInt();
            if(draws > 0)
            {
                i -= draws /*+ 1*/;     //the amount of cards drawn is taken away from i here so it isn't taken away when specifying 
                //x -= draws;       //how many were drawn. i+1 so that it doesnt take away an extra card because of the loop
            }
            /*else
            {
                i += 1 ;
            }
            */
            
            
            
            System.out.println("How many land cards were drawn or lost?");
            subtracted = input.nextInt();
            if(subtracted > 0)
            {
                land -= subtracted;
                x -= subtracted;
                //i -= subtracted;
            }
            
            System.out.println("How many land cards were added to the deck this turn?");
            added = input.nextInt();
            if(added > 0)
            {
                land += added;
                x += added;
                i += added;
            }
            
            
            System.out.println("How many summon cards were drawn or lost?");
            subtracted = input.nextInt();
            if(subtracted > 0)
            {
                summons -= subtracted;
                x -= subtracted;
                //i -= subtracted;
            }
            
            System.out.println("How many summon cards were added to the deck this turn?");
            added = input.nextInt();
            if(added > 0)
            {
                summons += added;
                x += added;
                i += added;
            }
            
            
            System.out.println("How many sorcery cards were drawn or lost?");
            subtracted = input.nextInt();
            if(subtracted > 0)
            {
                sorceries -= subtracted;
                x -= subtracted;
                //i -= subtracted;
            }
            
            System.out.println("How many sorcery cards were added to the deck this turn?");
            added = input.nextInt();
            if(added > 0)
            {
                sorceries += added;
                x += added;
                i += added;
            }
            
            
            System.out.println("How many instant cards were drawn or lost?");
            subtracted = input.nextInt();
            if(subtracted > 0)
            {
                instants -= subtracted;
                x -= subtracted;
                //i -= subtracted;
            }
            
            System.out.println("How many instant cards were added to the deck this turn?");
            added = input.nextInt();
            if(added > 0)
            {
                instants += added;
                x += added;
                i += added;
            }
            
            
            System.out.println("How many artifact cards were drawn or lost?");
            subtracted = input.nextInt();
            if(subtracted > 0)
            {
                artifacts -= subtracted;
                x -= subtracted;
                //i -= subtracted;
            }
            
            System.out.println("How many artifact cards were added to the deck this turn?");
            added = input.nextInt();
            if(added > 0)
            {
                artifacts += added;
                x += added;
                i += added;
            }
            
            
            turn ++;
            
        }
    
    }
      
    public void amountCardsLeftChance(double amount, int deckSize)
    {
        DecimalFormat df = new DecimalFormat("#.000");
        
        double[] cardsLeft = new double[deckSize];
        
        double x = deckSize;
        
        for(int i = cardsLeft.length-1; i >= 0; i--)
        {
            cardsLeft[i] = ((1/x)*amount);
            x -= 1;
            
            //System.out.println("When there is  " + (i+1) + "  card  left there is a " + df.format(cardsLeft[i]*100) + "% chance of drawing your card");
            
            if(i == 0)
            {
                System.out.println("When there is  " + (i+1) + " card  left there is a " + df.format(cardsLeft[i]*100) + "% chance of drawing your card");
            }
            else if(i < 9)
            {
                System.out.println("When there are " + (i+1) + " cards left there is a " + df.format(cardsLeft[i]*100) + "%  chance of drawing your card");
            }
            else if(cardsLeft[i]*100 < 10)
            {
                System.out.println("When there are " + (i+1) + " cards left there is a " + df.format(cardsLeft[i]*100) + "%  chance of drawing your card");
            }
            else 
            {
                System.out.println("When there are " + (i+1) + " cards left there is a " + df.format(cardsLeft[i]*100) + "% chance of drawing your card");
            }
            
        }

    }
    
}
