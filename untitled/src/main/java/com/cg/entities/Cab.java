package com.cg.entities;

import javax.persistence.*;

@Entity
public class Cab {
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(name = "cab_id", nullable = false, unique = true)
    private Integer cabId;

    @Column(name = "car_type", nullable = false)
    private String carType;

    @Column(name = "per_km_rate", nullable = false)
    private float perKmRate;

    public Cab() {
    }

    public Cab(Integer cabId, String carType, float perKmRate) {
        super();
        this.cabId = cabId;
        this.carType = carType;
        this.perKmRate = perKmRate;
    }

    /*@Column(name = "booked", nullable = false)*/
    public Integer getCabId() {
        return cabId;
    }

    public void setCabId(Integer cabId) {
        this.cabId = cabId;
    }

    public String getCarType() {
        return carType;
    }

    public void setCarType(String carType) {
        this.carType = carType;
    }

    public float getPerKmRate() {
        return perKmRate;
    }

    public void setPerKmRate(float perKmRate) {
        this.perKmRate = perKmRate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Cab)) return false;

        Cab cab = (Cab) o;

        if (Float.compare(cab.perKmRate, perKmRate) != 0) return false;
        if (!getCabId().equals(cab.getCabId())) return false;
        if (!getCarType().equals(cab.getCarType())){
            return false;
        } else return cab.carType == null;
    }


    @Override
    public int hashCode() {
        int result = getCabId().hashCode();
        result = 31 * result + getCarType().hashCode();
        result = 31 * result + (perKmRate != +0.0f ? Float.floatToIntBits(perKmRate) : 0);
        return result;
    }
}
