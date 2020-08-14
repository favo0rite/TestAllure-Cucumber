package appline.utilsdata;

import java.util.ArrayList;
import java.util.List;

public class Basket {


    private static List<Product> productList = new ArrayList<>();

    public static void addProductToBasket(Product product) {
        productList.add(product);
    }

    public static void deleteProductToBasket(Product product) {
        productList.remove(product);
    }

    public static Product getProductToBasket(int i) {
        return productList.get(i);
    }

    public static List<Product> getProductList() {
        return productList;
    }

    public static int getMaxPrice() {
        int maxPrice = 0;
        for (int i = 0; i < productList.size(); i++) {
            if (getProductToBasket(i).getPrice() > maxPrice) maxPrice = getProductToBasket(i).getPrice();
        }
        return maxPrice;
    }

}
