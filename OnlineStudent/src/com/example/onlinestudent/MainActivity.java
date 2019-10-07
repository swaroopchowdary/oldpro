package com.example.onlinestudent;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.view.View.OnClickListener;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends Activity {

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		final EditText txtId = (EditText) findViewById(R.id.txtID);
		final EditText txtName = (EditText) findViewById(R.id.txtName);
		final EditText txtRollNo = (EditText) findViewById(R.id.txtNumber);
		final EditText txtEmail = (EditText) findViewById(R.id.txtEmail);
		Button btnInsert = (Button) findViewById(R.id.btnInsert);
		
		btnInsert.setOnClickListener(new OnClickListener() {
			
			@Override
			public void onClick(View v) {
				// TODO Auto-generated method stub
				String id = txtId.getText().toString();
				String name = txtName.getText().toString();
				String rollno = txtRollNo.getText().toString();
				String email = txtEmail.getText().toString();
				String url = "http://10.0.2.2/student/insert.php?id="+id+"&name="+name+"&rollno="+rollno+"&email="+email;
				new UniversalExecuteClass().execute(url,"0",null,null);
				
			}
		});
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}

}
