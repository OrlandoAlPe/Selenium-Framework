package utils;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.testng.Reporter;

public class TestSession {

	private static ThreadLocal<Map<String, Object>> sessionData = ThreadLocal.withInitial(HashMap::new);

	public static void setData(String key, Object value) {
		sessionData.get().put(key, value);
	}

	@SuppressWarnings("unchecked")
	public static <T> T get(String key) {
		return (T) sessionData.get().get(key);
	}

	public static void addProductToSession(String productName, String price) {
		List<Map<String, String>> products = get("cart_products");
		if (products == null) {
			products = new ArrayList<>();
			setData("cart_products", products);
		}

		Map<String, String> product = new HashMap<>();
		product.put("name", productName);
		product.put("price", price);
		products.add(product);
		Reporter.log("Product " + productName + " added to test session");
	}

	public static void clear() {
		sessionData.get().clear();
		Reporter.log("Test session data cleared.");
	}

	public static List<Map<String, String>> getCartProducts() {
		Reporter.log("Gathering cart products...");
		return get("cart_products");

	}

}
