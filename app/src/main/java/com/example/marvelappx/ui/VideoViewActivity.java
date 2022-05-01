package com.example.marvelappx.ui;

import android.net.Uri;
import android.os.Bundle;
import android.widget.MediaController;
import android.widget.VideoView;

import androidx.appcompat.app.AppCompatActivity;
import com.example.marvelappx.R;

public class VideoViewActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.video_view_activity);

        MediaController mediaController;
        mediaController = new MediaController(VideoViewActivity.this);

        VideoView mVideoView = findViewById(R.id.video_view);
        Uri localUri = Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.miranha);

        mVideoView.setVideoURI(localUri);
        mVideoView.setMediaController(mediaController);

        mVideoView.stopPlayback();
       // mVideoView.start();


}
}
