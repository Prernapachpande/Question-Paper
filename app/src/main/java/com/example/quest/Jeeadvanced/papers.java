package com.example.quest.Jeeadvanced;

import android.os.AsyncTask;

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

public class papers extends AsyncTask<Void, Void, Void> {
    String data="";
    String dataparsed="",dataparsed1="",datafile="",datafile1="";
    String singleparsed="",singleparsedB="",fileparsed="",fileparsed1="";

    @Override
    protected Void doInBackground(Void... voids) {
        try {
            URL url = new URL("http://mapi.trycatchtech.com/v1/twelfth_question_papers/question_papers_list?year_id=1&subject=");
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }
            JSONArray JA = new JSONArray(data);

            JSONObject A = (JSONObject) JA.get(0);
            singleparsed =A.get("paper") + "\n";
            dataparsed = singleparsed;
            JSONObject F = (JSONObject) JA.get(0);
            fileparsed = F.get("file")+ "\n";
            datafile = fileparsed;

            JSONObject B = (JSONObject) JA.get(1);
            singleparsedB =B.get("paper") + "\n";
            dataparsed1 = singleparsedB;
            JSONObject F1 = (JSONObject) JA.get(1);
            fileparsed1 = F1.get("file")+ "\n";
            datafile1 = fileparsed1;


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
        AdvancedPpr.ppra.setText(this.dataparsed);
        AdvancedPpr.pprb.setText(this.dataparsed1);
        AdvancedPpr.PaperA = this.datafile;
        AdvancedPpr.PaperB = this.datafile1;
    }
}

