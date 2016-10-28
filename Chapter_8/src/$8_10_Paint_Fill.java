import java.util.Random;
import java.util.Scanner;

class PaintFillHelper{
	private int width, height;
	
	private int screen[][];//screen is (0 - maxPixel) eg. (0 - 1079) * (0 - 1919)
	
	public PaintFillHelper(int x, int y) {
		// TODO Auto-generated constructor stub
		width = x;
		height = y;
		
		screen = new int[height][width];
	}
	
	public void fillScreen(int x, int y, int newColor){
		if(x < 0 || x >= width || y >= height || y < 0){
			System.out.println("Incorrect pixel values!");
			return;
		}
		
		fillScreen(x, y, newColor, screen[y][x]);
	}
	
	private void fillScreen(int x, int y, int newColor, int oldColor){
		if(x < 0 || x >= width || y < 0 || y >= height) return;
		if(screen[y][x] == oldColor){
			screen[y][x] = newColor;
			fillScreen(x - 1, y, newColor, oldColor);
			fillScreen(x + 1, y, newColor, oldColor);
			fillScreen(x, y - 1, newColor, oldColor);
			fillScreen(x, y + 1, newColor, oldColor);
		}
	}
	
	public void paintScreenRandom(){
		Random generator = new Random();
		for(int i = 0 ; i < height ; i++){
			for(int j = 0 ; j < width ; j++){
				screen[i][j] = generator.nextInt(3);
			}
		}
	}
	
	public void showScreenPixels(){
		for(int i = 0 ; i < height ; i++){
			for(int j = 0 ; j < width ; j++){
				System.out.print(screen[i][j] + " ");
			}
			System.out.println();
		}
	}
}

public class $8_10_Paint_Fill {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("Enter screen width: ");
		int x = sc.nextInt();
		System.out.print("Enter screen height: ");
		int y = sc.nextInt();
		PaintFillHelper helper = new PaintFillHelper(x, y);
		helper.paintScreenRandom();
		helper.showScreenPixels();
		System.out.println("Enter x: ");
		x = sc.nextInt();
		System.out.println("Enter y: ");
		y = sc.nextInt();
		System.out.println("Enter new color: ");
		int newColor = sc.nextInt();
		helper.fillScreen(x, y, newColor);
		helper.showScreenPixels();
	}

}

