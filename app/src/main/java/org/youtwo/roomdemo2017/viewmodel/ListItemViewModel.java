package org.youtwo.roomdemo2017.viewmodel;

import android.arch.lifecycle.LiveData;
import android.arch.lifecycle.ViewModel;
import org.youtwo.roomdemo2017.data.ListItem;
import org.youtwo.roomdemo2017.data.ListItemRepository;

/**
 * Created by Bill on 2017/9/7.
 */

public class ListItemViewModel extends ViewModel {
  private ListItemRepository repository;

  ListItemViewModel(ListItemRepository repository) {
    this.repository = repository;
  }

  public LiveData<ListItem> getListItemById(String itemId){
    return repository.getListItem(itemId);
  }
}
