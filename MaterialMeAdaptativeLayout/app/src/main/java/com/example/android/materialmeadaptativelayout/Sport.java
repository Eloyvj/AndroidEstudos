package com.example.android.materialmeadaptativelayout;

import android.os.Parcel;
import android.os.Parcelable;

/**
 * Data model for each row of the RecyclerView
 */
class Sport implements Parcelable {

    // Member variables representing the title and information about the sport.
    private String title;
    private String info;
    private final int imageResource;
    private String subtitleNews;

    /**
     * Constructor for the Sport data model.
     *
     * @param title The name if the sport.
     * @param info Information about the sport.
     * @param imageResource Sport image.
     * @param subtitleNews News about the sport.
     */
    Sport(String title, String info, int imageResource, String subtitleNews) {
        this.title = title;
        this.info = info;
        this.imageResource = imageResource;
        this.subtitleNews = subtitleNews;
    }

    /**
     * Gets the title of the sport.
     *
     * @return The title of the sport.
     */
    String getTitle() {
        return title;
    }

    /**

     * Gets the info about the sport.
     *
     * @return The info about the sport.
     */
    String getInfo() {
        return info;
    }

    /**
     * Gets the path image about the sport.
     *
     * @return The path image about the sport.
     */
    public int getImageResource() {
        return imageResource;
    }

    /**
     *  Gets the info about the sport.
     *
     * @return The news about the sport.
     */
    public String getSubtitleNews() {
        return subtitleNews;
    }

    protected Sport(Parcel in) {
        title = in.readString();
        info = in.readString();
        imageResource = in.readInt();
        subtitleNews = in.readString();
    }

    @Override
    public int describeContents() {
        return 0;
    }

    @Override
    public void writeToParcel(Parcel dest, int flags) {
        dest.writeString(title);
        dest.writeString(info);
        dest.writeInt(imageResource);
        dest.writeString(subtitleNews);
    }

    @SuppressWarnings("unused")
    public static final Parcelable.Creator<Sport> CREATOR = new Parcelable.Creator<Sport>() {
        @Override
        public Sport createFromParcel(Parcel in) {
            return new Sport(in);
        }

        @Override
        public Sport[] newArray(int size) {
            return new Sport[size];
        }
    };
}