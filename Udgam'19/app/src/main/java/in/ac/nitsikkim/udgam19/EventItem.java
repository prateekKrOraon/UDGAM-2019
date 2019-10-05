package in.ac.nitsikkim.udgam19;

public class EventItem {
    private int mImageResource;
    private int mText1;
    private String mText2;

    public EventItem(int ImageResource, int text1,String text2){
        this.mImageResource = ImageResource;
        this.mText1 = text1;
        this.mText2 = text2;

    }

    public void setText(int texxt){
        mText1 = texxt;
    }

    public int getmImageResource(){
        return mImageResource;
    }

    public int getmText1() {
        return mText1;
    }

    public String getmText2() {
        return mText2;
    }
}
