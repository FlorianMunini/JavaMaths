package Model;

import java.awt.FileDialog;
import java.io.BufferedInputStream;
import java.io.DataInputStream;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.util.ArrayList;


import View.FenetreView;

public class Load {
//	protected int size;
//	private static FenetreView frame;

	public Load() {
		super();
	//	this.size = 0;
	}

	public void main(ArrayList<Complex> liste) { // throws FileNotFoundException,
		/*										// IOException {

		DataInputStream dis;
		
				ObjectInputStream ois = null;
			FileDialog sDialog = new FileDialog(frame, "Charger en txt un _figures.txt", FileDialog.LOAD);

				sDialog.setVisible(true);
				String path2 = sDialog.getDirectory() + sDialog.getFile();

			
				if (sDialog.getFile() == null)
					System.out.println("Save annulée");
				else {
					if ((path2.endsWith(".wave"))) {
						try {

							// On récupère maintenant les données !

							ois = new ObjectInputStream(
									new BufferedInputStream(new FileInputStream(new File(path2))));

							try {

								for (int i = 0; i < size; i++) {
									liste.add((Complex) ois.readObject());
								}
								for (Complex c : liste) {
									System.out.println(c.toString() + "\n");

								}
							} catch (ClassNotFoundException e) {
								e.printStackTrace();
							}

							ois.close();

						} catch (FileNotFoundException e) {
							e.printStackTrace();
						} catch (IOException e) {
							e.printStackTrace();
						}

					}
				}
				*/
			}
		
		}
	



