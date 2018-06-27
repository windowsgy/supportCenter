package utils.telnet;



import utils.base.LogInfo;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.*;


public class GatTelnet {

    public static void run(List<StruTelnetMap> telnetList){

        LogInfo.info("Gat Count:"+telnetList.size());

        int taskSize = 10;
        // 创建一个线程池
        ExecutorService pool = Executors.newFixedThreadPool(taskSize);
        // 创建多个有返回值的任务

        List<Future> list = new ArrayList<>();

        for(int i = 0 ; i < telnetList.size();i++) {

            StruTelnetMap map = telnetList.get(i);

            Callable<?> c = new TelnetUtil(map);

            Future<?> f = pool.submit(c);

            list.add(f);

        }
        // 关闭线程池
		pool.shutdown();

        for (Future<?> f : list) {

            try {

                StruGatMap map = (StruGatMap) f.get();

                System.out.println(map.getGatStep()+":"+map.getGaterBoolean());


            } catch (InterruptedException e) {

                e.printStackTrace();

            } catch (ExecutionException E) {

                E.printStackTrace();
            }

        }

    }

}
