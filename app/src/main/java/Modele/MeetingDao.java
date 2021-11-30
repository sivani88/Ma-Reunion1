package Modele;

import androidx.lifecycle.LiveData;
import androidx.room.Dao;
import androidx.room.Delete;
import androidx.room.Insert;
import androidx.room.Query;
import androidx.room.Update;

import java.util.List;

@Dao
public interface MeetingDao {


    @Insert
    Void insertMeeting (Meeting meeting);

   @Update
    Void updateMeeting(Meeting meeting);

    @Delete
    Void deleteMeeting(LiveData<List<Meeting>> meeting);

    @Query("DELETE FROM meeting_table")
    void deleteAllMeetings();

    @Query("SELECT * FROM meeting_table ORDER BY Date")
    LiveData<List<Meeting>> getAllMeetingsByDate();


    @Query("SELECT * FROM meeting_table ORDER BY Name")
    LiveData<List<Meeting>> getAllMeetingsByName();

    @Query("SELECT * FROM meeting_table")
    LiveData<List<Meeting>> getAll();


}
