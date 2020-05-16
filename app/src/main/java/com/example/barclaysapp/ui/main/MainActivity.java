package com.example.barclaysapp.ui.main;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.widget.NestedScrollView;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.barclaysapp.R;
import com.example.barclaysapp.model.Response;
import com.example.barclaysapp.model.TeamsItem;
import com.example.barclaysapp.ui.club.ClubActivity;

import java.io.Serializable;
import java.util.List;

public class MainActivity extends AppCompatActivity implements MainContract.view{

    RecyclerView recyclerView;
    private final MainPresenter mainPresenter = new MainPresenter(this);

    public static final String EXTRA_ITEMLIST = "itemList" ;
    public static final String EXTRA_POSITION = "position" ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        recyclerView = findViewById(R.id.recyclerview_club);
        mainPresenter.getClubListItem();

    }

    @Override
    public void showProgress() {
        findViewById(R.id.shimmer_clublist).setVisibility(View.VISIBLE);
    }

    @Override
    public void hideProgress() {
        findViewById(R.id.shimmer_clublist).setVisibility(View.GONE);
    }

    @Override
    public void showClubList(List<TeamsItem> teamsItemList) {
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(this, teamsItemList);
        recyclerView.setAdapter(recyclerAdapter);
        GridLayoutManager layoutManager = new GridLayoutManager(this,3,
                GridLayoutManager.VERTICAL, false);
        recyclerView.setLayoutManager(layoutManager);
        recyclerAdapter.notifyDataSetChanged();

        recyclerAdapter.setOnitemClickListener((view, position) ->{
            Intent intent = new Intent(this, ClubActivity.class);
            intent.putExtra(EXTRA_ITEMLIST, (Serializable) teamsItemList);
            intent.putExtra(EXTRA_POSITION, position);
            startActivity(intent);
        } );
    }

    @Override
    public void showFailureMessage(String message) {
        Toast.makeText(this,message, Toast.LENGTH_SHORT).show();
    }
}
