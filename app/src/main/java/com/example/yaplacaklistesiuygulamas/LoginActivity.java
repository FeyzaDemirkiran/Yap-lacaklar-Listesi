package com.example.yaplacaklistesiuygulamas;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.gms.tasks.Task;
import com.google.firebase.auth.AuthResult;
import com.google.firebase.auth.FirebaseAuth;

public class LoginActivity extends AppCompatActivity {

    private EditText emailEditText , sifreEditText;
    private Button loginButton, registerButton;

    private FirebaseAuth auth ;  // giriş yapmış bir kullanıcı var mı kontrol edilir.

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate ( savedInstanceState );
        EdgeToEdge.enable ( this );
        setContentView ( R.layout.activity_login );

        emailEditText = findViewById ( R.id.email);
        sifreEditText = findViewById ( R.id.sifre);
        loginButton   = findViewById ( R.id.giris_button);
        registerButton= findViewById ( R.id.kayit_button);

        // Firebase de ki görevi başlatır.
        auth = FirebaseAuth.getInstance ();

        loginButton.setOnClickListener ( v -> kullaniciGiris());
        registerButton.setOnClickListener ( v -> kullaniciKayit());

    }

    private void kullaniciKayit() {
        String email = emailEditText.getText().toString ();
        String sifre = sifreEditText.getText().toString ();

        if (!email.isEmpty() && !sifre.isEmpty())
        {
            // Kayıt işlemi yaptıracak
            auth.createUserWithEmailAndPassword (email,sifre ).addOnCompleteListener ( task-> {
                if (task.isSuccessful ())
                {
                    Toast.makeText ( this, "Kayıt işlemi başarılı.",Toast.LENGTH_SHORT).show ();
                }
                else
                {
                    Toast.makeText ( this, "Kayıt işlemi başarısız.",Toast.LENGTH_SHORT).show ();
                }
            });
        }

        else {
            // Kayıt işlemi başarısız oldu
            Toast.makeText ( this, "Lütfen gerekli alanları doldurunuz.", Toast.LENGTH_SHORT ).show ();
        }

    }

    private void kullaniciGiris() {

        String email = emailEditText.getText().toString ();
        String sifre = sifreEditText.getText().toString ();

        if (!email.isEmpty() && !sifre.isEmpty())
        {
            // Giriş işlemi yaptıracak
            auth.signInWithEmailAndPassword (email,sifre ).addOnCompleteListener ( task-> {
                if (task.isSuccessful ())
                {
                    Toast.makeText ( this, "Giriş işlemi başarılı.",Toast.LENGTH_SHORT).show ();
                }
                else
                {
                    Toast.makeText ( this, "Giriş işlemi başarısız.",Toast.LENGTH_SHORT).show ();
                }
            });
        }

        else
        {
            // Giriş işlemi başarısız oldu
            Toast.makeText (this, "Lütfen gerekli alanları doldurunuz.", Toast.LENGTH_SHORT ).show ();
        }
    }


}

