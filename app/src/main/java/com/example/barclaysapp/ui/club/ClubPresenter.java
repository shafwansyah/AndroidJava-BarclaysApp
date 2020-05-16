package com.example.barclaysapp.ui.club;

import com.example.barclaysapp.Constant;
import com.example.barclaysapp.model.Response;
import com.example.barclaysapp.remote_api.ApiClient;
import com.example.barclaysapp.remote_api.ApiInterface;

import retrofit2.Call;
import retrofit2.Callback;

public class ClubPresenter implements ClubContract.presenter {

    private final ClubContract.view view;
    private ApiInterface apiInterface = new ApiClient().getClient().create(ApiInterface.class);

    public ClubPresenter(ClubContract.view view) {
        this.view = view;
    }

    @Override
    public void getClubListItem() {

        view.showProgress();
        Call<Response> responseCall = apiInterface.getAllTeam(Constant.LEAGUE_NAME);
        responseCall.enqueue(new Callback<Response>() {
            @Override
            public void onResponse(Call<Response> call, retrofit2.Response<Response> response) {
                view.hideProgress();
                if (response.body() != null){
                    view.showClubList(response.body().getTeams());
                }
            }

            @Override
            public void onFailure(Call<Response> call, Throwable t) {
                view.hideProgress();
                view.showFailureMessage(t.getLocalizedMessage());
            }
        });
    }
}
