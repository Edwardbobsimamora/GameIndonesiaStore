package com.example.gameindonesiastore;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;

public class HomeFragment extends Fragment {
    private RecyclerView rvGames;
    private ArrayList<Games> list = new ArrayList<>();

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.activity_games_list,container,false);
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        rvGames = (RecyclerView)view.findViewById(R.id.rv_games);
        rvGames.setHasFixedSize(true);

        list.addAll(GamesData.getListData());
        showRecyclerList();

        ImageView buttonBack = view.findViewById(R.id.buttonBack);
        buttonBack.setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View view) {
                backToMenu();
                Log.d("Test", "Kembali ke awal");
            }

        });
    }

    public void backToMenu() {
        Intent intent = new Intent(getContext(), SplashActivity.class);
        startActivity(intent);
    }

    private void showRecyclerList(){
        ListGamesAdapter listGamesAdapter = new ListGamesAdapter(list);
        rvGames.setLayoutManager(new LinearLayoutManager(getContext()));
        rvGames.setAdapter(listGamesAdapter);

        listGamesAdapter.setOnItemClickCallback(new ListGamesAdapter.OnItemClickCallback() {
            @Override
            public void onItemClicked(Games data) {
                showSelectedGames(data);
            }
        });
    }
    private void showSelectedGames(Games games) {
        try{
            Intent i = new Intent(getContext(), GamesDetailActivity.class);
            i.putExtra(GamesDetailActivity.EXTRA_NAME, games.getName());
            i.putExtra(GamesDetailActivity.EXTRA_PRICE, games.getPrice());
            i.putExtra(GamesDetailActivity.EXTRA_DEVELOPER, games.getDeveloper());
            i.putExtra(GamesDetailActivity.EXTRA_DETAIL, games.getDetail());
            i.putExtra(GamesDetailActivity.EXTRA_PHOTO, games.getPhoto());
            startActivity(i);
        }
        catch(Error e) {
            Log.e("Error", e.toString());
        }

    }
}
