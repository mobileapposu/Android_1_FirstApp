package io.mobile.app.osu.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.widget.RelativeLayout;
import android.widget.TextView;

// This is our new screen, where we're gonna welcome someone.
public class WelcomeActivity extends Activity {

	// When is this called? when the activity is created :)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// always call super!
		super.onCreate(savedInstanceState);
		// this is where we get the intent sent by our MainActivity
		Intent intent = this.getIntent();
		// Here is where we get the extra. Remember that key business i talked about?
		// Now is when we use the key, so the intent knows what information I want.
		String name = intent.getStringExtra(MainActivity.EXTRA_NAME_KEY);
		// Now we get the top level view of our activity, just as before
		RelativeLayout mainView = (RelativeLayout) this.getLayoutInflater().inflate(R.layout.activity_welcome, null);
		// Get the text view that has the id "hello_tv"
		TextView helloText = (TextView) mainView.findViewById(R.id.hello_tv);
		// Set the text of our text view to greet our user
		helloText.setText("Welcome to my dope app, " + name);
		// Set our view to show the updated helloText text field
		setContentView(mainView);
		// and now we're done with our dope app.
	}

}
