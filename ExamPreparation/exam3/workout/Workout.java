package ExamPreparation.exam3.workout;

import java.util.ArrayList;
import java.util.List;

public class Workout {
    private List<Exercise> exercises;
    private String type;
    private int exerciseCount;

    public Workout(String type, int exerciseCount) {
        this.type = type;
        this.exerciseCount = exerciseCount;
        this.exercises = new ArrayList<>();
    }


    public void addExercise(Exercise exercise) {
        if (exercises.size() < exerciseCount) {
            exercises.add(exercise);
        }
    }

    public Exercise getExercise(String name, String muscle) {
        for (Exercise exercise : exercises) {
            if (exercise.getName().equals(name) && exercise.getMuscle().equals(muscle)) {
                return exercise;
            }
        }
        return null;
    }

    public boolean removeExercise(String name, String muscle) {
        Exercise exercise = getExercise(name, muscle);
        return exercises.remove(exercise);
    }
    public Exercise getMostBurnedCaloriesExercise(){
        int calories = 0;
        if (!exercises.isEmpty()){
            for (Exercise exercise : exercises) {
                if (exercise.getBurnedCalories()>calories){
                    calories=exercise.getBurnedCalories();
                }
            }
            for (Exercise exercise : exercises) {
                if (exercise.getBurnedCalories()==calories){
                    return exercise;
                }
            }

        }
        return null;

    }

    public int getExerciseCount() {
        return exercises.size();
    }


    public String getStatistics() {
        StringBuilder stringBuilder = new StringBuilder();
        stringBuilder.append(String.format("Workout type: %s",type)).append(System.lineSeparator());
        for (Exercise exercise : exercises) {
            stringBuilder.append(exercise.toString()).append(System.lineSeparator());
        }

        return stringBuilder.toString();
    }
}
