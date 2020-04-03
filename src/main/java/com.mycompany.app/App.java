package com.mycompany.app;

import com.zaxxer.ping.PingResponseHandler;
import com.zaxxer.ping.IcmpPinger;
import com.zaxxer.ping.PingTarget;

import java.net.InetAddress;

public class App{

	public static void main(String[] args) throws Exception {
		System.out.println("HALLO");

IcmpPinger icmpPinger = new IcmpPinger(new PingResponseHandler() {
	@Override
        public void onResponse(PingTarget pingTarget, double v, int i, int i1) {
        	System.out.println("PINGRESPNSEHANDLER-ON_RESPONSE + " + pingTarget.toString() + " " + v + " " + i + " " + i1);
        }

        @Override
        public void onTimeout(PingTarget pingTarget) {
	        System.out.println("PINGRESPNSEHANDLER-ON_TIMEOUT");
        }
});

icmpPinger.ping(new PingTarget(InetAddress.getByName("1.1.1.1")));
icmpPinger.runSelector();

//while (icmpPinger.isPendingWork()){
//	Thread.sleep(200);
//        System.out.print("z");
//}

System.out.println("END PING");

icmpPinger.stopSelector();



//end main
	}
}
