package flashlite;


public class Main implements Runnable  {
	private static double minInterval = 5000;//
	private static double maxInterval = 15000;
	private static double timeToTakeScreenShot;
	//private static 
	private static boolean flag = false;

	public static void main(String[] args) {
			new AppTray();
		int count = 0;
		do{
			if(flag){
				timeToTakeScreenShot = Math.random()*maxInterval;
				break;
			}
			timeToTakeScreenShot = Math.random()*(maxInterval-minInterval)+minInterval;
			//double between 5 and 15
			try {
				Thread.sleep((long) timeToTakeScreenShot);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			ScreenShot.takeScreenShot();
			//WebcamPhoto.takeWebCamPhoto();
			count++;
		}while(count < 5);

	}

	@Override
	public void run() {
		// TODO Auto-generated method stub
		
	}

}
