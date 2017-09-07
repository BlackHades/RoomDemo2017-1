package org.youtwo.roomdemo2017.dependencyinjection;

import android.app.Application;
import dagger.Module;
import dagger.Provides;
import org.youtwo.roomdemo2017.RoomDemoApplication;

/**
 * Created by Bill on 2017/9/7.
 */
@Module
public class ApplicationModule {
  private final RoomDemoApplication application;
  public ApplicationModule(RoomDemoApplication application) {
    this.application = application;
  }

  @Provides
  RoomDemoApplication provideRoomDemoApplication(){
    return application;
  }

  @Provides
  Application provideApplication(){
    return application;
  }
}
