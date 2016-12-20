package szenmedcal1.medcal1.szen95.szenmedcal1;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.szen95.szenmedcal1.R;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by szen95 on 7/7/15.
 */

/**
 * A placeholder fragment containing a simple view.
 */
public class MainFragment extends Fragment {


    ArrayAdapter<String> mRandomAdapter;

    public MainFragment() {
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        String[] stuff = {
                "ABPI",
                "Alcohol Units",
                "Anion Gap",
                "BMI",
                "BMR (Female)",
                "BMR (Male)",
                "CHA2DSVASc",
                "Creatinine Clearance",
                "CURB65",
                "SIRS Criteria",
                "Wells' Criteria"
        };

        List<String> calculator = new ArrayList<String>(Arrays.asList(stuff));

        mRandomAdapter = new ArrayAdapter<String>(getActivity(), R.layout.list_item, R.id.list_item_calculator, calculator);

        View rootView = inflater.inflate(R.layout.fragment_main, container, false);

        ListView listView = (ListView) rootView.findViewById(R.id.listview);
        listView.setAdapter(mRandomAdapter);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {

            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long l) {

                if (position == 0) {
                    Intent intent = new Intent(getActivity(), ABPI.class);
                    startActivity(intent);
                }

                if (position == 1) {
                    Intent intent1 = new Intent(getActivity(), AlcoholUnits.class);
                    startActivity(intent1);
                }

                if (position == 2) {
                    Intent intent2 = new Intent(getActivity(), AnionGap.class);
                    startActivity(intent2);
                }

                if (position == 3) {
                    Intent intent3 = new Intent(getActivity(), BMI.class);
                    startActivity(intent3);
                }

                if (position == 4) {
                    Intent intent4 = new Intent(getActivity(), BMRFemale.class);
                    startActivity(intent4);
                }

                if (position == 5) {
                    Intent intent5 = new Intent(getActivity(), BMRMale.class);
                    startActivity(intent5);
                }

                if (position == 6) {
                    Intent intent6 = new Intent(getActivity(), CHA2DS2VASc.class);
                    startActivity(intent6);
                }

                if (position == 7) {
                    Intent intent7 = new Intent(getActivity(), CreatinineClearance.class);
                    startActivity(intent7);
                }

                if (position == 8) {
                    Intent intent8 = new Intent(getActivity(), CURB65.class);
                    startActivity(intent8);
                }

                if (position == 9) {
                    Intent intent9 = new Intent(getActivity(), SepsisCriteria.class);
                    startActivity(intent9);
                }

                if (position == 10) {
                    Intent intent10 = new Intent(getActivity(), WellsScore.class);
                    startActivity(intent10);
                }

                }


        });

        return rootView;
    }
}
