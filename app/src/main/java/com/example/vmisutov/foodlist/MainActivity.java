package com.example.vmisutov.foodlist;

import android.app.ListActivity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListAdapter;
import android.widget.ListView;
import android.widget.SimpleAdapter;
import android.widget.Toast;
import org.xmlpull.v1.XmlPullParser;

import java.io.Serializable;
import java.util.ArrayList;
public class MainActivity extends ListActivity {
    private static final String TAG = "MainActivity";
    ArrayList<Food> foodsList = new ArrayList<Food>();
    public final static String Name = "FoodName";
    public final static String Price = "FoodPrice";
    public final static String Description = "FoodDescription";
    public final static String Calories = "FoodCalories";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        try {
            XmlPullParser foodsParser = getResources().getXml(R.xml.foods);
            int eventType = foodsParser.getEventType();
            String name = null;
            String price = null;
            String description = null;
            String calories = null;


                while (eventType != XmlPullParser.END_DOCUMENT) {

                    if (eventType == XmlPullParser.START_TAG && foodsParser.getName().equals("name")) {
                        foodsParser.next();
                        name = foodsParser.getText();
                        //Log.e("name", foodsParser.getText());
                        // foodsParser.next();
                    } else if (eventType == XmlPullParser.START_TAG && foodsParser.getName().equals("price")) {
                        foodsParser.next();
                        price = foodsParser.getText();

                    } else if (eventType == XmlPullParser.START_TAG && foodsParser.getName().equals("description")) {
                        foodsParser.next();
                        description = foodsParser.getText();

                    } else if (eventType == XmlPullParser.START_TAG && foodsParser.getName().equals("calories")) {
                        foodsParser.next();
                        calories = foodsParser.getText();

                    }
                   if(eventType == XmlPullParser.END_TAG && foodsParser.getName().equals("food")) {
                       foodsList.add(new Food(name, price, description, calories));
                   }


                       eventType = foodsParser.next();

            }
        }
        catch (Throwable t) {
            Log.v(TAG, "Error XML-file loading: " + t.toString());
            Toast.makeText(this, "Error XML-file loading: " + t.toString(), Toast.LENGTH_LONG)
                    .show();
        }
        String[] from=new String[] { Food.NAME, Food.PRICE };
        int[] to=new int[] {R.id.nameView, R.id.priceView };
        ListAdapter adapter = new SimpleAdapter(this,foodsList,R.layout.food_list_item,from,to);
        setListAdapter(adapter);
//        setListAdapter(new ArrayAdapter<Food>(this, R.layout.food_list_item, foodsList));
    }
    @Override
    protected void onListItemClick (ListView l, View v, int position, long id) {

        Intent move = new Intent(this,FoodInfo.class);
        move.putExtra(Name, foodsList.get(position).get("name"));
        move.putExtra(Price, foodsList.get(position).get("price"));
        move.putExtra(Description, foodsList.get(position).get("description"));
        move.putExtra(Calories, foodsList.get(position).get("calories"));
        startActivity(move);
//
//          Toast.makeText(this, foodsList.get(position).NAME,
//                  Toast.LENGTH_SHORT).show();

    }



}