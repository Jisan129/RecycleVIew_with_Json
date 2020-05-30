package com.example.recycleview_with_json;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;
import android.view.textclassifier.TextLinks;

import com.android.volley.Request;
import com.android.volley.RequestQueue;
import com.android.volley.Response;
import com.android.volley.VolleyError;
import com.android.volley.toolbox.JsonObjectRequest;
import com.android.volley.toolbox.Volley;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    private RecyclerView mRecycleView;
    private ExampleAdapter mexampleAdapter;
    private ArrayList<ExampleItem> mexampleItems;
    private RequestQueue requestQueue;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
         setContentView(R.layout.activity_main);
         mRecycleView=findViewById(R.id.recycle_view);
         mRecycleView.setHasFixedSize(true);
         mRecycleView.setLayoutManager(new LinearLayoutManager(this));

         mexampleItems=new ArrayList<>();

         requestQueue = Volley.newRequestQueue(this);
         parseJSON();


    }

    private void parseJSON() {

        String url = "https://pixabay.com/api/?key=5303976-fd6581ad4ac165d1b75cc15b3&q=kitten&image_type=photo&pretty=true";
        JsonObjectRequest request=new JsonObjectRequest(Request.Method.GET, url, null,
                new Response.Listener<JSONObject>() {
                    @Override
                    public void onResponse(JSONObject response) {
                        try {
                            JSONArray jsonArray =response.getJSONArray("hits");
                            for (int i=0;i<jsonArray.length();i++){
                                JSONObject hit =jsonArray.getJSONObject(i);

                                String creatorName = hit.getString("user");
                                String imageUrl  =hit.getString("webformatURL");
                                int likeCount =hit.getInt("likes");


                                mexampleItems.add(new ExampleItem(imageUrl,creatorName,likeCount));

                            }
                            mexampleAdapter =new ExampleAdapter(MainActivity.this,mexampleItems);
                            mRecycleView.setAdapter(mexampleAdapter);

                        } catch (JSONException e) {
                            e.printStackTrace();
                        }

                    }
                }, new Response.ErrorListener() {
            @Override
            public void onErrorResponse(VolleyError error) {
                error.printStackTrace();
            }
        });
         requestQueue.add(request);
    }
}
