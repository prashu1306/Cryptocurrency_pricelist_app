package com.example.user.cryptocurrency_pricelist;
import android.os.AsyncTask;
import android.view.View;
import android.widget.ListView;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;
import java.util.ArrayList;

public class FetchData extends AsyncTask<Void, Void, JSONObject> {
    String data = "";
    String fetchvalue="";
    String onerow="";
    String returnval="";
    Display_listview activity;
    ArrayList<ListView2> array_list = new ArrayList<ListView2>();
    static ArrayList<ListView2> restore_array = new ArrayList<ListView2>();
    CustomListAdapter list;
    static JSONArray JA;
    static  URL url;
    public FetchData(Display_listview context)
    {
        activity=context;
    }

    public FetchData() {

    }

    @Override
    protected void onPostExecute(JSONObject aVoid)
    {
        super.onPostExecute(aVoid);
        ListView listView =activity.findViewById(R.id.listview);
        try {

            if (array_list.size() > 0) {
                list = new CustomListAdapter(activity, array_list);
            } else {
                list = new CustomListAdapter(activity, restore_array);            }

            listView.setAdapter(list);
        }
        catch (Exception e)
        {
            listView.setAdapter(null);
        }

      //  MainActivity.data1.setText(this.dataparsed);
    }

    @Override
    protected JSONObject doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.coinmarketcap.com/v1/ticker/ ");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                fetchvalue = fetchvalue + line;
            }
            JA = new JSONArray(fetchvalue);
            for (int i = 0; i < JA.length(); i++) {
                JSONObject JO = (JSONObject) JA.getJSONObject(i);
                /*singleparsed = "Name:" + JO.get("name") + "\n" +
                        "USD Exchange Rate" + JO.get("price_usd") + "\n" +
                        "Percentage change in last hour" + JO.get("percent_change_1h") + "\n";
                dataparsed = dataparsed + singleparsed;*/
                array_list.add(new ListView2(JO.getString("name"),
                                JO.getString("price_usd"),
                                JO.getString("percent_change_1h")
                        )
                );
                //arrayList.add(new ListViewItem2("12",1.2,3.4));
            }
        } catch (IOException e) {
            e.printStackTrace();
        } catch (JSONException e) {
            e.printStackTrace();
        }
        if(array_list.size()!=0)
            restore_array=array_list;
        return null;
}
    public class ListView2 {
        public String name;
        public String price_usd;
        public String percent_change_1h;

        public ListView2(String name, String price_usd, String percent_change_1h) {
            this.name = name;
            this.price_usd = price_usd;
            this.percent_change_1h = percent_change_1h;
        }
    }


}