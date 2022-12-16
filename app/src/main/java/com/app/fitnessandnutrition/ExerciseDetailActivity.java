package com.app.fitnessandnutrition;

import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;
import androidx.constraintlayout.widget.ConstraintSet;

import com.airbnb.lottie.LottieAnimationView;

import static com.app.fitnessandnutrition.Utilities.EXTRA_DETAIL_TYPE;
import static com.app.fitnessandnutrition.Utilities.EXTRA_EXERCISE;
import static com.app.fitnessandnutrition.Utilities.TYPE_ANIMATION;
import static com.app.fitnessandnutrition.Utilities.TYPE_IMAGES;

public class ExerciseDetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise_detail);

        LottieAnimationView detailAnimation = findViewById(R.id.lottieDetailAnimation);
        TextView tvExerciseName = findViewById(R.id.tvDetailExerciseName);
        TextView tvExerciseDetail = findViewById(R.id.tvDetailExerciseDescription);
        ImageView ivExerciseImage = findViewById(R.id.ivDetailExerciseImage);

        String detailType = getIntent().getStringExtra(EXTRA_DETAIL_TYPE);

        if(detailType.equals(TYPE_ANIMATION)) {
            Exercise currentExercise = (Exercise) getIntent().getSerializableExtra(EXTRA_EXERCISE);
            detailAnimation.setAnimation(currentExercise.exerciseAnimationId);
            tvExerciseName.setText(currentExercise.exerciseName);
            tvExerciseDetail.setText(getResources().getString(currentExercise.exerciseDescriptionStringId));
            ivExerciseImage.setVisibility(View.GONE);

        } else if (detailType.equals(TYPE_IMAGES)){

            Categories currentExercise = (Categories) getIntent().getSerializableExtra(EXTRA_EXERCISE);
            ivExerciseImage.setImageResource(currentExercise.getCategoryImg());
            tvExerciseName.setText(currentExercise.getCategoryTitle());
            ivExerciseImage.setVisibility(View.VISIBLE);
            tvExerciseDetail.setVisibility(View.GONE);

            ConstraintLayout.LayoutParams exerciseImageParams = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
            );

            exerciseImageParams.bottomToTop = R.id.tvDetailExerciseName;
            exerciseImageParams.startToStart = ConstraintSet.PARENT_ID;
            exerciseImageParams.endToEnd = ConstraintSet.PARENT_ID;
            exerciseImageParams.topToTop = ConstraintSet.PARENT_ID;
            exerciseImageParams.leftMargin = 16;
            exerciseImageParams.rightMargin = 16;
            exerciseImageParams.bottomMargin = 16;

            ivExerciseImage.setLayoutParams(exerciseImageParams);

            ConstraintLayout.LayoutParams exerciseNameParams = new ConstraintLayout.LayoutParams(
                    ConstraintLayout.LayoutParams.MATCH_CONSTRAINT,
                    ConstraintLayout.LayoutParams.WRAP_CONTENT
            );

            exerciseNameParams.bottomToBottom = ConstraintSet.PARENT_ID;
            exerciseNameParams.startToStart = ConstraintSet.PARENT_ID;
            exerciseNameParams.endToEnd = ConstraintSet.PARENT_ID;
            exerciseNameParams.bottomMargin = 16;

            tvExerciseName.setLayoutParams(exerciseNameParams);;
        }
    }
}
