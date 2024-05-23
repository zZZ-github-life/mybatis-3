package online.zzzzzzz.test1;

/**
 * @author zZZ.... <br/>
 * @description <br/>
 * @date 2023/12/29$  <br/>
 */
import java.io.Serializable;
import java.util.Objects;

public class Ta implements Serializable {

  private Integer id;
  private Short num;
  private String nn;
  private String n1;
  private String t1;
  private Integer ip;

  public Integer getId() {
    return id;
  }

  public void setId(Integer id) {
    this.id = id;
  }

  public Short getNum() {
    return num;
  }

  public void setNum(Short num) {
    this.num = num;
  }

  public String getNn() {
    return nn;
  }

  public void setNn(String nn) {
    this.nn = nn == null ? null : nn.length() <= 1 ? nn : nn.substring(0, 1);
  }

  public String getN1() {
    return n1;
  }

  public void setN1(String n1) {
    this.n1 = n1 == null ? null : n1.length() <= 1 ? n1 : n1.substring(0, 1);
  }

  public String getT1() {
    return t1;
  }

  public void setT1(String t1) {
    this.t1 = t1;
  }

  public Integer getIp() {
    return ip;
  }

  public void setIp(Integer ip) {
    this.ip = ip;
  }

  @Override
  public boolean equals(Object o) {
    if (this == o) return true;
    if (o == null || getClass() != o.getClass()) return false;
    Ta ta = (Ta) o;
    return Objects.equals(id, ta.id) && Objects.equals(num, ta.num) && Objects.equals(nn, ta.nn) && Objects.equals(n1, ta.n1) && Objects.equals(t1, ta.t1) && Objects.equals(ip, ta.ip);
  }

  @Override
  public int hashCode() {
    return Objects.hash(id, num, nn, n1, t1, ip);
  }

  @Override
  public String toString() {
    return "Ta{" +
      "id=" + id +
      ", num=" + num +
      ", nn='" + nn + '\'' +
      ", n1='" + n1 + '\'' +
      ", t1='" + t1 + '\'' +
      ", ip=" + ip +
      '}';
  }
}
