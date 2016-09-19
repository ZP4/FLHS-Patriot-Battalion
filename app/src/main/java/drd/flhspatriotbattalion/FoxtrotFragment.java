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
public class FoxtrotFragment extends Fragment {


    public FoxtrotFragment() {
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

              Foxtrot1 foxtrot1 = new Foxtrot1();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        foxtrot1,
                     foxtrot1.getTag()).commit();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Foxtrot2 foxtrot2 = new Foxtrot2();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        foxtrot2,
                        foxtrot2.getTag()).commit();
            }
        });







        return view;
    }

}
