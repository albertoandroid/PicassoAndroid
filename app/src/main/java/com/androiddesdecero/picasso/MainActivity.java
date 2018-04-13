package com.androiddesdecero.picasso;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.squareup.picasso.Callback;
import com.squareup.picasso.MemoryPolicy;
import com.squareup.picasso.NetworkPolicy;
import com.squareup.picasso.Picasso;

public class MainActivity extends AppCompatActivity {

    private static final String URL_INTERNET = "https://img.youtube.com/vi/1FPAtnTOHUA/maxresdefault.jpg";
    private static final String URL_INTERNET_PICASO= "http://i.imgur.com/DvpvklR.png";

    private ImageView activityMainIvLoadInternet;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setUpView();

        //loadImageByInternetUrlWithPicasso();

        //loadImageWithResizeWithPicasso();

        //loadImageWithResizeCenterCrop();

        //loadImageWithResizeCenterInside();

        //loadImageWithScaleDownWithPicasso();

        //loadImageWithOnlyCacheWithPicasso();

        //loadImageWithOutCacheWithPicasso();

        loadImageWithPlaceHoldeWithPicasso();
    }

    private void setUpView(){
        activityMainIvLoadInternet = findViewById(R.id.activityMainIVInternet);
    }

    private void loadImageByInternetUrlWithPicasso(){
        Picasso.get()
                .load(URL_INTERNET)
                .into(activityMainIvLoadInternet);
    }

    private void loadImageWithResizeWithPicasso(){
        Picasso.get()
                .load(URL_INTERNET)
                .resize(200, 200)
                .into(activityMainIvLoadInternet);
    }

    private void loadImageWithResizeCenterCrop(){
        Picasso.get()
                .load(URL_INTERNET)
                .resize(200, 200)
                .centerCrop()
                .into(activityMainIvLoadInternet);
    }

    private void loadImageWithResizeCenterInside(){
        Picasso.get()
                .load(URL_INTERNET)
                .resize(200, 200)
                .centerInside()
                .into(activityMainIvLoadInternet);
    }

    private void loadImageWithScaleDownWithPicasso(){
        Picasso.get()
                .load(URL_INTERNET)
                .resize(2000, 2000)
                .onlyScaleDown()
                .into(activityMainIvLoadInternet);
    }

    private void loadImageWithOnlyCacheWithPicasso(){
        Picasso.get()
                .load(URL_INTERNET_PICASO)
                .networkPolicy(NetworkPolicy.OFFLINE)
                .into(activityMainIvLoadInternet);
    }

    private void loadImageWithOutCacheWithPicasso(){
        Picasso.get()
                .load(URL_INTERNET_PICASO)
                .fetch(new Callback() {
                    @Override
                    public void onSuccess() {
                        Picasso.get()
                                .load(URL_INTERNET_PICASO)
                                .networkPolicy(NetworkPolicy.NO_CACHE)
                                .memoryPolicy(MemoryPolicy.NO_CACHE)
                                .into(activityMainIvLoadInternet);
                    }

                    @Override
                    public void onError(Exception e) {

                    }
                });
    }

    private void loadImageWithPlaceHoldeWithPicasso(){
        Picasso.get()
                .load(URL_INTERNET_PICASO)
                .placeholder(R.mipmap.ic_launcher)
                .into(activityMainIvLoadInternet);
    }


}
