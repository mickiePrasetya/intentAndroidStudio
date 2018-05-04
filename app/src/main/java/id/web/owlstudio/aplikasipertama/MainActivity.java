package id.web.owlstudio.aplikasipertama;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Handler;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // panggil toast / short dialog
        // Toast.makeText(this, "tampil onCreate", Toast.LENGTH_LONG).show();

        // console log di logcat
        // Log.d("Life","OnCreate");

        // set TimeOut to redirect to next activity
        Handler tunda = new Handler();
        tunda.postDelayed(new Runnable() {
            @Override
            public void run() {
            // move from MainActivity to UtamaActivity class
            startActivity(new Intent(MainActivity.this, UtamaActivity.class));

            // kill MainActivity after moving
            finish();
            }
        }, 5000);
    }

    @Override
    protected void onStart() {
        super.onStart();
        Toast.makeText(this, "showing lifecycle onStart", Toast.LENGTH_SHORT).show();
        Log.d("Life", "onStart");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Toast.makeText(this, "showing lifecycle onStop", Toast.LENGTH_SHORT).show();
        Log.d("Life","onStop");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Toast.makeText(this, "showing lifecycle onResume", Toast.LENGTH_SHORT).show();
        Log.d("Life", "onResume");
    }

    @Override
    protected void onRestart() {
        super.onRestart();
        Toast.makeText(this, "showing lifecycle onRestart", Toast.LENGTH_SHORT).show();
        Log.d("Life", "onRestart");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Toast.makeText(this, "showing lifecycle onDestroy", Toast.LENGTH_SHORT).show();
    }

    @Override
    protected void onPause() {
        super.onPause();
        Toast.makeText(this, "showing lifecycle onPause", Toast.LENGTH_SHORT).show();
    }

    // method ketika tombol back ditekan
    @Override
    public void onBackPressed() {
        AlertDialog.Builder keluar = new AlertDialog.Builder(MainActivity.this);
        keluar.setIcon(R.mipmap.icon_logo);
        keluar.setTitle("Info");
        keluar.setMessage("Are you sure you want to Quit?");

        // SET BUTTON YES AND NO
        keluar.setPositiveButton("yes", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
            // keluar aplikasi
            System.exit(0);
            moveTaskToBack(true);
            }
        });

        keluar.setNegativeButton("no", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        // INITIALIZE KELUAR ALERT/PROMPT DIALOG
        keluar.show();
    }
}
