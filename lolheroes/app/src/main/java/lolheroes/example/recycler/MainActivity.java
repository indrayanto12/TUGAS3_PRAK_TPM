package lolheroes.example.recycler;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import com.example.recycler.R;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private RecyclerView rvHeroes;
    private ArrayList<HeroesModel> listHeroes = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        rvHeroes = findViewById(R.id.rv_heroes_list);
        rvHeroes.setHasFixedSize(true);
        listHeroes.addAll(HeroesData.getListData());

        showRecyclerList();
    }

    private void showRecyclerList() {
        rvHeroes.setLayoutManager(new LinearLayoutManager(this));
        HeroesAdapter HeroesAdapter = new HeroesAdapter(this);
        HeroesAdapter.setHeroesModels(listHeroes);
        rvHeroes.setAdapter(HeroesAdapter);
    }
}