package com.example.restapiversion;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.util.Objects;

public class MainActivity extends AppCompatActivity {

    private static final String[] urls = new String[10];

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //TextView text = (TextView) findViewById(R.id.textView);
    }

    public void parse_on_click(View view) throws IOException {
        //setContentView(R.layout.activity_main);
        //TextView text = (TextView) findViewById(R.id.textView);
        urls[0] = "https://vk.com/memzavod1523l";
        String content = (String) new AsyncParse().doInBackground(urls);
        System.out.println(content);
    }



//text.setText((Objects.requireNonNull(ParseService.VKParse(urls[0]))).toString());
//        TextView text = findViewById(R.id.textView);
//        urls[0] = "https://vk.com/memzavod1523l";
//

}