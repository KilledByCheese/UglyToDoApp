package de.killedbycheese.mytodoapp;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;

import org.json.JSONException;

public class MainActivity extends AppCompatActivity {
    private LinearLayout todoList;
    private EditText addToDoText;
    private Button addToDoButton;
    private Button syncButton;
    private ToDoRestClientUsage restClient;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        restClient = new ToDoRestClientUsage();

        todoList = findViewById(R.id.todoList);

        addToDoText = findViewById(R.id.addToDoText);

        addToDoButton = findViewById(R.id.addToDoButton);
        addToDoButton.setOnClickListener(v -> {
            addTodo(v);
        });

        syncButton = findViewById(R.id.syncButton);
        syncButton.setOnClickListener(v -> {
            updateToDos();
        });

        updateToDos();

    }

    private void addTodo(View v) {
        String toDoText = addToDoText.getText().toString();
        if(toDoText.length() > 0) {
            restClient.addToDo(toDoText);
            updateToDos();
                addToDoText.setText("");
        }
    }

    private void updateToDos() {
        try {
            restClient.updateToDos(todoList);
        } catch (JSONException e) {
            e.printStackTrace();
        }
    }

}