package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by SretenskyVD on 30.11.2017.
 */
public class ParserKombez { public static void main(String[] args) throws IOException {
    System.setProperty("javax.net.ssl.trustStore", "s:/Let'sEncryptAuthorityX3_BF.crt.jks");
    Document doc1 = Jsoup.connect("https://bfide.ru/catalog/kombinezony/").get();
    Elements lHref = doc1.select("a.d_block");
    Elements links1 = doc1.getElementsByClass("product_name got_bold");
    Elements prices = doc1.getElementsByClass("current_price got_bold pink");
    //   Elements prices = doc1.getElementsByClass("old_price");
    Elements Categorys = doc1.getElementsByClass("title1 got_light mb30");
    Elements Names = doc1.select("a[data-product]");

    String aNums[] = {"23901", "22250"};
    String XXS = "XXS";
    String XS = "XS";
    String S = "S";
    String M = "M";
    String L = "L";
    // String Compare;
    String One;
    String t = "0";
    String k ="0";
    String f = "0";
    String l = "0";
    String e = "0";

    int y = 0;
    for (Element link1 : links1) {


        System.out.println();
        System.out.print(Categorys.text() + " ; " + Names.get(y).attr("data-product") + " ; " + link1.text() + " ; " + prices.get(y).text());
//        String Test = Names.get(y).attr("data-product");
//        System.out.print( Test);
        // System.out.print(Categorys.text() +  " ; " + Names.get(y).attr("data-product")+  " ; "  + link1.text() + " ; ");

        String addressUrl = lHref.get(y).attr("abs:href");


        Document doc2 = Jsoup.connect(addressUrl).get();

        Elements razmeres = doc2.getElementsByClass("skuLabel prop_RAZMER_");



        for (Element razmer : razmeres) {

            if (razmer.text().equals(XXS)) {
                t = "10xxs";
            } else t = "0";
            if (razmer.text().equals(XS)) {
                k = "10xs";
            } else k = "0";
            if (razmer.text().equals(S)) {
                f = "10s";
            } else f = "0";
            if (razmer.text().equals(M)) {
                l = "10m";
            } else l = "0";
            if (razmer.text().equals(L)) {
                e = "10L";
            } else e = "0";

            // System.out.print(" ; " + razmer.text());
//                   String  Compare = razmer.text().toString();
//                   if (Compare.equals(XS)) {
//                             System.out.print(" ; " + "супер");}
//
//                 //   else {System.out.print(" ; " + razmer.text());}
       //     System.out.print(";" + t  + ";" + k +";"+ f + ";" + l +";");
  //          System.out.print(";" + t  + ";" + k +";"+ f + ";" + l +";"+ e +";");
        }
        System.out.print(";" + t  + ";" + k +";"+ f + ";" + l +";"+ e +";");


        Elements pictures = doc2.getElementsByClass("zoomer image");

        int z = 0;
        for (Element picture : pictures) {
            System.out.print(" ; https://bfide.ru" + pictures.get(z).attr("src"));
            z++;
        }
        y++;

        }
    }
}

