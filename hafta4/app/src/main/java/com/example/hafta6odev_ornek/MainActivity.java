package com.example.hafta6odev_ornek;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import androidx.appcompat.app.AppCompatActivity;
import java.util.Random; // Rastgele seçim için gerekli

public class MainActivity extends AppCompatActivity {

    // 9 Resmimizin ID'lerini bir dizi (Array) içinde tutuyoruz
    int[] tumResimler = {
            R.drawable.ist_1, R.drawable.ist_2, R.drawable.ist_3,
            R.drawable.ank_1, R.drawable.ank_2, R.drawable.ank_3,
            R.drawable.izm_1, R.drawable.izm_2, R.drawable.izm_3
    };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnSehirSec = findViewById(R.id.btnSehirSec);

        btnSehirSec.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                // 1. Rastgele bir resim seçme işlemi (Aynı kalıyor)
                Random rastgele = new Random();
                int rastgeleSayi = rastgele.nextInt(tumResimler.length);
                int secilenResimID = tumResimler[rastgeleSayi];

                // 2. AlertDialog oluşturma
                AlertDialog.Builder pencere = new AlertDialog.Builder(MainActivity.this);
                pencere.setTitle("Şehirler");
                pencere.setIcon(secilenResimID);

                // 3. Alt alta çıkacak seçenekleri bir dizi olarak hazırlıyoruz
                String[] sehirSecenekleri = {"İstanbul", "Ankara", "İzmir"};

                // 4. setItems komutu ile seçenekleri alt alta listeliyoruz
                pencere.setItems(sehirSecenekleri, new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        // "which" bize hangi sıradaki seçeneğe tıklandığını söyler (0'dan başlar)

                        if (which == 0) {
                            // 1. sıradaki (İstanbul) seçildi
                            Intent istanbulaGit = new Intent(MainActivity.this, IstanbulActivity.class);
                            startActivity(istanbulaGit);

                        } else if (which == 1) {
                            // 2. sıradaki (Ankara) seçildi
                            Intent ankarayaGit = new Intent(MainActivity.this, AnkaraActivity.class);
                            startActivity(ankarayaGit);

                        } else if (which == 2) {
                            // 3. sıradaki (İzmir) seçildi
                            Intent izmireGit = new Intent(MainActivity.this, IzmirActivity.class);
                            startActivity(izmireGit);
                        }
                    }
                });

                pencere.show();
            }
        });
    }
}