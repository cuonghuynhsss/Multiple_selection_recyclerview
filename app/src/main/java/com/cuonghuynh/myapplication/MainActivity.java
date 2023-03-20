package com.cuonghuynh.myapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.os.Bundle;

import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import java.util.ArrayList;

    public class MainActivity extends AppCompatActivity {

        private RecyclerView recyclerView;
        private ArrayList<Employee> employees = new ArrayList<>();
        private MultiAdapter adapter;
        private Button btnGetSelected;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.activity_main);
            this.btnGetSelected =  findViewById(R.id.bddd);
            this.recyclerView =  findViewById(R.id.recyclerView);

            getSupportActionBar().setTitle("Multiple Selection");
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.addItemDecoration(new DividerItemDecoration(this, LinearLayoutManager.VERTICAL));
            adapter = new MultiAdapter(this, employees);
            recyclerView.setAdapter(adapter);

            createList();

            btnGetSelected.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View view) {
                    if (adapter.getSelected().size() > 0) {
                        StringBuilder stringBuilder = new StringBuilder();
                        for (int i = 0; i < adapter.getSelected().size(); i++) {
                            stringBuilder.append(adapter.getSelected().get(i).getText());
                            stringBuilder.append("\n");
                        }
                        showToast(stringBuilder.toString().trim());
                    } else {
                        showToast("No Selection");
                    }
                }
            });
        }

        private void createList() {
            employees = new ArrayList<>();
            for (int i = 0; i < 20; i++) {
                Employee employee = new Employee("sfasfaf");
                //employee.setName("Employee " + (i + 1));
                // for example to show at least one selection
                if (i == 0) {
                    employee.setSelected(true);
                }
                //
                employees.add(employee);
            }
            adapter.setEmployees(employees);
        }

        private void showToast(String msg) {
            Toast.makeText(this, msg, Toast.LENGTH_SHORT).show();
        }
    }