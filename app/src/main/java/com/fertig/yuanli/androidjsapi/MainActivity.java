package com.fertig.yuanli.androidjsapi;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import java.io.IOException;

import jscore.SECBlockJavascriptAPI;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        final TextView textView = findViewById(R.id.text);
        final Button buttonAddress = findViewById(R.id.buttonAddress);
        final Button buttonMnemonic = findViewById(R.id.buttonMnemonic);
        final Button buttonPrivKey = findViewById(R.id.buttonPrivKey);
        final Button buttonTxsign = findViewById(R.id.buttonTxsign);
        final SECBlockJavascriptAPI api;
        try {
            api = new SECBlockJavascriptAPI(getApplicationContext());

            buttonAddress.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String privKey = "bad50f54db86259e077749d2593cd0fc74550a9b303da02972a37a16a7d23819";
                    textView.setText(api.PrivKeytoAddress(privKey));
                }
            });

            buttonMnemonic.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String privKey = "bad50f54db86259e077749d2593cd0fc74550a9b303da02972a37a16a7d23819";
                    textView.setText(api.EntropyToMnemonic(privKey));
                }
            });

            buttonPrivKey.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String mnemonic = "river position steel require girl someone build truck spoil size crouch wedding earn luxury holiday amateur parent entire potato vintage heavy trouble there define";
                    textView.setText(api.MnemonicToEntropy(mnemonic));
                }
            });

            buttonTxsign.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String Tx = "{\"privateKey\":\"bad50f54db86259e077749d2593cd0fc74550a9b303da02972a37a16a7d23819\",\"from\":\"0858768edb7c24b329efd1133888c2e1d0c23e76\",\"to\":\"04d7e0cd097bf5da8a6ac64b333d606639ffd7e8\",\"value\":\"3\",\"inputData\":\"Test\"}";
                    textView.setText(api.TxSign(Tx));
                }
            });
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
