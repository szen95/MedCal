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


public class AnionGap extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_anion_gap);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new AnionFragment())
                    .commit();
        }
    }

    public void calculateClickHandler(View view) {

        if(view.getId() == R.id.calculateButton) {

            EditText sodiumText = (EditText)findViewById(R.id.sodiumText);
            EditText chlorideText = (EditText)findViewById(R.id.chlorideText);
            EditText bicarbonateText = (EditText)findViewById(R.id.bicarbonateText);
            TextView anionText = (TextView)findViewById(R.id.anionLabel);

            // get the users values from the widget references
            float sodium = Float.parseFloat(sodiumText.getText().toString());
            float chloride = Float.parseFloat(chlorideText.getText().toString());
            float bicarbonate = Float.parseFloat(bicarbonateText.getText().toString());

            // calculate the anion gap
            float anionValue = calculateAnion(sodium, chloride, bicarbonate);

            // interpret the meaning of the bmi value
            String anionInterpretation = interpretAnion(anionValue);

            // now set the value in the result text
            anionText.setText(anionValue + " mEq/L" + " - " + anionInterpretation);

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private float calculateAnion (float sodium, float chloride, float bicarbonate) {
        return (float) (sodium - (chloride + bicarbonate));
    }

    // interpret what BMI means
    private String interpretAnion(float anionValue) {
        if (anionValue < 6) {
            return "Alterations in serum protein";
        } else if (anionValue > 12) {
            return "Metabolic acidosis";
        } else {
            return "Normal";
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_anion_gap, menu);
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
    public static class AnionFragment extends Fragment {

        private ArrayAdapter<String> mAdapter;

        public AnionFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_anion_gap, container, false);

            String[] ag = {
                    "Na+ (mEq/L)"
            };

            List<String> calculator = new ArrayList<String>(Arrays.asList(ag));

            mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_aniongap, R.id.textView5, calculator);


            ListView listView = (ListView) rootView.findViewById(R.id.listview6);

            listView.setAdapter(mAdapter);
            return rootView;
        }
    }
}
