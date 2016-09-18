package drd.flhspatriotbattalion;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.design.widget.FloatingActionButton;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v7.widget.Toolbar;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageButton;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class CentralFragment extends Fragment {
    // TODO: Rename parameter arguments, choose names that match
    // the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
    private static final String ARG_PARAM1 = "param1";
    private static final String ARG_PARAM2 = "param2";


    public CentralFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_central, container, false);
        // Inflate the layout for this fragment
       final TextView WOTD, Main;
        final FloatingActionButton FAB;

        Main = (TextView) view.findViewById(R.id.mainContent);

        WOTD = (TextView) view.findViewById(R.id.wotd);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference mainRef =  database.getReference("Main");
        DatabaseReference wotdRef = database.getReference("WOTD");

        mainRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String mainContent = dataSnapshot.getValue(String.class);
                Main.setText(mainContent);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        wotdRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String wordoftheday =dataSnapshot.getValue(String.class);
                WOTD.setText(wordoftheday);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {

            }
        });
        FAB = (FloatingActionButton) view.findViewById(R.id.fab);
        FAB.setBackgroundColor(getResources().getColor(R.color.colorAccent));
        FAB.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Create_Fragment create_fragment =new Create_Fragment();
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.Relative_Layout_For_Fragments,
                        create_fragment,
                        create_fragment.getTag()).commit();
            }
        });

return view;



    }


    }
