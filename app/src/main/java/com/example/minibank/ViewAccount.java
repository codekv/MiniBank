package com.example.minibank;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class ViewAccount extends AppCompatActivity {

    private Button button;
    private String name;
    private String account;
    private String phone;
    private String email;
    private String balance;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_account);

        button=(Button)findViewById(R.id.pay);

        Intent intent=getIntent();
        name=intent.getStringExtra("RName");
        account=intent.getStringExtra("RAccount");
        phone= intent.getStringExtra("RPhone");
        email=intent.getStringExtra("REmail");
        balance=intent.getStringExtra("RBalance");

        TextView nameTextView=findViewById(R.id.name);
        nameTextView.setText(name);
        TextView accTextView=findViewById(R.id.textan);
        accTextView.setText(account);
        TextView phoneTextView=findViewById(R.id.textph);
        phoneTextView.setText(phone);
        TextView emailTextView=findViewById(R.id.Email_Id);
        emailTextView.setText(email);
        TextView balanceTextView=findViewById(R.id.Balance);
        balanceTextView.setText(balance);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                openTransact();
            }
        });

    }
    public void openTransact()
    {
        Intent intent=new Intent(this,Transact.class);
        intent.putExtra("RName",name);
        intent.putExtra("RAccount",account);
        intent.putExtra("REmail",email);
        intent.putExtra("RPhone",phone);
        intent.putExtra("RBalance",balance);

        startActivity(intent);
    }
}