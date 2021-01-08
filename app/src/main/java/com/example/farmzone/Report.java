package com.example.farmzone;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.TextView;

import org.json.JSONException;
import org.json.JSONObject;

public class Report extends AppCompatActivity {

    RecyclerView recyclerView;
    SharedPreferences  sharedPreferences;
    JSONObject saved;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_report);

        recyclerView = findViewById(R.id.report_rv);

        sharedPreferences = getSharedPreferences("farmer", Context.MODE_PRIVATE);
        Log.d("testing",sharedPreferences.getString("saved",""));
        try {
            saved = new JSONObject(sharedPreferences.getString("saved",""));
        } catch (JSONException e) {
            e.printStackTrace();
        }

        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(Report.this);
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setAdapter(new Adapter());

    }

    public class Adapter extends RecyclerView.Adapter<Adapter.Holder>
    {

        @NonNull
        @Override
        public Adapter.Holder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
            View view = LayoutInflater.from(Report.this)
                    .inflate(R.layout.row_item,viewGroup,false);
            Holder holder = new Holder(view);
            view.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = recyclerView.getChildAdapterPosition(v);
                    Intent intent = new Intent(Report.this,
                            Farm.class);
                    intent.putExtra("position",position);
                }
            });
            return holder;
        }

        @Override
        public void onBindViewHolder(@NonNull Adapter.Holder holder, int i) {

            try {
                holder.fname.setText(saved.getString("saved"+i));
                holder.fname.setText(saved.getString("saved"+i));
                //holder.pname.setText(saved.getString("saved"+i));
                //holder.crop.setText(saved.getString("saved"+i));
                //holder.pstage.setText(saved.getString("saved"+i));
                //holder.sCondition.setText(saved.getString("saved"+i));
                //holder.npkVals.setText(saved.getString("saved"+i));
            } catch (JSONException e) {
                e.printStackTrace();
            }
        }

        @Override
        public int getItemCount() {
            return saved.length();
        }

        public class Holder extends RecyclerView.ViewHolder {
            TextView fname, fdname, pname, crop, pstage, sCondition, npkVals;
            public Holder(@NonNull View itemView) {
                super(itemView);



                fname = itemView.findViewById(R.id.tv_farm);
            }
        }
    }



}
