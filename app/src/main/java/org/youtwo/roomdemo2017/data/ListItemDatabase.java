package org.youtwo.roomdemo2017.data;

import android.arch.persistence.room.Database;
import android.arch.persistence.room.RoomDatabase;

/**
 * entities:
 * The Models which we will use to convert to/from data stored in an SQL Table.
 * <p>
 * version:
 * In order to preserve Data when an SQL Table changes it's structure, we increment the version
 * number. Room also requires that you create a "Migration" class which allow the Database to be
 * restructured as desired, based on the Database structure of the initial version, to the structure
 * after the version is updated.
 * Created by R_KAY on 7/31/2017.
 */
@Database(entities = {ListItem.class}, version = 1, exportSchema = false)
public abstract class ListItemDatabase extends RoomDatabase {
  public abstract ListItemDao listItemDao();
}
