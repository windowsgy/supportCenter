package utils.telnet;

import java.util.ArrayList;
import java.util.List;

public class TelVersionCmd {

	public static List<String>  run(String str) {

		List<String> list = new ArrayList<>();

		if (str.contains("PON")) {

			list.add("show version-running");

		}

		else if (str.contains("ZTE")) {

			list.add("show version");

		}

		else if (str.contains("Raisecom")) {

			list.add("show version");

		}

		else {

			list.add("display version");

		}

		list.add("exit");


		return list ;


	}
}
