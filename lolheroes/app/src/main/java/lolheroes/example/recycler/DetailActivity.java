package lolheroes.example.recycler;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import com.bumptech.glide.Glide;
import com.example.recycler.R;

public class DetailActivity extends AppCompatActivity {
    TextView tvPreview, tvNamaPreview;
    ImageView ivLogo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_detail);

        ivLogo = findViewById(R.id.iv_logo);
        tvNamaPreview = findViewById(R.id.preview_nama_heroes);
        tvPreview = findViewById(R.id.tv_preview);

        getIncomingExtra();
    }

    private void getIncomingExtra(){
        if (getIntent().hasExtra("logo") && getIntent().hasExtra("nama") && getIntent().hasExtra("preview")){
            int logoHeroes = getIntent().getIntExtra("logo", 0);
            String namaHeroes = getIntent().getStringExtra("nama");
            String previewHeroes = getIntent().getStringExtra("preview");

            setDataActivity(logoHeroes, namaHeroes, previewHeroes);
        }
    }

    private void setDataActivity(int logoHeroes, String namaHeroes, String previewHeroes){
        Glide.with(this).asBitmap().load(logoHeroes).into(ivLogo);
        tvNamaPreview.setText(namaHeroes);
        tvPreview.setText(previewHeroes);
    }
}
