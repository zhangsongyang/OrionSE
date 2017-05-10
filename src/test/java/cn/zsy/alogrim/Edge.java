package cn.zsy.alogrim;

/**
 * 一条边
 */
public class Edge<V> implements Cloneable {
    /**
     * 起点
     */
    private V src;
    /**
     * 终点
     */
    private V dest;
    /**
     * 权值
     */
    private double weight;

    /**
     * 不带权值的一条边
     *
     * @param src
     * @param dest
     */
    public Edge(V src, V dest) {
        this(src, dest, 0);
    }

    /**
     * 带权值的一条边
     *
     * @param src
     * @param dest
     * @param weight
     */
    public Edge(V src, V dest, double weight) {
        this.src = src;
        this.dest = dest;
        this.weight = weight;
    }

    /**
     * 获取起点
     *
     * @return
     */
    public V getSource() {
        return this.src;
    }

    /**
     * 获取终点
     *
     * @return
     */
    public V getDest() {
        return this.dest;
    }

    /**
     * 获取权值
     *
     * @return
     */
    public double getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        String ret = String.format("src : %s , dest : %s , weight : %s", src, dest, weight);
        return ret;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Edge<?> edge = (Edge<?>) o;

        if (Double.compare(edge.weight, weight) != 0) return false;
        if (!src.equals(edge.src)) return false;
        return dest.equals(edge.dest);

    }

    @Override
    public int hashCode() {
        int result;
        long temp;
        result = src.hashCode();
        result = 31 * result + dest.hashCode();
        temp = Double.doubleToLongBits(weight);
        result = 31 * result + (int) (temp ^ (temp >>> 32));
        return result;
    }

    @Override
    public Object clone() {
        try {
            return super.clone();
        } catch (CloneNotSupportedException e) {
            e.printStackTrace();
        }
        return null;
    }


    public String getRoute() {
        return this.src + "-" + this.dest;
    }

}