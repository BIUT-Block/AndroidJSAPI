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
        final Button encryptKeystore = findViewById(R.id.encryptKeystore);
        final Button decryptKeystore = findViewById(R.id.decryptKeystore);
        final Button buttonAddress = findViewById(R.id.buttonAddress);
        final Button buttonMnemonic = findViewById(R.id.buttonMnemonic);
        final Button buttonPrivKey = findViewById(R.id.buttonPrivKey);
        final Button buttonTxsign = findViewById(R.id.buttonTxsign);
        final SECBlockJavascriptAPI api;
        try {
            api = new SECBlockJavascriptAPI(getApplicationContext());

            encryptKeystore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String KeyStore = "{\"868ca59fb5941e1fcca0f83a51b119fa70b503aac7f78fab4d2fc7a8994c7a54\":{\"privateKey\":\"868ca59fb5941e1fcca0f83a51b119fa70b503aac7f78fab4d2fc7a8994c7a54\",\"publicKey\":\"a92cfe5aae7f2a71e98a26275f5cb206e3f1ae777245f572354a15d5e45623d2e53124bced96e0b1306e9a7441b54025cd000282c9369652e40bad2779b6c522\",\"englishWords\":\"make gown gun hen draft avocado crater business demise mirror edit visual area limb prison year moral foil episode monster maze plate true leopard\",\"userAddress\":\"baaac46667bcd1f828f248adb68e894753dcc350\"}}";
                    textView.setText(api.encryptKeystore(KeyStore,"123456"));
                }
            });

            decryptKeystore.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    String secretString = "U2FsdGVkX1+pckN7K/jeQob8oJXWwoE29IxJjR9ypQwHXMY5eqQwr7kK9I20Ie4rZ5ibZKponKof+eQgc+HSEnpBtI8etYABvN7bX1Fre/qRpUy5qhDPauyUq8xNzvGW7vChqrNG5RPYg02trJwFfhQ0JFvnp8327EfE2jt3IWBl2EA3ZxddXsKkoZyX7Lrum2HQ8JdruVNDn8tysFPqPP6CmhkH68YfIMgYNbzM7NjQusyad33rMrVen7+0qmXHqQFAUyXcP1m2aRFDpJ3Vt2Fa2PwR92f1GwQywRwfolfPVljT9c9Av9K9R38yB1URGhg9Cpgwekepu8G/qDVJUQ1sH/GKI+CfwG+psLfYVYbf4DlcUz6+91ofMW3aYpjXr1Jo/1hLgAYUXM1/isGfVZnzSCBrmNwpSEkP4OuAvWq6HKvf0xxemn4S4+ksOO2njEK3AtrNjk+8yHqFX/4taNWhyQdRcXP2KVBYylgZet1Emi3Y9p3mCsgyjivRZLDVOwgrzpoQYG2tiihbGou/ilZ4Zlb+A2bb1HN0P9ybHNUyTsyaNhoDCJFEY6Fi0WHF9ekqEltHdjonWOQS3zVPgrOx4Y2/zKcVqE2j8tmpnIF/T2xrAsNuyoZPqskokrOxeltCDdGlBYVu4fePfWD+R+gu8AZGto8WD4ciWGb8+RCVPPW1bv7NaQgkUxm/cO+Vv4jCaIEPBrtbWv+glCrTCg==";
                    textView.setText(api.decryptKeystore(secretString, "123456"));
                }
            });

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
