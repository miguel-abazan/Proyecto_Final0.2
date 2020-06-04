package Hilo;
import vista.Login;
public class HiloLogin extends Thread{
	public void run() {
		for (int i = 0; i < 100; i++) {
			Login.barra.setValue(i);
			Login.barra.repaint();
			try {
				Thread.sleep(10);
			} catch (InterruptedException e) {
				// TODO: handle exception
			}
		}
	}
	

}
