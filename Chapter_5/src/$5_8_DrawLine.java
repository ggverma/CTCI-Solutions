import java.util.Arrays;

class DLHelper{
	public void drawLine(byte[] screen, int width, int x1, int x2, int y){
		int start_offset = x1 % 8;
		int start_byte = x1 / 8;
		if(start_offset != 0) start_byte++;
		
		int end_offset = x2 % 8;
		int end_byte = x2 / 8;
		if(end_offset != 7) end_byte--;
		
		for(int b = start_byte ; b < end_byte ; b++){
			screen[(width / 8) * y + b] = (byte)0xFF;
		}
		
		byte start_mask = (byte)(0xFF >> start_offset);
		byte end_mask = (byte)~(0xFF >> (end_offset + 1));
		
		if(x1 / 8 == x2 / 8){
			byte mask = (byte)(start_mask & end_mask);
			screen[(width / 8) * y + (x1 / 8)] |= mask;
		}else{
			if(start_offset != 0){
				int byte_number = (width / 8) * y + start_byte - 1;
				screen[byte_number] |= start_mask;
			}
			if(end_offset != 7){
				int byte_number = (width / 8) * y + end_byte + 1;
				screen[byte_number] |= end_mask;
			}
		}
	}
}

public class $5_8_DrawLine {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		byte screen[] = new byte[30];
		DLHelper helper = new DLHelper();
		helper.drawLine(screen, 10, 4, 28, 7);
		System.out.println(Arrays.toString(screen));
	}

}
