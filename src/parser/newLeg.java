package parser;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;

/**
 * Created by SretenskyVD on 13.04.2018.
 */
public class newLeg {
    public static void main(String[] args) throws IOException {

        System.setProperty("javax.net.ssl.trustStore", "s:/Let'sEncryptAuthorityX3_BF.crt.jks");
        String Path = "https://bfide.ru/catalog/losiny/";


            Document doc1 = Jsoup.connect(Path).get();
            Elements lHref = doc1.select("a.d_block");
            Elements links1 = doc1.getElementsByClass("product_name got_bold");
            Elements prices = doc1.getElementsByClass("current_price got_bold pink");



      //      Elements Categorys = doc1.getElementsByClass("title1 got_light mb30");
        Elements Categorys = doc1.getElementsByClass("filter__h");
        System.out.println(Categorys);
            Elements Names = doc1.select("a[data-product]");


            int y = 0;
            for (Element link1 : links1) {

                System.out.println();
                System.out.print(Categorys.text() + " ; " + Names.get(y).attr("data-product") + " ; " + link1.text() + " ; " + prices.get(y).text() +" ; "+ "полиамид 80%, лайкра 20%" );

                String addressUrl = lHref.get(y).attr("abs:href");
                try {

                    Document doc2 = Jsoup.connect(addressUrl).get();
                    Elements razmeres = doc2.getElementsByClass("skuLabel prop_RAZMER_");

                    int numRazmeras = 5;
                    String[] allRazmeras = new String[numRazmeras];
                    allRazmeras[0] = "XXS";
                    allRazmeras[1] = "XS";
                    allRazmeras[2] = "S";
                    allRazmeras[3] = "M";
                    allRazmeras[4] = "L";
                    int allRazmerasIndex = 0;

                    for (Element razmer : razmeres) {
                        while (allRazmerasIndex < numRazmeras && !allRazmeras[allRazmerasIndex].equals(razmer.text())) {
                            System.out.print("; " + allRazmeras[allRazmerasIndex] + " ; 0");
                            ++allRazmerasIndex;
                        }
                        if (allRazmerasIndex < numRazmeras) {
                            ++allRazmerasIndex;
                        }
                        // System.out.print( " ; " + razmer.text());
                        System.out.print(" ; " + razmer.text() + " ; " + "10");
                    }
                    while (allRazmerasIndex < numRazmeras) {
                        System.out.print("; " + allRazmeras[allRazmerasIndex] + " ; 0");
                        ++allRazmerasIndex;
                    }


//                Elements opisanie = doc2.getElementsByClass("al_left fz12");

//                for (Element razmer : razmeres) {
//
//                }
//                    System.out.print(" ; " + razmer.text());
//                }
                    Elements pictures = doc2.getElementsByClass("zoomer image");
                    //  System.out.print(" ; " + opisanie.text());


                    int z = 0;
                    for (Element picture : pictures) {
                        System.out.print(" ; https://bfide.ru" + pictures.get(z).attr("src"));
                        z++;
                    }

                }
                catch (java.util.zip.ZipException e){

                    Document doc2 = Jsoup.connect(addressUrl).get();
                    Elements razmeres = doc2.getElementsByClass("skuLabel prop_RAZMER_");
                    int numRazmeras = 5;
                    String[] allRazmeras = new String[numRazmeras];
                    allRazmeras[0] = "XXS";
                    allRazmeras[1] = "XS";
                    allRazmeras[2] = "S";
                    allRazmeras[3] = "M";
                    allRazmeras[4] = "L";
                    int allRazmerasIndex = 0;
                    for (Element razmer : razmeres) {
                        while (allRazmerasIndex < numRazmeras && !allRazmeras[allRazmerasIndex].equals(razmer.text())) {
                            System.out.print("; " + allRazmeras[allRazmerasIndex] + " ; 0");
                            ++allRazmerasIndex;
                        }
                        if (allRazmerasIndex < numRazmeras) {
                            ++allRazmerasIndex;
                        }
                        System.out.print(" ; " + razmer.text() + " ; " + "10");
                    }
                    while (allRazmerasIndex < numRazmeras) {
                        System.out.print("; " + allRazmeras[allRazmerasIndex] + " ; 0");
                        ++allRazmerasIndex;
                    }
                    Elements pictures = doc2.getElementsByClass("zoomer image");
                    int z = 0;
                    for (Element picture : pictures) {
                        System.out.print(" ; https://bfide.ru" + pictures.get(z).attr("src"));
                        z++;
                    }

                }

                y++;

            }



        }


    }

