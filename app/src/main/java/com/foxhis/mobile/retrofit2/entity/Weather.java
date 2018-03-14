package com.foxhis.mobile.retrofit2.entity;

import org.greenrobot.greendao.annotation.Entity;
import org.greenrobot.greendao.annotation.Id;
import org.greenrobot.greendao.annotation.Generated;
import org.greenrobot.greendao.annotation.Property;

/**
 * Created by zyh on 2017/12/26.
 */

@Entity
public class Weather {
    @Id(autoincrement = true)
    private Long id;
    @Property
    private String cityName;
    @Property
    private String temperature;
    @Property
    private String windDirection;
    @Property
    private String windLevel;
    @Generated(hash = 2002875198)
    public Weather(Long id, String cityName, String temperature,
            String windDirection, String windLevel) {
        this.id = id;
        this.cityName = cityName;
        this.temperature = temperature;
        this.windDirection = windDirection;
        this.windLevel = windLevel;
    }
    @Generated(hash = 556711069)
    public Weather() {
    }
    public Long getId() {
        return this.id;
    }
    public void setId(Long id) {
        this.id = id;
    }
    public String getCityName() {
        return this.cityName;
    }
    public void setCityName(String cityName) {
        this.cityName = cityName;
    }
    public String getTemperature() {
        return this.temperature;
    }
    public void setTemperature(String temperature) {
        this.temperature = temperature;
    }
    public String getWindDirection() {
        return this.windDirection;
    }
    public void setWindDirection(String windDirection) {
        this.windDirection = windDirection;
    }
    public String getWindLevel() {
        return this.windLevel;
    }
    public void setWindLevel(String windLevel) {
        this.windLevel = windLevel;
    }

}
