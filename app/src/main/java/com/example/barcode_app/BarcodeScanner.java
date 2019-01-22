package com.example.barcode_app;
import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.util.SparseArray;
import android.widget.Toast;
import com.google.android.gms.vision.barcode.Barcode;
import java.util.List;
import info.androidhive.barcode.BarcodeReader;

public class BarcodeScanner extends AppCompatActivity implements BarcodeReader.BarcodeReaderListener {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_barcode_scanner);
    }

    @Override
    public void onScanned(final Barcode barcode) {
        // single barcode scanned
        runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //Toast.makeText(getApplicationContext(), "Barcode: " + barcode.displayValue, Toast.LENGTH_SHORT).show();
                // Put the String to pass back into an Intent and close this activity
                String stringToPassBack = barcode.displayValue;
                Intent intent = new Intent();
                intent.putExtra("keyName", stringToPassBack);
                setResult(RESULT_OK, intent);
                finish();

            }
        });
    }

    @Override
    public void onScannedMultiple(List<Barcode> list) {
        // multiple barcodes scanned
    }

    @Override
    public void onBitmapScanned(SparseArray<Barcode> sparseArray) {
        // barcode scanned from bitmap image
    }

    @Override
    public void onScanError(String s) {
        // scan error
    }

    @Override
    public void onCameraPermissionDenied() {
        // camera permission denied
        Toast.makeText(getApplicationContext(), "No Camera Permission", Toast.LENGTH_SHORT).show();

    }


}

