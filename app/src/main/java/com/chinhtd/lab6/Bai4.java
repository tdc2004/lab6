package com.chinhtd.lab6;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

public class Bai4 extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai4);
        EditText tk = findViewById(R.id.edt_user);
        EditText mk = findViewById(R.id.edt_pass);
        Button btn_dk = findViewById(R.id.btn_dk);
        Button btn_dn = findViewById(R.id.btn_dn);

        btn_dk.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(getApplicationContext(), Bai4_dangky.class);
                startActivity(intent);
            }
        });
        String user = getIntent().getStringExtra(Bai4_dangky.Key_user);
        String pass = getIntent().getStringExtra(Bai4_dangky.Key_pass);
        tk.setText(user);
        mk.setText(pass);
        btn_dn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String taikhoan = tk.getText().toString();
                String matkhau = mk.getText().toString();
                if (taikhoan.equals(user)  && matkhau.equals(pass) ){
                    Toast.makeText(Bai4.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Bai4.this, Activity_home.class));
                }else if(taikhoan.equals("tdc") && matkhau.equals("123")){
                    Toast.makeText(Bai4.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                    startActivity(new Intent(Bai4.this, Activity_home.class));
                }else{
                    Toast.makeText(Bai4.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}