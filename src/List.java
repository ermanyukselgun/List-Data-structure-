/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */


import java.util.Scanner;

class Item { 
    int val; // elemanın değeri 
    Item next; // sonraki elemanın erişim bilgisi 
    /* yapıcı işlev, parametre değerlerinn ilgili öz niteliklere atar */
    Item(int val, Item next)
    { 
        this.val = val;
        this.next=next;
    } 
} 
public class List {

private Item list;  // İlk elemanın erişim bilgisini tutar

  // yaratıcı işlev, ilk eleman erişim bilgisi olarak null atar
  public List() {
    list=null;
  }

  // listenin başına yeni bir eleman ekler, değerini parametre olarak alır
  public void insert(int val) {
    Item t=new Item(val,list);  // eklenen elemanın değeri val, sonrası ise eski ilk eleman
    list=t;  // listenin başında artık bu yeni ilk eleman var
  }

  // son elemanın erişim bilgisini döndürür
  public Item atEnd() {
    Item t;
    if(list==null) return null;   // liste boşsa, son eleman da yok
    t=list;                       // listenin başından başla
    while(t.next!=null) t=t.next; // son elemana (next öz niteliği null olan) kadar git
    return t;                     // erişim bilgisini döndür
  }

  // listenin sonuna yeni bir eleman ekler, değerini parametre olarak alır
  public void append(int val) {
    Item t=new Item(val,null);  // eklenen elemanın değeri val, sonrası ise yok
    if(list==null)              // liste zaten boşsa,
      list=t;                   // ilk eleman da bu yeni eklenen
    else                        // değilse,
      atEnd().next=t;           // son elemanın sonrası yeni eklenen eleman
  }

  // listenin (eğer varsa) val değerine sahip ilk elemanını bulup siler
  public void remove(int val) {
    Item t=list;
    if(t==null) return;  // liste boşsa yapacak işlem yok
    if(t.val==val)       // listenin ilk elemanı val değerine sahipse,
      list=t.next;       // 2. eleman artık listenin başında
    else {               // değilse,
      Item prev=t;       // prev, t'nin baktığı elemanın öncesini tutsun
      t=t.next;          // t de, bakmaya 2. elemandan başlasın
      while(t!=null && t.val!=val) {  // t sona gelmediyse ve değeri val'dan farklı ise
        prev=prev.next;               // hem prev,
        t=t.next;                     // hem t birer ilerlesin
      }
      if(t==null) return;  // döngüden çıkış nedeni sona gelmiş olmaksa, bulamadık demek
      prev.next=t.next;    // ama değilse, bulduk: prev'in sonrası, artık t'nin sonrası
    }                      // yani t elemanı listeden kopartıldı, aradan çıkartıldı
  }

  // listedeki eleman sayısını bulup döndürür
  public int length() {
    Item t=list;      // listenin başından başla
    int i=0;          // sayaç 0
    while(t!=null) {  // sona gelmediysek
      i++;            // sayacı artır
      t=t.next;       // sonraki elemana geç
    }
    return i;         // sayaç değerini döndür
  }

  // listenin elemanlarını ekrana yazar
  public void display() {
    Item t=list;      // listenin başından başla
    while(t!=null) {  // sona gelmediysek
      System.out.print(t.val+" ");  // elemanın değerini yaz
      t=t.next;       // sonraki elemana geç
    }
    
      
  }
  
  public void listeyeEkle()
  { 
      while(true)
      {
            System.out.println("Listeye ekleme yapmak istediğiniz pozitif sayiyi giriniz");
            Scanner sayi= new Scanner (System.in);
            int number=sayi.nextInt();
            if (number<0) 
            {
                break;
            }
            else
            {
                append(number);
            }
      }
      
      
  }
  public void histogram()
  {
      Item i = list;
      while(i!=null) 
      { 
          
          Item t=list;
          int index =0;
          while(t !=null) 
          {              
              if (i.val==t.val) {
                  index++;
                  remove(t.val);
              }
            t=t.next;       // sonraki elemana geç
          }
                     

          if(i.next==null)
          {
              if (index != 0) 
              {
                System.out.println(i.val+":"+index);
              }

              break;
          }
          
           if (index != 0) 
              {
                System.out.println(i.val+":"+index);
              }

          

          i=i.next;           
          
          
      }
  }
  
  
    public static void main(String[] args) {
        List test = new List();
        test.listeyeEkle();        
        test.histogram();
    }

}