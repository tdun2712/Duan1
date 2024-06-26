/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class Anh {
    private int Id;
    private int IdSPCT;
    private String url;

    public Anh() {
    }

    public Anh(int Id, int IdSPCT, String url) {
        this.Id = Id;
        this.IdSPCT = IdSPCT;
        this.url = url;
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public int getIdSPCT() {
        return IdSPCT;
    }

    public void setIdSPCT(int IdSPCT) {
        this.IdSPCT = IdSPCT;
    }

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }

   

    @Override
    public String toString() {
        return "Anh{" + "Id=" + Id + ", IdSPCT=" + IdSPCT + ", url=" + url + '}';
    }
    
    
}
