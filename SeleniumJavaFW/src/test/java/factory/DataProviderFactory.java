package factory;

import providers.BrowserConfigProvider;
import providers.ConfigDataProvider;
import providers.ExcelDataProvider;

public class DataProviderFactory {

	public static ExcelDataProvider getExcel() {
		ExcelDataProvider excel = new ExcelDataProvider();
		return excel;

	}

	public static ConfigDataProvider getConfig() {
		ConfigDataProvider config = new ConfigDataProvider();
		return config;
	}

	public static BrowserConfigProvider getBrowserConfig() {
		BrowserConfigProvider browserConfig = new BrowserConfigProvider();
		return browserConfig;
	}

}
