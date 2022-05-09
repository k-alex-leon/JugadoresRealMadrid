package com.example.jugadoresrealmadrid;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import java.util.ArrayList;

public class PlayerAdapter extends BaseAdapter {

    Context context;
    ArrayList<Player> playerArrayList;

    public PlayerAdapter(Context context, ArrayList<Player> playerArrayList) {
        this.context = context;
        this.playerArrayList = playerArrayList;
    }

    @Override
    public int getCount() {
        return playerArrayList.size();
    }

    @Override
    public Object getItem(int i) {
        return i;
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        TextView txtVName, txtVAge, txtVHeight, txtVPosition, txtVCountry;

        Player player = playerArrayList.get(i);

        if (view==null)
            view = LayoutInflater.from(context).inflate(R.layout.cardview_player, null);

        txtVName = view.findViewById(R.id.txtVNamePlayer);
        txtVAge = view.findViewById(R.id.txtVAgePlayer);
        txtVHeight = view.findViewById(R.id.txtVHeightPlayer);
        txtVPosition = view.findViewById(R.id.txtVPositionPlayer);
        txtVCountry = view.findViewById(R.id.txtVCountryPlayer);

        // pasando data a los campos del adapter
        txtVName.setText(player.getName());
        txtVAge.setText(player.getAge()+ " years");
        txtVHeight.setText(player.getHeight() + " cm");
        txtVPosition.setText(player.getPosition());
        txtVCountry.setText(player.getCountry());

        // debe retornar una vista
        return view;
    }
}
