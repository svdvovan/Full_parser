package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by SretenskyVD on 27.11.2017.
 */
public class ParserOnePage_test {

    public static void main(String[] args) throws IOException {

        System.setProperty("javax.net.ssl.trustStore", "s:/Let'sEncryptAuthorityX3_BF.crt.jks");
        String Path = "https://bfide.ru/catalog/losiny/";
        int Page = 0;
        for (int count = 0; count <= 1; count++)

        {

            if (Page == 1) {
                Path = "https://bfide.ru/catalog/losiny/?PAGEN_1=2";
            }


            Document doc1 = Jsoup.connect(Path).get();
            // Document doc1 = Jsoup.connect("https://bfide.ru/catalog/losiny/").get();
            Elements lHref = doc1.select("a.d_block");
            Elements links1 = doc1.getElementsByClass("product_name got_bold");
            Elements prices = doc1.getElementsByClass("current_price got_bold pink");
            // Elements prices = doc1.getElementsByClass("old_price");


            Elements Categorys = doc1.getElementsByClass("title1 got_light mb30");
            Elements Names = doc1.select("a[data-product]");


            int y = 0;
            for (Element link1 : links1) {

                System.out.println();
                System.out.print(Categorys.text() + " ; " + Names.get(y).attr("data-product") + " ; " + link1.text() + " ; " + prices.get(y).text());
                String addressUrl = lHref.get(y).attr("abs:href");


                Document doc2 = Jsoup.connect(addressUrl).get();

                Elements razmeres = doc2.getElementsByClass("skuLabel prop_RAZMER_");
                Elements opisanie = doc2.getElementsByClass("al_left fz12");



                        for (Element razmer : razmeres) {
                                    System.out.print(" ; "+ razmer.text()+ " ; 10"  );
                                }








                Elements pictures = doc2.getElementsByClass("zoomer image");
                //  System.out.print(" ; " + opisanie.text());
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
