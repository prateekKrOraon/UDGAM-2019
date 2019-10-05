package in.ac.nitsikkim.udgam19;

import android.support.design.widget.Snackbar;
import android.widget.ImageButton;
import android.widget.TextView;

public class DeveloperDetail {

    private String name;
    private String designation;
    private String other;
    private String description;
    private String call;
    private String mail;
    private String linkedIn;
    private String gitHub;
    private String fb;

    public DeveloperDetail(String name, String designation, String other, String description, String call, String mail, String linkedIn, String gitHub, String fb) {
        this.name = name;
        this.designation = designation;
        this.other = other;
        this.description = description;
        this.call = call;
        this.mail = mail;
        this.linkedIn = linkedIn;
        this.gitHub = gitHub;
        this.fb = fb;
    }
}
