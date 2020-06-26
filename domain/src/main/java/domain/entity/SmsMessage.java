package domain.entity;

import com.google.gson.annotations.SerializedName;

public class SmsMessage {

    @SerializedName("from")
    private String from;

    @SerializedName("body")
    private String body;

    public String getFrom() {
        return from;
    }

    public void setFrom(String from) {
        this.from = from;
    }

    public String getBody() {
        return body;
    }

    public void setBody(String body) {
        this.body = body;
    }
}
