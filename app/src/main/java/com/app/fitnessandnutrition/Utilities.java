package com.app.fitnessandnutrition;

import java.util.Arrays;
import java.util.List;

public class Utilities {
    public static final String USERS_COLLECTION_REF = "users";

    public static final String EXTRA_EXERCISE = "exercise";

    public static final String EXTRA_DETAIL_TYPE = "detail_type";

    public static final String TYPE_IMAGES = "images";
    public static final String TYPE_ANIMATION = "animation";

    public static final String STRETCHING_EXERCISE = "stretching";
    public static final String HOME_EXERCISE = "home";
    public static final String YOGA_EXERCISE = "yoga";
    public static final String NUTRITION = "nutrition";

    public static final List<Exercise> homeBeginnerExerciseList = Arrays.asList(
            new Exercise("High Knee Taps", R.raw.beg_high_knee_taps, "30s", R.string.high_knee_taps),
            new Exercise("Jumping Jacks", R.raw.beg_jumping_jacks, "30s", R.string.jumping_jacks),
            new Exercise("Bridge", R.raw.beg_bridge, "30s", R.string.bridge),
            new Exercise("Incline Push Ups", R.raw.beg_inclined_push_ups, "10 x", R.string.incline_push_ups),
            new Exercise("Mountain Climbers", R.raw.beg_mountain_climber, "20s", R.string.mountain_climbers),
            new Exercise("Forward Lunges", R.raw.beg_forward_lunges, "15 x", R.string.forward_lunges),
            new Exercise("Deficit Push Ups", R.raw.beg_deficit_push_ups, "10 x", R.string.deficit_push_ups),
            new Exercise("Floor Dips", R.raw.beg_floor_dips, "12 x", R.string.floor_dips),
            new Exercise("Squats", R.raw.beg_squat, "10 x", R.string.squats),
            new Exercise("Planks", R.raw.beg_plank, "40s", R.string.planks),
            new Exercise("Bicycle Crunches", R.raw.beg_bicycle_crunch, "30s", R.string.bicycle_crunches),
            new Exercise("Cobra Stretch", R.raw.beg_cobra_stretch,"30s", R.string.cobra_stretch),
            new Exercise("Chest Shoulder Stretch", R.raw.beg_chest_shoulder_stretch,"30s", R.string.chest_shoulder_stretch),
            new Exercise("Child Pose", R.raw.beg_child_pose,"30s", R.string.child_pose)
    );

    public static final List<Exercise> homeIntermediateExerciseList = Arrays.asList(
            new Exercise("High Knee Taps", R.raw.beg_high_knee_taps, "60s", R.string.high_knee_taps),
            new Exercise("Jumping Jacks", R.raw.beg_jumping_jacks, "60s", R.string.jumping_jacks),
            new Exercise("Burpees", R.raw.med_burpees, "10 x", R.string.burpees),
            new Exercise("Deficit Push Ups", R.raw.beg_deficit_push_ups, "15 x", R.string.deficit_push_ups),
            new Exercise("Mountain Climbers", R.raw.beg_mountain_climber, "40s", R.string.mountain_climbers),
            new Exercise("Forward Lunges", R.raw.beg_forward_lunges, "20 x", R.string.forward_lunges),
            new Exercise("Decline Push Ups", R.raw.med_decline_push_ups, "10 x", R.string.decline_push_ups),
            new Exercise("Floor Dips", R.raw.beg_floor_dips, "12 x", R.string.floor_dips),
            new Exercise("Squats", R.raw.beg_squat, "15 x", R.string.squats),
            new Exercise("Planks", R.raw.beg_plank, "60s", R.string.planks),
            new Exercise("Flutter Kicks", R.raw.med_flutter_kicks, "40s", R.string.flutter_kicks),
            new Exercise("Cobra Stretch", R.raw.beg_cobra_stretch,"40s", R.string.cobra_stretch),
            new Exercise("Chest Shoulder Stretch", R.raw.beg_chest_shoulder_stretch,"40s", R.string.chest_shoulder_stretch),
            new Exercise("Child Pose", R.raw.beg_child_pose,"30s", R.string.child_pose)
    );

    public static final List<Exercise> homeAdvancedExerciseList = Arrays.asList(
            new Exercise("High Knee Taps", R.raw.beg_high_knee_taps, "60s", R.string.high_knee_taps),
            new Exercise("Jumping Jacks", R.raw.beg_jumping_jacks, "60s", R.string.jumping_jacks),
            new Exercise("Bird Dog", R.raw.adv_bird_dog, "30 x", R.string.bird_dog),
            new Exercise("Jumping Lunges", R.raw.adv_jumping_lunges, "40s", R.string.jumping_lunges),
            new Exercise("Burpees", R.raw.med_burpees, "15 x", R.string.burpees),
            new Exercise("Archer Push Ups", R.raw.adv_archer_push_ups, "10 x", R.string.archer_push_ups),
            new Exercise("Mountain Climbers", R.raw.beg_mountain_climber, "60s", R.string.mountain_climbers),
            new Exercise("Squat Jumps", R.raw.adv_squat_jumps, "20 x", R.string.squat_jumps),
            new Exercise("Decline Push Ups", R.raw.med_decline_push_ups, "15 x", R.string.decline_push_ups),
            new Exercise("Floor Dips", R.raw.beg_floor_dips, "15 x", R.string.floor_dips),
            new Exercise("Squats", R.raw.beg_squat, "15 x", R.string.squats),
            new Exercise("Plank Low to High", R.raw.adv_plank_low_to_high, "40s", R.string.plank_low_to_high),
            new Exercise("Flutter Kicks", R.raw.med_flutter_kicks, "60s", R.string.flutter_kicks),
            new Exercise("Cobra Stretch", R.raw.beg_cobra_stretch,"60s", R.string.cobra_stretch),
            new Exercise("Chest Shoulder Stretch", R.raw.beg_chest_shoulder_stretch,"40s", R.string.chest_shoulder_stretch),
            new Exercise("Child Pose", R.raw.beg_child_pose,"40s", R.string.child_pose)
    );

    public static final List<Exercise> stretchingExerciseList = Arrays.asList(
            new Exercise("Bench Hamstring Stretch Left", R.raw.bench_hamstring_stretch_left, "30s"),
            new Exercise("Bench Hamstring Stretch Right", R.raw.bench_hamstring_stretch_right, "30s"),
            new Exercise("Bench Kneeling Lat Stretch Left", R.raw.bench_kneeling_lat_stretch_left, "30s"),
            new Exercise("Bench Kneeling Lat Stretch Right", R.raw.bench_kneeling_lat_stretch_right, "30s"),
            new Exercise("Box Glute Stretch Left", R.raw.box_glute_stretch_left, "30s"),
            new Exercise("Box Glute Stretch Right", R.raw.box_glute_stretch_right, "30s"),
            new Exercise("Chest Shoulders Stretch", R.raw.chest_shoulders_stretch, "30s"),
            new Exercise("Chest Stretch Left", R.raw.chest_stretch_left, "30s"),
            new Exercise("Chest Stretch Right", R.raw.chest_stretch_right, "30s"),
            new Exercise("Cobra Stretch", R.raw.cobra_stretch, "30s"),
            new Exercise("Dynamic Chest Shoulders Stretch", R.raw.dynamic_chest_shoulders_stretch, "30s"),
            new Exercise("Dynamic Chest Stretch", R.raw.dynamic_chest_stretch,"30s"),
            new Exercise("Dynamic Hamstring Stretch Left", R.raw.dynamic_hamstring_stretch_left,"30s"),
            new Exercise("Dynamic Hamstring Stretch Right", R.raw.dynamic_hamstring_stretch_right,"30s"),
            new Exercise("Hamstring Stretch Left", R.raw.hamstring_stretch_left,"30s"),
            new Exercise("Hamstring Stretch Right", R.raw.hamstring_stretch_right,"30s"),
            new Exercise("Lying Abductor Stretch Left", R.raw.lying_abductor_stretch_left,"30s"),
            new Exercise("Lying Abductor Stretch Right", R.raw.lying_abductor_stretch_right,"30s"),
            new Exercise("Neck Stretch Left", R.raw.neck_stretch_left,"30s"),
            new Exercise("Neck Stretch Right", R.raw.neck_stretch_right,"30s"),
            new Exercise("Prone Chest Stretch Left", R.raw.prone_chest_stretch_left,"30s"),
            new Exercise("Prone Chest Stretch Right", R.raw.prone_chest_stretch_right,"30s"),
            new Exercise("Torso Twist Stretch Left", R.raw.torso_twist_stretch_left,"30s"),
            new Exercise("Torso Twist Stretch Right", R.raw.torso_twist_stretch_right,"30s"),
            new Exercise("Twisting Hip Flexor Stretch Left", R.raw.twisting_hip_flexor_stretch_left,"30s"),
            new Exercise("Twisting Hip Flexor Stretch Right", R.raw.twisting_hip_flexor_stretch_right,"30s")
    );

    public static final List<Categories> categoryList =  Arrays.asList(
            new Categories(R.drawable.bg_home_workout, "Home Workout"),
            new Categories(R.drawable.bg_gym_workout, "Stretching"),
            new Categories(R.drawable.bg_yoga, "Yoga"),
            new Categories(R.drawable.bg_nutrition, "Nutrition")
    );

    public static final List<Categories> yogaExerciseList = Arrays.asList(
            new Categories(R.drawable.yoga_boat_pose, "Boat Pose"),
            new Categories(R.drawable.yoga_bow_pose, "Bow Pose"),
            new Categories(R.drawable.yoga_cobra_pose, "Cobra Pose"),
            new Categories(R.drawable.yoga_crescent_lunge, "Crescent Lunge"),
            new Categories(R.drawable.yoga_downward_facing_dog, "Downward Facing Dog"),
            new Categories(R.drawable.yoga_easy_pose, "Easy Pose"),
            new Categories(R.drawable.yoga_half_pigeon, "Half Pigeon"),
            new Categories(R.drawable.yoga_low_lunge, "Low Lunge"),
            new Categories(R.drawable.yoga_upward_bow, "Upward Bow"),
            new Categories(R.drawable.yoga_warrior_pose, "Warrior Pose"),
            new Categories(R.drawable.yoga_warrior_pose_2, "Warrior Pose 2")
    );

    public static final List<Categories> nutritionImagesList = Arrays.asList(
            new Categories(R.drawable.bread, "Bread"),
            new Categories(R.drawable.chicken, "Chicken"),
            new Categories(R.drawable.cottage_cheese, "Cottage Cheese"),
            new Categories(R.drawable.eggs, "Eggs"),
            new Categories(R.drawable.fruits, "Fruits"),
            new Categories(R.drawable.lentils, "Lentils"),
            new Categories(R.drawable.milk, "Milk"),
            new Categories(R.drawable.nuts, "Nuts"),
            new Categories(R.drawable.oats, "Oats"),
            new Categories(R.drawable.soya_chunks, "Soya Chunks"),
            new Categories(R.drawable.vegetables, "Vegetables"),
            new Categories(R.drawable.whey_protein, "Whey Protein"),
            new Categories(R.drawable.yogurt, "Yogurt")
    );

    public static final List<Categories> nutritionFatLossTipsList = Arrays.asList(
            new Categories("Eat plenty of soluble fiber"),
            new Categories("Avoid foods that contain trans fats"),
            new Categories("Don’t drink too much alcohol"),
            new Categories("Eat a high protein diet"),
            new Categories("Reduce your stress levels"),
            new Categories("Don’t eat a lot of sugary foods"),
            new Categories("Do aerobic exercise (cardio)"),
            new Categories("Cut back on carbs"),
            new Categories("Avoid sugar-sweetened beverages"),
            new Categories("Get plenty of restful sleep"),
            new Categories("Track your food intake and exercise"),
            new Categories("Eat fatty fish every week"),
            new Categories("Try intermittent fasting"),
            new Categories("Drink green tea")
    );

    public static final List<Categories> nutritionHealthTipsList = Arrays.asList(
            new Categories("Eat a healthy diet"),
            new Categories("Consume less salt and sugar"),
            new Categories("Reduce intake of harmful fats"),
            new Categories("Avoid alcohol"),
            new Categories("Don’t smoke"),
            new Categories("Be physically active"),
            new Categories("Check your blood pressure regularly"),
            new Categories("Prevent mosquito bites"),
            new Categories("Drink only safe water"),
            new Categories("Take antibiotics only as prescribed"),
            new Categories("Clean your hands properly"),
            new Categories("Prepare your food correctly"),
            new Categories("Have regular check-ups"),
            new Categories("Don’t drink sugar calories"),
            new Categories("Eat nuts"),
            new Categories("Avoid processed junk food"),
            new Categories("Eat vegetables and fruits"),
            new Categories("Get enough sleep"),
            new Categories("Make sure to eat enough protein")
    );
}


