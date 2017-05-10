package cn.zsy.graphB;


public class Road implements Cloneable {
    public Road(String begin, String end) {
        this.begin = begin;
        this.end = end;
    }

    private String begin;
    private String end;

//    public String toString() {
//        return begin + "->" + end;
//    }

    public String getBegin() {
        return begin;
    }

    public void setBegin(String begin) {
        this.begin = begin;
    }

    public String getEnd() {
        return end;
    }

    public void setEnd(String end) {
        this.end = end;
    }

    public boolean equals(Object obj) {
        Road r = (Road) obj;
        if (this.getBegin().equals(r.getBegin()) && this.getEnd().equals(r.getEnd())) {
            return true;
        }
        return false;
    }

    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return null;
    }
}
