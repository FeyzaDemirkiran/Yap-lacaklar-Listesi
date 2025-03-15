package com.example.yaplacaklistesiuygulamas;

import android.widget.EditText;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;

import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import com.google.firebase.auth.FirebaseAuth;

public class RegisterActivity extends AppCompatActivity {

    private EditText emailEditText,sifreEditText;

    // Yetkiyi tanımlandı.
    private FirebaseAuth auth;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this ); // kullanıcı arayüzünün kenarlardan taşmasını sağlamak için kullanılıyor.
        setContentView ( R.layout.activity_register );

        emailEditText = findViewById ( R.id.email );
        sifreEditText = findViewById ( R.id.sifre );
        Button registerButton;
        registerButton = findViewById ( R.id.kayit_button );
// Firebase olayını başlatma
        auth= FirebaseAuth.getInstance ();

        registerButton.setOnClickListener ( v -> {
            // Kullanıcı verilerini al
            String email = emailEditText.getText ().toString ();
            String sifre = sifreEditText.getText ().toString ();
            // kullanıcı verilerini çağır.
            kullaniciKayit( email,sifre);
        } );
    }

      private void kullaniciKayit(@NonNull String email, String sifre) {

        if(!email.isEmpty() && !sifre.isEmpty()) {
            auth.createUserWithEmailAndPassword ( email,sifre).addOnCompleteListener(task -> {

                if(task.isSuccessful ()) {
                    Toast.makeText ( this,"Kayıt Başarılı", Toast.LENGTH_SHORT).show ();
                    // Kayıt başarılı ise direkt ana sayfaya yönlendirsin.
                    startActivity ( new Intent (this, MainActivity.class) );
                    // mevcut kayıt aktivitesini bitirdikten sonra ana sayfaya yönlendirsin.
                    finish ();
                }

            } );
        }
       else {

            Toast.makeText ( this,"Bütün alanları doldurun.",Toast.LENGTH_SHORT).show ();
        }
      }


}