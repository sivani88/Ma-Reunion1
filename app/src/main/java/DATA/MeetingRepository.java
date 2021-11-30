package DATA;

import android.app.Application;

import androidx.lifecycle.LiveData;
import androidx.room.Room;

import java.util.List;

import Modele.Meeting;
import Modele.MeetingDao;

public class MeetingRepository {

    private MeetingDao mMeetingDao;
    private LiveData<List<Meeting>> allMeetings;

    public MeetingRepository(Application application) {
        MeetingDatabase db = Room.databaseBuilder(application.getApplicationContext(), MeetingDatabase.class, "meeting-base").build();
        MeetingDao meetingDao = db.meetingDao();
        List<Meeting> meetings = (List<Meeting>) meetingDao.getAll();

    }
    LiveData<List<Meeting>> getAllMeetings(){
        return allMeetings;
    }

    public void insert(Meeting meeting) {

    }

    public void updateMeeting (Meeting meeting) {
        MeetingDatabase.databaseWriteExecutor.execute(() -> {
            mMeetingDao.insertMeeting(meeting);
        });
    }


    public  void deleteMeeting(Meeting meeting) {
        MeetingDatabase.databaseWriteExecutor.execute(() -> {
           // mMeetingDao.deleteMeeting(meeting, );
        });
    }
    public void deleteAllMetings(LiveData<List<Meeting>> meeting) {
        MeetingDatabase.databaseWriteExecutor.execute(() -> {
          mMeetingDao.deleteMeeting(allMeetings);

        });
        //TODO
    }


    //public Object MeetingRepository(Meeting meeting) {
      //  mMeetingDao.deleteMeeting(allMeetings);
      //  return null;

   // }

    public void insertMeeting(Meeting meeting) {
        MeetingDatabase.databaseWriteExecutor.execute(() -> {
            mMeetingDao.insertMeeting(meeting);
        });
    }

}

