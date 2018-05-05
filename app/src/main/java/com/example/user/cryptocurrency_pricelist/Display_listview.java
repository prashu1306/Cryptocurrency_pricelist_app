package com.example.user.cryptocurrency_pricelist;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Display_listview extends AppCompatActivity {
    String json_string;
    TextView tx ;
    static FetchData process;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_display_listview);
        //json_string = getIntent().getExtras().getString("str");
        //tx = (TextView)findViewById(R.id.txt_view);
        //tx.setText(json_string);
        process= new FetchData(this);
        process.execute();

    }
}