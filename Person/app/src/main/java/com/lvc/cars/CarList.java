package com.lvc.cars;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.view.View;
import android.widget.Toast;

import com.lvc.cars.model.Car;
import com.lvc.memories.R;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;


public class CarList extends AppCompatActivity implements CarListAdapter.OnDataSelected {



    private List<Car> cars = new ArrayList<Car>();
    private RecyclerView recyclerView;
    private RecyclerView.Adapter adapter; //RecyclerView.Adapter
    private RecyclerView.LayoutManager layoutManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        createFakeCars();


        findViewById(R.id.fab).setOnClickListener(new View.OnClickListener() {

            @Override
            public void onClick(View v) {
                recyclerView.scrollToPosition(0);
                Car newCar = new Car("New car" + new Date().toString(), "Description");
                cars.add(0,newCar);
                adapter.notifyItemInserted(0);
            }

        });

        recyclerView = (RecyclerView) findViewById(R.id.my_recycler_view);
        recyclerView.setHasFixedSize(true);

        LinearLayoutManager linearLayoutManager = new LinearLayoutManager(this);
        linearLayoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        GridLayoutManager gridLayoutManager = new GridLayoutManager(this,2);

        layoutManager = linearLayoutManager;
        recyclerView.setLayoutManager(gridLayoutManager);


        adapter = new CarListAdapter(this,this,cars);
        recyclerView.setAdapter(adapter);
    }

    @Override
    public void onDataSelected(View view, int position) {
        Car selectedItem  = cars.get(position);
        Toast.makeText(this, "Selected Item: " + selectedItem.toString(), Toast.LENGTH_SHORT).show();
        cars.remove(position);
        adapter.notifyItemRemoved(position);
    }


    private void createFakeCars() {
        for(int i =0; i < 10; i ++) {
            Car sampleCar = new Car();
            sampleCar.setTitle("Car " + 1);
            sampleCar.setDescription("Description: " + 1);
            cars.add(sampleCar);
        }

    }
}
