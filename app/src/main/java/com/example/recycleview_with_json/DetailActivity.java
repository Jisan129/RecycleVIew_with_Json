package com.example.recycleview_with_json;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import static com.example.recycleview_with_json.MainActivity.EXTRA_CREATOR;
import static com.example.recycleview_with_json.MainActivity.EXTRA_LIKES;
import static com.example.recycleview_with_json.MainActivity.EXTRA_URL;

public class DetailActivity extends AppCompatActivity {
    private ImageView imageViewDetails;
    private TextView creatorDetails;
    private TextView likesDetails;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);
        Intent intent =getIntent();

        String imageUrl=intent.getStringExtra(EXTRA_URL);
        String creatorName=intent.getStringExtra(EXTRA_CREATOR);
        int  likes =intent.getIntExtra(EXTRA_LIKES,0);




        imageViewDetails=findViewById(R.id.imageViewDetails);
        creatorDetails=findViewById(R.id.creatorDetails);
        likesDetails=findViewById(R.id.likeDetails);

        Picasso.get().load(imageUrl).fit().into(imageViewDetails);
        creatorDetails.setText(creatorName);
        likesDetails.setText("Likes "+likes);
    }
}
