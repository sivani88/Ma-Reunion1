package Modele;

import androidx.room.ColumnInfo;
import androidx.room.Entity;
import androidx.room.Ignore;
import androidx.room.PrimaryKey;

import com.example.mareunion1.R;

import java.util.Arrays;
import java.util.List;


@Entity(tableName = "meeting_table")
public class Meeting {
    @PrimaryKey(autoGenerate = true)
    private long id;
    @ColumnInfo(name = "subject")
    private String subject;
    @ColumnInfo(name = "mail")
    private String mMail;
    @ColumnInfo(name = "name")
    private String mName;
    @ColumnInfo(name = "date")
    private String mDate;
    @ColumnInfo(name = "hour")
    private String mHour;
    @Ignore
    private boolean availability;
    @ColumnInfo(name = "avatar")
    private int avatarUrl;


    public Meeting(String subject, String mail, String name, String date, String hour, boolean availability, int avatarUrl) {
        this.subject = subject;
        mMail = mail;
        mName = name;
        mDate = date;
        mHour = hour;
        this.availability = availability;
        this.avatarUrl = avatarUrl;
    }

    private static class MeetingRoom {
        public int avatarUrl;
        public String mName;

        public MeetingRoom(int mAvatarUrl, String name) {
            avatarUrl = mAvatarUrl;
            mName = name;
        }
    }

    private static List<MeetingRoom> MEETING_ROOMS = Arrays.asList(
            new MeetingRoom(R.drawable.london, "London"),
            new MeetingRoom(R.drawable.paris, "Paris"),
            new MeetingRoom(R.drawable.vienna, "Vienne"),
            new MeetingRoom(R.drawable.venise, "Venise"),
            new MeetingRoom(R.drawable.barcelona, "Barcelona"),
            new MeetingRoom(R.drawable.berlin, "Berlin"),
            new MeetingRoom(R.drawable.newyork, "NewYork"),
            new MeetingRoom(R.drawable.moscou, "Moscou"));

    public long getId() {
        return id;
    }

    public void setId(long id) {
        this.id = id;
    }

    public String getSubject() {
        return subject;
    }

    public String getMail() {
        return mMail;
    }

    public String getName() {
        return mName;
    }

    public String getDate() {
        return mDate;
    }

    public String getHour() {
        return mHour;
    }

    public boolean isAvailability() {
        return availability;
    }


    public int getAvatarUrl() {
        for (int i = 0; i < MEETING_ROOMS.size(); i++) {
            if (MEETING_ROOMS.get(i).mName == mName) {
                return MEETING_ROOMS.get(i).avatarUrl;
            }
        }
        return 0;

    }
}