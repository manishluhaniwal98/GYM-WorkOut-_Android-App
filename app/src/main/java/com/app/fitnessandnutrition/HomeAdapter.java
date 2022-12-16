package com.app.fitnessandnutrition;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class HomeAdapter extends RecyclerView.Adapter<HomeAdapter.ViewHolder> {

    List<Categories> categoryList;
    ICategoryAdapter listener;

    public HomeAdapter(List<Categories> categoryList, ICategoryAdapter listener) {
        this.categoryList = categoryList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        ViewHolder holder = new ViewHolder(LayoutInflater.from(parent.getContext()).
                inflate(R.layout.item_home_layout, parent,false));

        holder.categoryImg.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                listener.onCategoryClick(categoryList.get(holder.getAdapterPosition()).getCategoryTitle());
            }
        });

        return holder;
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        holder.categoryImg.setImageResource(categoryList.get(position).getCategoryImg());
        holder.categoryTitle.setText(categoryList.get(position).getCategoryTitle());
    }

    @Override
    public int getItemCount() {
        return categoryList.size();
    }

    public static class ViewHolder extends RecyclerView.ViewHolder {

        ImageView categoryImg;
        TextView categoryTitle;

        public ViewHolder(@NonNull View itemView) {
            super(itemView);
            this.categoryImg = itemView.findViewById(R.id.home_category_img);
            this.categoryTitle = itemView.findViewById(R.id.home_category_title);
        }
    }
    interface ICategoryAdapter{
        void onCategoryClick(String title);
    }
}
