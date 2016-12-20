package szenmedcal1.medcal1.szen95.szenmedcal1;

import android.content.Context;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.view.LayoutInflater;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.szen95.szenmedcal1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CURB65 extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_curb65);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_curb65, menu);
        return true;
    }

    public void calculateClickHandler(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        Spinner spinner1 = (Spinner) findViewById(R.id.spinner1);

        Spinner spinner2 = (Spinner) findViewById(R.id.spinner2);

        Spinner spinner3 = (Spinner) findViewById(R.id.spinner3);

        Spinner spinner4 = (Spinner) findViewById(R.id.spinner4);

        String selectedItem = (String) spinner.getSelectedItem();

        String selectedItem1 = (String) spinner1.getSelectedItem();

        String selectedItem2 = (String) spinner2.getSelectedItem();

        String selectedItem3 = (String) spinner3.getSelectedItem();

        String selectedItem4 = (String) spinner4.getSelectedItem();

        if (selectedItem.trim().equals("No") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("No") && selectedItem3.equals("No") &&
                selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton) {

            TextView resText = (TextView) findViewById(R.id.resLabel);

            resText.setText(0 + " " + "-" + " " + "Low risk group: 0.6% 30-day mortality. Consider outpatient treatment.");

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        } else if (selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton ) {

            TextView resText = (TextView) findViewById(R.id.resLabel);

            resText.setText(1 + " " + "-" + " " + "Low risk group: 0.6% 30-day mortality. Consider outpatient treatment.");

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        } else if (selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton) {

            TextView resText = (TextView) findViewById(R.id.resLabel);

            resText.setText(2 + " " + "-" + " " + "Moderate risk group: 6.8% 30-day mortality. Consider inpatient treatment or outpatient with close followup.");

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        } else if (selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton ||selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton) {

            TextView resText = (TextView) findViewById(R.id.resLabel);

            resText.setText(3 + " " + "-" + " " + "Severe risk group: 14.0% 30-day mortality. Consider inpatient treatment with possible intensive care admission.");

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        } else if (selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("No") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("No") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("No") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("No") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton || selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("No")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton) {

            TextView resText = (TextView) findViewById(R.id.resLabel);

            resText.setText(4 + " " + "-" + " " + "Highest risk group: 27.8% 30-day mortality. Consider inpatient treatment with possible intensive care admission.");

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        } else if (selectedItem.trim().equals("Yes") && selectedItem1.trim().equals("Yes") && selectedItem2.trim().equals("Yes") && selectedItem3.trim().equals("Yes")
                && selectedItem4.trim().equals("Yes") && view.getId() == R.id.calculateButton) {

            TextView resText = (TextView) findViewById(R.id.resLabel);

            resText.setText(5 + " " + "-" + " " + "Highest risk group: 27.8% 30-day mortality. Consider inpatient treatment with possible intensive care admission.");

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        } else {
            Toast.makeText(getApplicationContext(), "Please try again!",
                    Toast.LENGTH_SHORT).show();
        }
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

    /**
     * A placeholder fragment containing a simple view.
     */
    public static class PlaceholderFragment extends Fragment {
        private ArrayAdapter<String> mAdapter;


        public PlaceholderFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_curb65, container, false);

            String[] curb = {
                    "Confusion"
            };

            List<String> calculator = new ArrayList<String>(Arrays.asList(curb));

            mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_curb, R.id.textView14, calculator);


            ListView listView = (ListView) rootView.findViewById(R.id.listview8);

            listView.setAdapter(mAdapter);

            return rootView;
        }
    }
}
