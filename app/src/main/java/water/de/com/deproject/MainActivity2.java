package water.de.com.deproject;

import android.os.AsyncTask;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.TextView;

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

public class MainActivity2 extends AppCompatActivity {

    TextView t1;
    TextView AutoMode_TextView;
    TextView MotorStatus_Textiew;
    Switch aut, motor_switch;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        aut = (Switch) findViewById(R.id.s2);
        motor_switch = findViewById(R.id.s1);
        MotorStatus_Textiew = findViewById(R.id.motorStatus_textView_id);
        t1 = findViewById(R.id.t1);

        AutoMode_TextView = findViewById(R.id.autoMode_textView_id);

        ulData process = new ulData();
        process.execute();

        aut.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if (isChecked) {

                    autoOn obj2 = new autoOn();
                    obj2.execute();
                    AutoMode_TextView.setText("Auto Mode: ON");

                } else {
                    autoMan obj1 = new autoMan();
                    obj1.execute();
                    AutoMode_TextView.setText("Auto Mode: OFF");
                }

            }
        });

        motor_switch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                if(isChecked){
                    MotorStatus_Textiew.setText("Motor Status: ON");
                    manOn obj3 = new manOn();
                    obj3.execute();
                }
                else{
                    MotorStatus_Textiew.setText("Motor Status: OFF");
                    manOff obj4 = new manOff();
                    obj4.execute();

                }
            }
        });
    }



    private class ulData extends AsyncTask<Void,Void,Void>{
        String data1 = "";
        String v = "";


        @Override
        protected Void doInBackground(Void... voids) {
            try {
                URL url = new URL("https://api.thingspeak.com/channels/741025/feeds.json?api_key=6RNLHYT3JQMDTTHS&results=2");

                HttpURLConnection con = (HttpURLConnection) url.openConnection();
                InputStream ip = con.getInputStream();
                BufferedReader br = new BufferedReader(new InputStreamReader(ip));
                String line = "";
                while(line != null) {
                    line = br.readLine();
                    data1 = data1 + line;
                }
                JSONObject jo = new JSONObject(data1);
                JSONArray ja = (JSONArray) jo.get("feeds");
                for(int i = 0; i < ja.length();i++) {


                    JSONObject jo1 = (JSONObject) ja.get(i);
                    v = jo1.get("field1") + "";


                }
                Integer a = Integer.parseInt(v);
                if(a>100){
                    data1 = "error";
                }else{
                    data1 = a + "";
                }




            } catch (MalformedURLException e) {
                e.printStackTrace();
            } catch (IOException e) {
                e.printStackTrace();
            } catch (JSONException e) {
                e.printStackTrace();
            }
            return null;
        }


        @Override
        protected void onPostExecute(Void aVoid) {
            super.onPostExecute(aVoid);
            t1.setText(data1);

        }
    }


}
