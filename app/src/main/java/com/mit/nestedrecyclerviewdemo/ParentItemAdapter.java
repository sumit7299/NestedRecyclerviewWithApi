package com.mit.nestedrecyclerviewdemo;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ParentItemAdapter extends RecyclerView.Adapter<ParentItemAdapter.ParentViewHolder> {



    private List<ParentModel> itemList;
    private Context context;

    public ParentItemAdapter(List<ParentModel> itemList, Context context) {
        this.itemList = itemList;
        this.context = context;
    }

    @NonNull
    @Override
    public ParentViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.parent_item, viewGroup, false);

        return new ParentViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ParentViewHolder parentViewHolder, int position)
    {

        parentViewHolder.categoryid.setText(itemList.get(position).getCategoryid());
        parentViewHolder.categoryname.setText(itemList.get(position).getCategory());
        parentViewHolder.layout.setText(itemList.get(position).getLayout());
        parentViewHolder.type.setText(itemList.get(position).getType());


//        parentViewHolder.ChildRecyclerView.setLayoutManager(new GridLayoutManager(context,0));



        LinearLayoutManager layoutManager = new LinearLayoutManager(parentViewHolder.ChildRecyclerView.getContext(),
                LinearLayoutManager.HORIZONTAL,
                false);

        parentViewHolder.ChildRecyclerView.setLayoutManager(layoutManager);



      parentViewHolder.ChildRecyclerView.setAdapter(new ChildItemAdapter(itemList.get(position).getChildItemList()));

    }


    @Override
    public int getItemCount()
    {

        return itemList.size();
    }


    class ParentViewHolder extends RecyclerView.ViewHolder {

        private TextView categoryid,categoryname,layout,type;
        private RecyclerView ChildRecyclerView;

        ParentViewHolder(final View itemView)
        {
            super(itemView);

            categoryid = itemView.findViewById(R.id.categoryid);
            categoryname=itemView.findViewById(R.id.categoryname);
            layout = itemView.findViewById(R.id.layout);
            type  = itemView.findViewById(R.id.type);

            ChildRecyclerView = itemView.findViewById(R.id.child_recyclerview);
        }
    }
}
