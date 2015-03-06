package com.benscholer.latinverbconjugator;

import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardViewNative;


public class Results extends ActionBarActivity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);

		//Create a Card
		Card card = new Card(this);

		//Create a CardHeader
		CardHeader header = new CardHeader(this);

		//Add Header to card
		card.addCardHeader(header);

		//Set card in the cardView
		CardViewNative cardView = (CardViewNative) this.findViewById(R.id.carddemo);
		cardView.setCard(card);
	}
}
