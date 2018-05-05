package com.example.user.cryptocurrency_pricelist;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import org.json.JSONException;
import com.example.user.cryptocurrency_pricelist.R;
public class MainActivity extends AppCompatActivity {
    Button click;
    public static TextView data1;
  //  static FetchData process = null;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        click = (Button)findViewById(R.id.button);
       /* try {
            process = new FetchData();
        } catch (Exception e) {
            e.printStackTrace();
        }
        process.execute();*/
        //dataparsed= process.getDataparsed();
        click.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                Intent intent = new Intent(MainActivity.this,Display_listview.class);
                //intent.putExtra("str",dataparsed);
                startActivity(intent);
            }
        });
    }
}