package lolheroes.example.recycler;

import com.example.recycler.R;

import java.util.ArrayList;

public class HeroesData {
    private static String[] title = new String[]{"Akali","AurelionSol","Braum",
            "Camille","Corki","Darius","Diana","DrMundo","Evelynn","Malphite"};

    private static int[] thumbnail = new
            int[]{R.drawable.akali,R.drawable.aurelionsol,
            R.drawable.braum,R.drawable.camille,R.drawable.corki,R.drawable.darius,
            R.drawable.diana,R.drawable.drmundo,R.drawable.evelynn,R.drawable.malphite};


    private static String[] preview = new String[]{
            "Abandoning the Kinkou Order and her tittle of the Fist of Shadow, Akali now strikes alone, ready to be the deadly weapon her people need.",
            "Aurelion Sol is a cosmic being capable of creating and destroying stars with the flick of his fingers.",
            "Blessed with massive biceps and an even bigger heart, Braum is a beloves iceborn hero of the Freljord.",
            "Weaponize to operate outside the boundaries of the law, Camille is the principal intelligencer of Clan Ferros.",
            "Corki fires a missile toward his target location that explodes on impact.",
            "Darius attacks and damaging abilities cause enemies to bleed for physical damage over 5 seconds, stacking up to 5 times.",
            "Bearing her crescent moonblade, Diana fights as a warrior of the Lunari-a faith all but quashed in the lands arround Mount Targon.",
            "Dr.Mundo hurls his cleaver, dealing damage equal to a portion of his target's short time.",
            "She lures in prey with the voluptuous facade of a human female, but once a person succumbs to her charms, Evelynn's.",
            "A massive creature of living stone, Malphite strugggles to impose blessed order on a chaotic world."

    };

    public static ArrayList<HeroesModel> getListData(){
        HeroesModel heroesModel = null;
        ArrayList<HeroesModel> list = new ArrayList<>();
        for (int i = 0; i <title.length; i++){
            heroesModel = new HeroesModel();
            heroesModel.setLambangHeroes(thumbnail[i]);
            heroesModel.setNamaHeroes(title[i]);
            heroesModel.setPrivew(preview[i]);
            list.add(heroesModel);
        }
        return list;
    }
}

