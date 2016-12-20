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
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import com.example.szen95.szenmedcal1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class CreatinineClearance extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_creatinine_clearance2);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void calculateClickHandler(View view) {
        Spinner spinner = (Spinner) findViewById(R.id.spinner);

        String selectedItem = (String) spinner.getSelectedItem();


        if (selectedItem.trim().equals("Male") && view.getId() == R.id.calculateButton) {

            EditText ageText = (EditText) findViewById(R.id.ageText);
            EditText kgText = (EditText) findViewById(R.id.kgText);
            EditText creaText = (EditText) findViewById(R.id.creaText);
            TextView resText = (TextView) findViewById(R.id.resLabel);


            float kg = Float.parseFloat(kgText.getText().toString());
            float crea = Float.parseFloat(creaText.getText().toString());
            float age = Float.parseFloat(ageText.getText().toString());

            float creatinine = calculateCreatinine1(kg, crea, age);

            resText.setText(creatinine + " mL/min");

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        } else if (selectedItem.trim().equals("Female") && view.getId() == R.id.calculateButton) {

            EditText ageText = (EditText) findViewById(R.id.ageText);
            EditText kgText = (EditText) findViewById(R.id.kgText);
            EditText creaText = (EditText) findViewById(R.id.creaText);
            TextView resText = (TextView) findViewById(R.id.resLabel);


            float kg = Float.parseFloat(kgText.getText().toString());
            float crea = Float.parseFloat(creaText.getText().toString());
            float age = Float.parseFloat(ageText.getText().toString());

            float creatinine = calculateCreatinine1(kg, crea, age);

            resText.setText(creatinine + " mL/min");

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);

        } else {
            Toast.makeText(getApplicationContext(), "Please try again!",
                    Toast.LENGTH_SHORT).show();
        }

    }

    private float calculateCreatinine1(float kg, float crea, float age) {
        return (float) (((140 - age) * kg) / crea);

    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_creatinine_clearance, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_creatinine_clearance, container, false);

            String[] cc = {
                    "Select Gender"
            };

            List<String> calculator = new ArrayList<String>(Arrays.asList(cc));

            mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_crea, R.id.textView14, calculator);


            ListView listView = (ListView) rootView.findViewById(R.id.listview7);

            listView.setAdapter(mAdapter);

            return rootView;
        }
    }
}
