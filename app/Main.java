import java.io.IOException;
import java.util.Arrays;

import org.audary.api.azure.StringArrayResponse;
import org.audary.api.translate.TranslateClient;

public class Main {

	public static void main(String[] args) throws IOException {
		TranslateClient t = new TranslateClient("f62e26dd33c84109bbdf95a3f3735724");
		StringArrayResponse sar = t.retrieveLocales();
		System.out.println(Arrays.toString(t.retrieveLanguages(sar, "en").string));
	}

}
