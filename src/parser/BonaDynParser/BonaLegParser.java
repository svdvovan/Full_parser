package parser.BonaDynParser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by SretenskyVD on 20.04.2018.
 */
public class BonaLegParser {
    public static void main(String[] args) throws IOException {

        System.setProperty("javax.net.ssl.trustStore", "s:/Let'sEncryptAuthorityX3_BF.crt.jks");
        String Path = "https://bfide.ru/catalog/losiny/?SECTION_CODE=losiny&PAGEN_1=";
        int Page = 4;
        for (int count = 1; count <= 1; count++)

        {

           String Path1 = Path + Page;
            System.out.println(Path1);

            Document doc1 = Jsoup.connect(Path1).get();

//            Elements lHref = doc1.select("a.d_block");
            Elements lHref = doc1.getElementsByClass("product__link");
            Elements NameOfProduct = doc1.getElementsByClass("product__title");
            Elements links1 = doc1.getElementsByClass("product__mid");
            Elements prices = doc1.getElementsByClass("product__price");

            Elements Categorys = doc1.getElementsByClass("filter__h");
            Elements Names = doc1.select("a[data-product]");
            Elements id_product =  doc1.getElementsByClass("gofav  js-add2favorite");


            int y = 0;
            for (Element link1 : links1) {
                String idNumber = id_product.get(y).attr("data-id");
                System.out.println();
                System.out.print(Categorys.text() + " ; " +idNumber + " ; "+ NameOfProduct.get(y).text() +" ; "+ prices.get(y).text() + " ; " );
               String addressUrl = lHref.get(y).attr("abs:href");

                Document doc2 = Jsoup.connect(addressUrl).get();
                Elements razmeres = doc2.getElementsByClass("sizes sizes_dark");

                Elements BaseRazmer = doc2.getElementsByClass("js-size_change sizes__size  sizes__size_active");


                for (Element razmer : razmeres) {

                   System.out.print(BaseRazmer.text()+ " ; " + BaseRazmer.attr("data-count"));
                    Elements data2  = doc2.getElementsByClass("js-size_change sizes__size ");
                    int t=0;
                    for (Element data1 : data2){
                        System.out.print(" ; " + data2.get(t).text() + " ; "+ data2.get(t).attr("data-count"));
                    t++;
                    }

                }
                Elements pictures = doc2.getElementsByClass("productphoto__photo owl-lazy");
                int z = 0;
                for (Element picture : pictures) {
                    System.out.print(" ; https://bfide.ru" + pictures.get(z).attr("src"));
                    z++;
                }

                y++;

            }

            Page++;

        }


    }

}