package com.example.jugadoresrealmadrid;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.SearchView;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

import java.util.ArrayList;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    TextInputEditText inputNamePlayer,inputAgePlayer, inputHeightPlayer,
            inputPositionPlayer ,inputCountryPlayer;

    ArrayList<Player> arrayList = new ArrayList<>();

    SearchView mSearchViewPlayer;
    PlayerAdapter mPlayerAdapter;

    AlertDialog mAlertDialog;

    private Button mBtnAddPlayer;
    private ListView mListViewPlayers;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mBtnAddPlayer = findViewById(R.id.btnAddPlayer);
        mBtnAddPlayer.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // al click muestra popup para agregar player
                showAddPlayerDialog();
            }
        });

        // para buscar por nombre
        mSearchViewPlayer = findViewById(R.id.searchViewPlayer);
        mSearchViewPlayer.setIconifiedByDefault(false);
        mSearchViewPlayer.setOnQueryTextListener(new SearchView.OnQueryTextListener() {
            @Override
            public boolean onQueryTextSubmit(String s) {
                return false;
            }

            // si el texto de busqueda cambia
            @Override
            public boolean onQueryTextChange(String s) {
                // crea nueva lista de resultados encontrados
                ArrayList<Player> filterPlayers = new ArrayList<Player>();
                for (Player player : arrayList){
                    // si la busqueda es igaul a algun nombre lo agrega a la lista filtro
                    if (player.getName().toLowerCase(Locale.ROOT).contains(s)){
                        filterPlayers.add(player);
                    }
                }
                // necesita crear nuevo adapter
                PlayerAdapter playerFilterAdapter = new PlayerAdapter(MainActivity.this, filterPlayers);
                mListViewPlayers.setAdapter(playerFilterAdapter);
                return false;
            }
        });
        mListViewPlayers = findViewById(R.id.listViewPlayers);
    }

    private void showAddPlayerDialog() {
        // creando popup
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        // asignando el view a usar
        View view = getLayoutInflater().inflate(R.layout.add_player_dialog, null);

        builder.setView(view);
        mAlertDialog = builder.create();
        mAlertDialog.show();

        // obteniendo ids
         inputNamePlayer = view.findViewById(R.id.iETNamePlayer);
         inputAgePlayer = view.findViewById(R.id.iETAgePlayer);
         inputHeightPlayer = view.findViewById(R.id.iETHeightPlayer);
         inputPositionPlayer = view.findViewById(R.id.iETPositionPlayer);
         inputCountryPlayer = view.findViewById(R.id.iETCountryPlayer);

        Button btnAddInfo = view.findViewById(R.id.btnAdd);
        // validar inputs
        btnAddInfo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // validando que los campos no esten en blanco
                validateIfo();
            }
        });

        ImageView imgVClose = view.findViewById(R.id.imgVClose);
        imgVClose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                // cierra el popup
                mAlertDialog.dismiss();
            }
        });

    }

    private void validateIfo() {
        String name, country, position, height , age;
        name = inputNamePlayer.getText().toString();
        country = inputCountryPlayer.getText().toString();
        position = inputPositionPlayer.getText().toString();
        age = inputAgePlayer.getText().toString();
        height = inputHeightPlayer.getText().toString();
        if (!name.isEmpty() && !country.isEmpty()
                && !position.isEmpty() && !age.isEmpty() && !height.isEmpty()){
            // asignando data
            Player player = new Player();
            player.setName(name);
            player.setAge(Integer.parseInt(age));
            player.setHeight(Integer.parseInt(height));
            player.setPosition(position);
            player.setCountry(country);
            // agrega plater a la lista
            arrayList.add(player);
            // pasando al adapter
            mPlayerAdapter = new PlayerAdapter(this, arrayList);
             // pasa adapter a listview
            mListViewPlayers.setAdapter(mPlayerAdapter);
            // mensaje por pantalla
            Toast.makeText(this, "Player added", Toast.LENGTH_LONG).show();
            // cierra el popup
            mAlertDialog.dismiss();
        }else{
            Toast.makeText(this, "There can be no empty fields", Toast.LENGTH_LONG).show();
        }
    }

}