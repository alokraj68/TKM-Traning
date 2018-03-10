package in.alokraj68.sharedpreference;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Button btn = findViewById(R.id.button);
        Button get = findViewById(R.id.get);
        final EditText text = findViewById(R.id.editText);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = String.valueOf(text.getText());
                if (TextUtils.isEmpty(text.getText().toString())) {
                    Toast.makeText(MainActivity.this, "Empty inout box", Toast.LENGTH_SHORT).show();
                } else {

                    callDb(name);
                    Toast.makeText(MainActivity.this, "Done!", Toast.LENGTH_LONG).show();

                }

                //        Toast.makeText(MainActivity.this, name.length(), Toast.LENGTH_SHORT).show();

            }

        });

        get.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String text = getFromDb();
                Toast.makeText(MainActivity.this, "Your name is: " + text, Toast.LENGTH_LONG).show();
            }
        });
    }

    private String getFromDb() {
        SharedPreferences prefs = getSharedPreferences("preference", MODE_PRIVATE);
        String restoredText = prefs.getString("name", null);
        return restoredText;
    }

    private void callDb(String name) {
// MY_PREFS_NAME - a static String variable like:
//public static final String MY_PREFS_NAME = "MyPrefsFile";
        SharedPreferences.Editor editor = getSharedPreferences("preference", MODE_PRIVATE).edit();
        editor.putString("name", name);
        editor.putInt("idName", 12);
        editor.apply();
    }
}
