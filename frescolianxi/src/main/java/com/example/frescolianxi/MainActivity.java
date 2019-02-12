package com.example.frescolianxi;

import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.facebook.drawee.backends.pipeline.Fresco;
import com.facebook.drawee.generic.RoundingParams;
import com.facebook.drawee.interfaces.DraweeController;
import com.facebook.drawee.view.SimpleDraweeView;
import com.facebook.imagepipeline.request.ImageRequest;
import com.facebook.imagepipeline.request.ImageRequestBuilder;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private Button yj;
    private Button yx;
    private Button bl;
    private Button jjs;
    private Button cp;
    private Button dt;
    private Button jt;
    private Button pzokhttp;
    private SimpleDraweeView img;
    private SimpleDraweeView draweeView;
    private Uri uri;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();

        uri = Uri.parse("http://images.xuejuzi.cn/1702/1_170206110930_1.jpg");
        draweeView = (SimpleDraweeView) findViewById(R.id.img);
        draweeView.setImageURI(uri);
        draweeView.setAspectRatio(1f);
    }

    private void initView() {
        yj = (Button) findViewById(R.id.yj);
        yx = (Button) findViewById(R.id.yx);
        bl = (Button) findViewById(R.id.bl);
        jjs = (Button) findViewById(R.id.jjs);
        cp = (Button) findViewById(R.id.cp);
        dt = (Button) findViewById(R.id.dt);
        jt = (Button) findViewById(R.id.jt);
        pzokhttp = (Button) findViewById(R.id.pzokhttp);
        img = (SimpleDraweeView) findViewById(R.id.img);

        yj.setOnClickListener(this);
        yx.setOnClickListener(this);
        bl.setOnClickListener(this);
        jjs.setOnClickListener(this);
        cp.setOnClickListener(this);
        dt.setOnClickListener(this);
        jt.setOnClickListener(this);
        pzokhttp.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()) {
            case R.id.yj:
                RoundingParams roundingParams = RoundingParams.fromCornersRadius(50f);
                roundingParams.setBorderColor(Color.RED);
                // roundingParams.setRoundAsCircle(true);
                draweeView.getHierarchy().setRoundingParams(roundingParams);
                draweeView.setImageURI(uri);
                break;
            case R.id.yx:
                RoundingParams roundingParams1 = RoundingParams.fromCornersRadius(20f);
                roundingParams1.setBorderColor(Color.RED);
                roundingParams1.setRoundAsCircle(true);
                draweeView.getHierarchy().setRoundingParams(roundingParams1);
                draweeView.setImageURI(uri);
                break;
            case R.id.bl:
                RoundingParams roundingParams2 = RoundingParams.fromCornersRadius(20f);
                roundingParams2.setBorderColor(Color.RED);
                Toast.makeText(MainActivity.this,"比例",Toast.LENGTH_SHORT).show();
                draweeView.getHierarchy().setRoundingParams(roundingParams2);
                draweeView.setAspectRatio(2f);
                draweeView.setImageURI(uri);
                break;
            case R.id.jjs:
                ImageRequest request = ImageRequestBuilder.newBuilderWithSource(uri)
                        .setProgressiveRenderingEnabled(true)
                        .build();
                DraweeController controller = Fresco.newDraweeControllerBuilder()
                        .setImageRequest(request)
                        .setOldController(draweeView.getController())
                        .build();
                draweeView.setController(controller);
                break;
            case R.id.cp:

                break;
            case R.id.dt:

                break;
            case R.id.jt:

                break;
            case R.id.pzokhttp:

                break;
        }
    }
}
