package com.benscholer.latinverbconjugator;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.widget.Toolbar;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;


public class Main extends ActionBarActivity {

	EditText first;
	EditText second;
	EditText third;
	EditText fourth;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
		toolbar.setTitle("Latin Conjugation Tool");
	}

	public void conjugate(View view) {

		first = (EditText) findViewById(R.id.first);
		second = (EditText) findViewById(R.id.second);
		third = (EditText) findViewById(R.id.third);
		fourth = (EditText) findViewById(R.id.fourth);

		try {
			Shared.first = first.getText().toString();
			Shared.second = second.getText().toString();
			Shared.third = third.getText().toString();
			Shared.fourth = fourth.getText().toString();
		} catch (Exception e) {
			Toast.makeText(this, "Check verbs and try again.", Toast.LENGTH_LONG).show();
		}

		String last_three = Shared.second.substring(Shared.second.length() - 3);

		switch (last_three) {
			case "are":
				Shared.type = 1;
				break;
			case "ēre":
				Shared.type = 2;
				break;
			case "ere":
				Shared.type = 3;
				break;
			case "ire":
				Shared.type = 4;
				break;
			default:
				Shared.type = 0;
				break;
		}

		startActivity(new Intent(this, Results.class));
	}
}
