package homework5.paulreitz.com.homework5;

import android.app.Activity;
import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;

import java.util.List;


public class MyActivity extends Activity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my);

        String[] country={"Lessons","Building 1st App","Swift Tutorial 2", "Swift Tutorial 3"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        country);

        Spinner spinner =
                (Spinner)  findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);

        WebView webview = (WebView) this.findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl("https://developer.apple.com/swift/");


        /**
         * CRUD Operations
         * */
        // add Books

        AdapterView.OnItemSelectedListener onSpinner =
                new AdapterView.OnItemSelectedListener() {
                    @Override
                    public void onItemSelected(AdapterView<?> parent,View view,int position,long id)
                    {
                        //when an item is selected
                        if (parent.getSelectedItem().toString().contains("Building 1st App"))
                        {
                            Intent intent = new Intent(parent.getContext(), MySecondWindow.class);
                            startActivity(intent);


                        }
                        else if(parent.getSelectedItem().toString().contains("Swift Tutorial 2"))
                        {
                            Intent intent = new Intent(parent.getContext(), MyThirdWindow.class);
                            startActivity(intent);
                            // alert.setMessage("Enter book name!");

// Set an EditText view to get user input

                        }
                        else if(parent.getSelectedItem().toString().contains("Swift Tutorial 3"))
                        {
                            Intent intent = new Intent(parent.getContext(), MyFourthWindow.class);
                            startActivity(intent);
                            // alert.setMessage("Enter book name!");

// Set an EditText view to get user input

                        }





                    }
                    @Override
                    public void onNothingSelected( AdapterView<?>  parent)
                    {
                        //when nothing is selected
                        return;


                    }
                };

        spinner.setOnItemSelectedListener(onSpinner);
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.my, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        if (id == R.id.action_settings) {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }
}
