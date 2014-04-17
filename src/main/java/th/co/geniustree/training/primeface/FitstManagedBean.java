/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package th.co.geniustree.training.primeface;

import java.io.Serializable;
import javax.annotation.PostConstruct;
import javax.enterprise.context.SessionScoped;
import javax.inject.Named;

/**
 *
 * @author toy
 */
@Named//บอกว่าเป็น managed bean ชื่อ firstMB
@SessionScoped
//บอกว่า ตัวแปรทุกตัวใน managed bean นี้ อยู่ในระดับ session scope
//scope มันก็จะมีอยู่หลายระดับ เช่น
//@RequestScoped คือ request ทุกครั้ง managed bean จะสร้างตัวแปรใหม่ทุกครั้ง
//@SessionScoped คือ สร้าง attribute ครั้งเดียวเฉพาะตอน create session attribute ที่เหลือก็จะไปเอาจาก session มาใช้
//@ApplicationScoped คือสร้างครั้งเดียว ตอน start application, scope นี้ ทุกคนใน application จะมองเห็นเป็นค่าเดียวกันหมด  ซึ่งต่างจาก SessionScoped ที่จะมองเห็นเฉพาะ session ใคร session มัน
//@ViewScoped
public class FitstManagedBean implements Serializable{ //implements Serializable ใช้ในกรณีที่เป็น SessionScoped และ ApplicationScoped เพื่อให้สามารถจัดเก็บค่า attribute ต่างๆ ไว้ใน application ได้
 
    private String firstName;
    private String lastName;
 
    @PostConstruct //บอกว่า ให้ทำหลังจากที่เรียก constructor
    public void postConstruct() {
        firstName = "Kittipong";
        lastName = "Pinta";
    }
 
    //การเรียกใช้งาน attribute ต่างๆ ของ managed bean จะเรียกผ่าน method getter setter เสมอ ****
    //ไม่เกียวกับจำนวน attribute ที่มีอยู่ครับ 
    public String getFirstName() {
        return firstName;
    }
 
    //ทั้งๆ ที่ไม่มี attribute id  แต่ก็สามารถเรียกใช้งาน method id ได้
    public int getId(){
       return 501;
    }
 
    //การ set ค่าให้กับ attribute จะเรียกใช้ setter method ของ attribute นั้น
    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }
 
    //ส่วนการอ่านค่า จะเรียกใช้ getter method ของ attribute นั้นครับ 
    public String getLastName() {
        return lastName;
    }
 
    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
     
    //อันนี้ เราอาจมองว่ามันคือ action อะไรบางอย่างก็ได้  ที่เราอยากที่ view action เข้ามา
    //เราอาจจะตั้งเป็น onSave(), onAdd(), onRemove() ...  หรือตั้งชื่อว่าอะไรก็ได้น่ะครับ  เพียงแต่ผมชอบใช้ on นำหน้า  เพื่อให้รู้ว่ามันคือ action ที่รองรับการเกิด event ต่างๆ  ตามที่เราต้องการ
    public void onAction(){
        System.out.println("call action");
        System.out.println("first name => " + firstName);
        System.out.println("last name => " + lastName);
    }
}
