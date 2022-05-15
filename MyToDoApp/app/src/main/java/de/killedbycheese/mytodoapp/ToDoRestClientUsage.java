package de.killedbycheese.mytodoapp;

import android.util.Log;
import android.widget.LinearLayout;

import com.loopj.android.http.JsonHttpResponseHandler;

import org.json.JSONArray;
import org.json.JSONException;

import java.io.UnsupportedEncodingException;

import cz.msebera.android.httpclient.Header;
import cz.msebera.android.httpclient.HttpEntity;
import cz.msebera.android.httpclient.entity.StringEntity;

public class ToDoRestClientUsage {

    public void updateToDos(LinearLayout v) throws JSONException {
        HttpClient.get("todo", null, new JsonHttpResponseHandler() {
            @Override
            public void onSuccess(int statusCode, Header[] headers, JSONArray todos) {
                v.removeAllViews();
                for(int i = 0; i < todos.length(); i++) {
                    try {
                        String todo = todos.getJSONObject(i).getString("todo");
                        ToDoItem todoItem = new ToDoItem(v.getContext(), todo);
                        v.addView(todoItem);
                        todoItem.getButton().setOnClickListener(vi -> {
                            try {
                                HttpEntity entity = new StringEntity(todo);
                                HttpClient.delete("todo", null, new JsonHttpResponseHandler() {
                                    //TODO figure out why onFailure gets triggered and not onSuccess - still working somehow ¯\_(ツ)_/¯
                                    @Override
                                    public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                                        Log.v("INFO", "Failure"+ statusCode + responseString);
                                        v.removeView(todoItem);
                                    }
                                }, entity);
                            } catch (UnsupportedEncodingException e) {
                                e.printStackTrace();
                            }
                        });
                    } catch (JSONException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
    }

    public void addToDo(String todo) {
        HttpEntity entity = null;
        try {
            entity = new StringEntity(todo);
            HttpClient.post("todo", null, new JsonHttpResponseHandler() {
                //TODO figure out why onFailure gets triggered and not onSuccess - still working somehow ¯\_(ツ)_/¯
                @Override
                public void onFailure(int statusCode, Header[] headers, String responseString, Throwable throwable) {
                    Log.v("INFO", "Failure"+ statusCode + responseString);
                }
            }, entity);
        } catch (UnsupportedEncodingException e) {
            e.printStackTrace();
        }
    }
}
