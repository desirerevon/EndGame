package com.dgardner.endgame;
import android.os.AsyncTask;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class FetchPinterest extends AsyncTask<Void, Void, Void> {
    String pinData ="";
    String parse ="";
    String theParser ="";


    @Override
    protected Void doInBackground(Void... voids) {


        {
            try {
                ///////////////////////////////////////////////////////////////CREATE REQUEST
                URL url = new URL("https://www.reddit.com/r/Marvel/hot.json");
                HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
                //////////////////////////////////////////////////////////////READ ALL LINES
                InputStream inputStream = httpURLConnection.getInputStream();
                BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
                String line = "";
                while (line != null) {
                    line = bufferedReader.readLine();
                    pinData = pinData + line;
                }


            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            }

            return null;
        }

    }

    @Override
    protected void onPostExecute (Void aVoid){
        super.onPostExecute(aVoid);

        MainActivity.textView.setText(this.pinData);


    }
}
