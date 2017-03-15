package com.eni.android.progressdialog;

import android.app.Activity;
import android.app.ProgressDialog;
import android.os.Bundle;

public class ProgressDialogExampleActivity extends Activity {
	/** Called when the activity is first created. */
	@Override
	public void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.main);

		ProgressDialog dialog = ProgressDialog.show(
				ProgressDialogExampleActivity.this,
				getResources().getString(R.string.dialog_title), getResources()
						.getString(R.string.dialog_load), true);
	}
}