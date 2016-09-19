package drd.flhspatriotbattalion;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;


public class Charlie2 extends Fragment {

    public Charlie2() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment

        View view = inflater.inflate(R.layout.fragment_platoon, container, false);
        final TextView content, title;
        final String platoonName = "Charlie Two Platoon";
        content = (TextView) view.findViewById(R.id.Alpha1content);
        title =(TextView) view.findViewById(R.id.Title);
        title.setText(platoonName);
        FirebaseDatabase database = FirebaseDatabase.getInstance();
        DatabaseReference myRef = database.getReference().child("Charlie").child("two");
        myRef.addValueEventListener(new ValueEventListener() {
            @Override
            public void onDataChange(DataSnapshot dataSnapshot) {
                String text = dataSnapshot.getValue().toString();
                content.setText(text);
            }

            @Override
            public void onCancelled(DatabaseError databaseError) {
            content.setText(R.string.defaultText);
            }
        });






        return view;
    }
}