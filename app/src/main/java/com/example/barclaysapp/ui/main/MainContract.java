package com.example.barclaysapp.ui.main;

import com.example.barclaysapp.model.TeamsItem;

import java.util.List;

public interface MainContract {

    interface view{
        void showProgress();
        void hideProgress();
        void showClubList(List<TeamsItem> teamsItemList);
        void showFailureMessage(String message);
    }

    interface presenter{
        void getClubListItem();
    }
}
