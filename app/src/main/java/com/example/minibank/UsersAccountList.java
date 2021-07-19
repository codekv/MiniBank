package com.example.minibank;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;

import java.util.ArrayList;
import java.util.List;

public class UsersAccountList extends AppCompatActivity {

    private RecyclerView recyclerView;
    private Recyclerviewholder recyclerviewholder;
    private ArrayList<Accounts> accountsArrayList;
    private ArrayAdapter<String> arrayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.recyclerview);

        database db=new database(UsersAccountList.this);

        //Recyclerview initialization
        recyclerView=findViewById(R.id.RecyclerView);
        recyclerView.setHasFixedSize(true);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));


        /*final LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);
        recyclerView.setLayoutManager(layoutManager);*/

        accountsArrayList=new ArrayList<>();


        //Get all accounts
        List<Accounts> accountsList=db.getAllAccounts();
        for(Accounts account:accountsList)
        {
            Log.d("sid","Account: "+account.getId1()+"\n"+
                    "Name: "+account.getName() +"\n"+
                    "Email: "+account.getEmail()+"\n"+
                    "PhoneNO: "+account.getPhone()+"\n"+
                    "Balance: "+account.getBalance());

            accountsArrayList.add(account);
        }

        //Use Recyclerview
        Recyclerviewholder recyclerview = new Recyclerviewholder(UsersAccountList.this,accountsArrayList);
        recyclerView.setAdapter(recyclerview);

    }
}