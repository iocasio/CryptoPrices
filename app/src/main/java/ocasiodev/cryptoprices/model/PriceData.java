package ocasiodev.cryptoprices.model;

import com.google.gson.annotations.SerializedName;

public class PriceData {

    @SerializedName("mid")
    private double midPrice;
    @SerializedName("bid")
    private double bidPrice;
    @SerializedName("ask")
    private double askPrice;
    @SerializedName("last_price")
    private double lastPrice;
    @SerializedName("high")
    private double highPrice;
    @SerializedName("low")
    private double lowPrice;
    @SerializedName("volume")
    private double volume;
    @SerializedName("timestamp")
    private double timeStamp;

    public double getMidPrice() {
        return midPrice;
    }

    public void setMidPrice(double midPrice) {
        this.midPrice = midPrice;
    }

    public double getBidPrice() {
        return bidPrice;
    }

    public void setBidPrice(double bidPrice) {
        this.bidPrice = bidPrice;
    }

    public double getAskPrice() {
        return askPrice;
    }

    public void setAskPrice(double askPrice) {
        this.askPrice = askPrice;
    }

    public double getLastPrice() {
        return lastPrice;
    }

    public void setLastPrice(double lastPrice) {
        this.lastPrice = lastPrice;
    }

    public double getHighPrice() {
        return highPrice;
    }

    public void setHighPrice(double highPrice) {
        this.highPrice = highPrice;
    }

    public double getLowPrice() {
        return lowPrice;
    }

    public void setLowPrice(double lowPrice) {
        this.lowPrice = lowPrice;
    }

    public double getVolume() {
        return volume;
    }

    public void setVolume(double volume) {
        this.volume = volume;
    }

    public double getTimeStamp() {
        return timeStamp;
    }

    public void setTimeStamp(double timeStamp) {
        this.timeStamp = timeStamp;
    }
}
