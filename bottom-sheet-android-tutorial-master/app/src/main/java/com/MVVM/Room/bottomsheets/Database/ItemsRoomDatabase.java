package com.thetechnocafe.Room.bottomsheets.Database;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;
import android.util.Log;

import com.thetechnocafe.Room.bottomsheets.model.ItemsEntity;


@Database(entities = {ItemsEntity.class}, version = 1, exportSchema = false)
public abstract class ItemsRoomDatabase extends RoomDatabase {

    private static ItemsRoomDatabase INSTANCE;

    public abstract ItemsDao itemsDao();

    public synchronized static ItemsRoomDatabase getInstance(Context context) {
        if (INSTANCE == null) {
            INSTANCE = buildDatabase(context);
        }
        return INSTANCE;
    }

    private static ItemsRoomDatabase buildDatabase(final Context context) {
        return Room.databaseBuilder(context,
                ItemsRoomDatabase.class,
                "UsersObjects")
                .addCallback(new Callback() {
                    @Override
                    public void onCreate(@NonNull SupportSQLiteDatabase db) {
                        super.onCreate(db);
                        new popuateDateToDb(context).execute();
                    }

                    @Override
                    public void onOpen(@NonNull SupportSQLiteDatabase db) {
                        super.onOpen(db);


                    }
                })
                .build();
    }

    private static class popuateDateToDb extends AsyncTask<Void, Void, Void> {

        ItemsDao itemsDao;

        popuateDateToDb(Context context) {
            itemsDao = ItemsRoomDatabase.getInstance(context).itemsDao();
        }

        @Override
        protected void onPreExecute() {
            super.onPreExecute();
        }

        @Override
        protected Void doInBackground(Void... voids) {

            itemsDao.insertAll(new ItemsEntity("Add.png", "https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Fundraiser.png", "Add"));
            itemsDao.insertAll(new ItemsEntity("Drinks.png", "https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Chama.png", "Drinks"));
            itemsDao.insertAll(new ItemsEntity("Birthday.png", "https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Birthday.png", "Birthday"));
            itemsDao.insertAll(new ItemsEntity("Bookshop.png", "https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Chama.png", "Bookshop"));
            itemsDao.insertAll(new ItemsEntity("Wedding.png", "https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Fundraiser.png", "Wedding"));
            itemsDao.insertAll(new ItemsEntity("BabyShower.png", "https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Birthday.png", "Baby shower"));
            itemsDao.insertAll(new ItemsEntity("Changa.png", "https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Fundraiser.png", "Changa"));
            itemsDao.insertAll(new ItemsEntity("Chama.png", "https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Chama.png", "Chama"));

            return null;
        }

        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);


            Log.d("LOG_Data", "@dataLogged inserted -> ");
        }
    }

}
