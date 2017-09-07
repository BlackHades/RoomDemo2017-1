package org.youtwo.roomdemo2017.create;

import android.os.Bundle;
import android.support.v4.app.FragmentManager;
import org.youtwo.roomdemo2017.R;
import org.youtwo.roomdemo2017.util.BaseActivity;

/**
 * Created by Bill on 2017/9/7.
 */

public class CreateActivity extends BaseActivity {
  private static final String CREATE_FRAG = "CREATE_FRAG";


  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_create);


    FragmentManager manager = getSupportFragmentManager();

    CreateFragment fragment = (CreateFragment) manager.findFragmentByTag(CREATE_FRAG);

    if (fragment == null) {
      fragment = CreateFragment.newInstance();
    }

    addFragmentToActivity(manager,
        fragment,
        R.id.root_activity_create,
        CREATE_FRAG
    );

  }
}
