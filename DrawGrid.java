import java.awt.Color;
import java.awt.Graphics;


import javax.swing.JFrame;
import javax.swing.JPanel;

public class DrawGrid {


	//Default Constructor
	public DrawGrid() {
		init();

	}
	
	//TEST
	GridGenerator test = new GridGenerator();
	//////
	
	
	private final int WIDTH = 820;
	private final int HEIGHT = 640;
	private final int XSIZE = 800;
	private final int YSIZE = 600;
	
	private final int buckX = 160;
	private final int buckY = 120;
	
	private int CSIZE = XSIZE / buckX;

	JFrame frame;
	Map canvas;
	
	public void init() {

		frame = new JFrame();
		frame.setVisible(true);
		frame.setResizable(false);
		frame.setSize(WIDTH,HEIGHT);
		frame.setLocationRelativeTo(null);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);
		
		canvas = new Map();
		
		canvas.setBounds(10, 10, XSIZE+1, YSIZE+1);
		frame.getContentPane().add(canvas);
	}
	
	class Map extends JPanel {	//MAP CLASS
		public void paintComponent(Graphics g) {	//REPAINT
			//super.paintComponent(g);
			g.setColor(Color.RED);
			for(int x = 0; x < buckX; x++) {	//PAINT EACH NODE IN THE GRID
				for(int y = 0; y < buckY; y++) {
					
					/*
					if(test.Grid[x][y].type == '0') {
						System.out.println("CASE 0");
					} else if (test.Grid[x][y].type == '1') {
						System.out.println("CASE 1");
					} else if (test.Grid[x][y].type == '2') {
						System.out.println("CASE 2");
					}
					
					*/
					
					
					switch(test.Grid[x][y].type) {
					// 0 - BLACK
					// 1 - WHITE
					// 2 - GRAY
						case '0':
							
							g.setColor(Color.BLACK);
							break;
						case '1':
							
							g.setColor(Color.WHITE);
							break;
						case '2':
							
							g.setColor(Color.GRAY);
							break;
					}
					//System.out.print(test.Grid[x][y].type);
					//System.out.println("(" + x*buckX + "," + y*buckY + ")");
					g.fillRect(x*CSIZE,y*CSIZE,CSIZE,CSIZE);
					//g.fillRect(100,50,CSIZE,CSIZE);
					g.setColor(Color.BLACK);
					g.drawRect(x*CSIZE,y*CSIZE,CSIZE,CSIZE);
				}
			}
			int[] s = test.start;
			g.setColor(Color.GREEN);
			g.fillRect(s[0]*CSIZE,s[1]*CSIZE,CSIZE,CSIZE);
			
			int[] f = test.end;
			g.setColor(Color.RED);
			g.fillRect(f[0]*CSIZE,f[1]*CSIZE,CSIZE,CSIZE);
		}
	}
}


