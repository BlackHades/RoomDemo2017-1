package org.youtwo.roomdemo2017.dependencyinjection;

import android.app.Application;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.persistence.room.Room;
import dagger.Module;
import dagger.Provides;
import javax.inject.Singleton;
import org.youtwo.roomdemo2017.data.ListItemDao;
import org.youtwo.roomdemo2017.data.ListItemDatabase;
import org.youtwo.roomdemo2017.data.ListItemRepository;
import org.youtwo.roomdemo2017.viewmodel.CustomViewModelFactory;

/**
 * Created by Bill on 2017/9/6.
 */
@Module
public class RoomModule {

  private final ListItemDatabase database;

  public RoomModule(Application application) {
    this.database = Room.databaseBuilder(
        application,
        ListItemDatabase.class,
        "ListItem.db"
    ).build();
  }

  @Provides
  @Singleton
  ListItemRepository provideListItemRepository(ListItemDao listItemDao){
    return new ListItemRepository(listItemDao);
  }

  @Provides
  @Singleton
  ListItemDao provideListItemDao(ListItemDatabase database){
    return database.listItemDao();
  }

  @Provides
  @Singleton
  ListItemDatabase provideListItemDatabase(Application application){
    return database;
  }

  @Provides
  @Singleton
  ViewModelProvider.Factory provideViewModelFactory(ListItemRepository repository){
    return new CustomViewModelFactory(repository);
  }
}
