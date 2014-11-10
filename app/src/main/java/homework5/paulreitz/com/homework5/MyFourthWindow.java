package homework5.paulreitz.com.homework5;

/**
 * Created by Paul on 11/10/2014.
*/

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

public class MyFourthWindow extends MyActivity {

    public void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        String[] country={"Lessons","Building 1st App","Swift Tutorial 2", "Swift Tutorial 3"};
        ArrayAdapter<String> stringArrayAdapter=
                new ArrayAdapter<String>(
                        this,
                        android.R.layout.simple_spinner_dropdown_item,
                        country);

        Spinner spinner =
                (Spinner)  findViewById(R.id.spinner);
        spinner.setAdapter(stringArrayAdapter);

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
                            Intent intent = new Intent(parent.getContext(), MyFourthWindow.class);
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
    

        WebView webview = (WebView) this.findViewById(R.id.webView);
        webview.getSettings().setJavaScriptEnabled(true);
        webview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });
        webview.loadUrl("http://www.raywenderlich.com/75289/swift-tutorial-part-3-tuples-protocols-delegates-table-views");


    }

}