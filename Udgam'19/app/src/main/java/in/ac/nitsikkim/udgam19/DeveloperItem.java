package in.ac.nitsikkim.udgam19;

public class DeveloperItem {

    private int profileImage;
    private int name;
    private int designation;

    public DeveloperItem(int name,int profileImage, int designation){
        this.profileImage = profileImage;
        this.name = name;
        this.designation = designation;

    }

    public void setName(int name){
        this.name = name;
    }

    public void setProfileImage(int profileImage) {
        this.profileImage = profileImage;
    }

    public void setDesignation(int designation) {
        this.designation = designation;
    }

    public int getProfileImage(){
        return profileImage;
    }

    public int getName() {
        return name;
    }

    public int getDesignation() {
        return designation;
    }
}
