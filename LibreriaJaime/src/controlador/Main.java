package controlador;

import java.awt.EventQueue;

import vista.AccesoUI;
import vista.UI;

public class Main {
		public static void main(String[] args) {
			EventQueue.invokeLater(new Runnable() {
				public void run() {
					try {
						UI ui = new UI();
						EventUI eventUI = new EventUI(ui);
						ui.setVisible(true);
					} catch (Exception e) {
						e.printStackTrace();
					}
				}
			});
		}
	}

