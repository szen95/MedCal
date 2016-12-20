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


public class BMRMale extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmrmale);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new BMRMaleFragment())
                    .commit();
        }
    }

    public void calculateClickHandler(View view) {

        if(view.getId() == R.id.calculateButton) {

            EditText kgText = (EditText)findViewById(R.id.kgText);
            EditText cmText = (EditText)findViewById(R.id.cmText);
            EditText ageText = (EditText)findViewById(R.id.ageText);
            TextView bmrText = (TextView)findViewById(R.id.bmrLabel);

            // get the users values from the widget references
            float kg = Float.parseFloat(kgText.getText().toString());
            float cm = Float.parseFloat(cmText.getText().toString());
            float age = Float.parseFloat(ageText.getText().toString());

            // calculate the bmr value
            float bmrValue = calculateBMR(kg, cm, age);


            // now set the value in the result text
            bmrText.setText(bmrValue + " kcal/day" + " - " + "energy required to maintain non-exercise bodily functions");

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private float calculateBMR (float kg, float cm, float age) {
        return (float) (66.5 + (13.8 * kg) + (5 * cm) - (6.8 * age));
    }



    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_bmrmale, menu);
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
    public static class BMRMaleFragment extends Fragment {

        private ArrayAdapter<String> mAdapter;

        public BMRMaleFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_bmrmale, container, false);



            String[] bmrm = {
                    "Your Weight (kg)"
            };

            List<String> calculator = new ArrayList<String>(Arrays.asList(bmrm));

            mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_bmrm, R.id.textView8, calculator);


            ListView listView = (ListView) rootView.findViewById(R.id.listview3);

            listView.setAdapter(mAdapter);

            return rootView;
        }
    }
}
