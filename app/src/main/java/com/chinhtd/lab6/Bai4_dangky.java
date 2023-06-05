package com.chinhtd.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Bai4_dangky extends AppCompatActivity {
    public static String Key_user ="user";
    public static String Key_pass ="Pass";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4_dangky);
        EditText tk = findViewById(R.id.edt_tk);
        EditText mk = findViewById(R.id.edt_mk);
        EditText rmk = findViewById(R.id.edt_remk);
        Button btn = findViewById(R.id.btn_dk1);
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String user = tk.getText().toString();
                String pas =mk.getText().toString();
                String repas = rmk.getText().toString();
                if(user==null || user.equals("")){
                    Toast.makeText(Bai4_dangky.this, "Chua nhap tai khoan", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(pas == null || pas.equals("")){
                    Toast.makeText(Bai4_dangky.this, "Chua nhap mat khau", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(repas == null || repas.equals("")){
                    Toast.makeText(Bai4_dangky.this, "Chua nhap lai mat khau", Toast.LENGTH_SHORT).show();
                    return;
                }
                if(!pas.equals(repas)){
                    Toast.makeText(Bai4_dangky.this, "Mat Khau khong khop", Toast.LENGTH_SHORT).show();
                    return;
                }
                Intent intent = new Intent(getApplicationContext(), Bai4.class);
                intent.putExtra(Key_user,user);
                intent.putExtra(Key_pass,pas);
                startActivity(intent);
            }
        });
    }
}