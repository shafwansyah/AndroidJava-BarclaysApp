package com.example.barclaysapp.ui.club;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.ProgressBar;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.barclaysapp.R;
import com.example.barclaysapp.model.TeamsItem;
import com.example.barclaysapp.ui.main.MainActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class ClubActivity extends AppCompatActivity {

    @BindView(R.id.clubname) TextView clubTitle;
    @BindView(R.id.clubdesc) TextView clubdesc;
    @BindView(R.id.clubbadge) ImageView clubbadge;

    List<TeamsItem> teamsItems;
    int position;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_club);

        ButterKnife.bind(this);

        Intent intent = getIntent();
        teamsItems = (List<TeamsItem>) intent.getSerializableExtra(MainActivity.EXTRA_ITEMLIST);
        position = intent.getIntExtra(MainActivity.EXTRA_POSITION,0 );

        String strClubLogo = teamsItems.get(position).getStrTeamBadge();
        Picasso.get().load(strClubLogo).into(clubbadge);

        clubTitle.setText(teamsItems.get(position).getStrTeam());
        clubdesc.setText(teamsItems.get(position).getStrDescriptionEN());

    }
}
