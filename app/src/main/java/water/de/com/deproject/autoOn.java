package water.de.com.deproject;



import android.os.AsyncTask;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

public class autoOn extends AsyncTask<Void,Void,Void>{


    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("https://api.thingspeak.com/update?api_key=9DXY6WA1LCV0ARVE&field1=1");

            HttpURLConnection con = (HttpURLConnection) url.openConnection();
            InputStream ip = con.getInputStream();
            BufferedReader br = new BufferedReader(new InputStreamReader(ip));
            String line = "";




        } catch (MalformedURLException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }


    @Override
    protected void onPostExecute(Void aVoid) {
        super.onPostExecute(aVoid);

    }
}
