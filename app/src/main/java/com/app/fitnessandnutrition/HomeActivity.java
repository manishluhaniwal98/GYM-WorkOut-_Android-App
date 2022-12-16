package com.app.fitnessandnutrition;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.gms.tasks.OnSuccessListener;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;
import com.google.firebase.firestore.CollectionReference;
import com.google.firebase.firestore.DocumentSnapshot;
import com.google.firebase.firestore.FirebaseFirestore;
import com.google.firebase.firestore.QuerySnapshot;

import java.text.DecimalFormat;

import static com.app.fitnessandnutrition.Utilities.EXTRA_EXERCISE;
import static com.app.fitnessandnutrition.Utilities.HOME_EXERCISE;
import static com.app.fitnessandnutrition.Utilities.NUTRITION;
import static com.app.fitnessandnutrition.Utilities.STRETCHING_EXERCISE;
import static com.app.fitnessandnutrition.Utilities.USERS_COLLECTION_REF;
import static com.app.fitnessandnutrition.Utilities.YOGA_EXERCISE;

public class HomeActivity extends AppCompatActivity implements HomeAdapter.ICategoryAdapter {

    private final FirebaseAuth auth = FirebaseAuth.getInstance();
    private final FirebaseFirestore db = FirebaseFirestore.getInstance();
    private final CollectionReference usersRef = db.collection(USERS_COLLECTION_REF);

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);
        initRecyclerView();

    }

    private void initRecyclerView() {
        RecyclerView homeRecyclerView = findViewById(R.id.home_recycler_view);
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(RecyclerView.VERTICAL);
        homeRecyclerView.setLayoutManager(layoutManager);
        HomeAdapter adapter = new HomeAdapter(Utilities.categoryList, this);
        homeRecyclerView.setAdapter(adapter);
    }

    @Override
    public void onCategoryClick(String title) {
        if(title != null){

            Intent intent = new Intent(this, ExerciseActivity.class);
            switch (title){
                case "Home Workout":
                    startActivity(intent.putExtra(EXTRA_EXERCISE, HOME_EXERCISE));
                    break;
                case "Stretching":
                    startActivity(intent.putExtra(EXTRA_EXERCISE, STRETCHING_EXERCISE));
                    break;
                case "Nutrition":
                    startActivity(intent.putExtra(EXTRA_EXERCISE, NUTRITION));
                    break;
                case "Yoga":
                    startActivity(intent.putExtra(EXTRA_EXERCISE, YOGA_EXERCISE));
                    break;
                default:
                    Log.d("home_activity_log", "invalid title");
            }
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.home_menu, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {

        switch (item.getItemId()) {
            case R.id.miAboutUs:
                startActivity(new Intent(this, AboutUsActivity.class));
                break;

            case R.id.miLogout:
                auth.signOut();
                finish();
                startActivity(new Intent(this, LoginActivity.class));
        }
        return super.onOptionsItemSelected(item);
    }
}