package sg.edu.rp.c346.id21023028.demoweather;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.loopj.android.http.AsyncHttpClient;
import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import cz.msebera.android.httpclient.Header;


public class MainActivity extends AppCompatActivity {

    ListView lvWeather;
    AsyncHttpClient client;
    ArrayAdapter<Weather> adapter;
    ArrayAdapter<Car> adapter2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //link variable to UI
        lvWeather = findViewById(R.id.lvWeather);

        client = new AsyncHttpClient();
    }

    //code for using weather API and displaying
//    @Override
//    protected void onResume() {
//        super.onResume();
//        ArrayList<Weather> alWeather = new ArrayList<Weather>();
//        client.get("https://api.data.gov.sg/v1/environment/2-hour-weather-forecast", new JsonHttpResponseHandler() {
//            String area;
//            String forecast;
//
//            @Override
//            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
//                try {
//                    JSONArray jsonArrItems = response.getJSONArray("items");
//                    JSONObject firstObj = jsonArrItems.getJSONObject(0);
//                    JSONArray jsonArrForecasts = firstObj.getJSONArray("forecasts");
//                    for(int i = 0; i < jsonArrForecasts.length(); i++) {
//                        JSONObject jsonObjForecast = jsonArrForecasts.getJSONObject(i);
//                        area = jsonObjForecast.getString("area");
//                        forecast = jsonObjForecast.getString("forecast");
//                        Weather weather = new Weather(area, forecast);
//                        alWeather.add(weather);
//                    }
//                }
//                catch(JSONException e){
//                }
//                //POINT X – Code to display List View
//                //create adapter for weather and link it
//                adapter = new ArrayAdapter<Weather>(MainActivity.this,
//                        android.R.layout.simple_list_item_1, alWeather); //note the context has to be explicitly stated since we are within another overidden function and context is not clear
//                lvWeather.setAdapter(adapter);
//            }//end onSuccess
//        });
//    }//end onResume


    //car exercise
    @Override
    protected void onResume() {
        super.onResume();
        ArrayList<Car> alCar = new ArrayList<Car>();
        client.get("https://api.data.gov.sg/v1/transport/carpark-availability", new JsonHttpResponseHandler() {
            String carparknumber;
            int slots;

            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONObject response) {
                try {
                    JSONArray jsonARR1 = response.getJSONArray("items"); //items array
                    JSONObject object = jsonARR1.getJSONObject(0); //get object
                    JSONArray jsonArrItems = object.getJSONArray("carpark_data"); //get carpark_data array
                    for(int i = 0; i < jsonArrItems.length(); i++) {
                        JSONObject obj = jsonArrItems.getJSONObject(i); //get json object
                        carparknumber = obj.getString("carpark_number");
                        JSONArray jsonArrInfo = obj.getJSONArray("carpark_info");
                        JSONObject obj2 = jsonArrInfo.getJSONObject(0);
                        slots = obj2.getInt("lots_available");
                        Car car = new Car(carparknumber,slots);
                        alCar.add(car);
                    }
                }
                catch(JSONException e){
                }
                //POINT X – Code to display List View
                //create adapter for weather and link it
                adapter2 = new ArrayAdapter<Car>(MainActivity.this,
                        android.R.layout.simple_list_item_1, alCar); //note the context has to be explicitly stated since we are within another overidden function and context is not clear
                lvWeather.setAdapter(adapter2);
            }//end onSuccess
        });
    }//end onResume

}