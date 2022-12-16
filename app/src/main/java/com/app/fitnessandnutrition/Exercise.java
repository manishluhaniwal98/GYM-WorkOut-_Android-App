package com.app.fitnessandnutrition;

import java.io.Serializable;

public class Exercise implements Serializable {

    String exerciseName;
    Integer exerciseAnimationId;
    String exerciseRepetition;
    Integer exerciseDescriptionStringId = 0;

    public Exercise(String exerciseName, Integer exerciseAnimationId, String exerciseRepetition) {
        this.exerciseName = exerciseName;
        this.exerciseAnimationId = exerciseAnimationId;
        this.exerciseRepetition = exerciseRepetition;
    }

    public Exercise(String exerciseName, Integer exerciseAnimationId, String exerciseRepetition, Integer exerciseDescriptionStringId) {
        this.exerciseName = exerciseName;
        this.exerciseAnimationId = exerciseAnimationId;
        this.exerciseRepetition = exerciseRepetition;
        this.exerciseDescriptionStringId = exerciseDescriptionStringId;
    }

    public String getExerciseName() {
        return exerciseName;
    }
    public Integer getExerciseAnimationId() {
        return exerciseAnimationId;
    }
}
