package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;

/**
 * Class to view the Details of each business object.
 * Consists of other CRUD operations.
 * @author dahnbalan
 */
public class DetailViewActivity extends Activity {

    private EditText nameField, numberField, primaryBusinessField, addressField, provinceField;
    private MyApplicationData appState;
    Business receivedPersonInfo;

    /**
     * onCreate of the Class.
     * Retrives the business object that is sent from the Intent of the MainActivity
     * Used to set the application state and the textFields and makes null checks.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail_view);
        receivedPersonInfo = (Business)getIntent().getSerializableExtra("Business");

        appState = ((MyApplicationData) getApplicationContext());

        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);

        if(receivedPersonInfo != null){
            nameField.setText(receivedPersonInfo.name);
            numberField.setText(receivedPersonInfo.number);
            primaryBusinessField.setText(receivedPersonInfo.primaryBusiness);
            addressField.setText(receivedPersonInfo.address);
            provinceField.setText(receivedPersonInfo.province);
        }
    }

    /**
     * Updates a business object from the data of the textFields.
     * Replaces the business object with the same id in the firebase database and finishes
     * @param v Current view from onClick
     */
    public void updateBusiness(View v){
        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String primaryBusiness = primaryBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();
        Business business = new Business(receivedPersonInfo.uid, name, primaryBusiness, address, province, number);

        appState.firebaseReference.child(receivedPersonInfo.uid).setValue(business);
        finish();
    }

    /**
     * Deletes a business object from firebase with the recieved id
     * @param v Current view from onClick
     */
    public void eraseBusiness(View v) {
        appState.firebaseReference.child(receivedPersonInfo.uid).removeValue();
        finish();
    }
}
