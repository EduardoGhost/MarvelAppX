package com.example.marvelappx.ui;

import android.net.Uri;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.MediaController;
import android.widget.Toast;
import android.widget.VideoView;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import com.example.marvelappx.R;
import com.google.android.youtube.player.YouTubeBaseActivity;
import com.google.android.youtube.player.YouTubeInitializationResult;
import com.google.android.youtube.player.YouTubePlayer;
import com.google.android.youtube.player.YouTubePlayerView;

import java.util.Arrays;
import java.util.Random;

public class VideoViewActivity extends YouTubeBaseActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view_activity);
//
//        MediaController mediaController;
//        mediaController = new MediaController(getApplicationContext());
//        int [] array = {R.raw.miranha, R.raw.miranha3, R.raw.video4};

//       String [] arrayURL = {"https://www.youtube.com/watch?v=Jrpv1C0WHFI", "https://www.youtube.com/watch?v=2Lba2qhWBe8"
//       , "https://www.youtube.com/watch?v=d81p3CFa9oM", "https://www.youtube.com/watch?v=uYUd54FpOIE",
//               "https://www.youtube.com/watch?v=dJU7io6neHk"};
////
//        VideoView mVideoView = findViewById(R.id.video_view);
//        Uri localUri = Uri.parse("android.resource://" + getPackageName() + "/" + array[1]);
//        mVideoView.setVideoURI(localUri);
//        mVideoView.setMediaController(mediaController);
//        mVideoView.stopPlayback();
//        mVideoView.start();

       // WebView myWebView = (WebView) findViewById(R.id.video_view);

//        Random random = new Random();
//        for (int i = 0; i < arrayURL.length; i++) {
//            int j = random.nextInt(arrayURL.length);
//            System.out.println("ZZZ " + j);
//            WebView myWebView = (WebView) findViewById(R.id.video_view);
//            myWebView.loadUrl(arrayURL[j]);
//            break;
//
//        }
            //myWebView.loadUrl(array[x]);


        //myWebView.loadUrl(arrayURL[0]);
       // myWebView.loadUrl("https://drive.google.com/file/d/158M1F7Tsl8iarwLfKAT8hWaaFf3elGp7/view?usp=sharing");

        YouTubePlayerView youTubePlayerView;
        youTubePlayerView = findViewById(R.id.video_view);
        YouTubePlayer.OnInitializedListener listener = new YouTubePlayer.OnInitializedListener() {
            @Override
            public void onInitializationSuccess(YouTubePlayer.Provider provider, YouTubePlayer youTubePlayer, boolean b) {

                String [] arrayURL = {"Jrpv1C0WHFI", "2Lba2qhWBe8", "d81p3CFa9oM", "uYUd54FpOIE", "dJU7io6neHk"};

                Random random = new Random();
                for (int i = 0; i < arrayURL.length; i++) {
                    int j = random.nextInt(arrayURL.length);
                    String string = arrayURL[j];
                    System.out.println("ZZZ " + string);
                    youTubePlayer.loadVideo(string);
                    youTubePlayer.play();
            }}
            @Override
            public void onInitializationFailure(YouTubePlayer.Provider provider, YouTubeInitializationResult youTubeInitializationResult) {
                Toast.makeText(getApplicationContext(),"errou feio", Toast.LENGTH_SHORT).show();
            }
        };
        youTubePlayerView.initialize("AIzaSyCknnR8i1B7UZ6eCz2i2dd0hGnBJV4pWqw",listener);


}
}
