package lolheroes.example.recycler;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.recycler.R;

import java.util.ArrayList;

public class HeroesAdapter extends RecyclerView.Adapter<HeroesAdapter.ViewHolder> {
    private Context context;
    private ArrayList<HeroesModel> heroesModels;

    public HeroesAdapter(Context context) {
        this.context = context;
    }

    public ArrayList<HeroesModel> getHeroesModels() {
        return heroesModels;
    }

    public void setHeroesModels(ArrayList<HeroesModel> heroesModels) {
        this.heroesModels = heroesModels;
    }

    @NonNull
    @Override
    public HeroesAdapter.ViewHolder onCreateViewHolder(@NonNull ViewGroup viewGroup, int i) {
        View itRow = LayoutInflater.from(viewGroup.getContext()).inflate(R.layout.item_heroes,viewGroup,false);
        return new ViewHolder(itRow);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder viewHolder, int i) {
        Glide.with(context).load(getHeroesModels().get(i).getLambangHeroes()).into(viewHolder.ivLambangHeroes);
        viewHolder.tvNamaheroes.setText(getHeroesModels().get(i).getNamaHeroes());
        viewHolder.share.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(Intent.ACTION_SEND);
                intent.putExtra(Intent.EXTRA_TEXT, getHeroesModels().get(i).getPrivew());
                intent.setType("text/plain");
                context.startActivity(Intent.createChooser(intent, "Send To"));
            }
        });

        viewHolder.visit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(context, DetailActivity.class);

                intent.putExtra("logo", getHeroesModels().get(i).getLambangHeroes());
                intent.putExtra("nama", getHeroesModels().get(i).getNamaHeroes());
                intent.putExtra("preview", getHeroesModels().get(i).getPrivew());
                context.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        return getHeroesModels().size();
    }

    public class ViewHolder extends RecyclerView.ViewHolder{
        private ImageView ivLambangHeroes;
        private TextView tvNamaheroes;
        private Button share;
        private Button visit;

        public ViewHolder(@NonNull View itemView){
            super(itemView);
            ivLambangHeroes = itemView.findViewById(R.id.IV);
            tvNamaheroes = itemView.findViewById(R.id.nama_heroes);
            share = itemView.findViewById(R.id.btn_share);
            visit = itemView.findViewById(R.id.btn_preview);
        }
    }
}

