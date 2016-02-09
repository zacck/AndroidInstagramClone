/*
 * Copyright (c) 2015-present, Parse, LLC.
 * All rights reserved.
 *
 * This source code is licensed under the BSD-style license found in the
 * LICENSE file in the root directory of this source tree. An additional grant
 * of patent rights can be found in the PATENTS file in the same directory.
 */
package com.parse.starter;

import android.content.Intent;
import android.database.Cursor;
import android.graphics.BitmapFactory;
import android.net.Uri;
import android.os.Bundle;
import android.provider.MediaStore;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.util.Log;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ImageView;

import com.parse.GetCallback;
import com.parse.Parse;
import com.parse.ParseAnalytics;
import com.parse.ParseException;
import com.parse.ParseObject;
import com.parse.ParseQuery;
import com.parse.SaveCallback;


public class MainActivity extends AppCompatActivity {

  @Override
  protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);
    ParseAnalytics.trackAppOpenedInBackground(getIntent());

    /*
    ParseObject score = new ParseObject("Score");
      score.put("username", "Zacck");
      score.put("points", 1999);
      score.saveInBackground(new SaveCallback() {
          @Override
          public void done(ParseException e) {
              if(e == null)
              {
                  Log.i("SaveinBackgroud", "Was successful");
              }
              else{
                  Log.i("SaveinBackgroundFailed", e.toString()+" Occured");
              }
          }
      });
      */

      //updating Parse data
      // we are querying the object we made
      ParseQuery<ParseObject> mParseQuery = ParseQuery.getQuery("Score");
      mParseQuery.getInBackground("9SfVA6v0lm", new GetCallback<ParseObject>() {
          @Override
          public void done(ParseObject object, ParseException e) {
              if(e == null)
              {
                  object.put("score","259");
                  object.saveInBackground();
              }
              else
              {
                  Log.i("Exception Occured", e.toString());

              }
          }
      });

      ParseQuery<ParseObject> mQuery = ParseQuery.getQuery("Score");
      mQuery.getInBackground("9SfVA6v0lm", new GetCallback<ParseObject>() {
          @Override
          public void done(ParseObject object, ParseException e) {
              if(e == null)
              {
                  object.put("username","zacck");
                  object.saveInBackground();
              }
              else
              {
                  Log.i("Exception Occured", e.toString());

              }
          }
      });




  }

  @Override
  public boolean onCreateOptionsMenu(Menu menu) {
    // Inflate the menu; this adds items to the action bar if it is present.
    getMenuInflater().inflate(R.menu.menu_main, menu);
    return true;
  }

  @Override
  public boolean onOptionsItemSelected(MenuItem item) {
    // Handle action bar item clicks here. The action bar will
    // automatically handle clicks on the Home/Up button, so long
    // as you specify a parent activity in AndroidManifest.xml.
    int id = item.getItemId();

    //noinspection SimplifiableIfStatement
    if (id == R.id.action_settings) {
      return true;
    }

    return super.onOptionsItemSelected(item);
  }
}
