package org.youtwo.roomdemo2017.dependencyinjection;

import android.app.Application;
import dagger.Component;
import javax.inject.Singleton;
import org.youtwo.roomdemo2017.create.CreateFragment;
import org.youtwo.roomdemo2017.detail.DetailFragment;
import org.youtwo.roomdemo2017.list.ListFragment;

/**
 * Created by Bill on 2017/9/7.
 */
@Singleton
@Component(modules = {ApplicationModule.class, RoomModule.class})
public interface ApplicationComponent {
  void inject(ListFragment listFragment);
  void inject(CreateFragment createFragment);
  void inject(DetailFragment detailFragment);

  Application application();
}
