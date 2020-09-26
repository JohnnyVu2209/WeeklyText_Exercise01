package com.apple.weeklytext_exercise01;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Switch;
import android.widget.TextView;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    EditText Ngay,Thang;
    TextView KetQua;
    Button Tinh;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Ngay = (EditText)findViewById(R.id.etDay);
        Thang = (EditText)findViewById(R.id.etMonth);
        KetQua = (TextView)findViewById(R.id.tvResult);
        Tinh = (Button)findViewById(R.id.btnCount);

        Tinh.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {


                try{
                    int D = Integer.parseInt(Ngay.getText().toString());
                    int M = Integer.parseInt(Thang.getText().toString());
                    int C = 0;
                    switch(M){
                        case 1: C += 31;
                        case 2: C += 29;
                        case 3: C += 31;
                        case 4: C += 30;
                        case 5: C += 31;
                        case 6: C += 30;
                        case 7: C += 31;
                        case 8: C += 31;
                        case 9: C += 30;
                        case 10: C += 31;
                        case 11: C += 30;
                        case 12: C += 31;
                            break;

                    }
                    C -= D;
                    KetQua.setText("Số ngày còn lại trong năm 2020 là: " + C);

                }catch (Exception e){
                    AlertDialog.Builder b = new AlertDialog.Builder(MainActivity.this);
                    b.setTitle("Lỗi");
                    b.setMessage("Vui lòng nhập đầy đủ thông tin");
                    b.setPositiveButton("OK", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialog, int which) {
                            Ngay.setText("");
                            Thang.setText("");
                        }
                    });
                    b.create();
                    b.show();
                }

            }
        });
    }
}
