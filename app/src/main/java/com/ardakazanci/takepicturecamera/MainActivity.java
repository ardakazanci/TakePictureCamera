package com.ardakazanci.takepicturecamera;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.provider.MediaStore;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {

	private Button openCameraButton;
	private ImageView capturePictureImageView;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);

		openCameraButton = findViewById(R.id.btn_camera);
		capturePictureImageView = findViewById(R.id.imageView);

		openCameraButton.setOnClickListener(new View.OnClickListener() {
			@Override
			public void onClick(View v) {

				Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
				startActivityForResult(intent, 0);


			}
		});

	}


	@Override
	protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
		super.onActivityResult(requestCode, resultCode, data);

		Bitmap bitmap = (Bitmap) data.getExtras().get("data");
		capturePictureImageView.setImageBitmap(bitmap);
	}
}
