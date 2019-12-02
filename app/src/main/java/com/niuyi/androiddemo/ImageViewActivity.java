package com.niuyi.androiddemo;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.Spinner;

import butterknife.Bind;
import butterknife.ButterKnife;

public class ImageViewActivity extends AppCompatActivity {

    @Bind(R.id.spinner)
    Spinner mSpinner;

    @Bind(R.id.iv_1)
    ImageView mImageView_1;

    @Bind(R.id.iv_2)
    ImageView mImageView_2;

    @Bind(R.id.iv_3)
    ImageView mImageView_3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);
        ButterKnife.bind(this);

        final String[] list = new String[]{
                "FIT_XY",
                "FIT_CENTER",
                "CENTER",
                "CENTER_CROP",
                "CENTER_INSIDE"
        };


        ArrayAdapter aa = new ArrayAdapter(this, android.R.layout.simple_spinner_item,list);
        aa.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        mSpinner.setAdapter(aa);
        mSpinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
                String value = list[position];

                if("FIT_XY".equalsIgnoreCase(value)){
                    mImageView_1.setScaleType(ImageView.ScaleType.FIT_XY);
                    mImageView_2.setScaleType(ImageView.ScaleType.FIT_XY);
                    mImageView_3.setScaleType(ImageView.ScaleType.FIT_XY);
                }else if("FIT_CENTER".equalsIgnoreCase(value)){
                    mImageView_1.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    mImageView_2.setScaleType(ImageView.ScaleType.FIT_CENTER);
                    mImageView_3.setScaleType(ImageView.ScaleType.FIT_CENTER);
                }else if("CENTER".equalsIgnoreCase(value)){
                    mImageView_1.setScaleType(ImageView.ScaleType.CENTER);
                    mImageView_2.setScaleType(ImageView.ScaleType.CENTER);
                    mImageView_3.setScaleType(ImageView.ScaleType.CENTER);
                }else if("CENTER_CROP".equalsIgnoreCase(value)){
                    mImageView_1.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    mImageView_2.setScaleType(ImageView.ScaleType.CENTER_CROP);
                    mImageView_3.setScaleType(ImageView.ScaleType.CENTER_CROP);
                }else if("CENTER_INSIDE".equalsIgnoreCase(value)){
                    mImageView_1.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    mImageView_2.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                    mImageView_3.setScaleType(ImageView.ScaleType.CENTER_INSIDE);
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> parent) {

            }
        });

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
    }
}
