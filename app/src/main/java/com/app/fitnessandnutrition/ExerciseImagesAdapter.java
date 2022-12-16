package com.app.fitnessandnutrition;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class ExerciseImagesAdapter extends RecyclerView.Adapter<ExerciseImagesAdapter.ExerciseImagesViewHolder> {

    public void setExerciseList(List<Categories> exerciseList) {
        this.exerciseList = exerciseList;
    }

    List<Categories> exerciseList;
    Boolean showImage = true;

    ExerciseImagesAdapter.ExerciseImagesItemClickListener listener;

    public void setShowImage(Boolean showImage) {
        this.showImage = showImage;
    }

    public void setListener(ExerciseImagesItemClickListener listener) {
        this.listener = listener;
    }

    public ExerciseImagesAdapter(List<Categories> exerciseList, ExerciseImagesAdapter.ExerciseImagesItemClickListener listener) {
        this.exerciseList = exerciseList;
        this.listener = listener;
    }

    @NonNull
    @Override
    public ExerciseImagesViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_exercise_image, parent, false);
        return new ExerciseImagesViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseImagesAdapter.ExerciseImagesViewHolder holder, int position) {
        Categories currentExercise = exerciseList.get(position);

        if(currentExercise != null) {

            if(showImage) {
                holder.ivExerciseImage.setImageResource(currentExercise.getCategoryImg());
            } else {
                holder.ivExerciseImage.setVisibility(View.GONE);

                ConstraintLayout.LayoutParams exerciseNameParams = new ConstraintLayout.LayoutParams(
                        ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                        ConstraintLayout.LayoutParams.WRAP_CONTENT
                );

                exerciseNameParams.bottomToBottom = ConstraintSet.PARENT_ID;
                exerciseNameParams.startToStart = ConstraintSet.PARENT_ID;
                exerciseNameParams.endToEnd = ConstraintSet.PARENT_ID;
                exerciseNameParams.topToTop = ConstraintSet.PARENT_ID;

                exerciseNameParams.topMargin = 50;
                exerciseNameParams.bottomMargin = 50;
                exerciseNameParams.leftMargin = 16;
                exerciseNameParams.rightMargin = 16;

                holder.tvExerciseName.setLayoutParams(exerciseNameParams);
                holder.tvExerciseName.setAllCaps(false);
            }

            holder.tvExerciseName.setText(currentExercise.getCategoryTitle());
        }
    }

    @Override
    public int getItemCount() { return exerciseList.size(); }

    public class ExerciseImagesViewHolder extends RecyclerView.ViewHolder {

        ImageView ivExerciseImage;
        TextView tvExerciseName;

        public ExerciseImagesViewHolder(@NonNull View itemView) {
            super(itemView);
            this.ivExerciseImage = itemView.findViewById(R.id.ivExerciseImage);
            this.tvExerciseName = itemView.findViewById(R.id.tvExerciseTitle);

            itemView.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    listener.onItemClick(exerciseList.get(getAdapterPosition()));
                }
            });
        }
    }

    interface ExerciseImagesItemClickListener{
        void onItemClick(Categories currentExercise);
    }
}
