package com.mit.nestedrecyclerviewdemo;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ChildItemAdapter extends RecyclerView.Adapter<ChildItemAdapter.ChildViewHolder> {

    private List<ChildModel> ChildItemList;

    public ChildItemAdapter(List<ChildModel> childItemList) {
        ChildItemList = childItemList;

    }

    @NonNull
    @Override
    public ChildViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.child_item, viewGroup, false);

        return new ChildViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ChildViewHolder childViewHolder, int position)
    {

       ChildModel childItem = ChildItemList.get(position);

       childViewHolder.childtitle.setText(childItem.getTitle());
        childViewHolder.childdescription.setText(childItem.getDescription());
        childViewHolder.childprice.setText(childItem.getPrice());
        childViewHolder.childdate.setText(childItem.getValidtill());


    }

    @Override
    public int getItemCount()
    {

        return ChildItemList.size();
    }


    class ChildViewHolder extends RecyclerView.ViewHolder {

        TextView childtitle,childdescription,childprice,childdate;

        ChildViewHolder(View itemView)
        {
            super(itemView);
            childtitle = itemView.findViewById(R.id.childtitle);
            childdescription = itemView.findViewById(R.id.childdescription);
            childprice = itemView.findViewById(R.id.childprice);
            childdate = itemView.findViewById(R.id.childdate);

        }
    }
}
