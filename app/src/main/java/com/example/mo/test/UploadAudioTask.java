package com.example.mo.test;

import android.os.AsyncTask;

import java.io.File;

public class UploadAudioTask extends AsyncTask<String, Integer, Long> {

    private String username;

    public UploadAudioTask(String username) {
        this.username = username;
    }

    @Override
    protected Long doInBackground(String... strings) {
        for (String url : strings) {
            try {
                FileUploader.UploadAudio(url, username);
                new File(url).delete();
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
        return 1L;
    }
}
