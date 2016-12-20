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


public class ABPI extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abpi);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.container, new PlaceholderFragment())
                    .commit();
        }
    }

    public void calculateClickHandler(View view) {

        if(view.getId() == R.id.calculateButton) {

            EditText paText = (EditText)findViewById(R.id.paText);
            EditText pbText = (EditText)findViewById(R.id.pbText);
            TextView resultText = (TextView)findViewById(R.id.resLabel);

            // get the users values from the widget references
            float pa = Float.parseFloat(paText.getText().toString());
            float pb = Float.parseFloat(pbText.getText().toString());

            // calculate the bmi value
            float abpiValue = calculateABPI(pa, pb);

            // interpret the meaning of the bmi value
            String abpiInterpretation = interpretABPI(abpiValue);

            // now set the value in the result text
            resultText.setText(abpiValue +  " - " + abpiInterpretation);

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private float calculateABPI (float pa, float pb) {
        return (float) (pa / pb);
    }

    // interpret what BMI means
    private String interpretABPI(float abpiValue) {
        if (abpiValue > 1.3) {
            return "Non-compressible blood vessels";
        } else if (abpiValue > 1 && abpiValue < 1.2) {
            return "Normal";
        } else if (abpiValue < 0.5) {
            return "Severe arterial disease";
        } else  if (abpiValue < 0.9 || abpiValue > 0.5) {
            return "Vascular occlusion - refer to vascular surgeon";
        } else {
            return "Check BP again";
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_abpi, menu);
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
            View rootView = inflater.inflate(R.layout.fragment_abpi, container, false);

            String[] abpi = {
                    "Ankle Systolic BP"
            };

            List<String> calculator = new ArrayList<String>(Arrays.asList(abpi));

            mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_abpi, R.id.textView8, calculator);


            ListView listView = (ListView) rootView.findViewById(R.id.listview8);

            listView.setAdapter(mAdapter);

            return rootView;
        }
    }
}
