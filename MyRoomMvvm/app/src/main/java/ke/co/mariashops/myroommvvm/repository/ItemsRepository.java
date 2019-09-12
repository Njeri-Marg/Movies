package ke.co.mariashops.myroommvvm.repository;

import android.app.Application;
import android.arch.lifecycle.LiveData;
import android.os.AsyncTask;

import java.util.List;

import ke.co.mariashops.myroommvvm.database.ItemsDao;
import ke.co.mariashops.myroommvvm.ItemsEntity;
import ke.co.mariashops.myroommvvm.database.ItemsRoomDatabase;

public class ItemsRepository
{
    private ItemsDao itemsDao;
    private LiveData<List<ItemsEntity>>allData;

    public ItemsRepository(Application application){
        ItemsRoomDatabase database=ItemsRoomDatabase.getinstance(application);
        itemsDao=database.itemsDao();
        allData=itemsDao.getData();
    }
    public void  insert(ItemsEntity itemsEntity){
        new InsertAsyncTask(itemsDao).execute(itemsEntity);

    }
    public void update(ItemsEntity itemsEntity){
        new UpdateAsyncTask(itemsDao).execute(itemsEntity);

    }

    public void delete(ItemsEntity itemsEntity){
        new  DeleteAsyncTask(itemsDao).execute(itemsEntity);

    }

    public void deleteAllItems(){
        new  DeleteAllItemsAsyncTask(itemsDao).execute();

    }
    public LiveData<List<ItemsEntity>>getAllData(){
        return allData;
    }


    public static class InsertAsyncTask extends AsyncTask<ItemsEntity, Void,Void>{
        private  ItemsDao itemsDao;

        private InsertAsyncTask(ItemsDao itemsDao){
            this. itemsDao = itemsDao;
        }

        @Override
        protected Void doInBackground(ItemsEntity... itemsEntities) {
            itemsDao.insert(itemsEntities[0]);
            return null;
        }
    }
    public static class UpdateAsyncTask extends AsyncTask<ItemsEntity,Void, Void>{
        private ItemsDao itemsDao;

        private UpdateAsyncTask(ItemsDao itemsDao){
            this.itemsDao=itemsDao;
        }

        @Override
        protected Void doInBackground(ItemsEntity... itemsEntities) {
            itemsDao.update(itemsEntities[0]);
            return null;
        }
    }
    public static class DeleteAsyncTask extends AsyncTask<ItemsEntity,Void, Void>{
        private ItemsDao itemsDao;

        private DeleteAsyncTask(ItemsDao itemsDao){
            this.itemsDao=itemsDao;
        }

        @Override
        protected Void doInBackground(ItemsEntity... itemsEntities) {
            itemsDao.delete(itemsEntities[0]);
            return null;
        }
    }
    public static class DeleteAllItemsAsyncTask extends AsyncTask<Void,Void, Void>{
        private ItemsDao itemsDao;

        private DeleteAllItemsAsyncTask(ItemsDao itemsDao){
            this.itemsDao=itemsDao;
        }

        @Override
        protected Void doInBackground(Void... Voids) {
            itemsDao.deleteAllItems();
            return null;
        }
    }
}
