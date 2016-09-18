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
public class AlphaFragment extends Fragment {


    public AlphaFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
      View view = inflater.inflate(R.layout.fragment_alpha, container, false);
        Button a1, a2;
        a1 = (Button) view.findViewById(R.id.A1button);
        a2 = (Button) view.findViewById(R.id.A2button);
        a1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Alpha1 alpha1 = new Alpha1();
                FragmentManager fragmentManager =  getFragmentManager();//use getfragmentmanger() for changing fragments withen fragments. Matrix? I know right!
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        alpha1,
                        alpha1.getTag()).commit();
            }
        });
        a2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            Alpha2 alpha2 = new Alpha2();
                FragmentManager fragmentManager =  getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        alpha2,
                        alpha2.getTag()).commit();
            }
        });




















        return view;

    }

}
