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
import android.widget.TextView;

import com.example.szen95.szenmedcal1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class AlcoholUnits extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alcohol_units);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new AlcoholFragment())
                    .commit();
        }

    }

    public void calculateClickHandler(View view) {

        if(view.getId() == R.id.calculateButton) {

            EditText volumeText = (EditText)findViewById(R.id.volumeText);
            EditText abvText = (EditText)findViewById(R.id.abvText);
            TextView unitText = (TextView)findViewById(R.id.unitLabel);

            // get the users values from the widget references
            float volume = Float.parseFloat(volumeText.getText().toString());
            float abv = Float.parseFloat(abvText.getText().toString());

            // calculate the bmi value
            float unitValue = calculateUnit(volume, abv);

            String unitInterpretation = interpretUnit(unitValue);

            // now set the value in the result text
            unitText.setText(unitValue + " units" + " - " + unitInterpretation);

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    // interpret what BMI means
    private String interpretUnit(float unitValue) {
        if (unitValue > 4) {
            return "Excessive";
        } else {
            return "Normal";
        }
    }

    private float calculateUnit (float volume, float abv) {

        return (float) (volume * abv / 1000);
    }

    
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_alcohol_units, menu);
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
    public static class AlcoholFragment extends Fragment {

        private ArrayAdapter<String> mAdapter;

        public AlcoholFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_alcohol_units, container, false);


            String[] au = {
                    "Volume of Drink (ml)"
            };

            List<String> calculator = new ArrayList<String>(Arrays.asList(au));

            mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_alchoholunits, R.id.textView3, calculator);


            ListView listView = (ListView) rootView.findViewById(R.id.listview5);

            listView.setAdapter(mAdapter);
            return rootView;
        }
    }
}
