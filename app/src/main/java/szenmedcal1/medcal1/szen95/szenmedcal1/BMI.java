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


public class BMI extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bmi);
        if (savedInstanceState == null) {
            getSupportFragmentManager().beginTransaction()
                    .add(R.id.bmi_container, new BMIFragment())
                    .commit();
        }

    }

    public void calculateClickHandler(View view) {

        if(view.getId() == R.id.calculateButton) {

            EditText weightText = (EditText)findViewById(R.id.weightText);
            EditText heightText = (EditText)findViewById(R.id.heightText);
            TextView resultText = (TextView)findViewById(R.id.resultLabel);

            // get the users values from the widget references
            float weight = Float.parseFloat(weightText.getText().toString());
            float height = Float.parseFloat(heightText.getText().toString());

            // calculate the bmi value
            float bmiValue = calculateBMI(weight, height);

            // interpret the meaning of the bmi value
            String bmiInterpretation = interpretBMI(bmiValue);

            // now set the value in the result text
            resultText.setText(bmiValue + " kg/m2" + " - " + bmiInterpretation);

            InputMethodManager inputMethodManager = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
            inputMethodManager.hideSoftInputFromWindow(getCurrentFocus().getWindowToken(), InputMethodManager.HIDE_NOT_ALWAYS);
        }
    }

    private float calculateBMI (float weight, float height) {
        return (float) (weight / (height * height));
    }

    // interpret what BMI means
    private String interpretBMI(float bmiValue) {
        if (bmiValue < 16) {
            return "Severely underweight";
        } else if (bmiValue < 18.5) {
            return "Underweight";
        } else if (bmiValue < 25) {
            return "Normal";
        } else if (bmiValue < 30) {
            return "Overweight";
        } else {
            return "Obese";
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_bmi, menu);
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
    public static class BMIFragment extends Fragment {

        private ArrayAdapter<String> mAdapter;

        public BMIFragment() {
        }

        @Override
        public View onCreateView(LayoutInflater inflater, ViewGroup container,
                                 Bundle savedInstanceState) {
            View rootView = inflater.inflate(R.layout.fragment_bmi, container, false);




                String[] bmi = {
                        "Your Weight (kg)"
                };

                List<String> calculator = new ArrayList<String>(Arrays.asList(bmi));

                mAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item_bmi, R.id.textView1, calculator);


                ListView listView = (ListView) rootView.findViewById(R.id.listview1);

                listView.setAdapter(mAdapter);

                return rootView;
        }
    }
}
