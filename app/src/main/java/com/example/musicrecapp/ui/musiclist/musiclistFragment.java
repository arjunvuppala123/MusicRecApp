package com.example.musicrecapp.ui.musiclist;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;

import com.example.musicrecapp.ui.musiclist.adapter.GenreAdapter;
import com.example.musicrecapp.ui.musiclist.adapter.SongAdapter;
import com.example.musicrecapp.ui.musiclist.model.Genre;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProvider;

import com.example.musicrecapp.R;
import com.example.musicrecapp.ui.musiclist.model.Song;

import java.util.ArrayList;
import java.util.List;

public class musiclistFragment extends Fragment implements AdapterView.OnItemSelectedListener{

    private List<Song> SongEntityList = new ArrayList<>();
    private List<Genre> GenreEntityList = new ArrayList<Genre>();
    private ListView listView;
    private SongAdapter adapter;
    private GenreAdapter GenreAdapter;
    private Spinner GenreSpinner;
    private musiclistViewModel musiclistViewModel;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        musiclistViewModel =
                new ViewModelProvider(this).get(musiclistViewModel.class);
        View root = inflater.inflate(R.layout.fragment_musiclist, container, false);
        //final TextView textView = root.findViewById(R.id.text_slideshow);
        GenreSpinner = root.findViewById(R.id.GenreSpinner);
        listView = root.findViewById(R.id.Song_listview);
        GenreAdapter = new GenreAdapter(getActivity(),android.R.layout.simple_spinner_dropdown_item,loadDummyGenres());
        GenreAdapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);
        GenreSpinner.setAdapter(GenreAdapter);
        GenreSpinner.setOnItemSelectedListener((AdapterView.OnItemSelectedListener) this);

        loadDummySong();
        adapter = new SongAdapter(getActivity(), SongEntityList);
        listView.setAdapter(adapter);

        musiclistViewModel.getText().observe(getViewLifecycleOwner(), new Observer<String>() {
            @Override
            public void onChanged(@Nullable String s) {
                //textView.setText(s);
            }
        });
        return root;
    }

    private List<Genre> loadDummyGenres(){
        GenreEntityList = new ArrayList<Genre>();

        Genre Genre1 = new Genre();
        Genre1.setId(1);
        Genre1.setGenre("Hip-Hop");
        GenreEntityList.add(Genre1);

        Genre Genre2 = new Genre();
        Genre2.setId(2);
        Genre2.setGenre("Rock");
        GenreEntityList.add(Genre2);

        Genre Genre3 = new Genre();
        Genre3.setId(3);
        Genre3.setGenre("Instrumental");
        GenreEntityList.add(Genre3);

        Genre Genre4 = new Genre();
        Genre4.setId(4);
        Genre4.setGenre("classical");
        GenreEntityList.add(Genre4);

        Genre Genre5 = new Genre();
        Genre5.setId(5);
        Genre5.setGenre("R&B");
        GenreEntityList.add(Genre5);

        return GenreEntityList;
    }


    private List<Song> loadDummySong(){

        SongEntityList = new ArrayList<>();
        Song Song1 = new Song();
        Song1.setId(1);
        Song1.setGenreId(1);
        Song1.setGenre("Hip-Hop");
        Song1.setsongName("Go Crazy");
        Song1.setartistName("Chris Brown & Young Thug");
        SongEntityList.add(Song1);

        Song Song2 = new Song();
        Song2.setId(2);
        Song2.setGenreId(2);
        Song2.setGenre("Rock");
        Song2.setsongName("Sad but True");
        Song2.setartistName("Snopp Dogg");
        SongEntityList.add(Song2);

        Song Song3 = new Song();
        Song3.setId(3);
        Song3.setGenreId(2);
        Song3.setGenre("Instrumental");
        Song3.setsongName("NORDHEM");
        Song3.setartistName("Henrik Lindstrand");
        SongEntityList.add(Song3);

        Song Song4 = new Song();
        Song4.setId(4);
        Song4.setGenreId(4);
        Song4.setGenre("Classical");
        Song4.setsongName("The Mother of Us All");
        Song4.setartistName("Virgil Thomson ");
        SongEntityList.add(Song4);

        Song Song5 = new Song();
        Song5.setId(5);
        Song5.setGenreId(5);
        Song5.setGenre("R&B");
        Song5.setsongName("Blinding Lights");
        Song5.setartistName("The Weenknd");
        SongEntityList.add(Song5);

        Song Song6 = new Song();
        Song6.setId(6);
        Song6.setGenreId(1);
        Song6.setGenre("Hip-Hop");
        Song6.setsongName("Laugh Now Cry Later");
        Song6.setartistName("Drake feat Lil Durk");
        SongEntityList.add(Song6);

        Song Song7 = new Song();
        Song7.setId(7);
        Song7.setGenreId(2);
        Song7.setGenre("Rock");
        Song7.setsongName("Age of Machine");
        Song7.setartistName("Greta Van Fleet");
        SongEntityList.add(Song7);

        Song Song8 = new Song();
        Song8.setId(8);
        Song8.setGenreId(3);
        Song8.setGenre("Instrumental");
        Song8.setsongName("Lullabies");
        Song8.setartistName("Yuna");
        SongEntityList.add(Song8);

        Song Song9 = new Song();
        Song9.setId(9);
        Song9.setGenreId(4);
        Song9.setGenre("classical");
        Song9.setsongName("Danish String Quartet");
        Song9.setartistName("Quatuor Danois");
        SongEntityList.add(Song9);

        Song Song10 = new Song();
        Song10.setId(10);
        Song10.setGenreId(5);
        Song10.setGenre("R&B");
        Song10.setsongName("Better Days");
        Song10.setartistName("oneRepublic");
        SongEntityList.add(Song10);

        Song Song11 = new Song();
        Song11.setId(11);
        Song11.setGenreId(5);
        Song11.setGenre("R&B");
        Song11.setsongName("Go Crazy");
        Song11.setartistName("Chris Brown");
        SongEntityList.add(Song11);

        Song Song12 = new Song();
        Song12.setId(12);
        Song12.setGenreId(3);
        Song12.setGenre("Instrumental");
        Song12.setsongName("The Vagabond");
        Song12.setartistName("Songs of Travel");
        SongEntityList.add(Song12);

        Song Song13 = new Song();
        Song13.setId(13);
        Song13.setGenreId(5);
        Song13.setGenre("R&B");
        Song13.setsongName("Damage");
        Song13.setartistName("H.E.R");
        SongEntityList.add(Song13);

        Song Song14 = new Song();
        Song14.setId(14);
        Song14.setGenreId(3);
        Song14.setGenre("Instrumental");
        Song14.setsongName("Jackets XL");
        Song14.setartistName("WDR Big Band and Yellowjackets");
        SongEntityList.add(Song14);

        Song Song15 = new Song();
        Song15.setId(15);
        Song15.setGenreId(5);
        Song15.setGenre("R&B");
        Song15.setsongName("Rise Up");
        Song15.setartistName("Andra Day");
        SongEntityList.add(Song15);

        Song Song16 = new Song();
        Song16.setId(16);
        Song16.setGenreId(5);
        Song16.setGenre("R&B");
        Song16.setsongName("Save Your Tears");
        Song16.setartistName("The Weeknd");
        SongEntityList.add(Song16);

        Song Song17 = new Song();
        Song17.setId(17);
        Song17.setGenreId(5);
        Song17.setGenre("R&B");
        Song17.setsongName("Vedo");
        Song17.setartistName("oneRepublic");
        SongEntityList.add(Song17);

        Song Song18 = new Song();
        Song18.setId(18);
        Song18.setGenreId(3);
        Song18.setGenre("Instrumental");
        Song18.setsongName("Surfboard");
        Song18.setartistName("oneRepublic");
        SongEntityList.add(Song18);

        Song Song19 = new Song();
        Song19.setId(19);
        Song19.setGenreId(5);
        Song19.setGenre("R&B");
        Song19.setsongName("Love Somebody");
        Song19.setartistName("Maroon 5");
        SongEntityList.add(Song19);

        Song Song20 = new Song();
        Song20.setId(20);
        Song20.setGenreId(5);
        Song20.setGenre("R&B");
        Song20.setsongName("You're Mines Still");
        Song20.setartistName("Yung Bleu Ft.Drake");
        SongEntityList.add(Song20);

        Song Song21 = new Song();
        Song21.setId(21);
        Song21.setGenreId(5);
        Song21.setGenre("R&B");
        Song21.setsongName("Let Me Love You");
        Song21.setartistName("DJ Snake");
        SongEntityList.add(Song21);

        Song Song22 = new Song();
        Song22.setId(22);
        Song22.setGenreId(3);
        Song22.setGenre("Instrumental");
        Song22.setsongName("The Circle");
        Song22.setartistName("Carmen Twillie, Lebo M");
        SongEntityList.add(Song22);

        Song Song23 = new Song();
        Song23.setId(23);
        Song23.setGenreId(3);
        Song23.setGenre("Instrumental");
        Song23.setsongName("Long In The Tooth");
        Song23.setartistName("Billy Joe Shaver");
        SongEntityList.add(Song23);

        Song Song24 = new Song();
        Song24.setId(24);
        Song24.setGenreId(3);
        Song24.setGenre("Instrumental");
        Song24.setsongName("Christmas Vibes");
        Song24.setartistName("Philip E Morris");
        SongEntityList.add(Song24);

        Song Song25 = new Song();
        Song25.setId(25);
        Song25.setGenreId(3);
        Song25.setGenre("Instrumental");
        Song25.setsongName("Plays");
        Song25.setartistName("Train");
        SongEntityList.add(Song25);

        Song Song26 = new Song();
        Song26.setId(26);
        Song26.setGenreId(3);
        Song26.setGenre("Instrumental");
        Song26.setsongName("Now's The Time");
        Song26.setartistName("The Savoy 10-Inch LP Collection (CD)");
        SongEntityList.add(Song26);

        Song Song27 = new Song();
        Song27.setId(27);
        Song27.setGenreId(1);
        Song27.setGenre("Hip-Hop");
        Song27.setsongName("Up");
        Song27.setartistName("Cardi B");
        SongEntityList.add(Song27);

        Song Song28 = new Song();
        Song28.setId(28);
        Song28.setGenreId(1);
        Song28.setGenre("Hip-Hop");
        Song28.setsongName("U 2 Luv");
        Song28.setartistName("Ne-Yo & Jeremih");
        SongEntityList.add(Song28);

        Song Song29 = new Song();
        Song29.setId(29);
        Song29.setGenreId(1);
        Song29.setGenre("Hip-Hop");
        Song29.setsongName("B.S");
        Song29.setartistName("Jhene Aiko feat H.E.R.");
        SongEntityList.add(Song29);

        Song Song30 = new Song();
        Song30.setId(30);
        Song30.setGenreId(1);
        Song30.setGenre("Hip-Hop");
        Song30.setsongName("Said Sum");
        Song30.setartistName("Moneybagg Yo");
        SongEntityList.add(Song30);

        Song Song31 = new Song();
        Song31.setId(31);
        Song31.setGenreId(1);
        Song31.setGenre("Hip-Hop");
        Song31.setsongName("The Woo");
        Song31.setartistName("Pop Smoke feat 50 Cent & Roddy Ricch ");
        SongEntityList.add(Song31);

        Song Song32 = new Song();
        Song32.setId(32);
        Song32.setGenreId(1);
        Song32.setGenre("Hip-Hop");
        Song32.setsongName("We Paid");
        Song32.setartistName("Lil Baby & 42 Dugg");
        SongEntityList.add(Song32);

        Song Song33 = new Song();
        Song33.setId(33);
        Song33.setGenreId(1);
        Song33.setGenre("Hip-Hop");
        Song33.setsongName("Hit Different");
        Song33.setartistName("SZA feat Ty Dolla $ign");
        SongEntityList.add(Song33);

        Song Song34 = new Song();
        Song34.setId(34);
        Song34.setGenreId(1);
        Song34.setGenre("Hip-Hop");
        Song34.setsongName("Bad Habits");
        Song34.setartistName("Usher");
        SongEntityList.add(Song34);

        Song Song35 = new Song();
        Song35.setId(35);
        Song35.setGenreId(1);
        Song35.setGenre("Rock");
        Song35.setsongName("Dreams");
        Song35.setartistName("Fleetwood Mac");
        SongEntityList.add(Song35);

        Song Song36 = new Song();
        Song36.setId(36);
        Song36.setGenreId(2);
        Song36.setGenre("Rock");
        Song36.setsongName("Vinkeles");
        Song36.setartistName("Jay Trak and Yaad");
        SongEntityList.add(Song36);

        Song Song37 = new Song();
        Song37.setId(37);
        Song37.setGenreId(2);
        Song37.setGenre("Rock");
        Song37.setsongName("Constance");
        Song37.setartistName("Spirit Box");
        SongEntityList.add(Song37);

        Song Song38 = new Song();
        Song38.setId(38);
        Song38.setGenreId(2);
        Song38.setGenre("Rock");
        Song38.setsongName("The Sound of Silence");
        Song38.setartistName("Disturebed");
        SongEntityList.add(Song38);


        Song Song39 = new Song();
        Song39.setId(39);
        Song39.setGenreId(2);
        Song39.setGenre("Rock");
        Song39.setsongName("Do They Know It's Christmas?");
        Song39.setartistName("Band Aid 30");
        SongEntityList.add(Song39);


        Song Song40 = new Song();
        Song40.setId(40);
        Song40.setGenreId(2);
        Song40.setGenre("Rock");
        Song40.setsongName("Yeah Right");
        Song40.setartistName("Disturebed");
        SongEntityList.add(Song40);

        Song Song41 = new Song();
        Song41.setId(40);
        Song41.setGenreId(4);
        Song41.setGenre("classical");
        Song41.setsongName("The Lark Ascending");
        Song41.setartistName("Ralph Vaughan Williams");
        SongEntityList.add(Song41);

        Song Song42 = new Song();
        Song42.setId(42);
        Song42.setGenreId(2);
        Song42.setGenre("Rock");
        Song42.setsongName("Popular Monster");
        Song42.setartistName("Falling In Reverse");
        SongEntityList.add(Song36);

        Song Song43 = new Song();
        Song43.setId(43);
        Song43.setGenreId(2);
        Song43.setGenre("Rock");
        Song43.setsongName("Enter Sandman");
        Song43.setartistName("Metallica");
        SongEntityList.add(Song43);

        Song Song44 = new Song();
        Song44.setId(44);
        Song44.setGenreId(4);
        Song44.setGenre("classical");
        Song44.setsongName("The Green Fuse");
        Song44.setartistName("Virgil Thomson");
        SongEntityList.add(Song44);

        Song Song45 = new Song();
        Song45.setId(45);
        Song45.setGenreId(4);
        Song45.setGenre("classical");
        Song45.setsongName("Study");
        Song45.setartistName("For studying");
        SongEntityList.add(Song45);

        Song Song46 = new Song();
        Song46.setId(46);
        Song46.setGenreId(4);
        Song46.setGenre("classical");
        Song46.setsongName("You and I");
        Song46.setartistName("Berlin Philharmonic");
        SongEntityList.add(Song46);

        Song Song47 = new Song();
        Song47.setId(47);
        Song47.setGenreId(4);
        Song47.setGenre("classical");
        Song47.setsongName("Rachmaniana: I. Andante improvizato");
        Song47.setartistName("Daniil Trifonov");
        SongEntityList.add(Song47);

        Song Song48 = new Song();
        Song48.setId(49);
        Song48.setGenreId(4);
        Song48.setGenre("classical");
        Song48.setsongName("Andantino");
        Song48.setartistName("Mozart");
        SongEntityList.add(Song48);

        Song Song49 = new Song();
        Song49.setId(49);
        Song49.setGenreId(4);
        Song49.setGenre("classical");
        Song49.setsongName("Mein!");
        Song49.setartistName("Jonas Kaufmann");
        SongEntityList.add(Song49);

        return SongEntityList;


    }

    @Override
    public void onItemSelected(AdapterView<?> parent, View view, int position, long id) {
        Genre Genre = GenreAdapter.getItem(position);

        adapter.getFilter().filter(Long.toString(Genre.getId()), count -> {
        });
    }


    @Override
    public void onNothingSelected(AdapterView<?> parent) {

    }

}
