package com.example.marvelappx.ui;

import android.os.Bundle;
import android.widget.ProgressBar;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marvelappx.R;
import com.github.barteksc.pdfviewer.PDFView;

public class PdfActivity extends AppCompatActivity {

    //ProgressBar progressBar;
    PDFView pdfView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.pdf_view);

        pdfView = findViewById(R.id.pdf_View);
        pdfView.fromAsset("alien.pdf").load();

}
}
