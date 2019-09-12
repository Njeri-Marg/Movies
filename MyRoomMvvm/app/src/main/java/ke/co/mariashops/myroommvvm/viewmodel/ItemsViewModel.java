package ke.co.mariashops.myroommvvm.viewmodel;

import android.app.Application;
import android.arch.lifecycle.AndroidViewModel;
import android.arch.lifecycle.LiveData;
import android.support.annotation.NonNull;

import java.util.List;

import ke.co.mariashops.myroommvvm.ItemsEntity;
import ke.co.mariashops.myroommvvm.repository.ItemsRepository;

public class ItemsViewModel extends AndroidViewModel {
    private ItemsRepository repository;
    private LiveData<List<ItemsEntity>>allData;

    public ItemsViewModel(@NonNull Application application) {
        super(application);
        repository=new ItemsRepository(application);
        allData=repository.getAllData();
    }
    public void insert(ItemsEntity itemsEntity){
        repository.insert(itemsEntity);
    }
    public void update(ItemsEntity itemsEntity){
        repository.update(itemsEntity);
    }
    public void delete(ItemsEntity itemsEntity){
        repository.delete(itemsEntity);
    }
    public void deleteAllItems(){
        repository.deleteAllItems();
    }
    public LiveData<List<ItemsEntity>>getAllData(){
        return allData;
    }
}
