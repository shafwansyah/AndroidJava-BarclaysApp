package com.example.barclaysapp.ui.club;

import com.example.barclaysapp.model.TeamsItem;

import java.util.List;

public interface ClubContract {
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
