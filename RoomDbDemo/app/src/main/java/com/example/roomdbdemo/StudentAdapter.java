package com.example.roomdbdemo;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class StudentAdapter extends RecyclerView.Adapter<StudentAdapter.StudentViewHolder> {
    Context ctx;
    List<StudentEntity> list;
    //for creating constuctor
    /*right click on here ->generate->constructor->select all->ok*/

    public StudentAdapter(Context ctx, List<StudentEntity> list) {
        this.ctx = ctx;
        this.list = list;
    }

    @NonNull
    @Override
    public StudentViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        return new StudentViewHolder(LayoutInflater.from(ctx).inflate(R.layout.row_design,parent,false));
    }

    @Override
    public void onBindViewHolder(@NonNull StudentViewHolder holder, int position) {
            holder.name_tv.setText(list.get(position).getName());
            holder.rollNum_tv.setText(list.get(position).getRollnumber());
            holder.delete_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    MainActivity.dataBase.studentDAO().delete(list.get(position));
                    Toast.makeText(ctx, "deleted "+holder.name_tv.getText().toString(), Toast.LENGTH_SHORT).show();
                }
            });
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class StudentViewHolder extends RecyclerView.ViewHolder {
        TextView edit_tv,delete_tv,name_tv,rollNum_tv;
        public StudentViewHolder(@NonNull View itemView) {
            super(itemView);
            edit_tv=itemView.findViewById(R.id.edit);
            delete_tv=itemView.findViewById(R.id.delete);
            name_tv=itemView.findViewById(R.id.name);
            rollNum_tv=itemView.findViewById(R.id.roll_num);
            edit_tv.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String name=name_tv.getText().toString();
                    String rollnum=rollNum_tv.getText().toString();
                    Intent i=new Intent(ctx,UpdateActivity.class);
                    i.putExtra("name",name);
                    i.putExtra("rol",rollnum);
                    ctx.startActivity(i);
                }
            });
        }
    }
}
