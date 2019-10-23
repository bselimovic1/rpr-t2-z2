package ba.unsa.etf.rpr.tutorijal02;

public class Interval {
    private double pocTacka;
    private double krajTacka;
    private boolean pocPripada;
    private boolean krajPripada;

    public Interval(double pocTacka, double krajTacka, boolean pocPripada, boolean krajPripada) {
        if (pocTacka - krajTacka > 0.00001) throw new IllegalArgumentException("Pocetna tacka veca od krajnje");
        this.pocTacka = pocTacka;
        this.krajTacka = krajTacka;
        this.pocPripada = pocPripada;
        this.krajPripada = krajPripada;
    }

    public Interval() {
        pocTacka = 0;
        krajTacka = 0;
        pocPripada = false;
        krajPripada = false;
    }

    public boolean isNull() {
        return pocTacka == 0 && krajTacka == 0 && pocPripada == false && krajPripada == false;
    }

    public boolean isIn(double t) {
        if (pocPripada && krajPripada)
            return t >= pocTacka && t <= krajTacka;
        else if (pocPripada && !krajPripada)
            return t >= pocTacka && t < krajTacka;
        else if (!pocPripada && krajPripada)
            return t > pocTacka && t <= krajTacka;
        else
            return t > pocTacka && t < krajTacka;
    }

    public Interval intersect(Interval i) {
        Interval presjek = new Interval();
        if(i.pocTacka >= pocTacka && krajTacka<=i.krajTacka){
            presjek.pocTacka=i.pocTacka;
            presjek.krajTacka= krajTacka;
            presjek.pocPripada=i.pocPripada;
            presjek.krajPripada=krajPripada;
        }
        else if(pocTacka>=i.pocTacka && i.krajTacka<=krajTacka){
            presjek.pocTacka= pocTacka;
            presjek.krajTacka= i.krajTacka;
            presjek.pocPripada=pocPripada;
            presjek.krajPripada=i.krajPripada;
        }
        else if(i.pocTacka>=pocTacka && i.krajTacka<=krajTacka){
            presjek.pocTacka=i.pocTacka;
            presjek.krajTacka=i.krajTacka;
            presjek.pocPripada=i.pocPripada;
            presjek.krajPripada=i.krajPripada;
        }
        else if(pocTacka>=i.pocTacka && krajTacka<=i.krajTacka){
            presjek.pocTacka=pocTacka;
            presjek.krajTacka=krajTacka;
            presjek.pocPripada=pocPripada;
            presjek.krajPripada=krajPripada;
        }

        else{
            presjek.pocTacka=0;
            presjek.krajTacka=0;
            presjek.pocPripada=false;
            presjek.krajPripada=false;
        }

        return presjek;
    }

    public static Interval intersect(Interval i1,Interval i2){
        Interval presjek = new Interval();
        if(i2.pocTacka >= i1.pocTacka && i1.krajTacka<=i2.krajTacka){
            presjek.pocTacka=i2.pocTacka;
            presjek.krajTacka= i1.krajTacka;
            presjek.pocPripada=i2.pocPripada;
            presjek.krajPripada=i1.krajPripada;
        }
        else if(i1.pocTacka>=i2.pocTacka && i2.krajTacka<=i1.krajTacka){
            presjek.pocTacka= i1.pocTacka;
            presjek.krajTacka= i2.krajTacka;
            presjek.pocPripada=i1.pocPripada;
            presjek.krajPripada=i2.krajPripada;
        }
        else if(i2.pocTacka>=i1.pocTacka && i2.krajTacka<=i1.krajTacka){
            presjek.pocTacka=i2.pocTacka;
            presjek.krajTacka=i2.krajTacka;
            presjek.pocPripada=i2.pocPripada;
            presjek.krajPripada=i2.krajPripada;
        }
        else if(i1.pocTacka>=i2.pocTacka && i1.krajTacka<=i2.krajTacka){
            presjek.pocTacka=i1.pocTacka;
            presjek.krajTacka=i1.krajTacka;
            presjek.pocPripada=i1.pocPripada;
            presjek.krajPripada=i1.krajPripada;
        }

        else{
            presjek.pocTacka=0;
            presjek.krajTacka=0;
            presjek.pocPripada=false;
            presjek.krajPripada=false;
        }

        return presjek;
    }
    @Override
    public String toString(){
        String tekst=new String();
        if(pocPripada==false) tekst += "(";
        else if(pocPripada) tekst+="[";
        if(pocTacka!=0) tekst += pocTacka+","+krajTacka;
        if(krajPripada) tekst += "]";
        else tekst += ")";
        return tekst;

    }
    @Override
    public boolean equals(Object o){
        Interval i = (Interval) o; // konverzija tipa object u tip interval
        return pocTacka==i.pocTacka && krajTacka==i.krajTacka && pocPripada==i.pocPripada && krajPripada==i.krajPripada;
    }
}