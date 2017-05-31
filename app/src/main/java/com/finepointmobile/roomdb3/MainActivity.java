package com.finepointmobile.roomdb3;

import android.arch.persistence.room.Room;
import android.content.Context;
import android.os.AsyncTask;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;

import java.util.List;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        new InsertData(this).execute();
    }

    private class InsertData extends AsyncTask<Void, Void, Void> {

        private Context mContext;

        public InsertData(Context context) {
            mContext = context;
        }

        @Override
        protected Void doInBackground(Void... params) {

            AppDatabase db = Room.databaseBuilder(mContext, AppDatabase.class, "production").build();

            User user = new User("Daniel");
            db.userDao().insertAll(user);

            List<User> users = db.userDao().getAllUsers();
            return null;
        }
    }
}
