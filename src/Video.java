public class Video {
    private int videoId;
    private String videoName;
    private int price;

    public Video(int videoId, String videoName, int price) {
        this.videoId = videoId;
        this.videoName = videoName;
        this.price = price;
    }

    @Override
    public String toString () {
        return "id: " + videoId + ", name: " + videoName + ", price: " + price;
    }
}
