package com.benscholer.latinverbconjugator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;
import it.gmariotti.cardslib.library.view.CardViewNative;


public class Results extends ActionBarActivity {

	public CardViewNative cardView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);

		cardView = (CardViewNative) this.findViewById(R.id.carddemo);
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

		Card card = new Card(this);

		CardHeader header = new CardHeader(this);
		header.setTitle("Present Active Indicative\n\n" +
				forms[0] + "\t" + forms[4] + "\n" +
				forms[1] + "\t" + forms[5] + "\n" +
				forms[2] + "\t" + forms[6]);

		card.addCardHeader(header);
		card.setShadow(true);
	}
}
