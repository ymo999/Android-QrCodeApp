package io.github.ymo999.qrcode;

import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;
import androidx.appcompat.app.AppCompatActivity;
import com.google.zxing.BarcodeFormat;
import com.journeyapps.barcodescanner.BarcodeEncoder;

public class MainActivity extends AppCompatActivity {

    private ImageView imageViewQr;
    private Button btGenerate;
    private EditText etInputText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imageViewQr = findViewById(R.id.imageViewQr);
        btGenerate = findViewById(R.id.btnGenerate);
        etInputText = findViewById(R.id.etInputText);

        btGenerate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                // 入力欄から文字列を取得
                String textToEncode = etInputText.getText().toString().trim();

                // 未入力チェック
                if (textToEncode.isEmpty()) {
                    Toast.makeText(MainActivity.this, "文字列を入力してください", Toast.LENGTH_SHORT).show();
                }

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
