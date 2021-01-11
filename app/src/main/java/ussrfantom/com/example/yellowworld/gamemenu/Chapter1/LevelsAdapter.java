package ussrfantom.com.example.yellowworld.gamemenu.Chapter1;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

import ussrfantom.com.example.yellowworld.R;
import ussrfantom.com.example.yellowworld.gamemenu.Winner;
import ussrfantom.com.example.yellowworld.gamemenu.WinnerAdapter;

public class LevelsAdapter extends RecyclerView.Adapter<LevelsAdapter.LevelsViewHolder>{
    private ArrayList<Levels> levels;
    private OnLevelsClickListener onLevelsClickListener;

    public LevelsAdapter(ArrayList<Levels> levels) {
        this.levels = levels;
    }

    interface OnLevelsClickListener{
        void onLevelsClick(int position);
    }

    public void setOnLevelsClickListener(OnLevelsClickListener onLevelsClickListener) {
        this.onLevelsClickListener = onLevelsClickListener;
    }

    @NonNull
    @Override
    public LevelsViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int viewType) {
        View view = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.levels_item, viewGroup, false);
        return new LevelsAdapter.LevelsViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull LevelsViewHolder levelsViewHolder, int position) {
        Levels level = levels.get(position);
        levelsViewHolder.textViewName.setText(level.getName());
    }

    @Override
    public int getItemCount() {
        return levels.size();
    }

    class LevelsViewHolder extends RecyclerView.ViewHolder {

        private TextView textViewName;


        public LevelsViewHolder(@NonNull View itemView) {
            super(itemView);
            textViewName = itemView.findViewById(R.id.textViewNameLevels);
            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    if (onLevelsClickListener != null){
                        onLevelsClickListener.onLevelsClick(getAdapterPosition());
                    }
                }
            });
        }
    }

}
