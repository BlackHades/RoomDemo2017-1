package org.youtwo.roomdemo2017;

import android.app.Application;
import org.youtwo.roomdemo2017.dependencyinjection.ApplicationComponent;
import org.youtwo.roomdemo2017.dependencyinjection.ApplicationModule;
import org.youtwo.roomdemo2017.dependencyinjection.DaggerApplicationComponent;
import org.youtwo.roomdemo2017.dependencyinjection.RoomModule;

/**
 * DispatchingAndroidInjector helps to inject Member Variables into Activities, Fragments, and so
 * forth.
 * <p>
 * https://github.com/googlesamples/android-architecture-components/blob/master/GithubBrowserSample/app/src/main/java/com/android/example/github/GithubApp.java
 */

public class RoomDemoApplication extends Application {
  private ApplicationComponent applicationComponent;

  @Override
  public void onCreate() {
    super.onCreate();

    applicationComponent = DaggerApplicationComponent
        .builder()
        .applicationModule(new ApplicationModule(this))
        .roomModule(new RoomModule(this))
        .build();

  }

  public ApplicationComponent getApplicationComponent() {
    return applicationComponent;
  }
}
