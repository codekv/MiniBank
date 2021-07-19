package com.example.minibank;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class Recyclerviewholder extends RecyclerView.Adapter<Recyclerviewholder.ViewHolder> {
    private Context context;
    private List<Accounts> accountsList;

    public Recyclerviewholder(Context context, List<Accounts>accountsList){
        this.context = context;
        this.accountsList=accountsList;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.viewdesign,parent,false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull Recyclerviewholder.ViewHolder holder, int position) {

        Accounts accounts=accountsList.get(position);

        holder.AccountName.setText(accounts.getName());
        holder.AccountNumber.setText(accounts.getEmail());
    }

    @Override
    public int getItemCount() {

        return accountsList.size();
    }
    //To perform actions on clicking on the class
    public class ViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener
    {
        public TextView AccountName;
        public TextView AccountNumber;
        public ImageView Next;


        public ViewHolder(@NonNull View itemView)
        {
            super(itemView);
            itemView.setOnClickListener(this);

            AccountName = itemView.findViewById(R.id.username);
            AccountNumber = itemView.findViewById(R.id.accountno);

        }

        @Override
        public void onClick(View v)
        {
            int position = this.getAdapterPosition();
            Accounts accounts=accountsList.get(position);
            String name=accounts.getName();
            int Acc_no=accounts.getId1();
            String Email=accounts.getEmail();
            String Phone=accounts.getPhone();
            int Balance=accounts.getBalance();
            Intent intent=new Intent(context, ViewAccount.class);
            intent.putExtra("RName",name);
            intent.putExtra("RAccount",String.valueOf(Acc_no));
            intent.putExtra("REmail",Email);
            intent.putExtra("RPhone",Phone);
            intent.putExtra("RBalance",String.valueOf(Balance));
            context.startActivity(intent);

        }
    }
}