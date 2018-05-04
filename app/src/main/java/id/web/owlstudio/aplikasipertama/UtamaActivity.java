package id.web.owlstudio.aplikasipertama;

import android.content.DialogInterface;
import android.content.Intent;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class UtamaActivity extends AppCompatActivity {

    // VARIABLE GLOBAL DECLARATION
    EditText edtusername, edtpassword;
    Button btnkirim;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_utama);

        // SET GlOBAL VARIABLES
        edtusername = (EditText)findViewById(R.id.edtusername);
        edtpassword = (EditText)findViewById(R.id.edtpassword);
        btnkirim = (Button)findViewById(R.id.btnkirim);

        btnkirim.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // parse to string
                String username = edtusername.getText().toString();
                String password = edtpassword.getText().toString();

                // SET DESTINATION ACTIVITY
                Intent kirimdata = new Intent(UtamaActivity.this, DetailActivity.class);

                // SEND DATA TO NEXT DESTINATION ACTIVITY -> DETAILACTIVITY
                kirimdata.putExtra("uS", username);
                kirimdata.putExtra("pw", password);

                // trigger action
                startActivity(kirimdata);
            }
        });

    }

    @Override
    public void onBackPressed() {
        AlertDialog.Builder keluar = new AlertDialog.Builder(UtamaActivity.this);
        keluar.setIcon(R.mipmap.icon_logo);
        keluar.setTitle("Confirmation Info");
        keluar.setMessage("Are you sure you want back to the splash screen?");

        // SET BUTTONS ON ALERT DIALOG
        keluar.setPositiveButton("back", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            // keluar aplikasi
            // System.exit(0);
            // moveTaskToBack(true);

            // pindah dari UtamaActivity menuju halaman Main Activity
            startActivity(new Intent(UtamaActivity.this, MainActivity.class));
            }
        });

        keluar.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // SHOWING ALERT DIALOG
        keluar.show();
    }
}
