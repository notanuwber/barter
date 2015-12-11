package jsphdev.cmu.barter2.ui;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;

import jsphdev.cmu.barter2.R;

public class CategoryActivity extends ActionBarActivity {
    private CheckBox book, computer, furniture, phone, tool;
    private Button save, reset;
    private boolean isBook, isComputer, isFurniture, isPhone, isTool;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);
        isBook = book.isChecked();
        isComputer = computer.isChecked();
        isFurniture = furniture.isChecked();
        isPhone = phone.isChecked();
        isTool = tool.isChecked();

        addListenerOnButton();
    }

    public void addListenerOnButton() {
        book = (CheckBox)findViewById(R.id.book);
        computer = (CheckBox)findViewById(R.id.computer);
        furniture = (CheckBox)findViewById(R.id.furniture);
        phone = (CheckBox)findViewById(R.id.phone);
        tool = (CheckBox)findViewById(R.id.tool);

        save = (Button)findViewById(R.id.save);
        reset = (Button)findViewById(R.id.reset);

        save.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if (book.isChecked()) {
                    isBook = true;
                } else {
                    isBook = false;
                }
                if (computer.isChecked()) {
                    isComputer = true;
                } else {
                    isComputer = false;
                }
                if (furniture.isChecked()) {
                    isFurniture = true;
                } else {
                    isFurniture = false;
                }
                if (phone.isChecked()) {
                    isPhone = true;
                } else {
                    isPhone = false;
                }
                if (tool.isChecked()) {
                    isTool = true;
                } else {
                    isTool = false;
                }

                // Transfer these five arguments to the home page.
                Intent intent = new Intent(CategoryActivity.this, HomePageActivity.class);
                intent.putExtra("isBook", isBook);
                intent.putExtra("isComputer", isComputer);
                intent.putExtra("isFurniture", isFurniture);
                intent.putExtra("isPhone", isPhone);
                intent.putExtra("isTool", isTool);
                startActivity(intent);
            }
        });

        reset.setOnClickListener(new View.OnClickListener() {

            @Override
            // If Reset is clicked, reset all the checkbox to the original states.
            public void onClick(View v) {
                book.setChecked(isBook);
                computer.setChecked(isComputer);
                furniture.setChecked(isFurniture);
                phone.setChecked(isPhone);
                tool.setChecked(isTool);
            }
        });
    }
}
