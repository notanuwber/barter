
package jsphdev.cmu.barter2.ui;

import android.content.Intent;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Bundle;
import android.support.v4.view.GestureDetectorCompat;
import android.support.v7.app.ActionBarActivity;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import jsphdev.cmu.barter2.R;
import jsphdev.cmu.barter2.entities.Item;

public class DetailActivity extends ActionBarActivity
        implements GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        init();
        registerClickListener();
        display();

        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    private void init() {
        imageView = (ImageView)findViewById(R.id.imageInDetail);
        descriptionTextView = (TextView)findViewById(R.id.descriptionInDetail);
        sellerTextView = (TextView)findViewById(R.id.sellerInDetail);
        phoneTextView = (TextView)findViewById(R.id.phoneInDetail);
        priceTextView = (TextView)findViewById(R.id.priceInDetail);

        item = (Item) this.getIntent().getSerializableExtra(Item.class.getName());
    }

    private void registerClickListener() {
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
    }

    private void display() {
        Bitmap bitmap = BitmapFactory.decodeByteArray(item.getImage(), 0, item.getImage().length);
        imageView.setImageBitmap(bitmap);
        descriptionTextView.setText(item.getDescription());
        sellerTextView.setText(item.getSeller());
        phoneTextView.setText(item.getPhone());
        priceTextView.setText(item.getPrice().toString());
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
        descriptionTextView.setText(e.toString());
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        //     textView.setText( e1.toString());
        //     Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
        //     startActivity(intent);
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        descriptionTextView.setText(e.toString());
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        int minDistance = 7;
        int minVelocity = 2;
        int dx = (int) (e2.getX() - e1.getX());
        if (Math.abs(dx) > minDistance && Math.abs(velocityX) > Math.abs(velocityY)) {
            if (velocityX > minVelocity) { // Move right
                Intent intent = new Intent(getApplicationContext(), HomePageActivity.class);
                startActivity(intent);
            } else { // Move Left
                Intent intent = new Intent(getApplicationContext(), MyPostActivity.class);
                startActivity(intent);
            }
        }
        return true;
    }
    ///////// End Gestures /////////

    private Item item;
    private ImageView imageView;
    private TextView descriptionTextView;
    private TextView sellerTextView;
    private TextView phoneTextView;
    private TextView priceTextView;
    private GestureDetectorCompat gestureDetector;
}