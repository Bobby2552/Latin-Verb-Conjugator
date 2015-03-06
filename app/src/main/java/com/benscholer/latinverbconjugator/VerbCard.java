package com.benscholer.latinverbconjugator;

import android.content.Context;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import it.gmariotti.cardslib.library.internal.Card;
import it.gmariotti.cardslib.library.internal.CardHeader;

/**
 * Created by benscholer on 3/6/15.
 */
public class VerbCard extends Card {

	private TextView textView;
	private String content;

	public VerbCard(Context context, String headerTitle, String content) {
		super(context, R.layout.verb_card);
		init(headerTitle);
		this.content = content;
	}

	public VerbCard(Context context, int innerLayout, String headerTitle, String content) {
		super(context, innerLayout);
		init(headerTitle);
		this.content = content;
	}

	private void init(String headerTitile) {
		CardHeader header = new CardHeader(getContext());
		header.setButtonOverflowVisible(false);
		header.setTitle(headerTitile);
		this.addCardHeader(header);
		this.setShadow(true);
	}

	@Override
	public void setupInnerViewElements(ViewGroup parent, View view) {
		textView = (TextView) view.findViewById(R.id.view);
		textView.setText(content);
	}
}
