/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class KichThuoc {
    private int Id;
    private String Ma;
     private String size;

    public KichThuoc(String size) {
        this.size = size;
    }

    public KichThuoc(int Id, String Ma, String size) {
        this.Id = Id;
        this.Ma = Ma;
        this.size = size;
    }

    public KichThuoc(String Ma, String size) {
        this.Ma = Ma;
        this.size = size;
    }

    
    public KichThuoc() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getMa() {
        return Ma;
    }

    public void setMa(String Ma) {
        this.Ma = Ma;
    }

    public String getSize() {
        return size;
    }

    public void setSize(String size) {
        this.size = size;
    }

    @Override
    public String toString() {
        return "KichThuoc{" + "Id=" + Id + ", Ma=" + Ma + ", size=" + size + '}';
    }

   public String getKichThuoc(){
       if (getId()==1) {
           return "S";
       }
       else if (getId()==2) {
           return "M";
       }
       else{
         return "L";
       }
   }

}
