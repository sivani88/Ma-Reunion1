package DATA;

import android.content.Context;

import androidx.annotation.NonNull;
import androidx.room.Database;
import androidx.room.Room;
import androidx.room.RoomDatabase;
import androidx.sqlite.db.SupportSQLiteDatabase;

import com.example.mareunion1.R;

import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

import Modele.Meeting;
import Modele.MeetingDao;



@Database(entities = {Meeting.class}, version = 1)
public abstract class MeetingDatabase extends RoomDatabase {

    public abstract MeetingDao meetingDao();

    public static MeetingDatabase mInstance;

    private static final int NUMBER_OF_THREADS= 4;
    static final ExecutorService databaseWriteExecutor =
            Executors.newFixedThreadPool(NUMBER_OF_THREADS);

    static MeetingDatabase getDatabase(final  Context context) {
        if(mInstance == null) {
            synchronized (MeetingDatabase.class) {
                if(mInstance == null) {
                    mInstance = Room.databaseBuilder(context.getApplicationContext(),
                            MeetingDatabase.class, "Meeting_database")
                            .addCallback(sRoomDatabaseCallback)
                            .build();

                }
            }
        }return mInstance;
    }
    private static  RoomDatabase.Callback sRoomDatabaseCallback = new RoomDatabase.Callback() {
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);

            databaseWriteExecutor.execute(() -> {
                MeetingDao dao = mInstance.meetingDao();
                dao.deleteAllMeetings();

                  //  dao.updateMeeting();
        //Todo
             // dao.deleteMeeting();

                dao.getAllMeetingsByDate();
                dao.getAllMeetingsByName();

                Meeting meeting = new Meeting("DRH", "lallala@gmail, loulou@Gmail", "Paris", "01/04/2022", "10", true, R.drawable.paris);
                meeting = new Meeting("Formation", "lallala@gmail, loulou@Gmail", "Paris", "01/04/2022", "10", true, R.drawable.paris);
                dao.insertMeeting(meeting);

            });
        }
    };



}

