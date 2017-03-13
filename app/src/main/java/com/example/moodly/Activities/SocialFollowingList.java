package com.example.moodly.Activities;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Adapter;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.moodly.Controllers.UserController;
import com.example.moodly.Models.User;
import com.example.moodly.R;

import java.util.ArrayList;

/**
 * Created by Victor on 2017-03-08.
 * Fragment to be displayed on SocialBase
 * Loads list of people that the current user follows from ElasticSearch
 *
 * @see SocialBase
 */

public class SocialFollowingList extends Fragment {

    protected UserController userController = UserController.getInstance();
    protected User currentUser;
    protected ArrayList<String> userList;

    private View rootView;
    protected ListView displayUserList;
    protected ArrayAdapter<String> adapter;

    // PLACEHOLDER
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        refreshOnline();
        setViews(inflater, container);

        return rootView;
    }

    // Displayed
    protected void setViews(LayoutInflater inflater, ViewGroup container) {

        rootView = inflater.inflate(R.layout.social_list, container, false);

        displayUserList = (ListView) rootView.findViewById(R.id.display_social_list);
        userList = currentUser.getFollowing();

        adapter = new ArrayAdapter<String>(getActivity(), R.layout.user_list_item, userList);
        displayUserList.setAdapter(adapter);

    }

    // match online data with offline data
    protected void refreshOnline() {
        // add synchronization elements for part 5 here?
        currentUser = userController.getCurrentUser();
        //followers = userController.getFollowers();

    }


}

