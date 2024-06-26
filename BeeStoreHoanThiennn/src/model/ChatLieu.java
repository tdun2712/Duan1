/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

/**
 *
 * @author phamt
 */
public class ChatLieu {
  private int Id;
    private String tenChatlieu;

    public ChatLieu(String tenChatlieu) {
        this.tenChatlieu = tenChatlieu;
    }

    public ChatLieu() {
    }

    public int getId() {
        return Id;
    }

    public void setId(int Id) {
        this.Id = Id;
    }

    public String getTenChatlieu() {
        return tenChatlieu;
    }

    public void setTenChatlieu(String tenChatlieu) {
        this.tenChatlieu = tenChatlieu;
    }

    public ChatLieu(int Id, String tenChatlieu) {
        this.Id = Id;
        this.tenChatlieu = tenChatlieu;
    }

    @Override
    public String toString() {
        return "ChatLieu{" + "Id=" + Id + ", tenChatlieu=" + tenChatlieu + '}';
    }

    
    
}
