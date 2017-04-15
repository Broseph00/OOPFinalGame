package com.iteration3.model.Map;

public class RegionLocation{
    private int x;
    private int y;
    private int z;
    private int region;

    public RegionLocation(int x, int y, int z, int region){
        this.x=x;
        this.y=y;
        this.z=z;
        this.region=region;
    }
    public int getX() {
        return this.x;
    }
    public int getY() {
        return this.y;
    }
    public int getZ() {
        return this.z;
    }
    public void setX(int x) { this.x = x; }
    public void setY(int y) { this.y = y; }
    public void setZ(int z) { this.z = z; }
    public int getRegion(){return this.region;}
    public void setRegion(int region){this.region=region;}
    public Location getLocation(){
        return new Location(this.x, this.y, this.z);
    }

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
