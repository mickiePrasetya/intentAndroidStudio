package id.web.owlstudio.aplikasipertama;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class DetailActivity extends AppCompatActivity {

    // GLOBAL VARIABLE DECLARATION
    EditText edtusername, edtpassword;
    Button btnkirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        // SET GLOBAL VARIABLE
        edtusername = (EditText)findViewById(R.id.edtusername);
        edtpassword = (EditText)findViewById(R.id.edtpasswords);
        // btnkirim = (Button)findViewById(R.id.btnkirim);

        // set data
        edtusername.setText(getIntent().getStringExtra("uS"));
        edtpassword.setText(getIntent().getStringExtra("pw"));
        // btnkirim.setOnClickListener(new View.OnClickListener() {
        //      @Override
        //      public void onClick(View v) {
        //          finish();
        //      }
        // });
    }
}
