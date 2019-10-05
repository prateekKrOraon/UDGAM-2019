package in.ac.nitsikkim.udgam19;

public class GuestItem {

    private int mImageResource;
    private int mName;

    public GuestItem(int mImageResource, int mName) {
        this.mImageResource = mImageResource;
        this.mName = mName;
    }

    public void setmImageResource(int mImageResource) {
        this.mImageResource = mImageResource;
    }

    public void setmName(int mName) {
        this.mName = mName;
    }

    public int getmImageResource() {
        return mImageResource;
    }

    public int getmName() {
        return mName;
    }
}
