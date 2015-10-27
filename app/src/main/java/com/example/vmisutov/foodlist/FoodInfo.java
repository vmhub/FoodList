package com.example.vmisutov.foodlist;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.TextView;
import android.widget.Toast;

public class FoodInfo extends AppCompatActivity {
    private TextView foodName;
    private TextView foodDescription;
    private TextView foodPrice;
    private TextView foodCalories;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Intent intent = getIntent();
        setContentView(R.layout.activity_food_info);
        foodName = (TextView)findViewById(R.id.foodName);
        foodDescription = (TextView)findViewById(R.id.foodDescription);
        foodPrice = (TextView)findViewById(R.id.foodPrice);
        foodCalories = (TextView)findViewById(R.id.foodCalories);
//        Log.e("dfas", intent.getStringExtra(MainActivity.Name) + "  " + intent.getStringExtra(MainActivity.Description)+
//                "  " +  intent.getStringExtra(MainActivity.Price) + "  "+  intent.getStringExtra(MainActivity.Calories));
        foodName.setText(intent.getStringExtra(MainActivity.Name));
        foodDescription.setText(intent.getStringExtra(MainActivity.Description));
        foodPrice.setText("Price: "+intent.getStringExtra(MainActivity.Price));
        foodCalories.setText("Calories: "+intent.getStringExtra(MainActivity.Calories));

    }


}
