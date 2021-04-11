package com.example.musicrecapp.ui.userprofile;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.lifecycle.Observer;
import com.example.musicrecapp.HomeActivity;
import com.example.musicrecapp.LoginActivity;
import com.example.musicrecapp.R;
import com.example.musicrecapp.UserProfileActivity;
import com.google.firebase.auth.FirebaseAuth;
import com.google.firebase.auth.FirebaseUser;


public class UserProfileFragment extends Fragment {

    Button logout ;
    TextView userEmailShow ;
    FirebaseAuth firebaseAuth ;
    FirebaseUser firebaseUser;

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.fragment_userprofile, container, false);
        logout = (Button) root.findViewById(R.id.logout);
        userEmailShow = (TextView) root.findViewById(R.id.user_email);
        firebaseAuth = FirebaseAuth.getInstance();
        if(firebaseAuth.getCurrentUser() == null){
            getActivity().finish();
            Intent intent = new Intent(getContext(), LoginActivity.class);
            startActivity(intent);
            Toast.makeText(getContext(), "Please Log in to continue", Toast.LENGTH_LONG).show();

        }
        firebaseUser = firebaseAuth.getCurrentUser();
        userEmailShow.setText("Successfully Logged In, Your Email = " + firebaseUser.getEmail());
        logout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                firebaseAuth.signOut();
                getActivity().finish();
                Intent intent = new Intent(getContext(), LoginActivity.class);
                startActivity(intent);
                Toast.makeText(getContext(), "Logged Out Successfully.", Toast.LENGTH_LONG).show();
            }
        });
        return root;
    }
}