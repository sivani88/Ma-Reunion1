package com.example.mareunion1;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.ViewModel;

import java.util.List;

import DATA.MeetingRepository;
import Modele.Meeting;

public class MeetingViewModel extends ViewModel {
    private MeetingRepository mRepository;
    private LiveData<List<Meeting>>  allMeetings;

    public MeetingViewModel(Application application) {
        
        mRepository =  new MeetingRepository(application);
       // allMeetings = mRepository.getAllMeetings;
    }
    public void insertMeeting(Meeting meeting) {
        mRepository.insertMeeting(meeting);
        
    }
    
    public  void update(Meeting meeting) {
        mRepository.updateMeeting(meeting);
    }
    public void delete(Meeting meeting) {
        mRepository.deleteMeeting(meeting);
    }
    public void deleteAllMeetings() {
        mRepository.deleteAllMetings(allMeetings);
        
    }
    LiveData<List<Meeting>> getAllMeetings() {
        return allMeetings;
    }
}
