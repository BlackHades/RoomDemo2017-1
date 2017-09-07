package org.youtwo.roomdemo2017.data;

import android.arch.lifecycle.LiveData;
import java.util.List;
import javax.inject.Inject;

/**
 * Created by Bill on 2017/9/7.
 */

public class ListItemRepository {
  private final ListItemDao listItemDao;

  @Inject
  public ListItemRepository(ListItemDao listItemDao){
    this.listItemDao = listItemDao;
  }


  public LiveData<List<ListItem>> getListOfData(){
    return listItemDao.getListItems();
  }

  public LiveData<ListItem> getListItem(String itemId){
    return listItemDao.getListItemById(itemId);
  }

  public Long createNewListItem(ListItem listItem){
    return listItemDao.insertListItem(listItem);
  }

  public void deleteListItem(ListItem listItem){
    listItemDao.deleteListItem(listItem);
  }

}
