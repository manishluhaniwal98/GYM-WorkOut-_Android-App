package com.app.fitnessandnutrition;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.Collections;

import static com.app.fitnessandnutrition.Utilities.EXTRA_DETAIL_TYPE;
import static com.app.fitnessandnutrition.Utilities.EXTRA_EXERCISE;
import static com.app.fitnessandnutrition.Utilities.HOME_EXERCISE;
import static com.app.fitnessandnutrition.Utilities.NUTRITION;
import static com.app.fitnessandnutrition.Utilities.STRETCHING_EXERCISE;
import static com.app.fitnessandnutrition.Utilities.TYPE_ANIMATION;
import static com.app.fitnessandnutrition.Utilities.TYPE_IMAGES;
import static com.app.fitnessandnutrition.Utilities.YOGA_EXERCISE;
import static com.app.fitnessandnutrition.Utilities.homeAdvancedExerciseList;
import static com.app.fitnessandnutrition.Utilities.homeBeginnerExerciseList;
import static com.app.fitnessandnutrition.Utilities.homeIntermediateExerciseList;
import static com.app.fitnessandnutrition.Utilities.nutritionFatLossTipsList;
import static com.app.fitnessandnutrition.Utilities.nutritionHealthTipsList;
import static com.app.fitnessandnutrition.Utilities.nutritionImagesList;
import static com.app.fitnessandnutrition.Utilities.stretchingExerciseList;
import static com.app.fitnessandnutrition.Utilities.yogaExerciseList;

public class ExerciseActivity extends AppCompatActivity {

    String exerciseType;
    RecyclerView homeRecyclerView;
    LinearLayout llHomeCategories;
    Button btnFirst;
    Button btnSecond;
    Button btnThird;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_exercise);

        llHomeCategories = findViewById(R.id.llHomeCategory);
        btnFirst = findViewById(R.id.btnBeginner);
        btnSecond = findViewById(R.id.btnIntermediate);
        btnThird = findViewById(R.id.btnAdvanced);

        exerciseType = getIntent().getStringExtra(EXTRA_EXERCISE);

        Log.d("Nully", exerciseType);
        initRecyclerView();
    }

    private void initRecyclerView() {
        homeRecyclerView = findViewById(R.id.rvExercise);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        homeRecyclerView.setLayoutManager(layoutManager);

        if (exerciseType.equals(HOME_EXERCISE) || exerciseType.equals(STRETCHING_EXERCISE)) {
            setupAnimationAdapter();
            return;
        }

        setupImagesAdapter();
    }

    private void setupAnimationAdapter() {

        ExerciseAnimationAdapter animationAdapter = new ExerciseAnimationAdapter(Collections.emptyList(), currentExercise -> {
            Intent intent = new Intent(this, ExerciseDetailActivity.class);
            intent.putExtra(EXTRA_EXERCISE, currentExercise);
            intent.putExtra(EXTRA_DETAIL_TYPE, TYPE_ANIMATION);
            startActivity(intent);
        });
        homeRecyclerView.setAdapter(animationAdapter);

        if(exerciseType.equals(HOME_EXERCISE)) {
            llHomeCategories.setVisibility(View.VISIBLE);

            btnFirst.setOnClickListener(v -> {
                animationAdapter.setExerciseList(homeBeginnerExerciseList);
                showRecyclerView();
            });

            btnSecond.setOnClickListener(v -> {
                animationAdapter.setExerciseList(homeIntermediateExerciseList);
                showRecyclerView();
            });

            btnThird.setOnClickListener(v -> {
                animationAdapter.setExerciseList(homeAdvancedExerciseList);
                showRecyclerView();
            });
        } else if (exerciseType.equals(STRETCHING_EXERCISE)) {
            animationAdapter.setExerciseList(stretchingExerciseList);
            animationAdapter.setListener((currentExercise) -> { /*NO-OP*/ });
            showRecyclerView();
        }
    }

    private void setupImagesAdapter() {
        Log.d("Nully", "Inside Images Adapter");

        ExerciseImagesAdapter imagesAdapter = new ExerciseImagesAdapter(Collections.emptyList(), currentExercise -> {
            Intent intent = new Intent(this, ExerciseDetailActivity.class);
            intent.putExtra(EXTRA_EXERCISE, currentExercise);
            intent.putExtra(EXTRA_DETAIL_TYPE, TYPE_IMAGES);
            startActivity(intent);
        });
        homeRecyclerView.setAdapter(imagesAdapter);

        if(exerciseType.equals(NUTRITION)) {

            Log.d("Nully", "Here");

            imagesAdapter.setListener(currentExercise -> { /*NO-OP*/ });

            llHomeCategories.setVisibility(View.VISIBLE);

            btnFirst.setText("Healthy Diet");
            btnFirst.setOnClickListener(v -> {
                Log.d("Nully", "First");
                imagesAdapter.setExerciseList(nutritionImagesList);
                showRecyclerView();
            });

            btnSecond.setText("Fat Loss Tips");
            btnSecond.setOnClickListener(v -> {
                Log.d("Nully", "Second");
                imagesAdapter.setExerciseList(nutritionFatLossTipsList);
                imagesAdapter.setShowImage(false);
                showRecyclerView();
            });

            btnThird.setText("General Health Tips");
            btnThird.setOnClickListener(v -> {
                Log.d("Nully", "Third");
                imagesAdapter.setExerciseList(nutritionHealthTipsList);
                imagesAdapter.setShowImage(false);
                showRecyclerView();
            });

        } else if (exerciseType.equals(YOGA_EXERCISE)) {
            imagesAdapter.setExerciseList(yogaExerciseList);
            showRecyclerView();
        }
    }

    private void showRecyclerView() {
        llHomeCategories.setVisibility(View.GONE);
        homeRecyclerView.setVisibility(View.VISIBLE);
    }
}
