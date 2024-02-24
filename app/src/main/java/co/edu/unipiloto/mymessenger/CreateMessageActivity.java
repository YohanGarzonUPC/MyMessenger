package co.edu.unipiloto.mymessenger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class CreateMessageActivity extends AppCompatActivity {
    String message ="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_create_message);
        Button boton = findViewById(R.id.button);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });

        Intent intent = getIntent();
        message = intent.getStringExtra("MESSAGE");
        if (message==null){
            message="";
        }
        TextView textView = findViewById(R.id.textView);
            textView.setText( message);
    }

    public void sendMessage(View view) {
        EditText editText = findViewById(R.id.Input);
        String message = editText.getText().toString();

        Intent intent = new Intent(this, ReceiveMessageActivity.class);
        intent.putExtra("MESSAGE", this.message+"\n"+"Propietario: "+message);
        startActivity(intent);
    }
}