package org.youtwo.roomdemo2017.detail;

import android.arch.lifecycle.LifecycleFragment;
import android.arch.lifecycle.Observer;
import android.arch.lifecycle.ViewModelProvider;
import android.arch.lifecycle.ViewModelProviders;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import javax.inject.Inject;
import org.youtwo.roomdemo2017.R;
import org.youtwo.roomdemo2017.RoomDemoApplication;
import org.youtwo.roomdemo2017.data.ListItem;
import org.youtwo.roomdemo2017.viewmodel.ListItemViewModel;

/**
 * Created by Bill on 2017/9/7.
 */

public class DetailFragment extends LifecycleFragment {
  private static final String EXTRA_ITEM_ID = "EXTRA_ITEM_ID";

  private TextView dateAndTime;
  private TextView message;
  private ImageView coloredBackground;

  private String itemId;

  @Inject
  ViewModelProvider.Factory viewModelFactory;

  ListItemViewModel listItemViewModel;

  public DetailFragment() {
  }


  public static DetailFragment newInstance(String itemId) {
    DetailFragment fragment = new DetailFragment();
    Bundle args = new Bundle();
    args.putString(EXTRA_ITEM_ID, itemId);

    fragment.setArguments(args);
    return fragment;
  }

  @Override
  public void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);

    ((RoomDemoApplication) getActivity().getApplication())
        .getApplicationComponent()
        .inject(this);

    Bundle args = getArguments();

    this.itemId = args.getString(EXTRA_ITEM_ID);
  }

  public void onActivityCreated(Bundle savedInstanceState) {
    super.onActivityCreated(savedInstanceState);

    //Set up and subscribe (observe) to the ViewModel
    listItemViewModel = ViewModelProviders.of(this, viewModelFactory)
        .get(ListItemViewModel.class);

    listItemViewModel.getListItemById(itemId).observe(this, new Observer<ListItem>() {
      @Override
      public void onChanged(@Nullable ListItem listItem) {
        dateAndTime.setText(listItem.getItemId());
        message.setText(listItem.getMessage());
        coloredBackground.setImageResource(listItem.getColorResource());
      }
    });


  }

  @Override
  public View onCreateView(LayoutInflater inflater, ViewGroup container,
      Bundle savedInstanceState) {
    View v = inflater.inflate(R.layout.fragment_detail, container, false);

    dateAndTime = (TextView) v.findViewById(R.id.lbl_date_and_time_header);

    message = (TextView) v.findViewById(R.id.lbl_message_body);


    coloredBackground = (ImageView) v.findViewById(R.id.imv_colored_background);

    return v;
  }


  @Override
  public void onAttach(Context context) {
    super.onAttach(context);
  }

  @Override
  public void onDetach() {
    super.onDetach();
  }

}
