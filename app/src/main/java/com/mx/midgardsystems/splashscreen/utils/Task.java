package com.mx.midgardsystems.splashscreen.utils;

import android.os.AsyncTask;
import android.util.Log;

public class Task  extends AsyncTask<String, Integer, String> {
    public int post_case = 0;
    private ICallback call;

    public Task(ICallback call) {
        this.call = call;
    }

    protected void onPreExecute() {
        Log.i("Entrar", "Asynctast");
    }

    protected String doInBackground(String... arg0) {
        try {
            call.time();
        } catch (Exception e) {
        }
        return null;
    }

    protected void onPostExecute(String s) {
        call.callback();
    }
}
