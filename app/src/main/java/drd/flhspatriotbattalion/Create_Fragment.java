package drd.flhspatriotbattalion;

import android.content.Context;
import android.content.Intent;
import android.inputmethodservice.Keyboard;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.KeyEvent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.inputmethod.InputMethodManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.google.firebase.database.DataSnapshot;
import com.google.firebase.database.DatabaseError;
import com.google.firebase.database.DatabaseReference;
import com.google.firebase.database.FirebaseDatabase;
import com.google.firebase.database.ValueEventListener;

import drd.flhspatriotbattalion.R;

public class Create_Fragment extends Fragment {
public EditText content, password;
public Button send;
public  Boolean isCorrect = false;
public InputMethodManager mgr;
    public Create_Fragment() {
        // Required empty public construct
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment


        final FirebaseDatabase database = FirebaseDatabase.getInstance();
        final DatabaseReference passwordRef = database.getReference().child("CFA");
        View view =  inflater.inflate(R.layout.fragment_create_, container, false);
        content = (EditText) view.findViewById(R.id.ContentInput);
        password = (EditText) view.findViewById(R.id.password);
        content.setSingleLine();
        content.setOnKeyListener(new View.OnKeyListener() {
            public boolean onKey(View v, int keyCode, KeyEvent event) {

                if ((event.getAction() == KeyEvent.ACTION_DOWN) &&
                    (keyCode == KeyEvent.KEYCODE_ENTER)){
                // Perform action on key press
                    System.out.println("Enter is pressed");
                    password.requestFocus();



                    return true;
                }
            return false;
        }


        });

        send = (Button) view.findViewById(R.id.send);

        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String context = content.getText().toString();
                isCorrect = false;
                if (context.equals("")) {
                    Toast.makeText(getActivity(), "Please enter a Message", Toast.LENGTH_SHORT).show();
                } else {
                        final String passwordEntered = password.getText().toString();
                        passwordRef.addValueEventListener(new ValueEventListener() {
                            @Override
                            public void onDataChange(DataSnapshot dataSnapshot) {
                                for (DataSnapshot postSnapshot : dataSnapshot.getChildren()) {
                                    String data = postSnapshot.getKey();

                                    System.out.println(passwordEntered);
                                    if (data.equals(passwordEntered)) {
                                        System.out.println("Access Granted");
                                        DatabaseReference create = passwordRef.child(data);
                                        create.addValueEventListener(new ValueEventListener() {
                                            @Override
                                            public void onDataChange(DataSnapshot dataSnapshot) {
                                                String string = dataSnapshot.getValue().toString();
                                                if (string.equals("a1")) {
                                                    database.getReference().child("Alpha").child("one").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("a2")) {
                                                    database.getReference().child("Alpha").child("two").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("b1")) {
                                                    database.getReference().child("Bravo").child("one").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("b2")) {
                                                    database.getReference().child("Bravo").child("two").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("c1")) {
                                                    database.getReference().child("Charlie").child("one").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("c2")) {
                                                    database.getReference().child("Charlie").child("two").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("d1")) {
                                                    database.getReference().child("Delta").child("one").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("d2")) {
                                                    database.getReference().child("Delta").child("two").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("e1")) {
                                                    database.getReference().child("Echo").child("one").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                } else if (string.equals("e2")) {
                                                    database.getReference().child("Echo").child("two").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                }else if (string.equals("f1")) {
                                                    database.getReference().child("Foxtrot").child("one").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);

                                                }else if (string.equals("f2")) {
                                                    database.getReference().child("Foxtrot").child("two").setValue(context);
                                                    Toast.makeText(getActivity(), "Sent", Toast.LENGTH_SHORT).show();
                                                    Intent i = new Intent(getActivity(), MainActivity.class);
                                                    startActivity(i);
                                            }


                                            }

                                            @Override
                                            public void onCancelled(DatabaseError databaseError) {

                                            }
                                        });
                                    }
                                }
                            }

                            @Override
                            public void onCancelled(DatabaseError databaseError) {
                            }
                        });

                }
                 
                }



        });

















        return view;

    }



}
