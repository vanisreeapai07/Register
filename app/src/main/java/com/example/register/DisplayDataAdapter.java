package com.example.register;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class DisplayDataAdapter extends RecyclerView.Adapter<DisplayDataAdapter.MyViewHolder>{

    List<DataModel> list;
    Context context;

    public DisplayDataAdapter(List<DataModel> list, Context context) {
        this.list = list;
        this.context = context;
    }


    @NonNull
    @Override
    public MyViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new MyViewHolder(LayoutInflater.from(parent.getContext()).inflate(R.layout.cardview,parent,false));

    }

    @Override
    public void onBindViewHolder(@NonNull MyViewHolder holder, int position) {
        DataModel model = list.get(position);
        holder.tv1.setText(model.getAttendance1());
        holder.tv2.setText(model.getAttendance2());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent i = new Intent(context,Update.class);
                i.putExtra("Attendance1",model.getAttendance1());
                i.putExtra("Attendance2",model.getAttendance2());
                i.putExtra("name1",model.getName1());
                i.putExtra("name2",model.getName2());
                context.startActivity(i);

            }
        });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    class MyViewHolder extends RecyclerView.ViewHolder {

        TextView tv1,tv2,tv3,tv4;

        public MyViewHolder(@NonNull View itemView) {
            super(itemView);

            tv1 = itemView.findViewById(R.id.tv1);
            tv2 = itemView.findViewById(R.id.tv2);
            tv3 = itemView.findViewById(R.id.tv3);
            tv4 = itemView.findViewById(R.id.tv2);
        }
    }
  }


