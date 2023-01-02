// [TUGAS] [Generic] [Collection] [Stream]
// - Silahkan ganti penggunaan Array dengan Collection yang sudah di delivery hari ini
// - Silahkan gunakan Method Stream yang di delivery hari ini utk kebutuhan menampilkan sebuah data. ex: report/sejenisnya
// - [opsional] implementasikan Generic Type pada aplikasi yang kalian buat. 

// dikumpulkan maks pada pukul 16.00

// note :
// - Jika Generic terimplementasi dengan baik, maka akan mendapatkan nilai tambahan.
// - Jika aplikasi kalian tidak menggunakan Array, coba diimplementasikan dan buat menggunakan Collection
import java.util.*;
public class Attendance2 {
    public static void main(String[] args) {
        NameEmployee nama1 = new NameEmployee();
        nama1.setEmployee();
        nama1.setName("Ronaldo Wati");
        nama1.process();
        nama1.tapIn(nama1.getHasil());
        System.out.println("");
        nama1.tapOut();
        System.out.println("");
        NameDivEmployee div1 = new NameDivEmployee();
        div1.setEmployee();
        div1.setNameDiv("Ridho Rachmat","HRD");
        div1.process();
        div1.prosesDivisi();
        div1.tapIn(div1.getName(),div1.getDiv());
        System.out.println("");
        div1.tapOut();
        System.out.println("");
        NameEmployee searchname = new NameEmployee();
        searchname.setEmployee();
        searchname.StreamName("Ridho");
    }
}

abstract class Attend {

    //INHERITANCE
    List<String> arr = new ArrayList<>();
    List<String> arrdiv = new ArrayList<>();
    String Employee="";
    String Division = "";

    //OVERLOADING
    public void tapIn(String result1, String result2){
        if(result1=="" || result2==""){
            System.out.println("Nama atau Divisi Tidak Terdaftar");
        }else{
            System.out.println("Nama ; " +result1);
            System.out.println("Divisi ; " +result2);
            System.out.println("Telah TapIn! Selamat Datang!");
        }
    }

    //OVERLOADING
    public void tapIn(String result1){
        if(result1==""){
            System.out.println("Nama tidak terdaftar, tidak bisa tapIn!");
        }else{
            System.out.println(result1+" telah tapIn!");
        }
    }

    public void setEmployee(){
        arr.add("Ridho Rachmat");
        arr.add("Riri Margareta");
        arr.add("Ronaldo Wati");
        arrdiv.add("HRD");
        arrdiv.add("Sales");
        arrdiv.add("Marketing");

    }

    public void StreamName(String j){

        arr.stream()
        .filter(x->x.contains(j))
        .sorted()
        .forEach(System.out::println);
    }

    public void SortName(String j){

        arr.stream()
        .sorted(Comparator.comparing(arr::StreamName()))
        .forEach(System.out::println);
    }

    //ABSTRACT
    abstract void process();
    abstract void tapOut();
}


//SUBCLASS
class NameEmployee extends Attend{
    private String name;
    private String result;

    //GETTER
    public String getHasil(){
        return this.result;
    }

    //SETTER
    public void setName(String name){
        this.name = name;
    }
    
    //OVERRIDING
    public void process(){

        for(String x : arr){
            if(x==name){
                Employee = x;
            }

        }
        this.result=Employee;
    }

    //OVERRIDING
    public void tapOut(){
        if(this.result==""){
            System.out.println("Nama tidak terdaftar, tidak bisa tapOut");
        }else{
            System.out.println(this.name+" sudah tapOut!");
        }
        
    }

}

//SUBCLASS
class NameDivEmployee extends Attend{
    private String name;
    private String division;
    private String result1;
    private String result2;

    //GETTER
    public String getName(){
        return this.result1;
    } 

    //GETTER
    public String getDiv(){
        return this.result2;
    } 

    //SETTER
    public void setNameDiv(String name, String div){
        this.name = name;
        this.division = div;
    }

    //OVERRIDING
    public void process(){
        for (String x : arr){
            if(x==this.name){
                Employee = x;
            }
        }
        this.result1=Employee;
    }

    public void prosesDivisi(){
        for (String x : arrdiv){
            if(x==this.division){
                Division = x;
            }
        }
        this.result2=division;
    }

    //OVERRIDING
    public void tapOut(){
        if(this.result1=="" || this.result2 ==""){
            System.out.println("Nama atau divisi tidak terdaftar, tidak bisa tapOut");
        }else{
            System.out.println(this.name+" dari divisi "+this.division+" sudah tapOut!");
        }
        
    }

}