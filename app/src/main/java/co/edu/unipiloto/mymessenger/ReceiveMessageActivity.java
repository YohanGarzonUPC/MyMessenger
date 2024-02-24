package co.edu.unipiloto.mymessenger;

import androidx.appcompat.app.AppCompatActivity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

public class ReceiveMessageActivity extends AppCompatActivity {
    String message="";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_receive_message);

        Button boton = findViewById(R.id.button1);
        boton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sendMessage(v);
            }
        });

        Intent intent = getIntent();
        message = intent.getStringExtra("MESSAGE");
        TextView textView = findViewById(R.id.textView1);
            textView.setText(message);
    }
    public void sendMessage(View view) {
        EditText editText = findViewById(R.id.Input1);
        String message = editText.getText().toString();

        Intent intent = new Intent(this, CreateMessageActivity.class);
        intent.putExtra("MESSAGE", this.message+"\n"+"Conductor: "+message);
        startActivity(intent);
    }
}
