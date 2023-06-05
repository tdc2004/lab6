package com.chinhtd.lab6;

import androidx.activity.result.ActivityResult;
import androidx.activity.result.ActivityResultCallback;
import androidx.activity.result.ActivityResultLauncher;
import androidx.activity.result.contract.ActivityResultContracts;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class Activity_home extends AppCompatActivity {

    private ArrayList<Student> list =new ArrayList<>();
    private ListView listView;
    private StudentAdapter adapter;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        listView = findViewById(R.id.lv);

        ActivityResultLauncher<Intent> add = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
            @Override
            public void onActivityResult(ActivityResult result) {
                if (result.getResultCode() == RESULT_OK) {
                    Intent intent = result.getData();
                    Bundle bundle = intent.getExtras();
                    String cs = bundle.getString(MainActivity.Key_COSO);
                    String ten = bundle.getString(MainActivity.Key_Name);
                    String dc = bundle.getString(MainActivity.Key_DiaChi);

                    list.add(new Student(cs,ten,dc));
                    fill();
                }
            }
        });
        list.add(new Student("FPoly Hà Nội", "Tống Doanh Chính", "Nam Định"));
        list.add(new Student("FPoly Hà Nội", "Lê Mạnh Quỳnh", "Vĩnh Phúc"));
        list.add(new Student("FPoly Hà Nội", "Tống Doanh Chính", "Nam Định"));
        list.add(new Student("FPoly Hà Nội", "Tống Doanh Chính", "Nam Định"));
        fill();

//        Button button = findViewById(R.id.btn_them);
//        button.setOnClickListener(new View.OnClickListener() {
//            @Override
//            public void onClick(View v) {
//                Intent intent = new Intent(Activity_home.this, MainActivity.class);
//                add.launch(intent);
//
//            }
//        });



        LayoutInflater inflater = (LayoutInflater)getSystemService(Context.LAYOUT_INFLATER_SERVICE);
        View view = inflater.inflate(R.layout.toolbar,null);
        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);
        getSupportActionBar().setTitle("Home");
        getSupportActionBar().setHomeAsUpIndicator(R.drawable.baseline_arrow_back_24);
        toolbar.setOnMenuItemClickListener(new Toolbar.OnMenuItemClickListener() {
            @Override
            public boolean onMenuItemClick(MenuItem item) {
                int i = item.getItemId();
                if (i==R.id.them_moi){
                    Intent intent = new Intent(Activity_home.this, MainActivity.class);
                    add.launch(intent);
                }else if (i == R.id.tim_kiem){

                }
                return false;
            }
        });

        }

    private void fill() {
        StudentAdapter adapter = new StudentAdapter(Activity_home.this,list);
        listView.setAdapter(adapter);
    }
    public void deleteSV(int index){
        list.remove(index);
        fill();
    }
    public static final String KEY_SV_MODEL ="sv_model";

    ActivityResultLauncher<Intent> goToEditSV = registerForActivityResult(new ActivityResultContracts.StartActivityForResult(), new ActivityResultCallback<ActivityResult>() {
        @Override
        public void onActivityResult(ActivityResult result) {
            if(result.getResultCode() == RESULT_OK){
                Intent intent = result.getData();
                Bundle bundle = intent.getExtras();
                String cs = bundle.getString(MainActivity.Key_COSO);
                String ten = bundle.getString(MainActivity.Key_Name);
                String dc = bundle.getString(MainActivity.Key_DiaChi);
                student.name = ten;
                student.diaChi=dc;
                student.coSo = cs;

                fill();

            }
        }
    });
    private Student student;
    public void updateSV(int position){
        Intent intent = new Intent(Activity_home.this,MainActivity.class);
        student = list.get(position);
        intent.putExtra(KEY_SV_MODEL,student);
        goToEditSV.launch(intent);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.toolbar, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        int id = item.getItemId();
        if(id == R.id.lich_hoc){
            Toast.makeText(this, "lichhoc", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.bangdiem){
            Toast.makeText(this, "bang diem", Toast.LENGTH_SHORT).show();
        }else if(id == R.id.diemdanh){
            Toast.makeText(this, "bang diem", Toast.LENGTH_SHORT).show();
        }else if (id == R.id.diemdanh){
            Toast.makeText(this, "diem danh", Toast.LENGTH_SHORT).show();
        } else if (id == R.id.dangxuat) {
            startActivity(new Intent(Activity_home.this, Bai4.class));
        }else if (item.getItemId() == android.R.id.home) {
            onBackPressed();
        }
        return true;
    }


}
