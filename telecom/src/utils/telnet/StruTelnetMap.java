package utils.telnet;

/**
 *
 * Created by jlgaoyuan on 2018/5/14.
 *
 */
public class StruTelnetMap {

    private int  tn ; //线程编号
    private String ipadd ;//IP地址
    private String uname;//用户名
    private String pwd;//密码
    private String cmdType  ; //指令类型

    //------------------------------------------------

    public void setTaskNumber (int info){ tn = info;  }
    public void setIpadd (String info){ ipadd = info;  }
    public void setUsername (String info){ uname = info;  }
    public void setPassword (String info){ pwd = info; }
    public void setCmd (String info){ cmdType = info; }
    //------------------------------------------------
    public int getTaskNumber (){ return tn; }
    public String getIpadd (){ return ipadd ; }
    public String getUsername (){ return uname ; }
    public String getPassword (){ return pwd ;}
    public String getCommand (){ return cmdType ;}
}
