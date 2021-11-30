package com.example.mareunion1;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.LiveData;
import androidx.room.Room;

import android.os.Bundle;

import java.util.List;

import DATA.MeetingDatabase;
import Modele.Meeting;
import Modele.MeetingDao;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        MeetingDatabase db = Room.databaseBuilder(getApplicationContext(), MeetingDatabase.class, "meeting-base").build();
        MeetingDao meetingDao = db.meetingDao();
        LiveData<List<Meeting>> meetings = meetingDao.getAll();

    }
}