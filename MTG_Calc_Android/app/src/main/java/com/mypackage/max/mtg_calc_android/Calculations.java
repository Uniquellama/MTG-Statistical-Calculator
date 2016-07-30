package com.mypackage.max.mtg_calc_android;

import static android.R.attr.y;

/**
 * Created by Max on 29/07/2016.
 */
public class Calculations {

	private int amountLand;
	private int amountCreatures;
	private int amountInstants;
	private int amountSorceries;
	private int amountEnchantments;
	private int amountArtifacts;
	private int amountPlaneswalkers;

	//Numeric values are for testing...
	public Calculations() {
		amountLand = 24; // R.id.amountLand;
		amountCreatures = 10; // R.id.amountCreatures;
		amountInstants = 6; //R.id.amountInstants;
		amountSorceries = 5; //R.id.amountSorceries;
		amountEnchantments = 5; //R.id.amountEnchantments;
		amountArtifacts = 5 ;//R.id.amountArtifacts;
		amountPlaneswalkers = 5; // R.id.amountPlaneswalkers;
	}
	/*
		Fills the array with the amount of each card type (Land, Creatures, Instants, etc.) with each index being a different card type...
		index = 0: Land
		index = 1: Creatures
		index = 2: Instants
		index = 3: Sorceries
		index = 4: Enchantments
		index = 5: Artifacts
		index = 6: Planeswalkers
	*/
	private int[] amountOfCards;
	{
		amountOfCards = new int[]{amountLand, amountCreatures, amountInstants, amountSorceries, amountEnchantments, amountArtifacts, amountPlaneswalkers};
	}




	//The probability of drawing a single card: (amount in deck / deck size)
	private double probabilityOfDraw(int amountOfCardInDeck, int deckSize)
	{
		return amountOfCardInDeck/deckSize;
	}

	//The probability of each card type in the starting hand where "p" is the probabilityOfDraw() and "n" is the hand size
	private double geometricCDF(int cardTypeIndex, int deckSize, int startingHand)
	{
		double p;
		double toReturn = 0;
		for(int i = 1; i < startingHand; i++)
		{
			p = probabilityOfDraw(amountOfCards[cardTypeIndex], deckSize);

			toReturn += p * Math.pow((1-p), i-1);
		}

		return toReturn;
	}
	//Fills an array with the probability of drawing each card type in the starting hand
	private double[] fillStartingHandProbabilities(double[] arrayOfProbabilities, int deckSize, int startingHand)
	{
		int y = 1;
		for (int i = 0; i < arrayOfProbabilities.length; i++)
		{
			arrayOfProbabilities[i] = geometricCDF(y, deckSize, startingHand);
			y++;
		}
		return arrayOfProbabilities;
	}

}
