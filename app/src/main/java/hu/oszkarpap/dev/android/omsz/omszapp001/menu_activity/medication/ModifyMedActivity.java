package hu.oszkarpap.dev.android.omsz.omszapp001.menu_activity.medication;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;


import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.database.FirebaseDatabase;

import hu.oszkarpap.dev.android.omsz.omszapp001.R;

public class ModifyMedActivity extends AppCompatActivity {

    private EditText createName, createAgent, createPack, createInd, createContra, createAdult, createChild;
    private Button createMemoryBTN;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_memory);
        createName = findViewById(R.id.createNameET);
        createAgent = findViewById(R.id.createAgentET);
        createPack = findViewById(R.id.createPackET);
        createInd = findViewById(R.id.createIndET);
        createContra = findViewById(R.id.createContraET);
        createAdult = findViewById(R.id.createAdultET);
        createChild = findViewById(R.id.createChildET);
        createMemoryBTN = findViewById(R.id.createMemoryBTN);
        createName.setText(getIntent().getStringExtra(MedActivity.KEY_NAME_MODIFY));
        createAgent.setText(getIntent().getStringExtra(MedActivity.KEY_AGENT_MODIFY));
        createPack.setText(getIntent().getStringExtra(MedActivity.KEY_PACK_MODIFY));
        createInd.setText(getIntent().getStringExtra(MedActivity.KEY_IND_MODIFY));
        createContra.setText(getIntent().getStringExtra(MedActivity.KEY_CONTRA_MODIFY));
        createAdult.setText(getIntent().getStringExtra(MedActivity.KEY_ADULT_MODIFY));
        createChild.setText(getIntent().getStringExtra(MedActivity.KEY_CHILD_MODIFY));

        createMemoryBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Medication  med = new Medication(createName.getText().toString(),createAgent.getText().toString(),createPack.getText().toString(),createInd.getText().toString(),createContra.getText().toString(),createAdult.getText().toString(),createChild.getText().toString());

                String key = FirebaseDatabase.getInstance().getReference().child("med").push().getKey();
                med.setKey(key);
                FirebaseDatabase.getInstance().getReference()
                        .child("med")
                        .child(key)
                        .setValue(med)
                        .addOnCompleteListener(new OnCompleteListener<Void>() {
                            @Override
                            public void onComplete(@NonNull Task<Void> task) {
                                Toast.makeText(ModifyMedActivity.this, "Firebase felhőbe mentve!!", Toast.LENGTH_SHORT).show();

                            }
                        });
                finish();
            }
        });


    }




}
