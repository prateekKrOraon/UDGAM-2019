package in.ac.nitsikkim.udgam19;


import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomSheetDialogFragment;
import android.support.design.widget.Snackbar;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.google.android.gms.auth.api.Auth;
import com.google.android.gms.auth.api.signin.GoogleSignInOptions;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.ResultCallback;
import com.google.android.gms.common.api.Status;

public class ProfileFragment extends BottomSheetDialogFragment {

    View view;
    EditText feedbackEditText;
    GoogleApiClient googleApiClient;
    String name,email,photo;
    TextView user,usere;
    ImageView image;
    public ProfileFragment() {
        // Required empty public constructor
    }
    @SuppressLint("ValidFragment")
    public ProfileFragment(String n, String e, String p) {
        name = n;
        email = e;
        photo = p;

        // Required empty public constructor
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        GoogleSignInOptions signInOptions = new GoogleSignInOptions.Builder(GoogleSignInOptions.DEFAULT_SIGN_IN).requestEmail().build();
        googleApiClient = new GoogleApiClient.Builder(getContext()).addApi(Auth.GOOGLE_SIGN_IN_API,signInOptions).build();
        googleApiClient.connect();
        view = inflater.inflate(R.layout.fragment_profile, container, false);
        RelativeLayout loginButtonProfile = view.findViewById(R.id.profile_name_button);
        user = view.findViewById(R.id.profile_name);
        user.setText(name);
        usere = view.findViewById(R.id.profile_email);
        usere.setText(email);
        image = (ImageView)view.findViewById(R.id.profile_image);
        if(photo.equals("no_image")){
            image.setImageResource(R.drawable.person_24);
        }else {
            Glide.with(this).load(photo).into(image);
        }
        ImageView profileImage = view.findViewById(R.id.profile_image);
        LinearLayout sendFeedback = view.findViewById(R.id.send_feedback);
        LinearLayout logOut = view.findViewById(R.id.log_out);
        feedbackEditText = view.findViewById(R.id.feedback_edit_text);

        loginButtonProfile.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"Login",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        profileImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"Profile Image",Toast.LENGTH_SHORT).show();
                dismiss();
            }
        });

        sendFeedback.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(view.getContext(),"Send Feedback",Toast.LENGTH_SHORT).show();
                showDialog();
                dismiss();
            }
        });

        logOut.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                dismiss();

                  Auth.GoogleSignInApi.signOut(googleApiClient).setResultCallback(new ResultCallback<Status>() {
                      @Override
                      public void onResult(@NonNull Status status) {

                          MainActivity.ma.finish();
                      }
                  });
                Intent intent = new Intent(getActivity(), in.ac.nitsikkim.udgam19.Login.class);
                startActivity(intent);

                Toast.makeText(view.getContext(),"You have logged out",Toast.LENGTH_LONG).show();
            }
        });

        return view;


    }



    private void showDialog() {

        final Dialog dialog = new Dialog(view.getContext());
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.feedback_dialog);
        dialog.setCancelable(true);
        WindowManager.LayoutParams wm = new WindowManager.LayoutParams();
        user = dialog.findViewById(R.id.user_name);
        user.setText(name);
        usere = dialog.findViewById(R.id.user_email);
        usere.setText(email);

        try {
            wm.copyFrom(dialog.getWindow().getAttributes());
            wm.width = WindowManager.LayoutParams.MATCH_PARENT;
            wm.height = WindowManager.LayoutParams.MATCH_PARENT;

        }catch(NullPointerException e){
            System.out.println(e.toString());
            Toast.makeText(view.getContext(),"Null Pointer Exception",Toast.LENGTH_LONG).show();
        }

        final ImageButton send = dialog.findViewById(R.id.feedback_send);

        ((EditText) dialog.findViewById(R.id.feedback_edit_text)).addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {
                send.setEnabled(!s.toString().trim().isEmpty());
            }

            @Override
            public void afterTextChanged(Editable s) {

            }
        });
        send.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();
                Snackbar.make(v.getRootView(),R.string.feedback_sent,Snackbar.LENGTH_SHORT).show();
            }
        });

        dialog.show();
        dialog.getWindow().setAttributes(wm);




    }



}
