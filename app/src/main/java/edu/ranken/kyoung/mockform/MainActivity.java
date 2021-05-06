package edu.ranken.kyoung.mockform;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Spinner;
import android.widget.Switch;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements
        AdapterView.OnItemSelectedListener{

    //Global Constants
    final String NIP = "No Input Provided!";

    // Program Variables
    String name = "";
    String address = "";
    String city = "";
    String state = "";
    String zipCode = "";
    String gender = "";
    String shift = "";
    String settings = "";
    String output = "";

    // Declare program widgets
    EditText etName;
    EditText etAddress;
    EditText etCity;
    Spinner  states;
    EditText etZipCode;
    RadioGroup rgGender;
    RadioButton radioBtnFemale;
    RadioButton radioBtnMale;
    RadioButton radioBtnPreferNotToAnswer;
    RadioGroup rgShift;
    CheckBox cbMorning;
    CheckBox cbAfternoon;
    CheckBox cbEvening;
    Switch switchSettings;
    ImageButton ibGetToast;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Reference Program Widgets
        etName = findViewById(R.id.etName);
        etAddress = findViewById(R.id.etAddress);
        etCity = findViewById(R.id.etCity);
        states = findViewById(R.id.states);
        etZipCode = findViewById(R.id.etZipCode);
        rgGender = findViewById(R.id.rgGender);
        radioBtnFemale = findViewById(R.id.radioBtnFemale);
        radioBtnMale = findViewById(R.id.radioBtnMale);
        radioBtnPreferNotToAnswer = findViewById(R.id.radioBtnPreferNotToAnswer);
        rgShift = findViewById(R.id.rgShift);
        cbMorning = findViewById(R.id.cbMorning);
        cbAfternoon = findViewById(R.id.cbAfternoon);
        cbEvening = findViewById(R.id.cbEvening);
        switchSettings = findViewById(R.id.switchSettings);
        ibGetToast = findViewById(R.id.iBGetToast);

        if (states != null) {
            states.setOnItemSelectedListener(this);
        }

        ArrayAdapter<CharSequence> adapter = ArrayAdapter.createFromResource(
                this,
                R.array.states,
                android.R.layout.simple_spinner_item);
        adapter.setDropDownViewResource(
                android.R.layout.simple_spinner_dropdown_item);

        if (states != null) {
            states.setAdapter(adapter);
            states.setOnItemSelectedListener(this);
        }
    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        state = states.getItemAtPosition(position).toString();
    }

    @Override
    public void onNothingSelected(AdapterView<?> parent) {

        Toast.makeText(getApplicationContext(),
                NIP, Toast.LENGTH_LONG).show();

    }


    public void getToast(View view)
    {
        // Check to see if entries are empty
        if ((name == "") || (address == ""))
        {
            Toast.makeText(getApplicationContext(),
                    NIP, Toast.LENGTH_LONG).show();
        }
        else if ((city == "") || (zipCode == ""))
        {
            Toast.makeText(getApplicationContext(),
                    NIP, Toast.LENGTH_LONG).show();
        }

        // Get entered values from edit texts
        name = etName.getText().toString();
        address = etAddress.getText().toString();
        city = etCity.getText().toString();
        zipCode = etZipCode.getText().toString();

        // Radio Buttons Checked
        if (radioBtnFemale.isChecked())
        {
            gender = "Female";
        }
        else if (radioBtnMale.isChecked())
        {
            gender = "Male";
        }
        else if (radioBtnPreferNotToAnswer.isChecked())
        {
            gender = "Prefer Not To Answer";
        }

        // Shift Checked
        if (cbMorning.isChecked())
        {
            shift = "Morning";
        }
        else if (cbAfternoon.isChecked())
        {
            shift = "Afternoon";
        }
        else if (cbEvening.isChecked())
        {
            shift = "Evening";
        }

        // Settings Toggle
        if (switchSettings.isChecked())
        {
            settings = "ON";
        }
        else
        {
            settings = "OFF";
        }

            // Toast Output
            output = "Name: "    + name    + "\n" +
                    "Address: "  + address + "\n" +
                    "City: "     + city    + "\n" +
                    "State: "    + state   + "\n" +
                    "Zip Code: " + zipCode + "\n" +
                    "Gender: "   + gender  + "\n" +
                    "Shift: "    + shift   + "\n" +
                    "Settings: " + settings;

            Toast.makeText(getApplicationContext(),
                    output, Toast.LENGTH_LONG).show();
    }
}