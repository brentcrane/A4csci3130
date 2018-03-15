package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

import com.google.android.gms.tasks.Task;

public class DetailViewActivity extends Activity {

    private EditText numberField, nameField, primaryBusinessField, addressField, provinceField;

    private MyApplicationData appState;
    Business receivedBusinessInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedBusinessInfo = (Business)getIntent().getSerializableExtra("Business");

        numberField = (EditText) findViewById(R.id.number);
        nameField = (EditText) findViewById(R.id.name);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        appState = (MyApplicationData)getApplicationContext();

        if(receivedBusinessInfo != null){
            numberField.setText(receivedBusinessInfo.number);
            nameField.setText(receivedBusinessInfo.name);
            primaryBusinessField.setText(receivedBusinessInfo.primaryBusiness);
            addressField.setText(receivedBusinessInfo.address);
            provinceField.setText(receivedBusinessInfo.province);
        }
    }

    /**
     * Update the information for the current business to the given values
     * @param v: ignored, not used
     */
    public void updateContact(View v) {

        receivedBusinessInfo.number = numberField.getText().toString();
        receivedBusinessInfo.name = nameField.getText().toString();
        receivedBusinessInfo.primaryBusiness = primaryBusinessField.getText().toString();
        receivedBusinessInfo.address = addressField.getText().toString();
        receivedBusinessInfo.province = provinceField.getText().toString();

        appState.firebaseReference.child(receivedBusinessInfo.id).setValue(receivedBusinessInfo);
        finish();
    }

    /**
     * Erase the current business from the database
     * @param v: ignored, not used
     */
    public void eraseContact(View v) {

        appState.firebaseReference.child(receivedBusinessInfo.id).removeValue();
        finish();
    }
}
