package com.chinhtd.lab6;

import androidx.appcompat.app.AppCompatActivity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    public static String Key_COSO = "coso";
    public static String Key_Name = "name";
    public static String Key_DiaChi = "dia_chi";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Spinner spinner = findViewById(R.id.spiner);
        LayoutInflater inflater = LayoutInflater.from(this);
        View selectedView = inflater.inflate(R.layout.item_spinner,null);
        TextView tvcoso = selectedView.findViewById(R.id.tv_coso);
        EditText edtTen = findViewById(R.id.edt_ten);
        EditText edtDiaChi = findViewById(R.id.edt_diachi);



        ArrayList<School> list = new ArrayList<>();
        list.add(new School(R.drawable.hn, "FPoly Ha Noi"));
        list.add(new School(R.drawable.hcm, "FPoly TP HCM"));
        list.add(new School(R.drawable.tn, "FPoly Tay Nguyen"));
        list.add(new School(R.drawable.dn, "FPoly Da Nang"));
        list.add(new School(R.drawable.ct, "FPoly Can Tho"));

        Student student = (Student) getIntent().getSerializableExtra(Activity_home.KEY_SV_MODEL);
        SchoolSpinnerAdapter adapter = new SchoolSpinnerAdapter(this,list);
        spinner.setAdapter(adapter);

        if (student!= null){
            edtTen.setText(student.name);
            edtDiaChi.setText(student.diaChi);
            int position = list.indexOf(student.coSo);
            spinner.setSelection(position);
        }

        Button btnSub = findViewById(R.id.btn_sub);
        btnSub.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                String coso = tvcoso.getText().toString();
                String ten = edtTen.getText().toString();
                String diaChi = edtDiaChi.getText().toString();

                if (ten.trim().equals("")){
                    Toast.makeText(MainActivity.this, "Tên SV không được để trống!", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (diaChi.trim().equals("")){
                    Toast.makeText(MainActivity.this, "Địa chỉ không được để trống!", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent();
                Bundle bundle = new Bundle();
                bundle.putString(Key_COSO,coso);
                bundle.putString(Key_Name,ten);
                bundle.putString(Key_DiaChi,diaChi);
                intent.putExtras(bundle);
                setResult(RESULT_OK,intent);
                finish();
            }
        });
    }
}