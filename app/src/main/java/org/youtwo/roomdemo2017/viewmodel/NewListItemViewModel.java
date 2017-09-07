package org.youtwo.roomdemo2017.viewmodel;

import android.arch.lifecycle.ViewModel;
import android.os.AsyncTask;
import org.youtwo.roomdemo2017.data.ListItem;
import org.youtwo.roomdemo2017.data.ListItemRepository;

/**
 * Created by Bill on 2017/9/7.
 */

public class NewListItemViewModel extends ViewModel {

  private ListItemRepository repository;

  NewListItemViewModel(ListItemRepository repository) {
    this.repository = repository;
  }

  /**
   * Attach our LiveData to the Database
   */
  public void addNewItemToDatabase(ListItem listItem){
    new AddItemTask().execute(listItem);
  }

  private class AddItemTask extends AsyncTask<ListItem, Void, Void> {

    @Override
    protected Void doInBackground(ListItem... item) {
      repository.createNewListItem(item[0]);
      return null;
    }
  }
}
