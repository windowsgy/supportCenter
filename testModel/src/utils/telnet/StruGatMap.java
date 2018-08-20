package utils.telnet;

/**
 *
 * Created by jlgaoyuan on 2018/5/14.
 */
public class StruGatMap {

    private boolean gatBoolean = false; //采集结果是否成功
    private String ipadd ;
    private String step ;//登陆步骤
    private String log ;//采集日志；
    private String gatInfo ; //采集信息
    private String startDateTime ;//采集开始时间
    private String endDateTime  ;//采集结束时间
    //------------------------------------------------
    public void setGaterBoolean (boolean info){  this.gatBoolean = info;  }
    public void setIpadd (String info){ this.ipadd = info ;}
    public void setGatStep (String info){ this.step = info ;}
    public void setInfo (String info){ gatInfo = info ;}
    public void setLog (String info){ this.log = info;  }
    public void setStartDateTime (String info){ this.startDateTime = info; }
    public void setEndDateTime (String info){ this.endDateTime = info; }
    //------------------------------------------------

    public boolean getGaterBoolean (){ return this.gatBoolean; }
    public String getGatStep (){ return step ;}
    public String getLog (){ return log ; }
    public String getInfo (){ return gatInfo ; }
    public String getStartDateTime (){return startDateTime ;}
    public String getEndDateTime (){return endDateTime ;}
    public String getIpadd(){return ipadd;}

}
