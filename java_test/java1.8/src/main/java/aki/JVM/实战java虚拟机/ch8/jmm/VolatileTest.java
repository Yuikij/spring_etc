package aki.JVM.实战java虚拟机.ch8.jmm;
/**
 * -server
 * @author Administrator
 *
 */
public class VolatileTest {
	public static class MyThread extends Thread{
		private boolean stop = false;  	//ȷ��stop�����ڶ��߳��пɼ�
		public synchronized void stopMe(){				//�������߳��е��ã�ֹͣ���߳�
			stop=true;
		}
		public synchronized boolean stopped(){
			return stop;
		}
		public void run() {  
			int i = 0;  
			while (!stopped()) { 					//�������߳��иı�stop��ֵ
				i++;  
			}
			System.out.println("Stop Thread");  
		}  
	}

	public static void main(String[] args) throws InterruptedException {
		MyThread t = new MyThread();  
		t.start(); 
		Thread.sleep(1000);
		t.stopMe();
		Thread.sleep(1000);

	}
}

