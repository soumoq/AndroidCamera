package com.example.androidcamera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.app.ActivityCompat;

import android.Manifest;
import android.content.Intent;
import android.graphics.Bitmap;
import android.hardware.Camera;
import android.media.MediaRecorder;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.SurfaceHolder;
import android.view.View;
import android.widget.Button;
import android.widget.Chronometer;
import android.widget.FrameLayout;
import android.widget.ImageView;
import android.widget.Toast;
import android.widget.VideoView;

public class MainActivity extends AppCompatActivity {


    Camera camera;
    FrameLayout frameLayout;
    ShowCamera showCamera;
    private int camId=Camera.CameraInfo.CAMERA_FACING_FRONT;

    public static final int MY_PERMISSIONS_CAMERA = 1;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //give permission
        if (ActivityCompat.shouldShowRequestPermissionRationale(this,
                Manifest.permission.CAMERA)) {
            Toast.makeText(this, "Please grant permissions to record audio", Toast.LENGTH_LONG).show();

            //Give user option to still opt-in the permissions
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_CAMERA);
        } else {
            // Show user dialog to grant permission to record audio
            ActivityCompat.requestPermissions(this,
                    new String[]{Manifest.permission.CAMERA},
                    MY_PERMISSIONS_CAMERA);
        }


        frameLayout = (FrameLayout) findViewById(R.id.frame_layout);

        //open camera
        camera = Camera.open(camId);

        showCamera = new ShowCamera(this, camera);
        frameLayout.addView(showCamera);
    }

}