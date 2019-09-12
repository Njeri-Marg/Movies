package ke.co.mariashops.myroommvvm.database;


import android.arch.persistence.db.SupportSQLiteDatabase;
import android.arch.persistence.room.Database;
import android.arch.persistence.room.Room;
import android.arch.persistence.room.RoomDatabase;
import android.content.Context;
import android.os.AsyncTask;
import android.support.annotation.NonNull;

import ke.co.mariashops.myroommvvm.ItemsEntity;


@Database(entities ={ItemsEntity.class},version = 1)
public abstract class ItemsRoomDatabase extends RoomDatabase
{
    private static ItemsRoomDatabase instance;
    public abstract ItemsDao itemsDao();

    public static synchronized ItemsRoomDatabase getinstance(Context context){
        if (instance==null){
            instance= Room.databaseBuilder(context.getApplicationContext(),
                    ItemsRoomDatabase.class,"UserPrefs")
                    .fallbackToDestructiveMigration()
                    .addCallback(roomCallback)
                    .build();
        }
        return instance;
    }
    private static RoomDatabase.Callback roomCallback=new RoomDatabase.Callback(){
        @Override
        public void onCreate(@NonNull SupportSQLiteDatabase db) {
            super.onCreate(db);
            new PopulateDbAsyncTask(instance).execute();
        }
    };
    private static class PopulateDbAsyncTask extends AsyncTask<Void,Void,Void>{
        private ItemsDao itemsDao;

        private PopulateDbAsyncTask(ItemsRoomDatabase db){
            itemsDao=db.itemsDao();
        }

        @Override
        protected Void doInBackground(Void... voids) {
            itemsDao.insert(new ItemsEntity("https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Fundraiser.png","Add"));
            itemsDao.insert(new ItemsEntity("https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Chama.png","Drinks"));
            itemsDao.insert(new ItemsEntity("https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Birthday.png","Birthday"));
            itemsDao.insert(new ItemsEntity("https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Fundraiser.png","Bookshop"));
            itemsDao.insert(new ItemsEntity("https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Birthday.png","Wedding"));
            itemsDao.insert(new ItemsEntity("https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Chama.png","Baby shower"));
            itemsDao.insert(new ItemsEntity("https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Fundraiser.png","Changa"));
            itemsDao.insert(new ItemsEntity("https://mula.co.ke/mula_ke/api/v1/images/icons/groups/Chama.png","Chama"));
            return null;
        }
    }
}
