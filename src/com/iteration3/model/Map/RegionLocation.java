package com.iteration3.model.Map;

public class RegionLocation extends Location{

    private int region;

    public RegionLocation(int x, int y, int z, int region){
        super(x, y ,z);
        this.region=region;
    }

    public int getRegion(){return this.region;}
    public void setRegion(int region){this.region=region;}

    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RegionLocation loc = (RegionLocation) o;
        return x == loc.getX() && y == loc.getY() && z == loc.getZ() && region == loc.getRegion();
    }

    public int hashCode(){
        int result = x ^ (x >>> 32);
        result = 31 * result + y ^ (y >>> 32);
        result = 31 * result + z ^ (z >>> 32);
        result = 31 * result + region ^ (region >>> 32);
        return result;
    }
}
