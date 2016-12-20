package szenmedcal1.medcal1.szen95.szenmedcal1;

import android.os.Bundle;
import android.support.v7.app.ActionBar;
import android.support.v7.app.ActionBarActivity;
import android.view.Menu;
import android.view.MenuItem;

import com.example.szen95.szenmedcal1.R;


public class MainActivity extends ActionBarActivity {

    private static final String BMI_TAG = "BMITAG";
    private static final String ALCOHOL_TAG = "ALCOHOLTAG";
    private static final String ANION_TAG = "ANIONTAG";

    private boolean mTwoPane;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        if (findViewById(R.id.bmi_container) != null) {
            mTwoPane = true;

            if (savedInstanceState == null) {

                getSupportFragmentManager().beginTransaction()
                        .replace(R.id.bmi_container, new BMI.BMIFragment(), BMI_TAG)
                        .commit();
            }
        } else {

            if (findViewById(R.id.alcohol_container) != null) {
                mTwoPane = true;

                if (savedInstanceState == null) {

                    getSupportFragmentManager().beginTransaction()
                            .replace(R.id.alcohol_container, new AlcoholUnits.AlcoholFragment(), ALCOHOL_TAG)
                            .commit();
                }
            } else {

                if (findViewById(R.id.anion_container) != null) {
                    mTwoPane = true;

                    if (savedInstanceState == null) {

                        getSupportFragmentManager().beginTransaction()
                                .replace(R.id.anion_container, new AnionGap.AnionFragment(), ANION_TAG)
                                .commit();
                    }

                } else {
                    mTwoPane = false;
                }
            }
        }
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
//        getMenuInflater().inflate(R.menu.menu_main, menu);

        ActionBar actionBar = getSupportActionBar();
        actionBar.setDisplayShowHomeEnabled(true);
        actionBar.setIcon(R.mipmap.ic_launcher);

        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_bar) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

}
