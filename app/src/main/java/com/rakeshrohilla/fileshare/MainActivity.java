package com.rakeshrohilla.fileshare;

import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.CountDownTimer;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.chaos.view.PinView;
import com.google.android.gms.tasks.OnCompleteListener;
import com.google.android.gms.tasks.Task;
import com.google.firebase.FirebaseException;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseAuthInvalidCredentialsException;
import com.google.firebase.auth.PhoneAuthCredential;
import com.google.firebase.auth.PhoneAuthProvider;

import java.util.concurrent.TimeUnit;

public class MainActivity extends AppCompatActivity {

    //declare object
    EditText editTextPhone;

    FirebaseAuth mAuth;
    Button btnGetVerficationCode;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //initialization
        mAuth = FirebaseAuth.getInstance();
        editTextPhone = findViewById(R.id.editTextPhone);
        btnGetVerficationCode=findViewById(R.id.btn_get_verfication);



        btnGetVerficationCode.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String phone = editTextPhone.getText().toString();

                if(phone.isEmpty()){
                    editTextPhone.setError("Phone number is required");
                    editTextPhone.requestFocus();
                    return;
                }

                if(phone.length() < 10 ){
                    editTextPhone.setError("Please enter a valid phone");
                    editTextPhone.requestFocus();
                    return;
                }
                Intent intent = new Intent(MainActivity.this, VerifyActivity.class);
                intent.putExtra("phone", phone);
                startActivity(intent);
                //finish();
            }
        });


    }



}