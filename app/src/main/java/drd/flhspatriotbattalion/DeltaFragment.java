package drd.flhspatriotbattalion;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

/**
 * A simple {@link Fragment} subclass.
 */
public class DeltaFragment extends Fragment {


    public DeltaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view =  inflater.inflate(R.layout.fragment_platoonpicker, container, false);
        Button a1, a2;
        a1 = (Button) view.findViewById(R.id.B1button);
        a2 = (Button) view.findViewById(R.id.B2button);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
              Delta1 delta1 = new Delta1();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        delta1,
                        delta1.getTag()).commit();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Delta2 delta2 = new Delta2();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        delta2,
                        delta2.getTag()).commit();
            }
        });







        return view;
    }

}
