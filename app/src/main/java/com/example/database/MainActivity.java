package com.example.database;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    // creating variables for our edittext, button and dbhandler
    private EditText Id, Name, Address, PhoneNo;
    private Button AddDetails;
    private DBHandler dbHandler;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // initializing all our variables.
        Id = findViewById(R.id.idID);
        Name = findViewById(R.id.idName);
        Address = findViewById(R.id.idAdress);
        PhoneNo = findViewById(R.id.idPhNo);
        AddDetails = findViewById(R.id.idBtnAddDetails);

        // creating a new dbhandler class
        // and passing our context to it.
        dbHandler = new DBHandler(MainActivity.this);

        // below line is to add on click listener for our add course button.
        AddDetails.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // below line is to get data from all edit text fields.
                String StudId = Id.getText().toString();
                String StudName = Name.getText().toString();
                String StudAddress = Address.getText().toString();
                String StudPhNo = PhoneNo.getText().toString();

                // validating if the text fields are empty or not.
                if (StudId.isEmpty() && StudName.isEmpty() && StudAddress.isEmpty() && StudPhNo.isEmpty()) {
                    Toast.makeText(MainActivity.this, "Please enter all the data..", Toast.LENGTH_SHORT).show();
                    return;
                }

                // on below line we are calling a method to add new
                // course to sqlite data and pass all our values to it.
                dbHandler.addNewCourse(StudId, StudName, StudAddress, StudPhNo);

                // after adding the data we are displaying a toast message.
                Toast.makeText(MainActivity.this, "Course has been added.", Toast.LENGTH_SHORT).show();
                Id.setText("");
                Name.setText("");
                PhoneNo.setText("");
                Address.setText("");
            }
        });
    }
}
