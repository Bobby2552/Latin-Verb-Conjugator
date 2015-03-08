package com.benscholer.latinverbconjugator;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;

import java.util.ArrayList;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardArrayAdapter;
import it.gmariotti.cardslib.library.view.CardListView;


public class Results extends ActionBarActivity {

	private ArrayList<Card> cards = new ArrayList<>();
	public CardListView cardView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_results);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle(Shared.second);

		presentIndicativeActive();
		presentIndicativePassive();

		imperfectIndicativeActive();
		imperfectIndicativePassive();
		imperfectSubjunctiveActive();

		perfectIndicativeActive();
		perfectIndicativePassive();

		pluperfectIndicativeActive();
		pluperfectSubjunctiveActive();

		CardArrayAdapter mCardArrayAdapter = new CardArrayAdapter(this, cards);

		CardListView listView = (CardListView) findViewById(R.id.list_view);
		if (listView != null) {
			listView.setAdapter(mCardArrayAdapter);
		}
	}

	public void presentIndicativeActive() {
		String prefix;
		prefix = Shared.second.replace("re", "");

		String[] forms = new String[6];
		String[] endings = {"o", "s", "t", "mus", "tis", "nt"};

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
			forms[i] += endings[i];
		}

		String conjugations = "\t\t" + forms[0] + "\t\t\t\t" + forms[3] + "\n" +
				"\t\t" + forms[1] + "\t\t\t\t" + forms[4] + "\n" +
				"\t\t" + forms[2] + "\t\t\t\t" + forms[5];

		VerbCard card = new VerbCard(this, "Present Indicative Active", conjugations);

		cards.add(card);
	}

	public void presentIndicativePassive() {
		String prefix;

		String[] forms = new String[6];
		String[] first_endings = {"or", "aris", "atur", "amur", "amini", "antur"};
		String[] second_endings = {"ēor", "ēris", "ētur", "ēmur", "ēmini", "ēntur"};
		String[] third_endings = {"or", "eris", "itur", "imur", "imini", "untur"};
		String[] fourth_endings = {"ior", "iris", "itur", "imur", "imini", "iuntur"};

		if (Shared.type == 1) {
			for (int i = 0; i < forms.length; i++) {
				forms[i] = Shared.second.replace("are", "");
				forms[i] += first_endings[i];
			}
		}

		if (Shared.type == 2) {
			for (int i = 0; i < forms.length; i++) {
				forms[i] = Shared.second.replace("ēre", "");
				forms[i] += second_endings[i];
			}
		}

		if (Shared.type == 3) {
			for (int i = 0; i < forms.length; i++) {
				forms[i] = Shared.second.replace("ere", "");
				forms[i] += third_endings[i];
			}
		}

		if (Shared.type == 4) {
			for (int i = 0; i < forms.length; i++) {
				forms[i] = Shared.second.replace("ire", "");
				forms[i] += fourth_endings[i];
			}
		}

		String conjugations = "\t\t" + forms[0] + "\t\t\t\t" + forms[3] + "\n" +
				"\t\t" + forms[1] + "\t\t\t\t" + forms[4] + "\n" +
				"\t\t" + forms[2] + "\t\t\t\t" + forms[5];

		VerbCard card = new VerbCard(this, "Present Indicative Passive", conjugations);

		cards.add(card);
	}

	public void imperfectIndicativeActive() {
		String prefix;
		prefix = Shared.second.replace("re", "");

		String[] forms = new String[6];
		String[] endings = {"bam", "bas", "bat", "bamus", "batis", "bant"};

		for (int i = 0; i < forms.length; i++) {
			forms[i] = prefix;
			if (Shared.type == 4) forms[i] += "e";
			forms[i] += endings[i];
		}

		String conjugations = "\t\t" + forms[0] + "\t\t\t\t" + forms[3] + "\n" +
				"\t\t" + forms[1] + "\t\t\t\t" + forms[4] + "\n" +
				"\t\t" + forms[2] + "\t\t\t\t" + forms[5];

		VerbCard card = new VerbCard(this, "Imperfect Indicative Active", conjugations);

		cards.add(card);
	}

	public void imperfectIndicativePassive() {
		String prefix;

		String[] forms = new String[6];
		String[] endings = {"bar", "baris", "batur", "bamur", "bamini", "bantur"};

		if (Shared.type == 1) {
			for (int i = 0; i < forms.length; i++) {
				forms[i] = Shared.second.replace("re", "");
				forms[i] += endings[i];
			}
		}

		if (Shared.type == 2) {
			for (int i = 0; i < forms.length; i++) {
				forms[i] = Shared.second.replace("re", "");
				forms[i] += endings[i];
			}
		}

		if (Shared.type == 3) {
			for (int i = 0; i < forms.length; i++) {
				forms[i] = Shared.second.replace("re", "");
				forms[i] += endings[i];
			}
		}

		if (Shared.type == 4) {
			for (int i = 0; i < forms.length; i++) {
				forms[i] = Shared.second.replace("re", "");
				forms[i] += "e" + endings[i];
			}
		}

		String conjugations = "\t\t" + forms[0] + "\t\t\t\t" + forms[3] + "\n" +
				"\t\t" + forms[1] + "\t\t\t\t" + forms[4] + "\n" +
				"\t\t" + forms[2] + "\t\t\t\t" + forms[5];

		VerbCard card = new VerbCard(this, "Imperfect Indicative Passive", conjugations);

		cards.add(card);
	}

	public void imperfectSubjunctiveActive() {
		String prefix;
		prefix = Shared.second;

		String[] forms = new String[6];
		String[] endings = {"m", "s", "t", "mus", "tis", "nt"};

		for (int i = 0; i < forms.length; i++) {
			forms[i] = prefix;
			forms[i] += endings[i];
		}

		String conjugations = "\t\t" + forms[0] + "\t\t\t\t" + forms[3] + "\n" +
				"\t\t" + forms[1] + "\t\t\t\t" + forms[4] + "\n" +
				"\t\t" + forms[2] + "\t\t\t\t" + forms[5];

		VerbCard card = new VerbCard(this, "Imperfect Subjunctive Active", conjugations);

		cards.add(card);
	}

	public void perfectIndicativeActive() {
		String prefix;
		prefix = Shared.third.replace("i", "");

		String[] forms = new String[6];
		String[] endings = {"i", "isti", "it", "imus", "istis", "erunt"};

		for (int i = 0; i < forms.length; i++) {
			forms[i] = prefix;
			forms[i] += endings[i];
		}

		String conjugations = "\t\t" + forms[0] + "\t\t\t\t" + forms[3] + "\n" +
				"\t\t" + forms[1] + "\t\t\t\t" + forms[4] + "\n" +
				"\t\t" + forms[2] + "\t\t\t\t" + forms[5];

		VerbCard card = new VerbCard(this, "Perfect Indicative Active", conjugations);

		cards.add(card);
	}

	public void perfectIndicativePassive() {
		String prefix;
		prefix = Shared.fourth;

		String[] forms = new String[6];
		String[] endings = {" sum", " es", " est", " sumus", " estis", " sunt"};

		for (int i = 0; i < forms.length; i++) {
			forms[i] = prefix;
			forms[i] += endings[i];
		}

		String conjugations = "\t\t" + forms[0] + "\t\t\t\t" + forms[3] + "\n" +
				"\t\t" + forms[1] + "\t\t\t\t" + forms[4] + "\n" +
				"\t\t" + forms[2] + "\t\t\t\t" + forms[5];

		VerbCard card = new VerbCard(this, "Perfect Indicative Passive", conjugations);

		cards.add(card);
	}

	public void pluperfectIndicativeActive() {
		String prefix;
		prefix = Shared.third.replace("i", "");

		String[] forms = new String[6];
		String[] endings = {"eram", "eras", "erat", "eramus", "eratis", "erant"};

		for (int i = 0; i < forms.length; i++) {
			forms[i] = prefix;
			forms[i] += endings[i];
		}

		String conjugations = "\t\t" + forms[0] + "\t\t\t\t" + forms[3] + "\n" +
				"\t\t" + forms[1] + "\t\t\t\t" + forms[4] + "\n" +
				"\t\t" + forms[2] + "\t\t\t\t" + forms[5];

		VerbCard card = new VerbCard(this, "Pluperfect Indicative Active", conjugations);

		cards.add(card);
	}

	public void pluperfectSubjunctiveActive() {
		String prefix;
		prefix = Shared.third + "sse";

		String[] forms = new String[6];
		String[] endings = {"m", "s", "t", "mus", "tis", "nt"};

		for (int i = 0; i < forms.length; i++) {
			forms[i] = prefix;
			forms[i] += endings[i];
		}

		String conjugations = "\t\t" + forms[0] + "\t\t\t\t" + forms[3] + "\n" +
				"\t\t" + forms[1] + "\t\t\t\t" + forms[4] + "\n" +
				"\t\t" + forms[2] + "\t\t\t\t" + forms[5];

		VerbCard card = new VerbCard(this, "Pluperfect Subjunctive Active", conjugations);

		cards.add(card);
	}

}