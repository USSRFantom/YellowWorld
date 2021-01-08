package ussrfantom.com.example.yellowworld.gamemenu;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ussrfantom.com.example.yellowworld.R;

public class WinnerAdapter extends RecyclerView.Adapter<WinnerAdapter.WinnerViewHolder> {
    private ArrayList<Winner> winners;

    public WinnerAdapter(ArrayList<Winner> winners) {
        this.winners = winners;
    }

    @NonNull
    @Override
    public WinnerViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.winer_item, viewGroup, false);
        return new WinnerViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull WinnerViewHolder winnerViewHolder, int position) {
        Winner winner = winners.get(position);
        winnerViewHolder.textViewName.setText(winner.getName());
        winnerViewHolder.textViewData.setText(winner.getData());
        winnerViewHolder.textViewDescription.setText(winner.getDescription());
    }

    @Override
    public int getItemCount() {
        return winners.size();
    }


    class WinnerViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;
        private TextView textViewData;
        private TextView textViewDescription;

        public WinnerViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewName);
            textViewData = itemView.findViewById(R.id.textViewData);
            textViewDescription = itemView.findViewById(R.id.textViewDescription);
        }
    }
}
