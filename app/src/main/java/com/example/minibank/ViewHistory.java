package com.example.minibank;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.SurfaceControl;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ViewHistory extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_history);

        ListView listView;
        listView = findViewById(R.id.listview);

        ArrayList<String> transactions = new ArrayList<>();
        database db  = new database(ViewHistory.this);

        List<Transaction> transactionList = db.getAllTransactions();
        for(Transaction transaction: transactionList){
            transactions.add("From: "+transaction.getS_name()+
                    "\nTo: "+transaction.getR_name()+
                    "\nAmount: "+transaction.getT_amt()+
                    "\nTime: "+transaction.getDatetime()+
                    "\nAvailable Balance: "+transaction.getS_acc());
        }

        ArrayAdapter<String> arrayAdapter = new ArrayAdapter<>(this,android.R.layout.simple_list_item_1,transactions);
        listView.setAdapter(arrayAdapter);
    }
}