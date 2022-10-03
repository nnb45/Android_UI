package com.poly.lab_7;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Patterns;
import android.view.View;
import android.widget.Toast;

import com.google.android.material.button.MaterialButton;
import com.google.android.material.internal.TextWatcherAdapter;
import com.google.android.material.textfield.TextInputEditText;
import com.google.android.material.textfield.TextInputLayout;

import java.util.regex.Pattern;

public class Bai_2 extends AppCompatActivity {
    TextInputLayout Layoutname, Layoutemail, LayoutPassword;
    TextInputEditText name, email, password;
    MaterialButton btn;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bai2);
        Layoutname = findViewById(R.id.Layoutname);
        Layoutemail = findViewById(R.id.Layoutemail);
        LayoutPassword = findViewById(R.id.LayoutPassword);

        name = findViewById(R.id.name);
        email = findViewById(R.id.email);
        password = findViewById(R.id.password);

        btn = findViewById(R.id.btn);

        name.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ValidateName();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });

        email.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                ValidateEmail();
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        password.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {
                ValidatePassword();
            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Validate();
            }
        });
    }

    private boolean ValidateName() {
        String name = Layoutname.getEditText().getText().toString().trim();
        if (name.isEmpty()) {
            Layoutname.setError("Nhập tên...");
            return false;
        } else {
            Layoutname.setError(null);
            Layoutname.setErrorEnabled(false);
            return true;
        }
    }

    private boolean ValidateEmail() {
        String email = Layoutemail.getEditText().getText().toString().trim();
        if (email.isEmpty()) {
            Layoutname.setError("Nhập email...");
            return false;
        } else if (!Patterns.EMAIL_ADDRESS.matcher(email).matches()) {
            Layoutemail.setError("Nhập không đúng định dạng");
            return false;
        } else {
            Layoutemail.setError(null);
            Layoutemail.setErrorEnabled(false);
            return true;
        }
    }
    private boolean ValidatePassword() {
        String pass = LayoutPassword.getEditText().getText().toString().trim();
        if (pass.isEmpty()) {
            LayoutPassword.setError("Nhập mật khẩu...");
            return false;
        } else if (pass.length() < 6) {
            LayoutPassword.setError("Nhập 6 kí tự");
            return false;
        } else {
            LayoutPassword.setError(null);
            LayoutPassword.setErrorEnabled(false);
            return true;
        }
    }
    private void Validate(){
        if(ValidateEmail() && ValidateName() && ValidatePassword()){
            Toast.makeText(this, "Thanh công", Toast.LENGTH_SHORT).show();
        }
    }
}
