package com.example.minibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.preference.PreferenceManager;
import android.view.View;
import android.widget.Button;

public class ViewUsersActivity extends AppCompatActivity {

    Button btnView ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_users);

        btnView = findViewById(R.id.btnView);
        database db =new database(ViewUsersActivity.this);
        SharedPreferences prefs = PreferenceManager.getDefaultSharedPreferences(this);
        if(!prefs.getBoolean("firstTime", false)) {
            //Adding accounts
            Accounts Asmita = new Accounts();
            Asmita.setName("Asmita Agrawal");
            Asmita.setEmail("XXXXXX10011");
            Asmita.setPhone("9011223344");
            Asmita.setBalance(10000);
            db.addAccount(Asmita);


            Accounts Ankit = new Accounts();
            Ankit.setName("Ankit Sharma");
            Ankit.setEmail("XXXXXX10012");
            Ankit.setPhone("9022334455");
            Ankit.setBalance(3400);
            db.addAccount(Ankit);

            Accounts Vaishali = new Accounts();
            Vaishali.setName("Vaishali Singh");
            Vaishali.setEmail("XXXXXX10013");
            Vaishali.setPhone("7011335577");
            Vaishali.setBalance(340000);
            db.addAccount(Vaishali);

            Accounts Bharat = new Accounts();
            Bharat.setName("Bharat Kumar");
            Bharat.setEmail("XXXXXX10014");
            Bharat.setPhone("8011335589");
            Bharat.setBalance(33030);
            db.addAccount(Bharat);

            Accounts Ansh = new Accounts();
            Ansh.setName("Ansh Mittal");
            Ansh.setEmail("XXXXXX10015");
            Ansh.setPhone("6022446677");
            Ansh.setBalance(100000);
            db.addAccount(Ansh);

            Accounts Rahul = new Accounts();
            Rahul.setName("Rahul Chopra");
            Rahul.setEmail("XXXXXX10016");
            Rahul.setPhone("722559908");
            Rahul.setBalance(3000);
            db.addAccount(Rahul);

            Accounts Radhika = new Accounts();
            Radhika.setName("Radhika Gupta");
            Radhika.setEmail("XXXXXX10017");
            Radhika.setPhone("8234567890");
            Radhika.setBalance(190000);
            db.addAccount(Radhika);

            Accounts Keshav = new Accounts();
            Keshav.setName("Keshav Kumar");
            Keshav.setEmail("XXXXXX10018");
            Keshav.setPhone("9876543210");
            Keshav.setBalance(120000);
            db.addAccount(Keshav);


            Accounts Harshita = new Accounts();
            Harshita.setName("Harshita Tiwari");
            Harshita.setEmail("XXXXXX10019");
            Harshita.setPhone("7998866554");
            Harshita.setBalance(88000);
            db.addAccount(Harshita);

            Accounts Tarak = new Accounts();
            Tarak.setName("Tarak Mehta");
            Tarak.setEmail("XXXXXX10020");
            Tarak.setPhone("999999566");
            Tarak.setBalance(160000);
            db.addAccount(Tarak);

            SharedPreferences.Editor editor = prefs.edit();
            editor.putBoolean("firstTime", true);
            editor.commit();

        }
        btnView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(ViewUsersActivity.this,UsersAccountList.class);
                startActivity(intent);
            }
        });

    }
}