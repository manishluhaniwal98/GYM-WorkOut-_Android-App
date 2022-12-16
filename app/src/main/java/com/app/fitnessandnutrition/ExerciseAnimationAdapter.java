package com.app.fitnessandnutrition;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.airbnb.lottie.LottieAnimationView;

import java.util.List;

public class ExerciseAnimationAdapter extends RecyclerView.Adapter<ExerciseAnimationAdapter.ExerciseViewHolder> {

    List<Exercise> exerciseList;
    ExerciseItemClickListener listener;

    public ExerciseAnimationAdapter(List<Exercise> exerciseList, ExerciseItemClickListener listener) {
        this.exerciseList = exerciseList;
        this.listener = listener;
    }

    public void setExerciseList(List<Exercise> exerciseList) {
        this.exerciseList = exerciseList;
    }

    public void setListener(ExerciseItemClickListener listener) {
        this.listener = listener;
    }

    @NonNull
    @Override
    public ExerciseViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View itemView = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.item_exercise_animation, parent, false);
        return new ExerciseViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull ExerciseViewHolder holder, int position) {
        Exercise currentExercise = exerciseList.get(position);
        holder.lottieAnimationView.setAnimation(currentExercise.getExerciseAnimationId());
        holder.tvExerciseName.setText(currentExercise.getExerciseName());
        holder.tvExerciseRepetition.setText(currentExercise.exerciseRepetition);
    }

    @Override
    public int getItemCount() { return exerciseList.size(); }

    public class ExerciseViewHolder extends RecyclerView.ViewHolder {

        LottieAnimationView lottieAnimationView;
        TextView tvExerciseName;
        TextView tvExerciseRepetition;

        public ExerciseViewHolder(@NonNull View itemView) {
            super(itemView);
            this.lottieAnimationView = itemView.findViewById(R.id.lottieExercise);
            this.tvExerciseName = itemView.findViewById(R.id.tvExerciseName);
            this.tvExerciseRepetition = itemView.findViewById(R.id.tvRepetition);

            itemView.setOnClickListener(v ->
                    listener.onItemClick(exerciseList.get(getAdapterPosition()))
            );
        }
    }

    interface ExerciseItemClickListener{
        void onItemClick(Exercise currentExercise);
    }
}
