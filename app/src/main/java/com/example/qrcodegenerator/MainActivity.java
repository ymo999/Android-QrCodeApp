package com.example.qrcodegenerator;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewQr;
    private Button buttonGenerate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewQr = findViewById(R.id.imageViewQr);
        buttonGenerate = findViewById(R.id.buttonGenerate);

        buttonGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // QRコードに変換したい文字列
                String textToEncode = "https://example.com";
                // QRコードのサイズ（ピクセル）
                int size = 500;

                try {
                    // BarcodeEncoderを使って一列でBitmapに変換
                    BarcodeEncoder barcodeEncoder = new BarcodeEncoder();
                    Bitmap bitmap = barcodeEncoder.encodeBitmap(
                            textToEncode,
                            BarcodeFormat.QR_CODE,
                            size,
                            size
                    );

                    // ImageViewに反映
                    imageViewQr.setImageBitmap(bitmap);

                } catch (Exception e) {
                    e.printStackTrace();
                    Toast.makeText(MainActivity.this, "生成に失敗しました", Toast.LENGTH_SHORT).show();
                }
            }
        });
    }
}
