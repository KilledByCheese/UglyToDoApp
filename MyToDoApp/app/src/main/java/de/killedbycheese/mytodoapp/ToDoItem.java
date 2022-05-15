package de.killedbycheese.mytodoapp;

import android.content.Context;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

public class ToDoItem extends LinearLayout {

    final Button removeButton;
    public ToDoItem(Context context, String todo) {
        super(context);
        TextView display = new TextView(context);
        display.setText(todo);

        removeButton = new Button(context);
        removeButton.setText("Complete");

        this.addView(display);
        this.addView(removeButton);
    }

    public Button getButton() {
        return removeButton;
    }
}
