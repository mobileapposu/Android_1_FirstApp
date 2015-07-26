package io.mobile.app.osu.android;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RelativeLayout;

/*
	Activities essentially represent screens in Android.
	This is the main activity which will just show a text box where the user can enter their name.
	Activities have something called a life cycle. This just means that
	the Android operating system calls certain functions when the user interacts with your app.
	So if your user closes your app, or leaves your app, different methods are called. The important
	lifecycle methods are overrided in this class and described, so you know when they're called.
 */
public class MainActivity extends Activity {

	// This is the key to an extra. An extra is a piece of data that we can transfer between activites.
	// We put extras in something called an Intent, explained further below. Extras
	// are put into a map, which is just a collection of pairs. Each pair is a key and a value.
	// To get a certain value from the map, we have to give it the key.
	public final static String EXTRA_NAME_KEY = "EXTRA_NAME_KEY";
	// This creates a new EditText variable, which is an editable text box, where the user will
	// enter their name. This is a private instance variable. Private instance variables in classes
	// are generally prefixed with a lowercase 'm'. This is a style popularized by Google and used
	// at many companies, but not necessary. This is mainly preference. I'll do it here because I think
	// it's helpful.
	private EditText mNameText;


	// onCreate is a lifecycle method! This is called when the android operating system first
	// creates your activity. It is the first method called in an activity.
	// In here, apps should set up their user interface, and initialize their private instance variables
	// (e.g. nameText)
	@Override
	protected void onCreate(Bundle savedInstanceState) {
		// In each lifecycle method, make sure to call super. This is necessary for Android
		// to set up resources related to this activity.
		super.onCreate(savedInstanceState);
		// This line gets a reference to the RelativeLayout in our view. This is basically the top-level
		// container of our view. To explain the "R.layout.activity_main" part:
		// Basically, any time you update an xml file in the "res" folder, a new "R" file is generated
		// by Android Studio. This R file contains references to all your resource files, which are
		// easily accessible through code.
		RelativeLayout mainView = (RelativeLayout) this.getLayoutInflater().inflate(R.layout.activity_main, null);
		// This line takes the mainView we just retrieved, and finds a view inside of it
		// with the id "enter_btn". This is the button for the user to go to the next screen.
		// Notice how we have "(Button)" to do something called casting. This makes it so
		// the regular view returned by findViewById() can be read as a Button object.
		Button enterButton = (Button) mainView.findViewById(R.id.enter_btn);
		// Similarly, this line gets the editable text field by the id "name_et" and stores it
		// inside mNameText.
		mNameText = (EditText) mainView.findViewById(R.id.name_et);
		// This sets the click listener for the enterButton. A listener in Android is essentially
		// a callback, if you're familiar with that terminology. For the complete newbies, just think
		// of this as a way to tell Android "hey, when my enterButton is clicked, I want you to
		// tell this listener." This is technically called an anonymous inner class, since we
		// construct a new class that implements View.OnClickListener, but don't give it a name
		// (hence anonymous) and instead just implement the necessary method: onClick. That's not
		// super important now, but good to know later.

		enterButton.setOnClickListener(new View.OnClickListener() {
			// This onClick function is called any time the enterButton is clicked.
			// the argument "v" here refers to what view was clicked.
			@Override
			public void onClick(View v) {
				// When the button is clicked, that means we should go to the next activity.
				// It's recommended to only have a few lines of code inside of an anonymous inner class
				// such as this, just because we're already indented 4 tabs in, and a couple if
				// statements and for loops could make it unreadable quick. So here we just call a function
				// to handle the details for us. This is also a good strategy for automated testing,
				// since it's hard to automate a human pressing a button.
				transferActivities();
			}
		});
		// Here we set our UI (user interface) to the mainView we retrieved from the activity_main.xml file.
		// note that this is at the end of the method. If we retrieve mainView by getLayoutInflater(),
		// then modify it as we do here (by setting the button onClickListener), then we need to
		// set the content view at the end.
		setContentView(mainView);
	}

	// This function leaves the MainActivity and launches the WelcomeActivity.
	public void transferActivities(){
		// This line gets whatever text is inside our text field. Depending on the maturity
		// of our user, this is either their name, or "penis".
		String name = mNameText.getText().toString();
		// Get hype. We're about to do something. And we're about to tell Android that we're about
		// to do something. Through an "Intent" cause we intend to do a thing. In this case,
		// we intend to go from this activity, to the WelcomeActivity activity.
		Intent intent = new Intent(this, WelcomeActivity.class);
		// Here we put an extra. An extra is just data we want to send from where we are to
		// where we're going. In this case, we want to send the user's name from MainActivity
		// to WelcomeActivity. EXTRA_NAME_KEY is the key associated with this data. So in
		// WelcomeActivity, the name will be retrieved by using this key.
		intent.putExtra(EXTRA_NAME_KEY, name);
		// This actually "executes" the intent. That is, let's stop intending to do something,
		// and just do it.
		startActivity(intent);
	}

	/*
		*** The following 3 methods are lifecycle methods, only implemented
		to show what they do. If your app doesn't need to do anything when the user
		leaves, rejoins, or destroys your app, then you don't need to implement these. ***
	 */

	// lifecycle method!
	// onResume() when the user enters your activity, whether for the first time,
	// or if they left your app temporarily and then came back to it.
	@Override
	public void onResume(){
		// make sure to call super in all lifecycle methods!
		super.onResume();
	}

	// lifecycle method! onPause() is called when the user leaves your activity.
	@Override
	public void onPause(){
		// make sure to call super in all lifecycle methods!
		super.onPause();
	}

	// lifecycle method! onDestroy() is called when the user destroys your activity,
	// This is when you should free up resources you were using.
	@Override
	public void onDestroy(){
		// make sure to call super in all lifecycle methods!
		super.onDestroy();
	}
}
