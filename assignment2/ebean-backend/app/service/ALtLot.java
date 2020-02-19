package service;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import java.util.List;

public class ALtLot {
    private static String addressJson = "[{\"address\":\"Los Angeles, CA, USA\",\"longitude\":-118.2436849,\"latitude\":34.0522342},{\"address\":\"Las Vegas, Nevada, USA\",\"longitude\":-115.1398296,\"latitude\":36.1699412},{\"address\":\"Honolulu, HI, USA\",\"longitude\":-157.8583333,\"latitude\":21.3069444},{\"address\":\"Washington, DC, USA\",\"longitude\":-77.0368707,\"latitude\":38.9071923},{\"address\":\" Beijing, China\",\"longitude\":116.4073963,\"latitude\":39.90419989999999},{\"address\":\"Orlando, FL, USA\",\"longitude\":-81.3792365,\"latitude\":28.5383355},{\"address\":\"Växjö, Sweden\",\"longitude\":14.8058523,\"latitude\":56.8790044},{\"address\":\"San Francisco, CA, USA\",\"longitude\":-122.4194155,\"latitude\":37.7749295},{\"address\":\"San Francisco, CA, USA\",\"longitude\":-122.4194155,\"latitude\":37.7749295},{\"address\":\"Chicago, Illinois, USA\",\"longitude\":-87.6297982,\"latitude\":41.8781136},{\"address\":\"Salt Lake City, Utah, USA\",\"longitude\":-111.8910474,\"latitude\":40.7607793},{\"address\":\"Santa Clara, CA, USA\",\"longitude\":-121.9552356,\"latitude\":37.3541079},{\"address\":\"Erfurt, Germany\",\"longitude\":11.02988,\"latitude\":50.98476789999999},{\"address\":\"Honolulu, HI, USA\",\"longitude\":-157.8583333,\"latitude\":21.3069444},{\"address\":\"Anchorage, AK, USA\",\"longitude\":-149.9002778,\"latitude\":61.2180556},{\"address\":\"New York, NY, USA\",\"longitude\":-74.0059728,\"latitude\":40.7127753},{\"address\":\"Miami, Florida, USA\",\"longitude\":-80.1917902,\"latitude\":25.7616798},{\"address\":\"Orlando, Florida, USA\",\"longitude\":-81.3792365,\"latitude\":28.5383355},{\"address\":\"San Diego, California, USA\",\"longitude\":-117.1610838,\"latitude\":32.715738},{\"address\":\"Tokyo, Japan\",\"longitude\":139.6503106,\"latitude\":35.6761919},{\"address\":\"Kühlungsborn, Germany\",\"longitude\":11.7420026,\"latitude\":54.14685129999999},{\"address\":\"Coventry, UK\",\"longitude\":-1.519693,\"latitude\":52.406822},{\"address\":\"Salt Lake City, Utah, USA\",\"longitude\":-111.8910474,\"latitude\":40.7607793},{\"address\":\"Bangalore, India\",\"longitude\":77.5945627,\"latitude\":12.9715987},{\"address\":\"Honolulu, HI, USA\",\"longitude\":-157.8583333,\"latitude\":21.3069444},{\"address\":\"Washington, DC, USA\",\"longitude\":-77.0368707,\"latitude\":38.9071923},{\"address\":\"Honolulu, Hawaii, USA\",\"longitude\":-157.8583333,\"latitude\":21.3069444},{\"address\":\"Orlando, FL, USA\",\"longitude\":-81.3792365,\"latitude\":28.5383355},{\"address\":\"San Francisco, CA, USA\",\"longitude\":-122.4194155,\"latitude\":37.7749295},{\"address\":\"San Francisco, CA, USA\",\"longitude\":-122.4194155,\"latitude\":37.7749295},{\"address\":\"Chicago, Illinois, USA\",\"longitude\":-87.6297982,\"latitude\":41.8781136},{\"address\":\"Salt Lake City, Utah, USA\",\"longitude\":-111.8910474,\"latitude\":40.7607793},{\"address\":\"Santa Clara, CA, USA\",\"longitude\":-121.9552356,\"latitude\":37.3541079},{\"address\":\"Honolulu, HI, USA\",\"longitude\":-157.8583333,\"latitude\":21.3069444},{\"address\":\"Anchorage, AK, USA\",\"longitude\":-149.9002778,\"latitude\":61.2180556},{\"address\":\"New York City, NY, USA\",\"longitude\":-74.0059728,\"latitude\":40.7127753},{\"address\":\"Miami, Florida, USA\",\"longitude\":-80.1917902,\"latitude\":25.7616798},{\"address\":\"Shanghai, China\",\"longitude\":121.473701,\"latitude\":31.230416}]";
    private String address;
    private Double longitude;
    private Double latitude;

    public String getAddress() {
        return address;
    }

    public void setAddress(String address) {
        this.address = address;
    }

    public Double getLongitude() {
        return longitude;
    }

    public void setLongitude(Double longitude) {
        this.longitude = longitude;
    }

    public Double getLatitude() {
        return latitude;
    }

    public void setLatitude(Double latitude) {
        this.latitude = latitude;
    }

    List<ALtLot> getList(){
        return new Gson().fromJson(addressJson, new TypeToken<List<ALtLot>>() {}.getType());
    }
}
