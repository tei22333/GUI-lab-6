package logic;

import java.text.SimpleDateFormat;
import java.util.Date;

import gui.TimerGUI;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import main.Main;

public class Timer {

	public static final int SLEEP_TIME = 1000;
	public static final int COUNT_UP = 1;
	public static final int COUNT_DOWN = -1;
	private TimerGUI timerGUI;
	private int hour;
	private int minute;
	private int second;
	private int countMode;
	private boolean isCounting = true;
	private Thread thread;

	// implement your code here

	public Timer(String name, int countMode) {
		this.timerGUI = new TimerGUI(name);
		this.countMode = countMode;
		resetHandle();
		setEventHandling();
		threadInitialize();
		// implement your code here
	}

	private void threadInitialize() {
		
		if (thread != null) {
			thread.interrupt();
		}
		thread = new Thread(new Runnable() {
			public void run() {
				try {
					while(isCounting) {
						if(countMode == COUNT_UP) {
							Main.timer.getThread().join();
						}
						updateTime();
						updateGUI();
						thread.sleep(SLEEP_TIME);
					}
				}catch(InterruptedException x) {
					
				}
			}
		});
		// implement your code here
	}

	private void updateGUI() {
		Platform.runLater(() -> {
			timerGUI.getDisplayPart().update(getTimeString());
		});
		// implement your code here

	}

	private void updateTime() {
		if (countMode == COUNT_UP) {
			second++;
			if (second == 60) {
				minute++;
				second = 0;
			}
			if (minute == 60) {
				hour++;
				minute = 0;
			}
		} else {
			second--;
			if (second == 0 && minute > 0) {
				second = 60;
				minute--;
			}
			if ((second == 0 && minute == 0) && hour > 0) {
				second = 60;
				minute = 59;
				hour--;
			}
			if ((second == 0 & minute == 0) && hour == 0) {
				isCounting = false;
				resetHandle();
			}
		} // implement your code here
	}

	private String getTimeString() {
		return (new SimpleDateFormat("HH:mm:ss")).format(new Date(0, 0, 0, hour, minute, second));
	}

	private void resetHandle() {
		isCounting = false;
		if (countMode == COUNT_UP) {
			hour = 0;
			minute = 0;
			second = 0;
		} if (countMode == COUNT_DOWN) {
			hour = 0;
			minute = 0;
			second = 30;
		}
		updateGUI();
		// implement your code here

	}

	private void startStopHandle() {
		isCounting = !isCounting;
		if (isCounting) {
			threadInitialize();
			getThread().start();
		}
		// implement your code here

	}

	private void setEventHandling() {
		timerGUI.getControlPart().getStartStopButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				startStopHandle();
			}
		});
		timerGUI.getControlPart().getResetButton().setOnAction(new EventHandler<ActionEvent>() {
			public void handle(ActionEvent event) {
				resetHandle();
			}
		});
		// implement your code here

	}

	public Thread getThread() {
		return this.thread;
	}

	public TimerGUI getTimerGUI() {
		return this.timerGUI;
	}

	// Generate Getters

}
