package com.example.recycleview_with_json;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;

public class ExampleAdapter extends RecyclerView.Adapter<ExampleAdapter.ExampleViewHolder> {
    private Context mContext;
    private ArrayList<ExampleItem> mexampleItems;


    public ExampleAdapter(Context context, ArrayList <ExampleItem> exampleItems){
        mContext=context;
        mexampleItems=exampleItems;
    }

    public class ExampleViewHolder extends RecyclerView.ViewHolder{
        public ImageView mimageView;
        public TextView mname;
        public TextView mlike;
        public ExampleViewHolder(@NonNull View itemView) {
            super(itemView);

            mimageView=itemView.findViewById(R.id.imageview);
            mname=itemView.findViewById(R.id.imagename);
            mlike=itemView.findViewById(R.id.like);

        }
    }


    @NonNull
    @Override
    public ExampleViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View v = LayoutInflater.from(mContext).inflate(R.layout.example_item,parent,false);
        return new ExampleViewHolder(v);
    }

    @Override
    public void onBindViewHolder(@NonNull ExampleViewHolder holder, int position) {
          ExampleItem currentItem =mexampleItems.get(position);

          String imageUrl =currentItem.getMimageId();
          String creatorName =currentItem.getMimageName();
          int likes=currentItem.getMlikes();

          holder.mname.setText(creatorName);
          holder.mlike.setText("Likes "+likes);
        Picasso.get().load(imageUrl).centerInside().into(holder.mimageView);

    }



    @Override
    public int getItemCount() {
        return 0;
    }
}
