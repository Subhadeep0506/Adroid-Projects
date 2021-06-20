package com.example.frangmentsrecyclerview;

import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentManager;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements PersonAdapter.ItemClicked {

    TextView contact_name, contact_number;
    EditText etName, etNumber;
    Button btnAdd;
    ListFrag listFrag;
    FragmentManager fragmentManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        contact_name = findViewById(R.id.contact_name);
        contact_number = findViewById(R.id.contact_number);
        etName = findViewById(R.id.etName);
        etNumber = findViewById(R.id.etNumber);
        btnAdd = findViewById(R.id.btnAdd);

        fragmentManager = this.getSupportFragmentManager();
        listFrag = (ListFrag) fragmentManager.findFragmentById(R.id.list_frag);

        btnAdd.setOnClickListener(v -> {

            if(etNumber.getText().toString().isEmpty() || etName.getText().toString().isEmpty()){
                Toast.makeText(this, "please enter all fields", Toast.LENGTH_SHORT).show();
            }
            else{

                ApplicationClass.people.add(new Person(etName.getText().toString().trim(),
                                                                 etNumber.getText().toString().trim()));
                Toast.makeText(this, "added person", Toast.LENGTH_SHORT).show();

                etName.setText(null);
                etNumber.setText(null);
                listFrag.notifyDataChanged();
            }
        });

        onItemClicked(0);
    }

    @Override
    public void onItemClicked(int index) {

        contact_name.setText(ApplicationClass.people.get(index).getName());
        contact_number.setText(ApplicationClass.people.get(index).getNumber());

    }
}