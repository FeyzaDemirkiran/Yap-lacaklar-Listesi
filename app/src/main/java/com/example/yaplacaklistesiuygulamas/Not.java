
package com.example.yaplacaklistesiuygulamas;

public class Not {

    private String id; //Notun benzersiz kimliğini tutar. Bu, Firebase'de saklanan veriyi tanımlamak için gereklidir.
    private String baslik;
    private String icerik;
    private String kullaniciId; //  Notun hangi kullanıcıya ait olduğunu belirtir (Firebase ile ilişkilendirilebilir).


    public Not(String baslik, String icerik, String kullaniciId) {
// Firebase işlevsellik açısından gerekli
    }

    public Not(String id, String baslik, String icerik, String kullaniciId)
    {

        this.id=id;
        this.baslik=baslik;
        this.icerik=icerik;
        this.kullaniciId=kullaniciId;
    }

    public String getId() {
        return id;
    } // notun kimliğini döndürür.
    public void setId(String id) {  // notun kimliğini ayarlar.

        this.id=id;
    }

    public String getBaslik(){

        return baslik;

    }

    public void setBaslik(String baslik) {

        this.baslik= baslik;
    }

    public String getIcerik(){

        return icerik;

    }

    public void setIcerik(String icerik) {

        this.icerik= icerik;
    }


    public String getKullaniciId(){

        return kullaniciId;

    }

    public void setKullaniciId(String kullaniciId) {

        this.kullaniciId=kullaniciId;
    }


}