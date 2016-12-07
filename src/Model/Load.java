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
	protected int size;
	private static FenetreView frame;

	public Load() {
		super();
		this.size = 0;
	}

	public void main(ArrayList<Complex> liste) { // throws FileNotFoundException,
												// IOException {

	/*	DataInputStream dis;
		FileDialog fDialog = new FileDialog(frame, "Charger size en txt un _size.txt", FileDialog.LOAD);

		fDialog.setVisible(true);
		String path = fDialog.getDirectory() + fDialog.getFile();

		if (fDialog.getFile() == null)
			System.out.println("Save annulée");
		else {
			if ((path.endsWith("_size.txt"))) {
				System.out.println("pas .txt");
				try {
					// On récupère maintenant les données !
					dis = new DataInputStream(new BufferedInputStream(new FileInputStream(new File(path))));

					size = dis.readInt();

				} catch (FileNotFoundException e) {
					e.printStackTrace();
				} catch (IOException e) {
					e.printStackTrace();
				}
*/
		/*			ObjectInputStream ois = null;
			FileDialog sDialog = new FileDialog(frame, "Charger en txt un _figures.txt", FileDialog.LOAD);

				sDialog.setVisible(true);
				String path2 = sDialog.getDirectory() + sDialog.getFile();

			
				if (sDialog.getFile() == null)
					System.out.println("Save annulée");
				else {
					if ((path2.endsWith("_figures.txt"))) {
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


