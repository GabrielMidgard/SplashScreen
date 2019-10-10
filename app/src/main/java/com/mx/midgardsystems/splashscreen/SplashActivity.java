package com.mx.midgardsystems.splashscreen;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.Window;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;

import com.mx.midgardsystems.splashscreen.utils.ICallback;
import com.mx.midgardsystems.splashscreen.utils.Task;

public class SplashActivity   extends AppCompatActivity implements ICallback{
    private Context context;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        this.requestWindowFeature(Window.FEATURE_NO_TITLE);
        setContentView(R.layout.activity_splash);
        context=this;
        Intent intent = getIntent();

        doInBackground();

        Task t = new Task( this );
        t.execute();
    }

    @Override
    public void callback() {
        final ImageView img = (ImageView) findViewById( R.id.imgSplash );
        Animation anim = AnimationUtils.loadAnimation(this, R.anim.splash_out);
        anim.setAnimationListener( new Animation.AnimationListener() {
            @Override
            public void onAnimationStart(Animation animation) {}

            @Override
            public void onAnimationRepeat(Animation animation) {}

            @Override
            public void onAnimationEnd(Animation animation) {
                Intent intent;
                intent = new Intent( getApplicationContext(), MainActivity.class);
                startActivity( intent );
                finish();
            }
        });
        anim.setFillAfter(true);
        img.startAnimation(anim);
    }

    @Override
    public void time() {
        try {
            Thread.sleep( 2500 );
        } catch (InterruptedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }


    protected void doInBackground(String... params) {
    }
}
