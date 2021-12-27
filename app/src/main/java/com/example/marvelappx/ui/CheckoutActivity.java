package com.example.marvelappx.ui;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.marvelappx.R;
import com.example.marvelappx.data.model.Comic;
import com.squareup.picasso.Picasso;

import java.io.Serializable;

public class CheckoutActivity extends AppCompatActivity {
    private Button btnConfirmarCompra;
    private Button btnAplicarCopum;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.checkout_activity);

    TextView check = findViewById(R.id.text_checkout);
    check.setText("CHECKOUT");

    String quantidade = getIntent().getStringExtra("keyy");
    Comic comic = (Comic) getIntent().getSerializableExtra("keyx");

    TextView txtTitulo = findViewById(R.id.text_comic);
    txtTitulo.setText(comic.getTitle());

        ImageView image = findViewById(R.id.image2);
        Picasso.get().load(comic.getThumbnail().getPath() + "." + //imagem .extensão
                comic.getThumbnail().getExtension())
                .placeholder((R.drawable.ic_launcher_background))
                .error(android.R.drawable.btn_dialog)
                .into(image);

    TextView txtTotal = findViewById(R.id.text_totalC);
    TextView txtQuanti = findViewById(R.id.text_quantidade);

    txtQuanti.setText("Quantidade: "+ quantidade);

    float valorTotal = (float) comic.getPrices().get(0).getPrice();
    int quantiConvertido =  Integer.parseInt(quantidade);
    float total = valorTotal*quantiConvertido;

    txtTotal.setText("Valor total: R$: " + String.valueOf(total));


        EditText editText = findViewById(R.id.edit_cupom);
        editText.setText("");


    btnConfirmarCompra = (Button) findViewById(R.id.btnConfirmarCompra);
    btnAplicarCopum = (Button) findViewById(R.id.btnAplicarCupom);

    btnConfirmarCompra.setOnClickListener(new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            String cupom = editText.getText().toString();

            if(cupom.contains("comum") && comic.isRare() == false){
                Intent intent = new Intent(getApplicationContext(), FinalActivity.class);
                float desconto10 = total/100*(10);
                float novoTotalComum = total-desconto10;
                intent.putExtra("keyFinal1",  String.valueOf(novoTotalComum));
                intent.putExtra("keyFinal2", (Serializable) comic);
                startActivity(intent);

                Toast.makeText(btnAplicarCopum.getContext(), "Cupom de 10% aplicado",
                        Toast.LENGTH_SHORT).show();

            }else if(cupom.contains("raro") && comic.isRare() == true){
                Intent intent = new Intent(getApplicationContext(), FinalActivity.class);
                System.out.println("CUPOM RARO "+cupom);
                float desconto25 = total/100*(25);
                float novoTotalRaro = total-desconto25;
                intent.putExtra("keyFinal1",  String.valueOf(novoTotalRaro));
                intent.putExtra("keyFinal2", (Serializable) comic);
                startActivity(intent);

                Toast.makeText(btnAplicarCopum.getContext(), "Cupom de 25% aplicado", Toast.LENGTH_SHORT).show();

            }else{
                Intent intent = new Intent(getApplicationContext(), FinalActivity.class);
                intent.putExtra("keyFinal1",  String.valueOf(total));
                startActivity(intent);

                Toast.makeText(btnAplicarCopum.getContext(), "Cupom invalido",
                        Toast.LENGTH_SHORT).show();

            }

        }
    });





}}
