package com.example.lab5;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.app.DatePickerDialog;
import android.app.ProgressDialog;
import android.app.TimePickerDialog;
import android.content.DialogInterface;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.DatePicker;
import android.widget.EditText;
import android.widget.TimePicker;
import android.widget.Toast;

import java.util.Calendar;

public class MainActivity extends AppCompatActivity {
    Calendar calendar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        // bài 1
        Button btnTime = findViewById(R.id.btnTime);
        Button btnDate = findViewById(R.id.btnDate);

        calendar = Calendar.getInstance();
        btnDate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DatePickerDialog datePickerDialog = new DatePickerDialog(
                        MainActivity.this,
                        new DatePickerDialog.OnDateSetListener() {
                            @Override
                            public void onDateSet(DatePicker view, int year, int month, int dayOfMonth) {
                                int nam = year;
                                int thang = month+1;
                                int ngay = dayOfMonth;
                                Toast.makeText(MainActivity.this, ngay+"/"+thang+"/"+nam, Toast.LENGTH_SHORT).show();
                            }
                        },
                        calendar.get(calendar.YEAR),
                        calendar.get(Calendar.MONTH),
                        calendar.get(Calendar.DAY_OF_MONTH)
                        );
                datePickerDialog.show();
            }
        });

        btnTime.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                TimePickerDialog timePickerDialog = new TimePickerDialog(
                        MainActivity.this,
                        new TimePickerDialog.OnTimeSetListener() {
                            @Override
                            public void onTimeSet(TimePicker view, int hourOfDay, int minute) {
//                                int gio = hourOfDay;
//                                int phut = minute;
 //                               Toast.makeText(MainActivity.this, gio+":"+phut, Toast.LENGTH_SHORT).show();

                                if (hourOfDay > 12){
                                    int gio = hourOfDay - 12;
                                    int phut = minute;
                                    Toast.makeText(MainActivity.this, gio+":"+phut+"pm", Toast.LENGTH_SHORT).show();
                                } else {
                                    int gio = hourOfDay;
                                    int phut = minute;
                                    Toast.makeText(MainActivity.this, gio+":"+phut+"am", Toast.LENGTH_SHORT).show();
                                }
                            }
                        },
                        calendar.get(Calendar.HOUR_OF_DAY),
                        calendar.get(Calendar.MINUTE),
                        false
                );
                timePickerDialog.show();
            }
        });
        // bài 2
        ProgressDialog progressDialog = ProgressDialog.show(
                MainActivity.this,
                "Thông báo",
                "Đang tải dữ liệu..."
        );

        CountDownTimer countDownTimer = new CountDownTimer(1000,1000) {
            @Override
            public void onTick(long millisUntilFinished) {

            }

            @Override
            public void onFinish() {
                progressDialog.dismiss();
            }
        };
        countDownTimer.start();
        // bài 3
        Button btnShow = findViewById(R.id.btnShow);
        Button btnShowList = findViewById(R.id.btnShowList);
        Button btnShowSingle = findViewById(R.id.btnShowSingle);
        Button btnShowMulti = findViewById(R.id.btnShowMulti);

        btnShow.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // hiển thị dialog
                showDialog();
            }
        });

        btnShowList.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogList();
            }
        });

        btnShowSingle.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogSingle();
            }
        });

        btnShowMulti.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogMulti();
            }
        });

        // bài 4
        Button btnShowLogin = findViewById(R.id.btnShowLogin);
        btnShowLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showDialogLogin();
            }
        });

    }

    private void showDialog(){
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Thông báo");
        builder.setMessage("Ở đây không có thông báo!");
        // ok , yes
        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "OK nè", Toast.LENGTH_SHORT).show();
            }
        });
        // no
        builder.setPositiveButton("No", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "No thì thôi", Toast.LENGTH_SHORT).show();
            }
        });

        // cancel
        builder.setNeutralButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Đã Cancel", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showDialogList(){
        String[] data = new String[]{"cam","ổi","quýt","kiwi"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Chọn lẹ lên");
        builder.setItems(data, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int i) {
                Toast.makeText(MainActivity.this, "Đã chọn " + data[i], Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();

    }

    private void showDialogSingle(){
        String[] data = new String[]{"Đỏ", "cam","vàng","xanh"};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Chọn 1 màu");
        builder.setSingleChoiceItems(data, 0 ,new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Đã chọn "+ data[which], Toast.LENGTH_SHORT).show();
            }
        });

        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "OK", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showDialogMulti(){
        String[] data = new String[]{"Đỏ", "cam","vàng","xanh"};
        boolean[] check = new boolean[]{false, true, false, true};

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("Chọn màu");
        builder.setMultiChoiceItems(data, check, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which, boolean isChecked) {
                if (isChecked){
                    Toast.makeText(MainActivity.this, "Chọn "+ data[which], Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Không chọn "+data[which], Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setNegativeButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                Toast.makeText(MainActivity.this, "Ok", Toast.LENGTH_SHORT).show();
            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

    private void showDialogLogin(){
        LayoutInflater inflater = getLayoutInflater();
        View view = inflater.inflate(R.layout.layoutlogin,null);
        EditText edtUser = view.findViewById(R.id.edtUser);
        EditText edtPass = view.findViewById(R.id.edtPass);

        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setView(view);
        builder.setNegativeButton("Đăng nhập", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                String user = edtUser.getText().toString();
                String pass = edtPass.getText().toString();

                if (user.equals("abc") && pass.equals("123")){
                    Toast.makeText(MainActivity.this, "Đăng nhập thành công", Toast.LENGTH_SHORT).show();
                }else {
                    Toast.makeText(MainActivity.this, "Đăng nhập thất bại", Toast.LENGTH_SHORT).show();
                }
            }
        });

        builder.setPositiveButton("Hủy", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {

            }
        });

        AlertDialog alertDialog = builder.create();
        alertDialog.show();
    }

}









