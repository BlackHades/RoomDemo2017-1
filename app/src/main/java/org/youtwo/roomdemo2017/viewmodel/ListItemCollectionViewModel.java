package org.youtwo.roomdemo2017.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import java.util.List;
import org.youtwo.roomdemo2017.data.ListItem;
import org.youtwo.roomdemo2017.data.ListItemRepository;

/**
 * Created by Bill on 2017/9/7.
 */

public class ListItemCollectionViewModel extends ViewModel {

  private ListItemRepository repository;

  ListItemCollectionViewModel(ListItemRepository repository) {
    this.repository = repository;
  }

  public LiveData<List<ListItem>> getListItems() {
    return repository.getListOfData();
  }

  public void deleteListItem(ListItem listItem) {
    DeleteItemTask deleteItemTask = new DeleteItemTask();
    deleteItemTask.execute(listItem);
  }

  private class DeleteItemTask extends AsyncTask<ListItem, Void, Void> {

    @Override
    protected Void doInBackground(ListItem... item) {
      repository.deleteListItem(item[0]);
      return null;
    }
  }
}
