
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
import android.widget.EditText;
import android.widget.ImageView;

import jsphdev.cmu.barter2.R;
import jsphdev.cmu.barter2.adapter.itemProxy.ItemListProxy;
import jsphdev.cmu.barter2.database.DbHelper;
import jsphdev.cmu.barter2.entities.Item;
import jsphdev.cmu.barter2.entities.ItemList;

public class HomePageActivity extends ActionBarActivity
        implements View.OnClickListener, GestureDetector.OnGestureListener, GestureDetector.OnDoubleTapListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home_page);

        init();
        registerClickListener();

        list = getItemListFromDb();
        displayImages();

        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);
    }

    private void init() {
        dbHelper = new DbHelper(getApplicationContext());
        searchText = (EditText) findViewById(R.id.search);
        imgView0 = (ImageView)findViewById(R.id.imageView);
        imgView1 = (ImageView)findViewById(R.id.imageView2);
        imgView2 = (ImageView)findViewById(R.id.imageView3);
        imgView3 = (ImageView)findViewById(R.id.imageView4);
    }

    private ItemList getItemListFromDb() {
        return dbHelper.getAllItems();
    }

    private void registerClickListener() {
        Button myAccountButton = (Button) findViewById(R.id.myAccount);
        myAccountButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(view.getContext(), MyAccountActivity.class);
                startActivity(intent);
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

        OnClickImageListener();
    }

    private void OnClickImageListener() {
        imgView0.setOnClickListener(this);
        imgView1.setOnClickListener(this);
        imgView2.setOnClickListener(this);
        imgView3.setOnClickListener(this);
    }

    private void displayImages() {
        displayImageView(imgView0);
        displayImageView(imgView1);
        displayImageView(imgView2);
        displayImageView(imgView3);
    }

    private void displayImageView(View view) {
        Integer index = getViewIndex(view.getId());
        Item item = list.getItems().get(index);

        Bitmap bm = BitmapFactory.decodeByteArray(item.getImage(), 0, item.getImage().length);
        ((ImageView) view).setImageBitmap(bm);
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

    @Override
    public void onClick(View view) {
        Integer index = getViewIndex(view.getId());
        Item item = list.getItems().get(index);

        Intent intent = new Intent(getApplicationContext(), DetailActivity.class);
        intent.putExtra(Item.class.getName(), item);
        startActivity(intent);
    }

    private Integer getViewIndex(Integer id) {
        if (id == R.id.imageView) {
            return 0;
        } else if (id == R.id.imageView2) {
            return 1;
        } else if (id == R.id.imageView3) {
            return 2;
        } else {
            return 3;
        }
    }

    private static ImageView imgView0;
    private static ImageView imgView1;
    private static ImageView imgView2;
    private static ImageView imgView3;
    private GestureDetectorCompat gestureDetector;
    private EditText searchText;
    private boolean isShown = false;
    private ItemList list;
    private ItemListProxy itemListProxy;
    private DbHelper dbHelper;
}