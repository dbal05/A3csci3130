package com.acme.a3csci3130;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

/**
 * Class that is used to create a Business. It keep track of the textFields.
 * It also generates the application state that can be used to get the firebase reference.
 * @author dahnbalan
 */
public class CreateBusinessActivity extends Activity {

    private Button submitButton;
    private EditText nameField, numberField, primaryBusinessField, addressField, provinceField;
    private MyApplicationData appState;

    /**
     * onCreate of the Class. Used to set the application state and the textFields.
     * @param savedInstanceState
     */
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_business_acitivity);
        //Get the app wide shared variables
        appState = ((MyApplicationData) getApplicationContext());

        submitButton = (Button) findViewById(R.id.submitButton);
        nameField = (EditText) findViewById(R.id.name);
        numberField = (EditText) findViewById(R.id.number);
        primaryBusinessField = (EditText) findViewById(R.id.primaryBusiness);
        addressField = (EditText) findViewById(R.id.address);
        provinceField = (EditText) findViewById(R.id.province);
    }

    /**
     * Creates a new business object from the data of the textFields and generated key for id.
     * Adds the business object to the firebase database and finishes
     * @param v Current view from onClick
     */
    public void submitInfoButton(View v) {
        //each entry needs a unique ID
        String businessID = appState.firebaseReference.push().getKey();
        String name = nameField.getText().toString();
        String number = numberField.getText().toString();
        String primaryBusiness = primaryBusinessField.getText().toString();
        String address = addressField.getText().toString();
        String province = provinceField.getText().toString();

        Business business = new Business(businessID, name, primaryBusiness, address, province, number);

        appState.firebaseReference.child(businessID).setValue(business);

        finish();

    }
}
