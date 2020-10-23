package com.example.list_menu_context_actionmode;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;
import androidx.constraintlayout.widget.ConstraintLayout;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ListView listView;
    Context context;
    ConstraintLayout rela;
    ArrayList<CountriesModel> countriesData;
    CustomAdapter customAdapter;
    CountriesModel countriesModel;

    @SuppressLint("WrongViewCast")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        context = this;
        setContentView(R.layout.activity_main);

        //getviews
        listView = findViewById(R.id.listView);
        rela = (ConstraintLayout) findViewById(R.id.rela);
        countriesData = new ArrayList<>();

        //add Countries Data
        populateCountriesData();

        customAdapter = new CustomAdapter(context, countriesData);
        listView.setAdapter(customAdapter);
        registerForContextMenu(listView);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {
                Toast.makeText(context, countriesData.get(position).getName(), Toast.LENGTH_SHORT).show();
            }
        });

    }

    public void onCreateContextMenu(ContextMenu menu, View v, ContextMenu.ContextMenuInfo menuInfo) {
        menu.setHeaderTitle("Cập nhật");
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.example_menu, menu);
    }

        public boolean onContextItemSelected(MenuItem item){
            switch (item.getItemId()) {
                case R.id.them:
                    Toast.makeText(this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.sua:
                    Toast.makeText(this, "Sửa thành công", Toast.LENGTH_SHORT).show();
                    return true;
                case R.id.xoa:
                    Toast.makeText(this, "Xóa thành công", Toast.LENGTH_SHORT).show();
                    return true;
                default:
                return super.onContextItemSelected(item);
            }
        }

    private void populateCountriesData() {
        //music1
        countriesModel = new CountriesModel();
        countriesModel.setId(1);
        countriesModel.setName("5 Centimeters Per Second");
        countriesModel.setImage(R.drawable.cms);
        countriesModel.setPopulation("CoMix Wave Films");
        countriesData.add(countriesModel);

        //music2
        countriesModel = new CountriesModel();
        countriesModel.setId(2);
        countriesModel.setName("The Girl Who Leapt Through Time");
        countriesModel.setImage(R.drawable.thegirl);
        countriesModel.setPopulation("Madhouse");
        countriesData.add(countriesModel);

        //music3
        countriesModel = new CountriesModel();
        countriesModel.setId(3);
        countriesModel.setName("Koe no Katachi");
        countriesModel.setImage(R.drawable.asilent);
        countriesModel.setPopulation("Kyoto Animation");
        countriesData.add(countriesModel);

        //music4
        countriesModel = new CountriesModel();
        countriesModel.setId(4);
        countriesModel.setName("Wolf Children");
        countriesModel.setImage(R.drawable.wolf);
        countriesModel.setPopulation("Studio Chizu");
        countriesData.add(countriesModel);

        //music5
        countriesModel = new CountriesModel();
        countriesModel.setId(5);
        countriesModel.setName("Hotarubi no Mori e");
        countriesModel.setImage(R.drawable.domdom);
        countriesModel.setPopulation("Brain’s Base");
        countriesData.add(countriesModel);

        //music6
        countriesModel = new CountriesModel();
        countriesModel.setId(6);
        countriesModel.setName("Grave of the Fireflies");
        countriesModel.setImage(R.drawable.modomdom);
        countriesModel.setPopulation("Studio Ghibli");
        countriesData.add(countriesModel);

        //music7
        countriesModel = new CountriesModel();
        countriesModel.setId(7);
        countriesModel.setName("Colorful");
        countriesModel.setImage(R.drawable.coloful);
        countriesModel.setPopulation("Sunrise / Ascension");
        countriesData.add(countriesModel);

        //music8
        countriesModel = new CountriesModel();
        countriesModel.setId(7);
        countriesModel.setName("Elfen Lied");
        countriesModel.setImage(R.drawable.elefen);
        countriesModel.setPopulation("A-1 Pictures");
        countriesData.add(countriesModel);

    }
}