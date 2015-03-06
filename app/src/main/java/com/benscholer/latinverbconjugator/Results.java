package com.benscholer.latinverbconjugator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.view.CardViewNative;


public class Results extends ActionBarActivity {

	private ArrayList<VerbCard> cards = new ArrayList<>();
	public CardViewNative cardView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle("Verbs");

		cardView = (CardViewNative) this.findViewById(R.id.carddemo);
		present();
		populate();
	}

	public void present() {
		String prefix;
		prefix = Shared.second.replace("re", "");

		String[] forms = new String[6];
		String[] endigns = {"o", "s", "t", "mus", "tis", "nt"};

		for (int i = 0; i < forms.length; i++) {
			forms[i] = prefix;
		}

		if (Shared.type == 1) {
			forms[0] = Shared.second;
			forms[0] = forms[0].replace("are", "");
		}

		if (Shared.type == 3) {
			forms[0] = Shared.second;
			forms[0] = forms[0].replace("ere", "");
		}

		for (int i = 0; i < forms.length; i++) {
			forms[i] += endigns[i];
		}

		String conjugations = forms[0] + "\t\t\t\t" + forms[3] + "\n" +
				forms[1] + "\t\t\t\t" + forms[4] + "\n" +
				forms[2] + "\t\t\t\t" + forms[5];

		VerbCard card = new VerbCard(this, "Present Indicative Active", conjugations);

		cards.add(card);
	}

	public void populate() {
		for (VerbCard card: cards) {
			cardView.setCard(card);
		}
	}
}
