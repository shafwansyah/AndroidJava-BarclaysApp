package com.example.barclaysapp.ui.main;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.barclaysapp.R;
import com.example.barclaysapp.model.TeamsItem;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class RecyclerAdapter extends RecyclerView.Adapter<RecyclerAdapter.RecyclerViewHolder> {

    private Context context;
    private List<TeamsItem> teamsItemList;
    private static ClickListener clickListener;

    public RecyclerAdapter(Context context, List<TeamsItem> teamsItemList) {
        this.context = context;
        this.teamsItemList = teamsItemList;
    }

    @NonNull
    @Override
    public RecyclerAdapter.RecyclerViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_recycler_clublist, parent, false);
        return new RecyclerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull RecyclerAdapter.RecyclerViewHolder holder, int position) {
        final TeamsItem teamsItem =teamsItemList.get(position);

        holder.txtclubname.setText(teamsItem.getStrTeam());
        Glide.with(context).load(teamsItem.getStrTeamBadge()).placeholder(R.drawable.ic_account_circle).into(holder.imgClubBadge);

    }

    @Override
    public int getItemCount() {
        return teamsItemList.size();
    }

    public class RecyclerViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{

        @BindView(R.id.txt_ClubList) TextView txtclubname;
        @BindView(R.id.image_Clublist) ImageView imgClubBadge;

        public RecyclerViewHolder(@NonNull View itemView) {
            super(itemView);
            ButterKnife.bind(this, itemView);
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            clickListener.onClick(v, getAdapterPosition());
        }
    }

    public void setOnitemClickListener (ClickListener clickListener){
        RecyclerAdapter.clickListener = clickListener;
    }

    public interface ClickListener{
        void onClick(View view, int position);
    }
}
