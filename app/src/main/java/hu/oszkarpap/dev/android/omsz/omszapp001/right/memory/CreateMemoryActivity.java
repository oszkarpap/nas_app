package hu.oszkarpap.dev.android.omsz.omszapp001.right.memory;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

import hu.oszkarpap.dev.android.omsz.omszapp001.R;
/**
 * @author Oszkar Pap
 * @version 1.0
 * This Activity create new medication memory, this medication save on device, in SQlite DB!
 */

public class CreateMemoryActivity extends AppCompatActivity {

    public static final String KEY_NAME = "NAME";
    public static final String KEY_AGENT = "AGENT";
    public static final String KEY_PACK = "PACK";
    public static final String KEY_IND = "IND";
    public static final String KEY_CONTRA = "CONTRA";
    public static final String KEY_ADULT = "ADULT";
    public static final String KEY_CHILD = "CHILD";
    private EditText createName, createAgent, createPack, createInd, createContra, createAdult, createChild;

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
        Button createMemoryBTN = findViewById(R.id.createMemoryBTN);

        createMemoryBTN.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = createName.getText().toString();
                String agent = createAgent.getText().toString();
                String pack = createPack.getText().toString();
                String ind = createInd.getText().toString();
                String contra = createContra.getText().toString();
                String adult = createAdult.getText().toString();
                String child = createChild.getText().toString();

                Intent intent = new Intent();

                intent.putExtra(KEY_NAME, name);
                intent.putExtra(KEY_AGENT, agent);
                intent.putExtra(KEY_PACK, pack);
                intent.putExtra(KEY_IND, ind);
                intent.putExtra(KEY_CONTRA, contra);
                intent.putExtra(KEY_ADULT, adult);
                intent.putExtra(KEY_CHILD, child);

                setResult(RESULT_OK,intent);
                finish();

            }
        });


    }
}
