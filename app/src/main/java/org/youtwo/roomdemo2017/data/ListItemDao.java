package org.youtwo.roomdemo2017.data;

import static android.arch.persistence.room.OnConflictStrategy.REPLACE;

import android.arch.lifecycle.LiveData;
import android.arch.persistence.room.Dao;
import android.arch.persistence.room.Delete;
import android.arch.persistence.room.Insert;
import android.arch.persistence.room.Query;
import java.util.List;

/**
 * A DAO, or Data Access Object, is a layer of abstraction (interface) between Java Objects and
 * SQL Statements.
 *
 * For a given entity, it defines how we may manage said entity within the Database.
 */
@Dao
public interface ListItemDao {
  /**
   * Get entity by itemId. For this App, we will pass in an ID when the detail Activity starts;
   * therefore we need not use LiveData as the Data will not change during the Activity's
   * Lifecycle.
   * @param itemId A Unique identifier for a given record within the Database.
   * @return
   */
  @Query("SELECT * FROM ListItem WHERE itemId = :itemId")
  LiveData<ListItem> getListItemById(String itemId);

  /**
   * Get all entities of type ListItem
   * @return
   */
  @Query("SELECT * FROM ListItem")
  LiveData<List<ListItem>> getListItems();


  /**
   * Insert a new ListItem
   * @param listItem
   */
  @Insert(onConflict = REPLACE)
  Long insertListItem(ListItem listItem);

  /**
   * Delete a given ListItem
   * @param listItem
   */
  @Delete
  void deleteListItem(ListItem listItem);
}
