package com.example.hesapmakinesi;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import androidx.appcompat.app.AppCompatActivity;

public class MainActivity extends AppCompatActivity {

    private TextView display;
    private double ilkSayi = 0;
    private String islem = "";
    private boolean yeniIslem = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        // Ekran tanımlaması XML'e uygun hale getirildi
        display = findViewById(R.id.textViewSonuc);

        // Rakam Butonları için Ortak Tıklama Dinleyicisi
        View.OnClickListener sayiDinleyici = view -> {
            if (yeniIslem) {
                display.setText("");
                yeniIslem = false;
            }
            Button b = (Button) view;
            display.append(b.getText().toString());
        };

        // Hatalı ID'ler düzeltildi (button1 ve button8)
        int[] sayiButonlari = {
                R.id.button1,  // 0
                R.id.button6, R.id.button7, R.id.button8,    // 1, 2, 3
                R.id.button11, R.id.button12, R.id.button13, // 4, 5, 6
                R.id.button16, R.id.button17, R.id.button18  // 7, 8, 9
        };

        for (int id : sayiButonlari) {
            findViewById(id).setOnClickListener(sayiDinleyici);
        }

        // Temel İşlem Butonları (+, -, *, /, x^y) için Ortak Dinleyici
        View.OnClickListener operatorDinleyici = view -> {
            if (display.getText().toString().isEmpty()) return;
            ilkSayi = Double.parseDouble(display.getText().toString());
            yeniIslem = true;

            int id = view.getId();
            if (id == R.id.button19) islem = "+";
            else if (id == R.id.button14) islem = "-";
            else if (id == R.id.button9) islem = "*";
            else if (id == R.id.button4) islem = "/";
            else if (id == R.id.button10) islem = "^"; // x^y
        };

        findViewById(R.id.button19).setOnClickListener(operatorDinleyici);
        findViewById(R.id.button14).setOnClickListener(operatorDinleyici);
        findViewById(R.id.button9).setOnClickListener(operatorDinleyici);
        findViewById(R.id.button4).setOnClickListener(operatorDinleyici);
        findViewById(R.id.button10).setOnClickListener(operatorDinleyici);

        // Eşittir (=) - Button 3
        findViewById(R.id.button3).setOnClickListener(v -> {
            if (islem.isEmpty() || display.getText().toString().isEmpty()) return;
            double ikinciSayi = Double.parseDouble(display.getText().toString());
            double sonuc = 0;

            switch (islem) {
                case "+": sonuc = ilkSayi + ikinciSayi; break;
                case "-": sonuc = ilkSayi - ikinciSayi; break;
                case "*": sonuc = ilkSayi * ikinciSayi; break;
                case "/":
                    if (ikinciSayi == 0) {
                        display.setText("Hata");
                        yeniIslem = true;
                        return;
                    }
                    sonuc = ilkSayi / ikinciSayi;
                    break;
                case "^": sonuc = Math.pow(ilkSayi, ikinciSayi); break;
            }

            display.setText(String.valueOf(sonuc));
            islem = "";
            yeniIslem = true;
        });

        // Temizle (C) - Button 2
        findViewById(R.id.button2).setOnClickListener(v -> {
            display.setText("");
            ilkSayi = 0;
            islem = "";
            yeniIslem = true;
        });

        // Karekök (√x) - Button 5
        findViewById(R.id.button5).setOnClickListener(v -> {
            if (display.getText().toString().isEmpty()) return;
            double sayi = Double.parseDouble(display.getText().toString());
            display.setText(String.valueOf(Math.sqrt(sayi)));
            yeniIslem = true;
        });

        // 1/x - Button 15
        findViewById(R.id.button15).setOnClickListener(v -> {
            if (display.getText().toString().isEmpty()) return;
            double sayi = Double.parseDouble(display.getText().toString());
            if (sayi == 0) { display.setText("Hata"); }
            else { display.setText(String.valueOf(1 / sayi)); }
            yeniIslem = true;
        });

        // Yüzde (%) - Button 20
        findViewById(R.id.button20).setOnClickListener(v -> {
            if (display.getText().toString().isEmpty()) return;
            double sayi = Double.parseDouble(display.getText().toString());
            display.setText(String.valueOf(sayi / 100));
            yeniIslem = true;
        });
    }
}