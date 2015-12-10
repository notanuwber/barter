
package jsphdev.cmu.barter2.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.media.Image;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;

import android.view.MotionEvent;
import android.gesture.Gesture;
import android.widget.TextView;

import static android.view.GestureDetector.*;

import jsphdev.cmu.barter2.R;

public class HomePageActivity extends ActionBarActivity
        implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    private static ImageView imgView1;
    private static ImageView imgView2;
    private static ImageView imgView3;
    private static ImageView imgView4;
    private GestureDetectorCompat gestureDetector;
    private EditText searchText;
    private boolean isShown = false;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        Button myAccountButton = (Button) findViewById(R.id.myAccount);
        myAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit = new Intent(view.getContext(), MyAccountActivity.class);
                startActivity(submit);
            }
        });

        Button myPostButton = (Button) findViewById(R.id.myPost);
        myPostButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent submit = new Intent(view.getContext(), MyPostActivity.class);
                startActivity(submit);
            }
        });


        searchText = (EditText) findViewById(R.id.search);

        OnClickButtonListener();
        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);

    }

    public void OnClickButtonListener() {
        imgView1 = (ImageView)findViewById(R.id.imageView);
        imgView1.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                 //       String description = getResources().getString(R.string.detail_description);
                 //       String.format(description, "A good hammer that can use everywhere!");
                        setContentView(R.layout.activity_detail);
                        String description = "A good hammer that can use everywhere!";
                        TextView temp = (TextView)findViewById(R.id.textView8);
                        temp.setText(description);

                        ImageView img = (ImageView)findViewById(R.id.imageView5);
                        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.mipmap.hammer);
                        img.setImageBitmap(bm);
                 //       Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                 //       startActivity(intent);
                    }
                }
        );
        imgView2 = (ImageView)findViewById(R.id.imageView2);
        imgView2.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    //    String description = getResources().getString(R.string.detail_description);
                    //    String.format(description, "This Book is 8/10 new, wanting to exchange with a cat");
                    //    Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                    //    startActivity(intent);
                        setContentView(R.layout.activity_detail);
                        String description = "This Book is 7/10 new, Wanting to exchange with a cat";
                        TextView temp = (TextView)findViewById(R.id.textView8);
                        temp.setText(description);

                        ImageView img = (ImageView)findViewById(R.id.imageView5);
                        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.mipmap.book);
                        img.setImageBitmap(bm);
                    }
                }
        );
        imgView3 = (ImageView)findViewById(R.id.imageView3);
        imgView3.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                    //    String description = getResources().getString(R.string.detail_description);
                    //    String.format(description, "Comfortable chair want to exchange comfortable bed");
                        setContentView(R.layout.activity_detail);
                        String description = "Comfortable chair want to exchange comfortable bed";
                        TextView temp = (TextView)findViewById(R.id.textView8);
                        temp.setText(description);

                        ImageView img = (ImageView)findViewById(R.id.imageView5);
                        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.mipmap.chair);
                        img.setImageBitmap(bm);
                    //    Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                    //    startActivity(intent);
                    }
                }
        );
        imgView4 = (ImageView)findViewById(R.id.imageView4);
        imgView4.setOnClickListener(
                new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {
                     //   String description = getResources().getString(R.string.detail_description);
                     //   String.format(description, "Just buy a new Iphone 6s, want to exchange the old phone with anything look OK");
                        setContentView(R.layout.activity_detail);
                        String description = "Just buy a new Iphone 6s, want to exchange the old phone with anything look OK";
                        TextView temp = (TextView)findViewById(R.id.textView8);
                        temp.setText(description);

                        ImageView img = (ImageView)findViewById(R.id.imageView5);
                        Bitmap bm = BitmapFactory.decodeResource(getResources(),R.mipmap.phone);
                        img.setImageBitmap(bm);
                    //    Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
                    //    startActivity(intent);
                    }
                }
        );

    }

    ///////// Begin Gestures /////////
    @Override
    public boolean onTouchEvent(MotionEvent event) {
        gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int minDistance = 7;
        int minVelocity = 2;
        int dx = (int) (e2.getX() - e1.getX());
        if (Math.abs(dx) > minDistance && Math.abs(velocityX) > Math.abs(velocityY)) {
            if (velocityX > minVelocity) { // Move right
                if (isShown = false) {
                    Intent intent = new Intent(getApplicationContext(), MyAccountActivity.class);
                    startActivity(intent);
                } else {
                    Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                    startActivity(intent);
                }
            } else { // Move Left
                Intent intent = new Intent(getApplicationContext(), MyPostActivity.class);
                startActivity(intent);
            }
        }
        return true;
    }
    ///////// End Gestures /////////


}