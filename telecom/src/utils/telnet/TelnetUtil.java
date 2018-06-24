package utils.telnet;


import java.io.InputStream;
import java.io.PrintStream;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.Callable;
import org.apache.commons.net.telnet.TelnetClient;
import utils.external.DateTimeUtil;

public class TelnetUtil implements Callable<Object> {

	private TelnetClient telnet = new TelnetClient();// 构造telnet对象

	private int taskNum;

	private InputStream in; // 输入流 连接方法赋值

	private PrintStream out; // 输出流 连接方法赋值

	private String ipaddress; // IP地址 构造方法初始化

	private String username; // 用户名 构造方法初始化

	private String password; // 密码 构造方法初始化

	private List<String> command; // 指令

	private StruGatMap gatMap = new StruGatMap();

	private static final String DATE_FORMAT = "yyyy-MM-dd HH:mm:ss";


	public TelnetUtil(StruTelnetMap map) {

		this.taskNum = map.getTaskNumber();

		this.ipaddress = map.getIpadd(); // ip地址加载

		this.username = map.getUsername(); // 用户名加载

		this.password = map.getPassword(); // 密码加载

		this.command = buildCmdList(map.getCommand());//指令

		gatMap.setStartDateTime(DateTimeUtil.getCurTime(DATE_FORMAT));


	}


	public Object call() throws Exception {

		gatMap.setGatStep("connectToServer");

		if(!connectToServer()){//如果连接失败返回

			return gatMap;

		}

		gatMap.setGatStep("beforeLogin");

		if(!read(TelnetEnd.beforeLoginList())){//登陆前判断

			return gatMap;

		}


		if (command.contains("version")) {//如果是查看设备基本信息，构造 version 指令

			this.command = TelVersionCmd.run(this.gatMap.getInfo());

		}


		gatMap.setGatStep("Send Username");

		if(sendToServer(this.username)){ //发送用户名

			return gatMap;


		}

		if(!read(TelnetEnd.LogingList())){//判断

			return gatMap;

		}


		gatMap.setGatStep("Send Password");

		if(sendToServer(this.password)){//发送密码

			return gatMap;


		}

		if(!read(TelnetEnd.LogingList())){//登陆判断

			return gatMap;

		}

		gatMap.setGatStep("Send Command");


		if(!sendCmd()){//发送指令

			return gatMap;

		}


		gatMap.setGatStep("Read Command");


		if(!read(TelnetEnd.commandEndList())){//登陆判断

			return gatMap;

		}


		return gatMap;


	}

	/**
	 * 循环发送指令
	 * @return boolean
	 */

	private  boolean sendCmd(){


		for (String aCommand : command) {

			if (!sendToServer(aCommand)) {

				return false;

			}

		}

		return true;

	}


	/**
	 * 连接方法
	 * @return boolean
	 */

	private boolean connectToServer() { //连接到服务器


		try {

			this.telnet.setDefaultTimeout(60000);// 60秒

			this.telnet.setConnectTimeout(60000);// 60秒

			this.telnet.setDefaultPort(23);//端口

			this.telnet.connect(this.ipaddress); //IP地址

			this.in = telnet.getInputStream();//输入流

			this.out = new PrintStream(telnet.getOutputStream());//输入流

			return true;

		} catch (Exception e) {

			gatMap.setEndDateTime(DateTimeUtil.getCurTime(DATE_FORMAT));//设置结束时间
			gatMap.setLog(e.getMessage());//设置错误消息
			gatMap.setGaterBoolean(false);//设置失败
			return false;


		}

	}




	/**
	 * 关闭连接方法
	 */

	private boolean connectClose() {

		try {

			this.telnet.disconnect();

			return true;

		} catch (Exception e) {

			gatMap.setEndDateTime(DateTimeUtil.getCurTime(DATE_FORMAT));//设置结束时间
			gatMap.setLog(e.getMessage());//设置错误消息
			gatMap.setGaterBoolean(false);//设置失败

			return false;

		}

	}

	/**
	 * 发送数据到服务端方法
	 *
	 * @param cmdStr 指令
	 * @return String
	 */

	private boolean sendToServer(String cmdStr) {

		try {

			this.out.println(cmdStr); // 发送指令

			this.out.flush(); // 刷新缓冲

		}

		catch (Exception e) {

			gatMap.setEndDateTime(DateTimeUtil.getCurTime(DATE_FORMAT));//设置结束时间
			gatMap.setLog(e.getMessage());//设置错误消息
			gatMap.setGaterBoolean(false);//设置失败

			return false;
		}

		return true;

	}


	/**
	 * 命令读取方法每字符读取
	 * @return boolean
	 */

	private boolean read(List<String> endList) { // 读取发送版本命令

		StringBuffer sb = new StringBuffer();

		try {

			char ch = (char) this.in.read();

			sb.append(ch);

			System.out.print(ch);

			while (true) {

				sb.append(ch);

				if (sb.toString().endsWith("More") || sb.toString().endsWith("Press any key to continue")) {//继续判断

					sendToServer(" ");

				}else if(TelnetEnd.error(sb.toString())){//错误判断

					this.gatMap.setInfo(sb.toString());

					return false;

				}

				else if (end(endList,sb.toString())) {//结束判断

					this.gatMap.setInfo(sb.toString());

					return true;

				}

				ch = (char) in.read();

			}


		} catch (Exception e) {

			gatMap.setEndDateTime(DateTimeUtil.getCurTime(DATE_FORMAT));//设置结束时间
			gatMap.setInfo(sb.toString());
			gatMap.setLog(e.getMessage());//设置错误消息
			gatMap.setGaterBoolean(false);//设置失败

			return false;

		}

	}

	public static boolean end(List<String> endList,String str ){

		for (String anEndList : endList) {

			if (str.endsWith(anEndList)) {

				return true;

			}

		}

		return false;



	}


	/**
	 * 构造指令行
	 * @param str 指令集
	 * @return 每行指令
	 */

	public static List<String> buildCmdList (String str){

		List<String> cmdList = new ArrayList<>();

		Scanner scanStr = new Scanner(str);

		while (scanStr.hasNextLine()) {

			cmdList.add(scanStr.nextLine().trim());// 读取每行命令

		}

		return cmdList;


	}



}
